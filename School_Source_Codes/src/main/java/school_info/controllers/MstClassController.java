package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.MstClass;
import school_info.models.School;
import school_info.service.MstClass.MstClassService;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/school_info/mstClass")
@CrossOrigin(origins = "*")
public class MstClassController {

    @Autowired
    private MstClassService mstClassService;

    @PostMapping("/updateMstClass")
    public MstClass updateMstClass(
            @RequestBody MstClass mstClass
    ){
        return mstClassService.updateMstClass(
                mstClass
        );
    }

    @DeleteMapping("/deleteMstClass/{classId}")
    public MessageResponse deleteMstClass(
            @PathVariable Long classId
    ){
        return mstClassService.deleteMstClass(
                classId
        );
    }

    @PostMapping("/findBySchool")
    public List<MstClass> findBySchool(
            @RequestBody School school
    ){
        return mstClassService.findBySchool(
                school
        );
    }

    @PostMapping("/findBySchoolAndClassName/{className}")
    public Optional<MstClass> findBySchoolAndClassName(
            @RequestBody School school,
            @PathVariable String className
    ){
        return mstClassService
                .findBySchoolAndClassName(
                        school,
                        className
                );
    }

    @GetMapping("/findByAvailableSeatsGreaterThan/{seats}")
    public List<MstClass> findByAvailableSeatsGreaterThan(
            @PathVariable Integer seats
    ){
        return mstClassService
                .findByAvailableSeatsGreaterThan(
                        seats
                );
    }
}