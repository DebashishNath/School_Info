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

            String userQuestion

    ) {

        StringBuilder prompt = new StringBuilder();

        /*
         * SYSTEM ROLE
         */

        prompt.append("""
                You are an intelligent AI Receptionist for a school.

                Rules:

                1. Answer politely and professionally.
                2. Use ONLY the information provided below.
                3. Never invent fees, dates, addresses or policies.
                4. If information is unavailable, reply exactly:
                   "Sorry, I don't have that information. Please contact the school office."
                5. Keep the answer short and precise.
                6. Do not explain your reasoning.

                """);

        /*
         * SCHOOL DETAILS
         */

        prompt.append("School Information:\n");

        prompt.append("School Name: ")
                .append(nullSafe(school.getSchoolName()))
                .append("\n");

        prompt.append("Address: ")
                .append(nullSafe(school.getAddress()))
                .append("\n");

        prompt.append("Phone: ")
                .append(nullSafe(school.getPhoneNumber()))
                .append("\n");

        prompt.append("\n");

        /*
         * FAQ
         */

        prompt.append("Frequently Asked Questions:\n\n");

        for (Faq faq : faqList) {

            prompt.append("Question: ")
                    .append(nullSafe(faq.getQuestion()))
                    .append("\n");

            prompt.append("Answer: ")
                    .append(nullSafe(faq.getAnswer()))
                    .append("\n\n");

        }

        /*
         * AI TRAINING
         */

        prompt.append("Training Knowledge:\n\n");

        for (AITraining training : trainingList) {

            prompt.append("Question: ")
                    .append(nullSafe(training.getQuestion()))
                    .append("\n");

            prompt.append("Answer: ")
                    .append(nullSafe(training.getAnswer()))
                    .append("\n\n");

        }

        /*
         * USER QUESTION
         */

        prompt.append("User Question:\n");

        prompt.append(userQuestion);

        prompt.append("\n\n");

        prompt.append("Answer:");

        return prompt.toString();

    }

    private String nullSafe(
            String value
    ) {

        return value == null
                ? ""
                : value.trim();

    }

}