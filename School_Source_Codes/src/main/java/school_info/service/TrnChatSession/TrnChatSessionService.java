package school_info.service.TrnChatSession;

import school_info.models.TrnChatSession;
import school_info.models.TrnParentLead;
import utils.MessageResponse;

import java.util.List;

public interface TrnChatSessionService {

    TrnChatSession updateTrnChatSession(
            TrnChatSession trnChatSession
    );

    MessageResponse deleteTrnChatSession(Long sessionId);

    List<TrnChatSession> findByLead(
            TrnParentLead lead
    );

    List<TrnChatSession> findByCommunicationChannel(
            String communicationChannel
    );

    List<TrnChatSession> findByAiHandled(
            String aiHandled
    );
}