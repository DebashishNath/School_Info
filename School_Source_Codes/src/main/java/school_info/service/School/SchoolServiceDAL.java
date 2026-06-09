package school_info.service.School;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.School;
import school_info.models.Student;
import school_info.repository.MstClassRepository;
import school_info.repository.SchoolRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.util.Optional;

@Service
class SchoolServiceDAL extends SchoolServiceImpl{

    @Autowired
    private SchoolRepository schoolRep;

    public SchoolServiceDAL() {}

    @Override
    public School updateSchool(School school){
        MessageResponse msgResp =new MessageResponse();
        try{
            School schoolToUpdate = schoolRep.save(school);
            msgResp = new MessageResponse(CodeConstants.SUCCESS.getID(),
                    "School details updated successfully!");
            schoolToUpdate.setReturnMessage(msgResp);
            return schoolToUpdate;
        }catch(Exception ex)
        {
            System.out.println("Error Is: " + ex.getMessage());
            msgResp = new MessageResponse(CodeConstants.FAILURE.getID(),
                    "Failed to update student details");
            school.setReturnMessage(msgResp);
            return school;
        }
    }

    @Override
    public MessageResponse deleteSchool(Long schoolId){
        MessageResponse msgResp = new MessageResponse();
        try
        {
            schoolRep.deleteById(schoolId);
            msgResp = new MessageResponse(CodeConstants.SUCCESS.getID(), "School details deleted successfully!");
            return msgResp;
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            msgResp = new MessageResponse(CodeConstants.FAILURE.getID(),"Failed to delete school");
            return msgResp;
        }
    }

    @Override
    public Optional<School> findBySchoolId(Long schoolId){
        return schoolRep.findBySchoolId(schoolId);
    }

    @Override
    public Optional<School> findBySchoolName(String schoolName){
        return schoolRep.findBySchoolName(schoolName);
    }

    @Override
    public boolean existsBySchoolName(String schoolName){
        return schoolRep.existsBySchoolName(schoolName);
    }
}