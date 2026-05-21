package school_info.service.TrnFollowup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.TrnFollowup;
import school_info.models.TrnParentLead;
import school_info.repository.TrnFollowupRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.sql.Timestamp;
import java.util.List;

@Service
class TrnFollowupServiceDAL
        extends TrnFollowupServiceImpl {

    @Autowired
    private TrnFollowupRepository trnFollowupRep;

    public TrnFollowupServiceDAL() {}

    @Override
    public TrnFollowup updateTrnFollowup(
            TrnFollowup trnFollowup
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            TrnFollowup trnFollowupToUpdate =
                    trnFollowupRep.save(trnFollowup);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Followup updated successfully!"
            );

            trnFollowupToUpdate
                    .setReturnMessage(msgResp);

            return trnFollowupToUpdate;

        }catch(Exception ex)
        {
            System.out.println(
                    "Error Is: " + ex.getMessage()
            );

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to update followup"
            );

            trnFollowup.setReturnMessage(msgResp);

            return trnFollowup;
        }
    }

    @Override
    public MessageResponse deleteTrnFollowup(
            Long followupId
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            trnFollowupRep.deleteById(followupId);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Followup deleted successfully!"
            );

            return msgResp;

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to delete followup"
            );

            return msgResp;
        }
    }

    @Override
    public List<TrnFollowup> findByLead(
            TrnParentLead lead
    ){
        return trnFollowupRep.findByLead(lead);
    }

    @Override
    public List<TrnFollowup> findByReminderStatus(
            String reminderStatus
    ){
        return trnFollowupRep
                .findByReminderStatus(reminderStatus);
    }

    @Override
    public List<TrnFollowup> findByReminderDateBefore(
            Timestamp timestamp
    ){
        return trnFollowupRep
                .findByReminderDateBefore(timestamp);
    }
}