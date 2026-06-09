package school_info.controllers;

import org.springframework.web.bind.annotation.*;
import school_info.ai.AIChatService;
import school_info.ai.AIRequest;
import school_info.ai.AIResponse;

@RestController
@RequestMapping("/api/school_info/ai")
public class AIController {

    private final AIChatService aiService;

    public AIController(AIChatService aiService) {

        this.aiService = aiService;

    }

    @PostMapping("/ask")
    public AIResponse ask(
            @RequestBody AIRequest request
    ) {

        System.out.println("AIService Started");

        AIResponse response =
                aiService.ask(request);

        System.out.println("AIService Completed");

        return response;
    }

}