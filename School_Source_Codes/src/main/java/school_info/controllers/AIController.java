package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.ai.AIService;

@RestController
@RequestMapping("/api/school_info/ai")
@CrossOrigin(origins = "*")
public class AIController {

    @Autowired
    private AIService aiService;

    @GetMapping("/ask")
    public String askQuestion(
            @RequestParam Long schoolId,
            @RequestParam String question
    ){

        return aiService.askQuestion(
                schoolId,
                question
        );
    }
}