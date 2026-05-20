package school_info.service.MstClass;

import org.springframework.beans.factory.annotation.Autowired;
import school_info.models.MstClass;
import school_info.models.School;
import school_info.models.Student;
import school_info.repository.MstClassRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

class MstClassServiceDAL extends MstClassServiceImpl{

    @Autowired
    private MstClassRepository mstClassRep;

    public MstClassServiceDAL() {}

    @Override
    public MstClass updateMstClass(MstClass mstClass){
        MessageResponse msgResp =new MessageResponse();
        try{
            MstClass mstClassToUpdate = mstClassRep.save(mstClass);
            msgResp = new MessageResponse(CodeConstants.SUCCESS.getID(),
                    "Class details updated successfully!");
            mstClassToUpdate.setReturnMessage(msgResp);
            return mstClassToUpdate;
        }catch(Exception ex)
        {
            System.out.println("Error Is: " + ex.getMessage());
            msgResp = new MessageResponse(CodeConstants.FAILURE.getID(),
                    "Failed to update class details");
            mstClass.setReturnMessage(msgResp);
            return mstClass;
        }
    }

    @Override
    public MessageResponse deleteMstClass(Long classId)
    {
        MessageResponse msgResp = new MessageResponse();
        try
        {
            mstClassRep.deleteById(classId);
            msgResp = new MessageResponse(CodeConstants.SUCCESS.getID(), "Class details deleted successfully!");
            return msgResp;
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            msgResp = new MessageResponse(CodeConstants.FAILURE.getID(),"Failed to delete class");
            return msgResp;
        }
    }

    @Override
    public List<MstClass> findBySchool(School school){
        return mstClassRep.findBySchool(school);
    }

    @Override
    public Optional<MstClass> findBySchoolAndClassName(
            School school,
            String className
    ){
        return mstClassRep.findBySchoolAndClassName(school,className);
    }

    @Override
    public List<MstClass> findByAvailableSeatsGreaterThan(Integer seats){
        return mstClassRep.findByAvailableSeatsGreaterThan(seats);
    }
}