package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.MstClass;
import school_info.models.Student;
import school_info.models.TrnStudentClass;
import school_info.service.TrnStudentClass.TrnStudentClassService;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/school_info/trnStudentClass")
@CrossOrigin(origins = "*")
public class TrnStudentClassController {

    @Autowired
    private TrnStudentClassService trnStudentClassService;

    @PostMapping("/updateTrnStudentClass")
    public TrnStudentClass updateTrnStudentClass(
            @RequestBody TrnStudentClass trnStudentClass
    ){
        return trnStudentClassService
                .updateTrnStudentClass(
                        trnStudentClass
                );
    }

    @DeleteMapping("/deleteTrnStudentClass/{studentClassId}")
    public MessageResponse deleteTrnStudentClass(
            @PathVariable Long studentClassId
    ){
        return trnStudentClassService
                .deleteTrnStudentClass(
                        studentClassId
                );
    }

    @PostMapping("/findByStudent")
    public List<TrnStudentClass> findByStudent(
            @RequestBody Student student
    ){
        return trnStudentClassService
                .findByStudent(student);
    }

    @PostMapping("/findByMstClass")
    public List<TrnStudentClass> findByMstClass(
            @RequestBody MstClass mstClass
    ){
        return trnStudentClassService
                .findByMstClass(mstClass);
    }

    @PostMapping("/findByStudentAndAcademicYear/{academicYear}")
    public Optional<TrnStudentClass>
    findByStudentAndAcademicYear(
            @RequestBody Student student,
            @PathVariable String academicYear
    ){
        return trnStudentClassService
                .findByStudentAndAcademicYear(
                        student,
                        academicYear
                );
    }

    @GetMapping("/findByStatus/{status}")
    public List<TrnStudentClass> findByStatus(
            @PathVariable String status
    ){
        return trnStudentClassService
                .findByStatus(status);
    }

    @GetMapping("/findByRollNumber/{rollNumber}")
    public Optional<TrnStudentClass> findByRollNumber(
            @PathVariable String rollNumber
    ){
        return trnStudentClassService
                .findByRollNumber(
                        rollNumber
                );
    }
}