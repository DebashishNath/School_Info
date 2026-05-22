package school_info.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OpenAIClient {

    @Value("${openai.api.key}")
    private String openaiApiKey;

    private static final String OPENAI_URL =
            "https://api.openai.com/v1/chat/completions";

    public String askChatGPT(String prompt) {

        //System.out.println("Open API Key: " + openaiApiKey);

        try {

            RestTemplate restTemplate =
                    new RestTemplate();

            HttpHeaders headers =
                    new HttpHeaders();

            headers.setContentType(
                    MediaType.APPLICATION_JSON
            );

            headers.setBearerAuth(openaiApiKey);

            Map<String, Object> body =
                    new HashMap<>();

            body.put(
                    "model",
                    "gpt-4o-mini"
            );

            body.put(
                    "messages",
                    List.of(
                            Map.of(
                                    "role", "user",
                                    "content", prompt
                            )
                    )
            );

            HttpEntity<Map<String, Object>> request =
                    new HttpEntity<>(
                            body,
                            headers
                    );

            ResponseEntity<Map<String, Object>> response =
                    restTemplate.exchange(
                            OPENAI_URL,
                            HttpMethod.POST,
                            request,
                            new ParameterizedTypeReference<Map<String, Object>>() {
                            }
                    );

            Map<String, Object> responseBody =
                    response.getBody();

            if (responseBody == null) {
                return "Empty response from OpenAI.";
            }

            List<Map<String, Object>> choices =
                    (List<Map<String, Object>>) responseBody.get("choices");

            if (choices == null || choices.isEmpty()) {
                return "No choices returned from OpenAI.";
            }

            Map<String, Object> firstChoice =
                    choices.get(0);

            Map<String, Object> message =
                    (Map<String, Object>) firstChoice.get("message");

            if (message == null) {
                return "No message returned from OpenAI.";
            }

            Object content =
                    message.get("content");

            return content != null
                    ? content.toString()
                    : "No content returned from OpenAI.";

        }
        catch (HttpClientErrorException ex)
        {
            System.out.println("Status Code : " + ex.getStatusCode());
            System.out.println("Response Body : " + ex.getResponseBodyAsString());

            return "OpenAI API Error : " + ex.getResponseBodyAsString();
        }
        catch (Exception ex) {

            System.out.println(
                    "OpenAI Error : " + ex.getMessage()
            );

            return "Unable to get AI response.";
        }
    }
}