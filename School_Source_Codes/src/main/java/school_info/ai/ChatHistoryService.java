package school_info.ai;

import org.springframework.stereotype.Service;
import school_info.models.TrnChatMessage;
import school_info.models.TrnChatSession;
import school_info.repository.TrnChatMessageRepository;

import java.util.List;

@Service
public class ChatHistoryService {

    private final TrnChatMessageRepository chatMessageRep;

    public ChatHistoryService(
            TrnChatMessageRepository chatMessageRep
    ) {

        this.chatMessageRep = chatMessageRep;

    }

    public String loadConversation(
            TrnChatSession session
    ) {

        if (session == null) {
            return "";
        }

        List<TrnChatMessage> messages =
                chatMessageRep.findBySessionOrderByMessageTimeAsc(
                        session
                );

        StringBuilder history =
                new StringBuilder();

        for (TrnChatMessage message : messages) {

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

    public void saveParentMessage(

            TrnChatSession session,

            String question

    ) {

        saveMessage(

                session,

                "PARENT",

                question

        );

    }

    public void saveAIMessage(

            TrnChatSession session,

            String answer

    ) {

        saveMessage(

                session,

                "AI",

                answer

        );

    }

    public void saveChatHistory(

            TrnChatSession session,

            String parentQuestion,

            String aiAnswer

    ) {

        saveParentMessage(

                session,

                parentQuestion

        );

        saveAIMessage(

                session,

                aiAnswer

        );

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

        TrnChatMessage chatMessage =
                new TrnChatMessage();

        chatMessage.setSession(
                session
        );

        chatMessage.setSenderType(
                senderType
        );

        chatMessage.setMessageText(
                messageText.trim()
        );

        chatMessageRep.save(
                chatMessage
        );

    }

}