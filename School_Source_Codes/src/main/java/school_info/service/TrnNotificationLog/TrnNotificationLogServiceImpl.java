package school_info.service.TrnNotificationLog;

import school_info.models.TrnNotificationLog;
import school_info.models.TrnParentLead;
import utils.MessageResponse;

import java.util.List;

abstract class TrnNotificationLogServiceImpl
        implements TrnNotificationLogService {

    @Override
    public TrnNotificationLog updateTrnNotificationLog(
            TrnNotificationLog trnNotificationLog
    ){
        return new TrnNotificationLogServiceDAL()
                .updateTrnNotificationLog(trnNotificationLog);
    }

    @Override
    public MessageResponse deleteTrnNotificationLog(
            Long notificationId
    ){
        return new TrnNotificationLogServiceDAL()
                .deleteTrnNotificationLog(notificationId);
    }

    @Override
    public List<TrnNotificationLog> findByLead(
            TrnParentLead lead
    ){
        return new TrnNotificationLogServiceDAL()
                .findByLead(lead);
    }

    @Override
    public List<TrnNotificationLog> findByNotificationType(
            String notificationType
    ){
        return new TrnNotificationLogServiceDAL()
                .findByNotificationType(notificationType);
    }

    @Override
    public List<TrnNotificationLog> findBySentStatus(
            String sentStatus
    ){
        return new TrnNotificationLogServiceDAL()
                .findBySentStatus(sentStatus);
    }
}