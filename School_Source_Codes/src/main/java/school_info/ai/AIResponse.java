package school_info.ai;

public class AIResponse {

    private String status;

    private String answer;

    private String intent;

    private Boolean actionPerformed;

    private String actionMessage;

    private Long schoolId;

    private Long sessionId;

    private Long leadId;

    public AIResponse() {
    }

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

    public Boolean getActionPerformed() {
        return actionPerformed;
    }

    public void setActionPerformed(
            Boolean actionPerformed
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

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(
            Long schoolId
    ) {
        this.schoolId = schoolId;
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

    @Override
    public String toString() {

        return "AIResponse{" +
                "status='" + status + '\'' +
                ", answer='" + answer + '\'' +
                ", intent='" + intent + '\'' +
                ", actionPerformed=" + actionPerformed +
                ", actionMessage='" + actionMessage + '\'' +
                ", schoolId=" + schoolId +
                ", sessionId=" + sessionId +
                ", leadId=" + leadId +
                '}';

    }

}