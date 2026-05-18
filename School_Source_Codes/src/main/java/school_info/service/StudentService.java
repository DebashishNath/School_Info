package school_info.service;

import school_info.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Long studentId);

    Optional<Student> findById(Long studentId);

    List<Student> findAllStudents();

    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    List<Student> findByGender(String gender);
}