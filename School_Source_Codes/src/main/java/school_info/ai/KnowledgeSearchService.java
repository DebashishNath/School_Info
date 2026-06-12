package school_info.ai;

import org.springframework.stereotype.Service;
import school_info.models.AITraining;
import school_info.models.Faq;
import school_info.models.School;
import school_info.service.AITraining.AITrainingService;
import school_info.service.Faq.FaqService;

import java.util.List;

@Service
public class KnowledgeSearchService {

    /*
     * Minimum score required to accept a local answer.
     */
    private static final int MINIMUM_SCORE = 60;

    private final FaqService faqService;

    private final AITrainingService aiTrainingService;

    private final TextSimilarityService textSimilarityService;

    public KnowledgeSearchService(

            FaqService faqService,

            AITrainingService aiTrainingService,

            TextSimilarityService textSimilarityService

    ) {

        this.faqService = faqService;
        this.aiTrainingService = aiTrainingService;
        this.textSimilarityService = textSimilarityService;

    }

    public String search(

            School school,

            String question

    ) {

        if (school == null ||
                question == null ||
                question.trim().isEmpty()) {

            return null;

        }

        String bestAnswer = null;

        int bestScore = 0;

        /*
         * Search FAQ
         */

        List<Faq> faqList =
                faqService.findBySchoolAndIsActive(

                        school,

                        "Y"

                );

        for (Faq faq : faqList) {

            int score =
                    textSimilarityService.calculateScore(

                            faq.getQuestion(),

                            question

                    );

            if (score > bestScore) {

                bestScore = score;

                bestAnswer = faq.getAnswer();

            }

        }

        /*
         * Search AI Training
         */

        List<AITraining> trainingList =
                aiTrainingService.findBySchool(
                        school
                );

        for (AITraining training : trainingList) {

            int score =
                    textSimilarityService.calculateScore(

                            training.getQuestion(),

                            question

                    );

            if (score > bestScore) {

                bestScore = score;

                bestAnswer = training.getAnswer();

            }

        }

        System.out.println(
                "Knowledge Score : " + bestScore
        );

        if (bestScore < MINIMUM_SCORE) {

            return null;

        }

        return bestAnswer;

    }

}