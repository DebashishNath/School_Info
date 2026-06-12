package school_info.ai;

import org.springframework.stereotype.Service;
import school_info.models.AITraining;
import school_info.models.Faq;
import school_info.models.School;
import school_info.service.AITraining.AITrainingService;
import school_info.service.Faq.FaqService;
import school_info.service.School.SchoolService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AIChatService {

    private static final String DEFAULT_RESPONSE =
            "Sorry, I don't have that information. Please contact the school office.";

    private final AIClient aiClient;
    private final PromptBuilder promptBuilder;
    private final AIResponseParser aiResponseParser;
    private final AIIntentDetector aiIntentDetector;
    private final AIActionExecutor aiActionExecutor;
    private final ChatHistoryService chatHistoryService;
    private final DatabaseRouterService databaseRouterService;
    private final SchoolService schoolService;
    private final FaqService faqService;
    private final AITrainingService aiTrainingService;

    public AIChatService(
            AIClient aiClient,
            PromptBuilder promptBuilder,
            AIResponseParser aiResponseParser,
            AIIntentDetector aiIntentDetector,
            AIActionExecutor aiActionExecutor,
            ChatHistoryService chatHistoryService,
            DatabaseRouterService databaseRouterService,
            SchoolService schoolService,
            FaqService faqService,
            AITrainingService aiTrainingService
    ) {
        this.aiClient = aiClient;
        this.promptBuilder = promptBuilder;
        this.aiResponseParser = aiResponseParser;
        this.aiIntentDetector = aiIntentDetector;
        this.aiActionExecutor = aiActionExecutor;
        this.chatHistoryService = chatHistoryService;
        this.databaseRouterService = databaseRouterService;
        this.schoolService = schoolService;
        this.faqService = faqService;
        this.aiTrainingService = aiTrainingService;
    }

    // =========================
    // MAIN FLOW
    // =========================
    public AIResponse ask(AIRequest request)
    {
        validateRequest(request);
        AIResponse response = createResponse(request);

        try {

            IntentType intent = aiIntentDetector.detectIntent(request.getQuestion());

            response.setIntent(intent.name());

            System.out.println("Detected Intent: " + intent);

            String finalAnswer;

            // =========================
            // STEP 1: STRUCTURED INTENTS (NO OLLAMA)
            // =========================
            if (isStructuredIntent(intent)) {

                finalAnswer = databaseRouterService.getResponse(intent, request);

                if (finalAnswer == null || finalAnswer.trim().isEmpty()) {
                    finalAnswer = getStructuredFallbackMessage(intent);
                }

            }

            // =========================
            // STEP 2: AI INTENTS (OLLAMA ALLOWED)
            // =========================
            else {

                finalAnswer = databaseRouterService.getResponse(intent, request);

                if (finalAnswer == null || finalAnswer.trim().isEmpty()) {
                    finalAnswer = getAIResponse(request);
                }
            }

            response.setAnswer(finalAnswer);

            chatHistoryService.saveChatHistory(request.getSessionId(),request.getQuestion(),finalAnswer);

            aiActionExecutor.execute(intent, request, response);

            response.setStatus("SUCCESS");

        } catch (Exception ex) {

            ex.printStackTrace();

            response.setStatus("FAILURE");
            response.setIntent(IntentType.UNKNOWN.name());
            response.setAnswer("Unable to process your request.");
            response.setActionMessage(ex.getMessage());
        }

        return response;
    }

    // =========================
    // ANSWER RESOLUTION
    // =========================
    private String resolveAnswer(AIRequest request, String dbAnswer) {

        if (dbAnswer != null && !dbAnswer.trim().isEmpty()) {
            return dbAnswer;
        }

        String aiAnswer = getAIResponse(request);

        if (aiAnswer != null && !aiAnswer.trim().isEmpty()) {
            return aiAnswer;
        }

        return DEFAULT_RESPONSE;
    }

    // =========================
    // VALIDATION (CRITICAL FIX AREA)
    // =========================
    private boolean isInvalidAnswer(String answer, String question) {

        if (answer == null || answer.trim().isEmpty()) {
            return true;
        }

        String qStd = extractStd(question.toLowerCase());
        String aStd = extractStd(answer.toLowerCase());

        // ❌ Reject wrong STD mapping
        if (qStd != null && aStd != null && !qStd.equals(aStd)) {
            return true;
        }

        return false;
    }

    private String extractStd(String text) {

        if (text == null) return null;

        if (text.contains("std 1") || text.contains("class 1")) return "1";
        if (text.contains("std 2") || text.contains("class 2")) return "2";
        if (text.contains("std 3") || text.contains("class 3")) return "3";
        if (text.contains("std 6") || text.contains("class 6")) return "6";

        return null;
    }

    // =========================
    // AI FALLBACK
    // =========================
    private String getAIResponse(AIRequest request) {

        School school = schoolService.findBySchoolId(request.getSchoolId())
                        .orElseThrow(() -> new RuntimeException("School not found."));

        List<Faq> faqList = faqService.findBySchoolAndIsActive(school, "Y");

        List<AITraining> trainingList = aiTrainingService.findBySchool(school);

        String prompt = promptBuilder.buildPrompt(school,faqList,trainingList,request.getQuestion());

        String rawResponse = aiClient.askAI(prompt);

        String response = aiResponseParser.parseResponse(rawResponse);

        return (response == null || response.trim().isEmpty())
                ? DEFAULT_RESPONSE
                : response;
    }

    // =========================
    // RESPONSE OBJECT
    // =========================
    private AIResponse createResponse(AIRequest request) {

        AIResponse response = new AIResponse();

        response.setSchoolId(request.getSchoolId());
        response.setLeadId(request.getLeadId());
        response.setSessionId(request.getSessionId());
        response.setActionPerformed(false);
        response.setStatus("SUCCESS");

        return response;
    }

    // =========================
    // VALIDATION
    // =========================
    private void validateRequest(AIRequest request) {

        if (request == null) {
            throw new RuntimeException("Invalid request.");
        }

        if (request.getSchoolId() == null) {
            throw new RuntimeException("School Id is mandatory.");
        }

        if (request.getQuestion() == null ||
                request.getQuestion().trim().isEmpty()) {
            throw new RuntimeException("Question is mandatory.");
        }
    }

    private boolean isStructuredIntent(IntentType intent)
    {

        return intent == IntentType.FEE_ENQUIRY
                || intent == IntentType.ADMISSION_ENQUIRY
                || intent == IntentType.TRANSPORT_ENQUIRY;
//                || intent == IntentType.CLASS_DETAILS
//                || intent == IntentType.SEAT_ENQUIRY;
    }

    private String getStructuredFallbackMessage(IntentType intent) {

        return switch (intent) {
            case FEE_ENQUIRY ->
                    "Fee information is not available. Please contact the school office.";

            case ADMISSION_ENQUIRY ->
                    "Admission details are not available. Please contact the school office.";

            case TRANSPORT_ENQUIRY ->
                    "Transport details are not available. Please contact the school office.";

            default ->
                    "Information not available.";
        };
    }

}