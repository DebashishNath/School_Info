package school_info.ai;

import org.springframework.stereotype.Service;
import school_info.models.AIClient;

@Service
public class AIService {

    private final AIClient aiClient;

    public AIService(AIClient aiClient) {

        this.aiClient = aiClient;

    }

    public String ask(String prompt) {

        return aiClient.askAI(prompt);

    }

}