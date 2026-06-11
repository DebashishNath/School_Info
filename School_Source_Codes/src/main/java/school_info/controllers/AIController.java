package school_info.controllers;

import org.springframework.web.bind.annotation.*;
import school_info.ai.AIChatService;
import school_info.ai.AIRequest;
import school_info.ai.AIResponse;

@RestController
@RequestMapping("/api/school_info/ai")
public class AIController {

    private final AIChatService aiChatService;

    public AIController(AIChatService aiChatService) {
        this.aiChatService = aiChatService;
    }

    @PostMapping("/ask")
    public AIResponse ask(@RequestBody AIRequest request)
    {
        System.out.println("REQUEST RECEIVED: " + request);
        AIResponse response = aiChatService.ask(request);
        System.out.println("RESPONSE: " + response);
        return response;
    }
}