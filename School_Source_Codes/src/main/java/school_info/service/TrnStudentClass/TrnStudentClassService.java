package school_info.service.TrnStudentClass;

import school_info.models.MstClass;
import school_info.models.Student;
import school_info.models.TrnStudentClass;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface TrnStudentClassService {

    TrnStudentClass updateTrnStudentClass(
            TrnStudentClass trnStudentClass
    );

    MessageResponse deleteTrnStudentClass(Long studentClassId);

    List<TrnStudentClass> findByStudent(Student student);

    List<TrnStudentClass> findByMstClass(MstClass mstClass);

    Optional<TrnStudentClass> findByStudentAndAcademicYear(
            Student student,
            String academicYear
    );

    List<TrnStudentClass> findByStatus(String status);

    Optional<TrnStudentClass> findByRollNumber(String rollNumber);
}