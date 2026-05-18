package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.School;
import school_info.models.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findBySchool(School school);

    List<Student> findByFirstNameContainingIgnoreCase(String firstName);

    List<Student> findByLastNameContainingIgnoreCase(String lastName);

    List<Student> findByDateOfBirth(LocalDate dateOfBirth);

    List<Student> findByGender(String gender);
}