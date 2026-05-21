package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school_info.models.TrnChatMessage;
import school_info.models.TrnChatSession;

import java.util.List;

@Repository
public interface TrnChatMessageRepository
        extends JpaRepository<TrnChatMessage, Long> {

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