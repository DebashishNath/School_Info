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
public class OllamaIntentHandler implements IntentHandler {

    private static final String DEFAULT_RESPONSE =
            "Sorry, I don't have that information. Please contact the school office.";

    private final SchoolService schoolService;

    private final FaqService faqService;

    private final AITrainingService aiTrainingService;

    private final PromptBuilder promptBuilder;

    private final AIClient aiClient;

    private final AIResponseParser aiResponseParser;

    public OllamaIntentHandler(

            SchoolService schoolService,

            FaqService faqService,

            AITrainingService aiTrainingService,

            PromptBuilder promptBuilder,

            AIClient aiClient,

            AIResponseParser aiResponseParser

    ) {

        this.schoolService = schoolService;
        this.faqService = faqService;
        this.aiTrainingService = aiTrainingService;
        this.promptBuilder = promptBuilder;
        this.aiClient = aiClient;
        this.aiResponseParser = aiResponseParser;

    }

    @Override
    public boolean supports(
            IntentType intent
    ) {

        /*
         * Final fallback.
         * Can answer every intent if no other handler succeeds.
         */

        return true;

    }

    @Override
    public String getAnswer(

            IntentType intent,

            AIRequest request

    ) {

        if (request == null ||
                request.getSchoolId() == null ||
                request.getQuestion() == null ||
                request.getQuestion().trim().isEmpty()) {

            return DEFAULT_RESPONSE;

        }

        School school =
                schoolService
                        .findBySchoolId(
                                request.getSchoolId()
                        )
                        .orElse(null);

        if (school == null) {

            return DEFAULT_RESPONSE;

        }

        List<Faq> faqList =
                faqService.findBySchoolAndIsActive(
                        school,
                        "Y"
                );

        List<AITraining> trainingList =
                aiTrainingService.findBySchool(
                        school
                );

        String prompt =
                promptBuilder.buildPrompt(

                        school,

                        faqList,

                        trainingList,

                        request.getQuestion()

                );

        String rawResponse =
                aiClient.askAI(
                        prompt
                );

        String response =
                aiResponseParser.parseResponse(rawResponse);

        if (response == null ||
                response.trim().isEmpty()) {

            return DEFAULT_RESPONSE;

        }

        return response.trim();

    }

}