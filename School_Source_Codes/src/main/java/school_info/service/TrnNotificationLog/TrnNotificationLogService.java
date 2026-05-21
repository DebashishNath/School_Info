package school_info.service.TrnNotificationLog;

import school_info.models.TrnNotificationLog;
import school_info.models.TrnParentLead;
import utils.MessageResponse;

import java.util.List;

public interface TrnNotificationLogService {

    TrnNotificationLog updateTrnNotificationLog(
            TrnNotificationLog trnNotificationLog
    );

    MessageResponse deleteTrnNotificationLog(
            Long notificationId
    );

    List<TrnNotificationLog> findByLead(
            TrnParentLead lead
    );

    List<TrnNotificationLog> findByNotificationType(
            String notificationType
    );

    List<TrnNotificationLog> findBySentStatus(
            String sentStatus
    );
}