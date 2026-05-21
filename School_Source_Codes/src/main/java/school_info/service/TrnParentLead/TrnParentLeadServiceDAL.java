package school_info.service.TrnParentLead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.MstClass;
import school_info.models.School;
import school_info.models.Student;
import school_info.models.TrnParentLead;
import school_info.repository.TrnParentLeadRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

@Service
class TrnParentLeadServiceDAL
        extends TrnParentLeadServiceImpl {

    @Autowired
    private TrnParentLeadRepository trnParentLeadRep;

    public TrnParentLeadServiceDAL() {}

    @Override
    public TrnParentLead updateTrnParentLead(
            TrnParentLead trnParentLead
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            TrnParentLead trnParentLeadToUpdate =
                    trnParentLeadRep.save(
                            trnParentLead
                    );

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Parent lead updated successfully!"
            );

            trnParentLeadToUpdate
                    .setReturnMessage(msgResp);

            return trnParentLeadToUpdate;

        }catch(Exception ex)
        {
            System.out.println(
                    "Error Is: " + ex.getMessage()
            );

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to update parent lead"
            );

            trnParentLead.setReturnMessage(msgResp);

            return trnParentLead;
        }
    }

    @Override
    public MessageResponse deleteTrnParentLead(
            Long leadId
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            trnParentLeadRep.deleteById(
                    leadId
            );

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Parent lead deleted successfully!"
            );

            return msgResp;

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to delete parent lead"
            );

            return msgResp;
        }
    }

    @Override
    public List<TrnParentLead> findBySchool(
            School school
    ){
        return trnParentLeadRep.findBySchool(
                school
        );
    }

    @Override
    public List<TrnParentLead> findByLeadStatus(
            String leadStatus
    ){
        return trnParentLeadRep.findByLeadStatus(
                leadStatus
        );
    }

    @Override
    public Optional<TrnParentLead> findByMobileNumber(
            String mobileNumber
    ){
        return trnParentLeadRep
                .findByMobileNumber(
                        mobileNumber
                );
    }

    @Override
    public Optional<TrnParentLead> findByEmail(
            String email
    ){
        return trnParentLeadRep.findByEmail(
                email
        );
    }

    @Override
    public List<TrnParentLead> findByInterestedClass(
            MstClass mstClass
    ){
        return trnParentLeadRep
                .findByInterestedClass(
                        mstClass
                );
    }

    @Override
    public Optional<TrnParentLead> findByStudent(
            Student student
    ){
        return trnParentLeadRep.findByStudent(
                student
        );
    }

    @Override
    public List<TrnParentLead>
    findByParentNameContainingIgnoreCase(
            String parentName
    ){
        return trnParentLeadRep
                .findByParentNameContainingIgnoreCase(
                        parentName
                );
    }
}