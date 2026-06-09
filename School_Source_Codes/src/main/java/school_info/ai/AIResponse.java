package school_info.ai;

public class AIResponse {

    private String status;

    private String answer;

    private String intent;

    private boolean actionPerformed;

    private String actionMessage;

    private Long sessionId;

    private Long leadId;

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {
        this.status = status;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(
            String answer
    ) {
        this.answer = answer;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(
            String intent
    ) {
        this.intent = intent;
    }

    public boolean isActionPerformed() {
        return actionPerformed;
    }

    public void setActionPerformed(
            boolean actionPerformed
    ) {
        this.actionPerformed = actionPerformed;
    }

    public String getActionMessage() {
        return actionMessage;
    }

    public void setActionMessage(
            String actionMessage
    ) {
        this.actionMessage = actionMessage;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(
            Long sessionId
    ) {
        this.sessionId = sessionId;
    }

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(
            Long leadId
    ) {
        this.leadId = leadId;
    }

}