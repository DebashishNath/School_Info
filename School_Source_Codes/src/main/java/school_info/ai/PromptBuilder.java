package school_info.ai;

import org.springframework.stereotype.Component;
import school_info.models.AITraining;
import school_info.models.Faq;
import school_info.models.School;

import java.util.List;

@Component
public class PromptBuilder {

    public String buildPrompt(

            School school,

            List<Faq> faqList,

            List<AITraining> trainingList,

            String parentQuestion

    ) {

        StringBuilder prompt =
                new StringBuilder();

        prompt.append("""
You are an AI Admission Assistant for a school.

==========================
IMPORTANT INSTRUCTIONS
==========================

1. Answer ONLY from the FAQ Data and Training Data provided below.

2. NEVER create, assume or guess any information.

3. NEVER change any amount, date, class name or document name.

4. If multiple questions are similar, use the closest matching FAQ or Training Data.

5. If the answer is not available in the data, reply exactly:

Sorry, I don't have that information. Please contact the school office.

6. Keep the answer short, professional and friendly.

7. Do NOT mention that you are using FAQ or Training Data.

8. Do NOT use your own knowledge.

==========================

""");

        prompt.append("School Information\n");
        prompt.append("------------------------------\n");
        prompt.append("School Name : ")
                .append(school.getSchoolName())
                .append("\n\n");

        prompt.append("FAQ DATA\n");
        prompt.append("------------------------------\n");

        for (Faq faq : faqList) {

            prompt.append("Question : ")
                    .append(faq.getQuestion())
                    .append("\n");

            prompt.append("Answer : ")
                    .append(faq.getAnswer())
                    .append("\n\n");

        }

        prompt.append("TRAINING DATA\n");
        prompt.append("------------------------------\n");

        for (AITraining aiTraining : trainingList) {

            prompt.append("Question : ")
                    .append(aiTraining.getQuestion())
                    .append("\n");

            prompt.append("Answer : ")
                    .append(aiTraining.getAnswer())
                    .append("\n\n");

        }

        prompt.append("PARENT QUESTION\n");
        prompt.append("------------------------------\n");
        prompt.append(parentQuestion);
        prompt.append("\n\n");

        prompt.append("""
Now generate ONLY the final answer.

Do not explain your reasoning.

If the answer exists in FAQ or Training Data, return exactly that answer.

""");

        return prompt.toString();

    }

}