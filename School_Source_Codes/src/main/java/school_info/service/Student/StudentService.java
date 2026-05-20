package school_info.service.Student;

import school_info.models.Student;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student updateStudent(Student student);

    MessageResponse deleteStudent(Long studentId);

    Optional<Student> findByStudentId(Long studentId);

    List<Student> findAllStudents();

    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    List<Student> findByGender(String gender);
}