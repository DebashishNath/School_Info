package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.TrnNotificationLog;
import school_info.models.TrnParentLead;
import school_info.service.TrnNotificationLog.TrnNotificationLogService;
import utils.MessageResponse;

import java.util.List;

@RestController
@RequestMapping("/api/school_info/trnNotificationLog")
@CrossOrigin(origins = "*")
public class TrnNotificationLogController {

    @Autowired
    private TrnNotificationLogService trnNotificationLogService;

    @PostMapping("/updateTrnNotificationLog")
    public TrnNotificationLog updateTrnNotificationLog(
            @RequestBody TrnNotificationLog trnNotificationLog
    ){
        return trnNotificationLogService
                .updateTrnNotificationLog(
                        trnNotificationLog
                );
    }

    @DeleteMapping("/deleteTrnNotificationLog/{notificationId}")
    public MessageResponse deleteTrnNotificationLog(
            @PathVariable Long notificationId
    ){
        return trnNotificationLogService
                .deleteTrnNotificationLog(
                        notificationId
                );
    }

    @PostMapping("/findByLead")
    public List<TrnNotificationLog> findByLead(
            @RequestBody TrnParentLead lead
    ){
        return trnNotificationLogService
                .findByLead(lead);
    }

    @GetMapping("/findByNotificationType/{notificationType}")
    public List<TrnNotificationLog> findByNotificationType(
            @PathVariable String notificationType
    ){
        return trnNotificationLogService
                .findByNotificationType(
                        notificationType
                );
    }

    @GetMapping("/findBySentStatus/{sentStatus}")
    public List<TrnNotificationLog> findBySentStatus(
            @PathVariable String sentStatus
    ){
        return trnNotificationLogService
                .findBySentStatus(sentStatus);
    }
}