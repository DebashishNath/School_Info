package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.TrnChatSession;
import school_info.models.TrnParentLead;
import school_info.service.TrnChatSession.TrnChatSessionService;
import utils.MessageResponse;

import java.util.List;

@RestController
@RequestMapping("/api/school_info/trnChatSession")
@CrossOrigin(origins = "*")
public class TrnChatSessionController {

    @Autowired
    private TrnChatSessionService trnChatSessionService;

    @PostMapping("/updateTrnChatSession")
    public TrnChatSession updateTrnChatSession(
            @RequestBody TrnChatSession trnChatSession
    ){
        return trnChatSessionService
                .updateTrnChatSession(
                        trnChatSession
                );
    }

    @DeleteMapping("/deleteTrnChatSession/{sessionId}")
    public MessageResponse deleteTrnChatSession(
            @PathVariable Long sessionId
    ){
        return trnChatSessionService
                .deleteTrnChatSession(sessionId);
    }

    @PostMapping("/findByLead")
    public List<TrnChatSession> findByLead(
            @RequestBody TrnParentLead lead
    ){
        return trnChatSessionService
                .findByLead(lead);
    }

    @GetMapping("/findByCommunicationChannel/{communicationChannel}")
    public List<TrnChatSession> findByCommunicationChannel(
            @PathVariable String communicationChannel
    ){
        return trnChatSessionService
                .findByCommunicationChannel(
                        communicationChannel
                );
    }

    @GetMapping("/findByAiHandled/{aiHandled}")
    public List<TrnChatSession> findByAiHandled(
            @PathVariable String aiHandled
    ){
        return trnChatSessionService
                .findByAiHandled(aiHandled);
    }
}