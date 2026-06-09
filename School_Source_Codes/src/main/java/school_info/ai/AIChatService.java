package school_info.ai;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AIClient aiClient;

    @Autowired
    private PromptBuilder promptBuilder;

    @Autowired
    private AIResponseParser aiResponseParser;

    @Autowired
    private AIIntentDetector aiIntentDetector;

    @Autowired
    private AIActionExecutor aiActionExecutor;

    @Autowired
    private ChatHistoryService chatHistoryService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private FaqService faqService;

    @Autowired
    private AITrainingService aiTrainingService;

    public AIResponse ask(
            AIRequest request
    ) {

        AIResponse aiResponse =
                new AIResponse();

        try {

            School school =
                    schoolService.findBySchoolId(
                            request.getSchoolId()
                    ).orElseThrow();

            List<Faq> faqList =
                    faqService.findBySchoolAndIsActive(
                            school,
                            "Y"
                    );

            List<AITraining> trainingList =
                    aiTrainingService.findBySchool(
                            school
                    );

            IntentType intent =
                    aiIntentDetector.detectIntent(
                            request.getQuestion()
                    );

            String prompt =
                    promptBuilder.buildPrompt(
                            school,
                            faqList,
                            trainingList,
                            request.getQuestion()
                    );

            String rawResponse =
                    aiClient.askAI(prompt);

            String finalResponse =
                    aiResponseParser.parseResponse(
                            rawResponse
                    );

            aiResponse.setAnswer(finalResponse);
            aiResponse.setIntent(intent.name());
            aiResponse.setStatus("SUCCESS");
            aiResponse.setSessionId(request.getSessionId());
            aiResponse.setLeadId(request.getLeadId());

            return aiResponse;

        } catch (Exception ex) {

            aiResponse.setStatus("FAILURE");
            aiResponse.setAnswer("Unable to process request.");
            aiResponse.setIntent(IntentType.UNKNOWN.name());
            aiResponse.setActionMessage(ex.getMessage());

            return aiResponse;
        }

    }

}