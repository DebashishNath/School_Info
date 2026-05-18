package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "trn_followup")
@Data
public class TrnFollowup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "followup_id")
    private Long followupId;

    @ManyToOne
    @JoinColumn(name = "lead_id")
    private TrnParentLead lead;

    @Column(name = "reminder_message")
    private String reminderMessage;

    @Column(name = "reminder_date")
    private Timestamp reminderDate;

    @Column(name = "reminder_status")
    private String reminderStatus;

    @Column(name = "sent_at")
    private Timestamp sentAt;

    @Column(name = "created_at")
    private Timestamp createdAt;
}