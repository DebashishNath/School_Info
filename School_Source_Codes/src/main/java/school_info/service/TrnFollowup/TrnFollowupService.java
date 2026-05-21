package school_info.service.TrnFollowup;

import school_info.models.TrnFollowup;
import school_info.models.TrnParentLead;
import utils.MessageResponse;

import java.sql.Timestamp;
import java.util.List;

public interface TrnFollowupService {

    TrnFollowup updateTrnFollowup(
            TrnFollowup trnFollowup
    );

    MessageResponse deleteTrnFollowup(
            Long followupId
    );

    List<TrnFollowup> findByLead(
            TrnParentLead lead
    );

    List<TrnFollowup> findByReminderStatus(
            String reminderStatus
    );

    List<TrnFollowup> findByReminderDateBefore(
            Timestamp timestamp
    );
}