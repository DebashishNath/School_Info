package school_info.ai;

import org.springframework.stereotype.Service;
import school_info.models.AITraining;
import school_info.models.Faq;
import school_info.models.School;
import school_info.service.AITraining.AITrainingService;
import school_info.service.Faq.FaqService;
import school_info.service.School.SchoolService;

import java.util.List;

@Service
public class AIChatService {

    private final AIClient aiClient;

    private final PromptBuilder promptBuilder;

    private final AIResponseParser aiResponseParser;

    private final AIIntentDetector aiIntentDetector;

    private final AIActionExecutor aiActionExecutor;

    private final ChatHistoryService chatHistoryService;

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
        this.schoolService = schoolService;
        this.faqService = faqService;
        this.aiTrainingService = aiTrainingService;

    }

    public AIResponse ask(
            AIRequest request
    ) {

        AIResponse response =
                new AIResponse();

        try {

            System.out.println("==================================");
            System.out.println("AI CHAT REQUEST STARTED");
            System.out.println("Question : " + request.getQuestion());
            System.out.println("School Id : " + request.getSchoolId());
            System.out.println("==================================");

            School school =
                    schoolService
                            .findBySchoolId(
                                    request.getSchoolId()
                            )
                            .orElseThrow(
                                    () -> new RuntimeException(
                                            "School not found."
                                    )
                            );

            List<Faq> faqList =
                    faqService.findBySchoolAndIsActive(
                            school,
                            "Y"
                    );

            List<AITraining> trainingList =
                    aiTrainingService.findBySchool(
                            school
                    );

            System.out.println(
                    "FAQ Count : " + faqList.size()
            );

            System.out.println(
                    "Training Count : " + trainingList.size()
            );

            IntentType intent =
                    aiIntentDetector.detectIntent(
                            request.getQuestion()
                    );

            System.out.println(
                    "Detected Intent : " + intent.name()
            );

            String prompt =
                    promptBuilder.buildPrompt(

                            school,

                            faqList,

                            trainingList,

                            request.getQuestion()

                    );

            System.out.println("==================================");
            System.out.println("PROMPT");
            System.out.println(prompt);
            System.out.println("==================================");

            String rawResponse =
                    aiClient.askAI(
                            prompt
                    );

            System.out.println("==================================");
            System.out.println("RAW AI RESPONSE");
            System.out.println(rawResponse);
            System.out.println("==================================");

            String finalResponse =
                    aiResponseParser.parseResponse(
                            rawResponse
                    );

            if (finalResponse == null ||
                    finalResponse.trim().isEmpty()) {

                finalResponse =
                        "Sorry, I don't have that information. Please contact the school office.";

            }

            response.setStatus(
                    "SUCCESS"
            );

            response.setIntent(
                    intent.name()
            );

            response.setAnswer(
                    finalResponse
            );

            response.setLeadId(
                    request.getLeadId()
            );

            response.setSessionId(
                    request.getSessionId()
            );

            response.setActionPerformed(
                    false
            );

            response.setActionMessage(
                    null
            );

//            chatHistoryService.saveChatHistory(
//
//                    request.getSessionId(),
//
//                    request.getQuestion(),
//
//                    finalResponse
//
//            );
//
//            aiActionExecutor.execute(
//
//                    intent,
//
//                    request,
//
//                    response
//
//            );

            System.out.println("==================================");
            System.out.println("AI CHAT REQUEST COMPLETED");
            System.out.println("==================================");

            return response;

        }
        catch (Exception ex) {

            ex.printStackTrace();

            response.setStatus(
                    "FAILURE"
            );

            response.setIntent(
                    IntentType.UNKNOWN.name()
            );

            response.setAnswer(
                    "Unable to process your request."
            );

            response.setLeadId(
                    request.getLeadId()
            );

            response.setSessionId(
                    request.getSessionId()
            );

            response.setActionPerformed(
                    false
            );

            response.setActionMessage(
                    ex.getMessage()
            );

            return response;

        }

    }

}