package school_info.service.TrnChatSession;

import school_info.models.TrnChatSession;
import school_info.models.TrnParentLead;
import utils.MessageResponse;

import java.util.List;

abstract class TrnChatSessionServiceImpl
        implements TrnChatSessionService {

    @Override
    public TrnChatSession updateTrnChatSession(
            TrnChatSession trnChatSession
    ){
        return new TrnChatSessionServiceDAL()
                .updateTrnChatSession(trnChatSession);
    }

    @Override
    public MessageResponse deleteTrnChatSession(
            Long sessionId
    ){
        return new TrnChatSessionServiceDAL()
                .deleteTrnChatSession(sessionId);
    }

    @Override
    public List<TrnChatSession> findByLead(
            TrnParentLead lead
    ){
        return new TrnChatSessionServiceDAL()
                .findByLead(lead);
    }

    @Override
    public List<TrnChatSession> findByCommunicationChannel(
            String communicationChannel
    ){
        return new TrnChatSessionServiceDAL()
                .findByCommunicationChannel(
                        communicationChannel
                );
    }

    @Override
    public List<TrnChatSession> findByAiHandled(
            String aiHandled
    ){
        return new TrnChatSessionServiceDAL()
                .findByAiHandled(aiHandled);
    }
}