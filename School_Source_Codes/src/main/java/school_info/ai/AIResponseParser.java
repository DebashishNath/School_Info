package school_info.ai;

import org.springframework.stereotype.Component;

@Component
public class AIResponseParser {

    private static final String DEFAULT_RESPONSE =
            "Sorry, I don't have that information. Please contact the school office.";

    public String parseResponse(
            String rawResponse
    ) {

        if (rawResponse == null ||
                rawResponse.trim().isEmpty()) {

            return DEFAULT_RESPONSE;

        }

        String response =
                rawResponse
                        .replaceAll("(?s)<think>.*?</think>", "")
                        .replace("\r", " ")
                        .replace("\n", " ")
                        .replaceAll("\\s+", " ")
                        .trim();

        if (response.isEmpty()) {

            return DEFAULT_RESPONSE;

        }

        if ("Unable to get AI response.".equalsIgnoreCase(response)) {

            return DEFAULT_RESPONSE;

        }

        if ("No response generated.".equalsIgnoreCase(response)) {

            return DEFAULT_RESPONSE;

        }

        return response;

    }

}