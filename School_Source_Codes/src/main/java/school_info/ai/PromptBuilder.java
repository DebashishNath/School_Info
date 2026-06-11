package school_info.ai;

import org.springframework.stereotype.Component;
import school_info.models.AITraining;
import school_info.models.Faq;
import school_info.models.School;

import java.util.List;

@Component
public class PromptBuilder {

    private static final String DEFAULT_RESPONSE =
            "Sorry, I don't have that information. Please contact the school office.";

    public String buildPrompt(

            School school,

            List<Faq> faqList,

            List<AITraining> trainingList,

            String parentQuestion

    ) {

        StringBuilder prompt =
                new StringBuilder(4096);

        appendSystemInstruction(
                prompt
        );

        appendSchoolInformation(

                prompt,

                school

        );

        appendFaqData(

                prompt,

                faqList

        );

        appendTrainingData(

                prompt,

                trainingList

        );

        appendParentQuestion(

                prompt,

                parentQuestion

        );

        return prompt.toString();

    }

    private void appendSystemInstruction(
            StringBuilder prompt
    ) {

        prompt.append("""

You are an AI Admission Assistant.

Rules:

1. Answer ONLY from the information provided.

2. Never guess.

3. Never modify fees, dates or documents.

4. If information is unavailable reply exactly:

""");

        prompt.append(DEFAULT_RESPONSE);

        prompt.append("""

5. Keep answers within 2 sentences.

6. Return only the final answer.

==================================================

""");

    }

    private void appendSchoolInformation(

            StringBuilder prompt,

            School school

    ) {

        if (school == null) {

            return;

        }

        prompt.append("School : ");

        prompt.append(

                school.getSchoolName()

        );

        prompt.append("\n\n");

    }

    private void appendFaqData(

            StringBuilder prompt,

            List<Faq> faqList

    ) {

        if (faqList == null ||
                faqList.isEmpty()) {

            return;

        }

        prompt.append("FAQ\n");

        prompt.append("--------------------\n");

        for (Faq faq : faqList) {

            if (faq == null) {

                continue;

            }

            prompt.append("Q: ");

            prompt.append(
                    faq.getQuestion()
            );

            prompt.append("\n");

            prompt.append("A: ");

            prompt.append(
                    faq.getAnswer()
            );

            prompt.append("\n\n");

        }

    }

    private void appendTrainingData(

            StringBuilder prompt,

            List<AITraining> trainingList

    ) {

        if (trainingList == null ||
                trainingList.isEmpty()) {

            return;

        }

        prompt.append("Training\n");

        prompt.append("--------------------\n");

        for (AITraining training : trainingList) {

            if (training == null) {

                continue;

            }

            prompt.append("Q: ");

            prompt.append(
                    training.getQuestion()
            );

            prompt.append("\n");

            prompt.append("A: ");

            prompt.append(
                    training.getAnswer()
            );

            prompt.append("\n\n");

        }

    }

    private void appendParentQuestion(

            StringBuilder prompt,

            String question

    ) {

        prompt.append("Parent Question\n");

        prompt.append("--------------------\n");

        prompt.append(

                question == null ? "" : question.trim()

        );

        prompt.append("\n");

    }

}