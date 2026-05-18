package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.TrnFollowup;
import school_info.models.TrnParentLead;

import java.sql.Timestamp;
import java.util.List;

public interface TrnFollowupRepository extends JpaRepository<TrnFollowup, Long> {

    List<TrnFollowup> findByLead(TrnParentLead lead);

    List<TrnFollowup> findByReminderStatus(String reminderStatus);

    List<TrnFollowup> findByReminderDateBefore(Timestamp timestamp);
}