package school_info.service.TrnChatSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.TrnChatSession;
import school_info.models.TrnParentLead;
import school_info.repository.TrnChatSessionRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.util.List;

@Service
class TrnChatSessionServiceDAL
        extends TrnChatSessionServiceImpl {

    @Autowired
    private TrnChatSessionRepository trnChatSessionRep;

    public TrnChatSessionServiceDAL() {}

    @Override
    public TrnChatSession updateTrnChatSession(
            TrnChatSession trnChatSession
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            TrnChatSession trnChatSessionToUpdate =
                    trnChatSessionRep.save(trnChatSession);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Chat session updated successfully!"
            );

            trnChatSessionToUpdate.setReturnMessage(msgResp);

            return trnChatSessionToUpdate;

        }catch(Exception ex)
        {
            System.out.println("Error Is: " + ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to update chat session"
            );

            trnChatSession.setReturnMessage(msgResp);

            return trnChatSession;
        }
    }

    @Override
    public MessageResponse deleteTrnChatSession(
            Long sessionId
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            trnChatSessionRep.deleteById(sessionId);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Chat session deleted successfully!"
            );

            return msgResp;

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to delete chat session"
            );

            return msgResp;
        }
    }

    @Override
    public List<TrnChatSession> findByLead(
            TrnParentLead lead
    ){
        return trnChatSessionRep.findByLead(lead);
    }

    @Override
    public List<TrnChatSession> findByCommunicationChannel(
            String communicationChannel
    ){
        return trnChatSessionRep
                .findByCommunicationChannel(
                        communicationChannel
                );
    }

    @Override
    public List<TrnChatSession> findByAiHandled(
            String aiHandled
    ){
        return trnChatSessionRep.findByAiHandled(aiHandled);
    }
}