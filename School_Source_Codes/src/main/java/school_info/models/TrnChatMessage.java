package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "trn_chat_message")
@Data
public class TrnChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private TrnChatSession session;

    @Column(name = "sender_type")
    private String senderType;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "message_time")
    private Timestamp messageTime;
}