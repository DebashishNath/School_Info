package school_info.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.AITraining;
import school_info.models.Faq;
import school_info.models.School;
import school_info.repository.AITrainingRepository;
import school_info.repository.FaqRepository;
import school_info.repository.SchoolRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AIServiceImpl implements AIService {

    @Autowired
    private SchoolRepository schoolRep;

    @Autowired
    private FaqRepository faqRep;

    @Autowired
    private AITrainingRepository aiTrainingRep;

    @Autowired
    private PromptBuilder promptBuilder;

    @Autowired
    private OpenAIClient openAIClient;

    @Autowired
    private AIResponseParser aiResponseParser;

    @Override
    public String askQuestion(
            Long schoolId,
            String parentQuestion
    ){

        try
        {
            Optional<School> schoolOpt =
                    schoolRep.findById(schoolId);

            if(schoolOpt.isEmpty())
            {
                return "School not found.";
            }

            School school = schoolOpt.get();

            List<Faq> faqList =
                    faqRep.findBySchool(school);

            List<AITraining> trainingList =
                    aiTrainingRep.findBySchool(school);

            String prompt =
                    promptBuilder.buildPrompt(
                            school,
                            faqList,
                            trainingList,
                            parentQuestion
                    );

            String rawResponse =
                    openAIClient.askChatGPT(prompt);

            return aiResponseParser
                    .parseResponse(rawResponse);

        }catch(Exception ex)
        {
            System.out.println(
                    "AI Error : " + ex.getMessage()
            );

            return "Sorry, I am unable to answer right now.";
        }
    }
}