package school_info.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class OllamaClient implements AIClient {

    private final RestTemplate restTemplate;

    private final String ollamaUrl;

    private final String model;

    private final Double temperature;

    private final Integer numPredict;

    private final Integer numContext;

    public OllamaClient(

            @Value("${ollama.url}")
            String ollamaUrl,

            @Value("${ollama.model}")
            String model,

            @Value("${ollama.temperature}")
            Double temperature,

            @Value("${ollama.numPredict}")
            Integer numPredict,

            @Value("${ollama.numContext}")
            Integer numContext

    ) {

        this.restTemplate =
                new RestTemplate();

        this.ollamaUrl =
                ollamaUrl;

        this.model =
                model;

        this.temperature =
                temperature;

        this.numPredict =
                numPredict;

        this.numContext =
                numContext;

    }

    @Override
    public String askAI(
            String prompt
    ) {

        if (prompt == null ||
                prompt.trim().isEmpty()) {

            return "Prompt is empty.";

        }

        try {

            printRequestDetails(
                    prompt
            );

            HttpEntity<OllamaRequest> entity =
                    new HttpEntity<>(

                            buildRequest(
                                    prompt
                            ),

                            buildHeaders()

                    );

            long startTime =
                    System.currentTimeMillis();

            ResponseEntity<OllamaResponse> response =
                    restTemplate.exchange(

                            ollamaUrl,

                            HttpMethod.POST,

                            entity,

                            OllamaResponse.class

                    );

            long endTime =
                    System.currentTimeMillis();

            System.out.println(
                    "OLLAMA RESPONSE TIME : "
                            + (endTime - startTime)
                            + " ms"
            );

            return extractResponse(
                    response
            );

        }
        catch (Exception ex) {

            System.out.println(
                    "=================================="
            );

            System.out.println(
                    "OLLAMA ERROR"
            );

            System.out.println(
                    ex.getMessage()
            );

            System.out.println(
                    "=================================="
            );

            ex.printStackTrace();

            return "Unable to get AI response.";

        }

    }

    private HttpHeaders buildHeaders() {

        HttpHeaders headers =
                new HttpHeaders();

        headers.setContentType(
                MediaType.APPLICATION_JSON
        );

        return headers;

    }

    private OllamaRequest buildRequest(
            String prompt
    ) {

        OllamaRequest request =
                new OllamaRequest();

        request.setModel(
                model
        );

        request.setPrompt(
                prompt
        );

        request.setStream(
                false
        );

        Map<String, Object> options =
                new HashMap<>();

        options.put(
                "temperature",
                temperature
        );

        options.put(
                "num_predict",
                numPredict
        );

        options.put(
                "num_ctx",
                numContext
        );

        request.setOptions(
                options
        );

        return request;

    }

    private String extractResponse(

            ResponseEntity<OllamaResponse> response

    ) {

        if (response == null ||
                response.getBody() == null) {

            return "No response from AI.";

        }

        String aiResponse =
                response.getBody().getResponse();

        if (aiResponse == null ||
                aiResponse.trim().isEmpty()) {

            return "No response generated.";

        }

        return aiResponse.trim();

    }

    private void printRequestDetails(
            String prompt
    ) {

        System.out.println(
                "=================================="
        );

        System.out.println(
                "OLLAMA REQUEST"
        );

        System.out.println(
                "URL          : "
                        + ollamaUrl
        );

        System.out.println(
                "MODEL        : "
                        + model
        );

        System.out.println(
                "TEMPERATURE  : "
                        + temperature
        );

        System.out.println(
                "NUM_PREDICT  : "
                        + numPredict
        );

        System.out.println(
                "NUM_CONTEXT  : "
                        + numContext
        );

        System.out.println("PROMPT SIZE  : " + prompt.length() + " characters");

        System.out.println("==================================");

    }

}