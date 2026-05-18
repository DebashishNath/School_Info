package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.TrnNotificationLog;
import school_info.models.TrnParentLead;

import java.util.List;

public interface TrnNotificationLogRepository extends JpaRepository<TrnNotificationLog, Long> {

    List<TrnNotificationLog> findByLead(TrnParentLead lead);

    List<TrnNotificationLog> findByNotificationType(String notificationType);

    List<TrnNotificationLog> findBySentStatus(String sentStatus);
}