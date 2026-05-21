package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.AITraining;
import school_info.models.School;
import school_info.service.AITraining.AITrainingService;
import utils.MessageResponse;

import java.util.List;

@RestController
@RequestMapping("/api/school_info/aiTraining")
@CrossOrigin(origins = "*")
public class AITrainingController {

    @Autowired
    private AITrainingService aiTrainingService;

    @PostMapping("/updateAITraining")
    public AITraining updateAITraining(
            @RequestBody AITraining aiTraining
    ){
        return aiTrainingService.updateAITraining(
                aiTraining
        );
    }

    @DeleteMapping("/deleteAITraining/{trainingId}")
    public MessageResponse deleteAITraining(
            @PathVariable Long trainingId
    ){
        return aiTrainingService.deleteAITraining(
                trainingId
        );
    }

    @PostMapping("/findBySchool")
    public List<AITraining> findBySchool(
            @RequestBody School school
    ){
        return aiTrainingService.findBySchool(
                school
        );
    }

    @GetMapping("/findByLanguageCode/{languageCode}")
    public List<AITraining> findByLanguageCode(
            @PathVariable String languageCode
    ){
        return aiTrainingService.findByLanguageCode(
                languageCode
        );
    }

    @GetMapping("/findByQuestionContainingIgnoreCase/{keyword}")
    public List<AITraining>
    findByQuestionContainingIgnoreCase(
            @PathVariable String keyword
    ){
        return aiTrainingService
                .findByQuestionContainingIgnoreCase(
                        keyword
                );
    }
}