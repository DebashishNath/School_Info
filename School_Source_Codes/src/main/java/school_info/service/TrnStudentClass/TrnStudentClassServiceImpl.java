package school_info.service.TrnStudentClass;

import school_info.models.MstClass;
import school_info.models.Student;
import school_info.models.TrnStudentClass;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

abstract class TrnStudentClassServiceImpl
        implements TrnStudentClassService {

    @Override
    public TrnStudentClass updateTrnStudentClass(
            TrnStudentClass trnStudentClass
    ){
        return new TrnStudentClassServiceDAL()
                .updateTrnStudentClass(trnStudentClass);
    }

    @Override
    public MessageResponse deleteTrnStudentClass(
            Long studentClassId
    ){
        return new TrnStudentClassServiceDAL()
                .deleteTrnStudentClass(studentClassId);
    }

    @Override
    public List<TrnStudentClass> findByStudent(
            Student student
    ){
        return new TrnStudentClassServiceDAL()
                .findByStudent(student);
    }

    @Override
    public List<TrnStudentClass> findByMstClass(
            MstClass mstClass
    ){
        return new TrnStudentClassServiceDAL()
                .findByMstClass(mstClass);
    }

    @Override
    public Optional<TrnStudentClass> findByStudentAndAcademicYear(
            Student student,
            String academicYear
    ){
        return new TrnStudentClassServiceDAL()
                .findByStudentAndAcademicYear(
                        student,
                        academicYear
                );
    }

    @Override
    public List<TrnStudentClass> findByStatus(
            String status
    ){
        return new TrnStudentClassServiceDAL()
                .findByStatus(status);
    }

    @Override
    public Optional<TrnStudentClass> findByRollNumber(
            String rollNumber
    ){
        return new TrnStudentClassServiceDAL()
                .findByRollNumber(rollNumber);
    }
}