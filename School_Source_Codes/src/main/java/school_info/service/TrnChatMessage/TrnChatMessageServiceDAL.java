package school_info.service.TrnChatMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.TrnChatMessage;
import school_info.models.TrnChatSession;
import school_info.repository.TrnChatMessageRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.util.List;

@Service
class TrnChatMessageServiceDAL
        extends TrnChatMessageServiceImpl {

    @Autowired
    private TrnChatMessageRepository trnChatMessageRep;

    public TrnChatMessageServiceDAL() {}

    @Override
    public TrnChatMessage updateTrnChatMessage(
            TrnChatMessage trnChatMessage
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            TrnChatMessage trnChatMessageToUpdate =
                    trnChatMessageRep.save(trnChatMessage);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Chat message updated successfully!"
            );

            trnChatMessageToUpdate.setReturnMessage(msgResp);

            return trnChatMessageToUpdate;

        }catch(Exception ex)
        {
            System.out.println("Error Is: " + ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to update chat message"
            );

            trnChatMessage.setReturnMessage(msgResp);

            return trnChatMessage;
        }
    }

    @Override
    public MessageResponse deleteTrnChatMessage(
            Long messageId
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            trnChatMessageRep.deleteById(messageId);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Chat message deleted successfully!"
            );

            return msgResp;

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to delete chat message"
            );

            return msgResp;
        }
    }

    @Override
    public List<TrnChatMessage> findBySession(
            TrnChatSession session
    ){
        return trnChatMessageRep.findBySession(session);
    }

    @Override
    public List<TrnChatMessage> findBySenderType(
            String senderType
    ){
        return trnChatMessageRep.findBySenderType(senderType);
    }

    @Override
    public List<TrnChatMessage> findBySessionOrderByMessageTimeAsc(
            TrnChatSession session
    ){
        return trnChatMessageRep
                .findBySessionOrderByMessageTimeAsc(session);
    }
}