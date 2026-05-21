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
    ){

        StringBuilder prompt =
                new StringBuilder();

        prompt.append(
                "You are an AI admission assistant.\n\n"
        );

        prompt.append(
                "School Name: "
        ).append(
                school.getSchoolName()
        ).append("\n\n");

        prompt.append("FAQ Data:\n");

        for(Faq faq : faqList)
        {
            prompt.append("Q: ")
                    .append(faq.getQuestion())
                    .append("\n");

            prompt.append("A: ")
                    .append(faq.getAnswer())
                    .append("\n\n");
        }

        prompt.append("Training Data:\n");

        for(AITraining aiTraining : trainingList)
        {
            prompt.append("Q: ")
                    .append(aiTraining.getQuestion())
                    .append("\n");

            prompt.append("A: ")
                    .append(aiTraining.getAnswer())
                    .append("\n\n");
        }

        prompt.append(
                "Parent Question:\n"
        );

        prompt.append(parentQuestion);

        prompt.append(
                "\n\nAnswer naturally and briefly."
        );

        return prompt.toString();
    }
}