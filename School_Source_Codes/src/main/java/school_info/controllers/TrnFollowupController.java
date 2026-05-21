package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.TrnFollowup;
import school_info.models.TrnParentLead;
import school_info.service.TrnFollowup.TrnFollowupService;
import utils.MessageResponse;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/school_info/trnFollowup")
@CrossOrigin(origins = "*")
public class TrnFollowupController {

    @Autowired
    private TrnFollowupService trnFollowupService;

    @PostMapping("/updateTrnFollowup")
    public TrnFollowup updateTrnFollowup(
            @RequestBody TrnFollowup trnFollowup
    ){
        return trnFollowupService
                .updateTrnFollowup(
                        trnFollowup
                );
    }

    @DeleteMapping("/deleteTrnFollowup/{followupId}")
    public MessageResponse deleteTrnFollowup(
            @PathVariable Long followupId
    ){
        return trnFollowupService
                .deleteTrnFollowup(
                        followupId
                );
    }

    @PostMapping("/findByLead")
    public List<TrnFollowup> findByLead(
            @RequestBody TrnParentLead lead
    ){
        return trnFollowupService
                .findByLead(lead);
    }

    @GetMapping("/findByReminderStatus/{reminderStatus}")
    public List<TrnFollowup> findByReminderStatus(
            @PathVariable String reminderStatus
    ){
        return trnFollowupService
                .findByReminderStatus(
                        reminderStatus
                );
    }

    @GetMapping("/findByReminderDateBefore/{timestamp}")
    public List<TrnFollowup> findByReminderDateBefore(
            @PathVariable Timestamp timestamp
    ){
        return trnFollowupService
                .findByReminderDateBefore(
                        timestamp
                );
    }
}