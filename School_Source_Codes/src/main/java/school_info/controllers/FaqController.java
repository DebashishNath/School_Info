package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.Faq;
import school_info.models.School;
import school_info.service.Faq.FaqService;
import utils.MessageResponse;

import java.util.List;

@RestController
@RequestMapping("/api/school_info/faq")
@CrossOrigin(origins = "*")
public class FaqController {

    @Autowired
    private FaqService faqService;

    @PostMapping("/updateFaq")
    public Faq updateFaq(
            @RequestBody Faq faq
    ){
        return faqService.updateFaq(faq);
    }

    @DeleteMapping("/deleteFaq/{faqId}")
    public MessageResponse deleteFaq(
            @PathVariable Long faqId
    ){
        return faqService.deleteFaq(faqId);
    }

    @PostMapping("/findBySchool")
    public List<Faq> findBySchool(
            @RequestBody School school
    ){
        return faqService.findBySchool(school);
    }

    @PostMapping("/findBySchoolAndIsActive/{isActive}")
    public List<Faq> findBySchoolAndIsActive(
            @RequestBody School school,
            @PathVariable String isActive
    ){
        return faqService.findBySchoolAndIsActive(
                school,
                isActive
        );
    }

    @GetMapping("/findByCategory/{category}")
    public List<Faq> findByCategory(
            @PathVariable String category
    ){
        return faqService.findByCategory(category);
    }

    @GetMapping("/findByQuestionContainingIgnoreCase/{keyword}")
    public List<Faq> findByQuestionContainingIgnoreCase(
            @PathVariable String keyword
    ){
        return faqService
                .findByQuestionContainingIgnoreCase(
                        keyword
                );
    }
}