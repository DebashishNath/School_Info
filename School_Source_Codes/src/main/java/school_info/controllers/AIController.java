package school_info.controllers;

import org.springframework.web.bind.annotation.*;
import school_info.ai.AIService;

@RestController
@RequestMapping("/api/school_info/ai")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {

        this.aiService = aiService;

    }

    @PostMapping("/ask")
    public String ask(@RequestBody String question) {
        System.out.println("AIService Started");
        String returnMessage = aiService.ask(question);
        System.out.println("AIService Started");
        return returnMessage;
    }

}