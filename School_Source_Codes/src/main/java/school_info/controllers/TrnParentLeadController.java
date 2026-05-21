package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.MstClass;
import school_info.models.School;
import school_info.models.Student;
import school_info.models.TrnParentLead;
import school_info.service.TrnParentLead.TrnParentLeadService;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/school_info/trnParentLead")
@CrossOrigin(origins = "*")
public class TrnParentLeadController {

    @Autowired
    private TrnParentLeadService trnParentLeadService;

    @PostMapping("/updateTrnParentLead")
    public TrnParentLead updateTrnParentLead(
            @RequestBody TrnParentLead trnParentLead
    ){
        return trnParentLeadService
                .updateTrnParentLead(
                        trnParentLead
                );
    }

    @DeleteMapping("/deleteTrnParentLead/{leadId}")
    public MessageResponse deleteTrnParentLead(
            @PathVariable Long leadId
    ){
        return trnParentLeadService
                .deleteTrnParentLead(
                        leadId
                );
    }

    @PostMapping("/findBySchool")
    public List<TrnParentLead> findBySchool(
            @RequestBody School school
    ){
        return trnParentLeadService
                .findBySchool(school);
    }

    @GetMapping("/findByLeadStatus/{leadStatus}")
    public List<TrnParentLead> findByLeadStatus(
            @PathVariable String leadStatus
    ){
        return trnParentLeadService
                .findByLeadStatus(
                        leadStatus
                );
    }

    @GetMapping("/findByMobileNumber/{mobileNumber}")
    public Optional<TrnParentLead> findByMobileNumber(
            @PathVariable String mobileNumber
    ){
        return trnParentLeadService
                .findByMobileNumber(
                        mobileNumber
                );
    }

    @GetMapping("/findByEmail/{email}")
    public Optional<TrnParentLead> findByEmail(
            @PathVariable String email
    ){
        return trnParentLeadService
                .findByEmail(email);
    }

    @PostMapping("/findByInterestedClass")
    public List<TrnParentLead> findByInterestedClass(
            @RequestBody MstClass mstClass
    ){
        return trnParentLeadService
                .findByInterestedClass(
                        mstClass
                );
    }

    @PostMapping("/findByStudent")
    public Optional<TrnParentLead> findByStudent(
            @RequestBody Student student
    ){
        return trnParentLeadService
                .findByStudent(student);
    }

    @GetMapping("/findByParentNameContainingIgnoreCase/{parentName}")
    public List<TrnParentLead>
    findByParentNameContainingIgnoreCase(
            @PathVariable String parentName
    ){
        return trnParentLeadService
                .findByParentNameContainingIgnoreCase(
                        parentName
                );
    }
}