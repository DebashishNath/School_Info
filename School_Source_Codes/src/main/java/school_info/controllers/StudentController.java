package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.Student;
import school_info.service.Student.StudentService;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/school_info/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/updateStudent")
    public Student updateStudent(
            @RequestBody Student student
    ){
        return studentService.updateStudent(
                student
        );
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public MessageResponse deleteStudent(
            @PathVariable Long studentId
    ){
        return studentService.deleteStudent(
                studentId
        );
    }

    @GetMapping("/findByStudentId/{studentId}")
    public Optional<Student> findByStudentId(
            @PathVariable Long studentId
    ){
        return studentService.findByStudentId(
                studentId
        );
    }

    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping("/findByFirstName/{firstName}")
    public List<Student> findByFirstName(
            @PathVariable String firstName
    ){
        return studentService.findByFirstName(
                firstName
        );
    }

    @GetMapping("/findByLastName/{lastName}")
    public List<Student> findByLastName(
            @PathVariable String lastName
    ){
        return studentService.findByLastName(
                lastName
        );
    }

    @GetMapping("/findByGender/{gender}")
    public List<Student> findByGender(
            @PathVariable String gender
    ){
        return studentService.findByGender(
                gender
        );
    }
}