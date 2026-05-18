package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "trn_notification_log")
@Data
public class TrnNotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name = "lead_id")
    private TrnParentLead lead;

    @Column(name = "notification_type")
    private String notificationType;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "subject_text")
    private String subjectText;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "sent_status")
    private String sentStatus;

    @Column(name = "sent_at")
    private Timestamp sentAt;

    @Column(name = "created_at")
    private Timestamp createdAt;
}