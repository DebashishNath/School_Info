package school_info.ai;

import org.springframework.stereotype.Service;
import school_info.models.TrnChatMessage;
import school_info.models.TrnChatSession;
import school_info.repository.TrnChatMessageRepository;
import school_info.repository.TrnChatSessionRepository;

import java.util.List;

@Service
public class ChatHistoryService {

    private static final String PARENT = "PARENT";

    private static final String AI = "AI";

    private final TrnChatSessionRepository chatSessionRepository;

    private final TrnChatMessageRepository chatMessageRepository;

    public ChatHistoryService(

            TrnChatSessionRepository chatSessionRepository,

            TrnChatMessageRepository chatMessageRepository

    ) {

        this.chatSessionRepository = chatSessionRepository;
        this.chatMessageRepository = chatMessageRepository;

    }

    public String loadConversation(
            Long sessionId
    ) {

        TrnChatSession session =
                getSession(sessionId);

        if (session == null) {

            return "";

        }

        List<TrnChatMessage> messageList =
                chatMessageRepository
                        .findBySessionOrderByMessageTimeAsc(
                                session
                        );

        StringBuilder history =
                new StringBuilder();

        for (TrnChatMessage message : messageList) {

            history.append(
                    message.getSenderType()
            );

            history.append(": ");

            history.append(
                    message.getMessageText()
            );

            history.append("\n");

        }

        return history.toString();

    }

    public void saveChatHistory(

            Long sessionId,

            String parentQuestion,

            String aiAnswer

    ) {

        TrnChatSession session =
                getSession(sessionId);

        if (session == null) {

            return;

        }

        saveMessage(

                session,

                PARENT,

                parentQuestion

        );

        saveMessage(

                session,

                AI,

                aiAnswer

        );

    }

    private TrnChatSession getSession(
            Long sessionId
    ) {

        if (sessionId == null) {

            return null;

        }

        return chatSessionRepository

                .findById(sessionId)

                .orElse(null);

    }

    private void saveMessage(

            TrnChatSession session,

            String senderType,

            String messageText

    ) {

        if (session == null) {

            return;

        }

        if (messageText == null ||
                messageText.trim().isEmpty()) {

            return;

        }

        TrnChatMessage message =
                new TrnChatMessage();

        message.setSession(
                session
        );

        message.setSenderType(
                senderType
        );

        message.setMessageText(
                messageText.trim()
        );

        chatMessageRepository.save(
                message
        );

    }

}