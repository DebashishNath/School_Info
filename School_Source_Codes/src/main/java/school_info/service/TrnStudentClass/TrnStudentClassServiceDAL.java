package school_info.service.TrnStudentClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.MstClass;
import school_info.models.Student;
import school_info.models.TrnStudentClass;
import school_info.repository.TrnStudentClassRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

@Service
class TrnStudentClassServiceDAL
        extends TrnStudentClassServiceImpl {

    @Autowired
    private TrnStudentClassRepository trnStudentClassRep;

    public TrnStudentClassServiceDAL() {}

    @Override
    public TrnStudentClass updateTrnStudentClass(
            TrnStudentClass trnStudentClass
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            TrnStudentClass trnStudentClassToUpdate =
                    trnStudentClassRep.save(trnStudentClass);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Student class updated successfully!"
            );

            trnStudentClassToUpdate.setReturnMessage(msgResp);

            return trnStudentClassToUpdate;

        }catch(Exception ex)
        {
            System.out.println("Error Is: " + ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to update student class"
            );

            trnStudentClass.setReturnMessage(msgResp);

            return trnStudentClass;
        }
    }

    @Override
    public MessageResponse deleteTrnStudentClass(
            Long studentClassId
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            trnStudentClassRep.deleteById(studentClassId);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Student class deleted successfully!"
            );

            return msgResp;

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to delete student class"
            );

            return msgResp;
        }
    }

    @Override
    public List<TrnStudentClass> findByStudent(
            Student student
    ){
        return trnStudentClassRep.findByStudent(student);
    }

    @Override
    public List<TrnStudentClass> findByMstClass(
            MstClass mstClass
    ){
        return trnStudentClassRep.findByMstClass(mstClass);
    }

    @Override
    public Optional<TrnStudentClass> findByStudentAndAcademicYear(
            Student student,
            String academicYear
    ){
        return trnStudentClassRep
                .findByStudentAndAcademicYear(
                        student,
                        academicYear
                );
    }

    @Override
    public List<TrnStudentClass> findByStatus(
            String status
    ){
        return trnStudentClassRep.findByStatus(status);
    }

    @Override
    public Optional<TrnStudentClass> findByRollNumber(
            String rollNumber
    ){
        return trnStudentClassRep.findByRollNumber(rollNumber);
    }
}