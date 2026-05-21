package school_info.models;

import jakarta.persistence.*;
import utils.MessageResponse;

import java.sql.Timestamp;

@Entity
@Table(name = "trn_chat_session")

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

    @Transient
    private MessageResponse returnMessage;

    public TrnChatSession(){}

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public TrnParentLead getLead() {
        return lead;
    }

    public void setLead(TrnParentLead lead) {
        this.lead = lead;
    }

    public Timestamp getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(Timestamp sessionStart) {
        this.sessionStart = sessionStart;
    }

    public Timestamp getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(Timestamp sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    public String getCommunicationChannel() {
        return communicationChannel;
    }

    public void setCommunicationChannel(String communicationChannel) {
        this.communicationChannel = communicationChannel;
    }

    public String getAiHandled() {
        return aiHandled;
    }

    public void setAiHandled(String aiHandled) {
        this.aiHandled = aiHandled;
    }

    public MessageResponse getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(MessageResponse returnMessage) {
        this.returnMessage = returnMessage;
    }
}