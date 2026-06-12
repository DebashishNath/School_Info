package school_info.ai;

import org.springframework.stereotype.Component;

@Component
public class AIResponseParser {

    private static final String DEFAULT_RESPONSE =
            "Sorry, I don't have that information. Please contact the school office.";

    public String parseResponse(String response)
    {
        if (response == null) {
            return DEFAULT_RESPONSE;
        }
        String answer = response.trim();

        /*
         * Remove markdown code blocks
         */

        answer = answer.replace("```", "");

        /*
         * Remove unnecessary labels
         */

        answer = answer.replace("Answer:", "");
        answer = answer.replace("Response:", "");

        /*
         * Remove multiple spaces
         */

        answer = answer.replaceAll("\\s+", " ").trim();

        /*
         * Empty response
         */

        if (answer.isEmpty()) {

            return DEFAULT_RESPONSE;

        }

        /*
         * Reject common hallucination placeholders
         */

        String lower = answer.toLowerCase();

        if (lower.contains("i don't know")
                || lower.contains("i do not know")
                || lower.contains("no information provided")
                || lower.contains("information is unavailable")
                || lower.contains("cannot determine")) {

            return DEFAULT_RESPONSE;

        }

        return answer;

    }

}