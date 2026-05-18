package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.Student;
import school_info.models.TrnStudentClass;

import java.util.List;
import java.util.Optional;

public interface TrnStudentClassRepository extends JpaRepository<TrnStudentClass, Long> {

    List<TrnStudentClass> findByStudent(Student student);

    List<TrnStudentClass> findByMstClass(Class mstClass);

    Optional<TrnStudentClass> findByStudentAndAcademicYear(
            Student student,
            String academicYear
    );

    List<TrnStudentClass> findByStatus(String status);

    Optional<TrnStudentClass> findByRollNumber(String rollNumber);
}