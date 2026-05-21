package school_info.service.TrnChatMessage;

import school_info.models.TrnChatMessage;
import school_info.models.TrnChatSession;
import utils.MessageResponse;

import java.util.List;

public interface TrnChatMessageService {

    TrnChatMessage updateTrnChatMessage(
            TrnChatMessage trnChatMessage
    );

    MessageResponse deleteTrnChatMessage(Long messageId);

    List<TrnChatMessage> findBySession(
            TrnChatSession session
    );

    List<TrnChatMessage> findBySenderType(
            String senderType
    );

    List<TrnChatMessage> findBySessionOrderByMessageTimeAsc(
            TrnChatSession session
    );
}