package school_info.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OllamaClient implements AIClient {

    @Value("${ollama.url}")
    private String ollamaUrl;

    @Value("${ollama.model}")
    private String model;

    @Override
    public String askAI(String prompt) {
        System.out.println("URL: " + ollamaUrl);
        System.out.println("model: " + model);
        try {

            RestTemplate restTemplate =
                    new RestTemplate();

            HttpHeaders headers =
                    new HttpHeaders();

            headers.setContentType(
                    MediaType.APPLICATION_JSON
            );

            OllamaRequest request =
                    new OllamaRequest();

            request.setModel(model);
            request.setPrompt(prompt);
            request.setStream(false);

            HttpEntity<OllamaRequest> entity =
                    new HttpEntity<>(
                            request,
                            headers
                    );

            ResponseEntity<OllamaResponse> response =
                    restTemplate.exchange(
                            ollamaUrl,
                            HttpMethod.POST,
                            entity,
                            OllamaResponse.class
                    );

            if (response.getBody() == null) {

                return "No response from Ollama.";

            }

            return response.getBody().getResponse();

        }
        catch (Exception ex) {

            ex.printStackTrace();

            return "Unable to get AI response.";

        }

    }

}