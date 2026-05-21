package school_info.service.TrnFollowup;

import school_info.models.TrnFollowup;
import school_info.models.TrnParentLead;
import utils.MessageResponse;

import java.sql.Timestamp;
import java.util.List;

abstract class TrnFollowupServiceImpl
        implements TrnFollowupService {

    @Override
    public TrnFollowup updateTrnFollowup(
            TrnFollowup trnFollowup
    ){
        return new TrnFollowupServiceDAL()
                .updateTrnFollowup(trnFollowup);
    }

    @Override
    public MessageResponse deleteTrnFollowup(
            Long followupId
    ){
        return new TrnFollowupServiceDAL()
                .deleteTrnFollowup(followupId);
    }

    @Override
    public List<TrnFollowup> findByLead(
            TrnParentLead lead
    ){
        return new TrnFollowupServiceDAL()
                .findByLead(lead);
    }

    @Override
    public List<TrnFollowup> findByReminderStatus(
            String reminderStatus
    ){
        return new TrnFollowupServiceDAL()
                .findByReminderStatus(reminderStatus);
    }

    @Override
    public List<TrnFollowup> findByReminderDateBefore(
            Timestamp timestamp
    ){
        return new TrnFollowupServiceDAL()
                .findByReminderDateBefore(timestamp);
    }
}