package school_info.service;

import school_info.models.Student;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

abstract class StudentServiceImpl implements StudentService {

    @Override
    public Student updateStudent(Student student){
        return new StudentServiceDAL().updateStudent(student);
    }

    @Override
    public MessageResponse deleteStudent(Long studentId){
        return new StudentServiceDAL().deleteStudent(studentId);
    }

    @Override
    public Optional<Student> findByStudentId(Long studentId){
        return new StudentServiceDAL().findByStudentId(studentId);
    }

    @Override
    public List<Student> findAllStudents(){
        return new StudentServiceDAL().findAllStudents();
    }

    @Override
    public List<Student> findByFirstName(String firstName){
        return new StudentServiceDAL().findByFirstName(firstName);
    }

    @Override
    public List<Student> findByLastName(String lastName){
        return new StudentServiceDAL().findByLastName(lastName);
    }

    @Override
    public List<Student> findByGender(String gender){
        return new StudentServiceDAL().findByGender(gender);
    }
}