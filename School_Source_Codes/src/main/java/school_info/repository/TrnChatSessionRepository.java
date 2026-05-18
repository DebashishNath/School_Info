package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.TrnChatSession;
import school_info.models.TrnParentLead;

import java.util.List;

public interface TrnChatSessionRepository extends JpaRepository<TrnChatSession, Long> {

    List<TrnChatSession> findByLead(TrnParentLead lead);

    List<TrnChatSession> findByCommunicationChannel(String communicationChannel);

    List<TrnChatSession> findByAiHandled(String aiHandled);
}