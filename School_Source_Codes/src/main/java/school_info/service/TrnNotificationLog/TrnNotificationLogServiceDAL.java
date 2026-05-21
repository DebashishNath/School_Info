package school_info.service.TrnNotificationLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.TrnNotificationLog;
import school_info.models.TrnParentLead;
import school_info.repository.TrnNotificationLogRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.util.List;

@Service
class TrnNotificationLogServiceDAL
        extends TrnNotificationLogServiceImpl {

    @Autowired
    private TrnNotificationLogRepository trnNotificationLogRep;

    public TrnNotificationLogServiceDAL() {}

    @Override
    public TrnNotificationLog updateTrnNotificationLog(
            TrnNotificationLog trnNotificationLog
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            TrnNotificationLog trnNotificationLogToUpdate =
                    trnNotificationLogRep.save(
                            trnNotificationLog
                    );

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Notification log updated successfully!"
            );

            trnNotificationLogToUpdate
                    .setReturnMessage(msgResp);

            return trnNotificationLogToUpdate;

        }catch(Exception ex)
        {
            System.out.println(
                    "Error Is: " + ex.getMessage()
            );

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to update notification log"
            );

            trnNotificationLog
                    .setReturnMessage(msgResp);

            return trnNotificationLog;
        }
    }

    @Override
    public MessageResponse deleteTrnNotificationLog(
            Long notificationId
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            trnNotificationLogRep.deleteById(
                    notificationId
            );

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Notification log deleted successfully!"
            );

            return msgResp;

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to delete notification log"
            );

            return msgResp;
        }
    }

    @Override
    public List<TrnNotificationLog> findByLead(
            TrnParentLead lead
    ){
        return trnNotificationLogRep.findByLead(
                lead
        );
    }

    @Override
    public List<TrnNotificationLog> findByNotificationType(
            String notificationType
    ){
        return trnNotificationLogRep
                .findByNotificationType(
                        notificationType
                );
    }

    @Override
    public List<TrnNotificationLog> findBySentStatus(
            String sentStatus
    ){
        return trnNotificationLogRep
                .findBySentStatus(sentStatus);
    }
}