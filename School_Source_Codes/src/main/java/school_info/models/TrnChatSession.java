package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "trn_chat_session")
@Data
public class TrnChatSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "lead_id")
    private TrnParentLead lead;

    @Column(name = "session_start")
    private Timestamp sessionStart;

    @Column(name = "session_end")
    private Timestamp sessionEnd;

    @Column(name = "communication_channel")
    private String communicationChannel;

    @Column(name = "ai_handled")
    private String aiHandled;
}