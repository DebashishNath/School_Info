package school_info.service.TrnChatMessage;

import school_info.models.TrnChatMessage;
import school_info.models.TrnChatSession;
import utils.MessageResponse;

import java.util.List;

abstract class TrnChatMessageServiceImpl
        implements TrnChatMessageService {

    @Override
    public TrnChatMessage updateTrnChatMessage(
            TrnChatMessage trnChatMessage
    ){
        return new TrnChatMessageServiceDAL()
                .updateTrnChatMessage(trnChatMessage);
    }

    @Override
    public MessageResponse deleteTrnChatMessage(
            Long messageId
    ){
        return new TrnChatMessageServiceDAL()
                .deleteTrnChatMessage(messageId);
    }

    @Override
    public List<TrnChatMessage> findBySession(
            TrnChatSession session
    ){
        return new TrnChatMessageServiceDAL()
                .findBySession(session);
    }

    @Override
    public List<TrnChatMessage> findBySenderType(
            String senderType
    ){
        return new TrnChatMessageServiceDAL()
                .findBySenderType(senderType);
    }

    @Override
    public List<TrnChatMessage> findBySessionOrderByMessageTimeAsc(
            TrnChatSession session
    ){
        return new TrnChatMessageServiceDAL()
                .findBySessionOrderByMessageTimeAsc(session);
    }
}