package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.School;
import school_info.service.School.SchoolService;
import utils.MessageResponse;

import java.util.Optional;

@RestController
@RequestMapping("/api/school_info/school")
@CrossOrigin(origins = "*")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/updateSchool")
    public School updateSchool(
            @RequestBody School school
    ){
        return schoolService.updateSchool(school);
    }

    @DeleteMapping("/deleteSchool/{schoolId}")
    public MessageResponse deleteSchool(
            @PathVariable Long schoolId
    ){
        return schoolService.deleteSchool(schoolId);
    }

    @GetMapping("/findBySchoolName/{schoolName}")
    public Optional<School> findBySchoolName(
            @PathVariable String schoolName
    ){
        return schoolService.findBySchoolName(
                schoolName
        );
    }

    @GetMapping("/existsBySchoolName/{schoolName}")
    public boolean existsBySchoolName(
            @PathVariable String schoolName
    ){
        return schoolService.existsBySchoolName(
                schoolName
        );
    }
}
