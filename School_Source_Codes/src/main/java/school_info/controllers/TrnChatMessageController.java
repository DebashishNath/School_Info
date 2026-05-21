package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.TrnChatMessage;
import school_info.models.TrnChatSession;
import school_info.service.TrnChatMessage.TrnChatMessageService;
import utils.MessageResponse;

import java.util.List;

@RestController
@RequestMapping("/api/school_info/trnChatMessage")
@CrossOrigin(origins = "*")
public class TrnChatMessageController {

    @Autowired
    private TrnChatMessageService trnChatMessageService;

    @PostMapping("/updateTrnChatMessage")
    public TrnChatMessage updateTrnChatMessage(
            @RequestBody TrnChatMessage trnChatMessage
    ){
        return trnChatMessageService
                .updateTrnChatMessage(
                        trnChatMessage
                );
    }

    @DeleteMapping("/deleteTrnChatMessage/{messageId}")
    public MessageResponse deleteTrnChatMessage(
            @PathVariable Long messageId
    ){
        return trnChatMessageService
                .deleteTrnChatMessage(messageId);
    }

    @PostMapping("/findBySession")
    public List<TrnChatMessage> findBySession(
            @RequestBody TrnChatSession session
    ){
        return trnChatMessageService
                .findBySession(session);
    }

    @GetMapping("/findBySenderType/{senderType}")
    public List<TrnChatMessage> findBySenderType(
            @PathVariable String senderType
    ){
        return trnChatMessageService
                .findBySenderType(senderType);
    }

    @PostMapping("/findBySessionOrderByMessageTimeAsc")
    public List<TrnChatMessage>
    findBySessionOrderByMessageTimeAsc(
            @RequestBody TrnChatSession session
    ){
        return trnChatMessageService
                .findBySessionOrderByMessageTimeAsc(
                        session
                );
    }
}