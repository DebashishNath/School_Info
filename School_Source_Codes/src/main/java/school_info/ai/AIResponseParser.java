package school_info.ai;

import org.springframework.stereotype.Component;

@Component
public class AIResponseParser {

    public String parseResponse(
            String rawResponse
    ){

        if(rawResponse == null)
        {
            return "No response generated.";
        }

        return rawResponse
                .replace("\n", " ")
                .trim();
    }
}