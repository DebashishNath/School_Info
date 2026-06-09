package school_info.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.TrnChatMessage;
import school_info.models.TrnChatSession;
import school_info.repository.TrnChatMessageRepository;

import java.util.List;

@Service
public class ChatHistoryService {

    @Autowired
    private TrnChatMessageRepository chatMessageRep;

    public String loadConversation(
            TrnChatSession session
    ){

        List<TrnChatMessage> messages =
                chatMessageRep
                        .findBySessionOrderByMessageTimeAsc(
                                session
                        );

        StringBuilder history =
                new StringBuilder();

        for(TrnChatMessage message : messages)
        {

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

    ){

        TrnChatMessage chatMessage =
                new TrnChatMessage();

        chatMessage.setSession(session);

        chatMessage.setSenderType("PARENT");

        chatMessage.setMessageText(question);

        chatMessageRep.save(chatMessage);

    }

    public void saveAIMessage(

            TrnChatSession session,

            String answer

    ){

        TrnChatMessage chatMessage =
                new TrnChatMessage();

        chatMessage.setSession(session);

        chatMessage.setSenderType("AI");

        chatMessage.setMessageText(answer);

        chatMessageRep.save(chatMessage);

    }

}