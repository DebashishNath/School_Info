package school_info.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
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

    public String askChatGPT(String prompt){

        try
        {
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

            body.put("model", "gpt-4o-mini");

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
                    new HttpEntity<>(body, headers);

            ResponseEntity<Map> response =
                    restTemplate.exchange(
                            OPENAI_URL,
                            HttpMethod.POST,
                            request,
                            Map.class
                    );

            List choices =
                    (List) response.getBody()
                            .get("choices");

            Map firstChoice =
                    (Map) choices.get(0);

            Map message =
                    (Map) firstChoice.get("message");

            return message.get("content")
                    .toString();

        }catch(Exception ex)
        {
            System.out.println(
                    "OpenAI Error : " + ex.getMessage()
            );

            return "Unable to get AI response.";
        }
    }
}