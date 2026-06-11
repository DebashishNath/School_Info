package school_info.ai;

public class AIRequest {

    private Long schoolId;

    private Long leadId;

    private Long sessionId;

    private String question;

    public AIRequest() {
    }

    public AIRequest(
            Long schoolId,
            Long leadId,
            Long sessionId,
            String question
    ) {
        this.schoolId = schoolId;
        this.leadId = leadId;
        this.sessionId = sessionId;
        this.question = question;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(
            Long schoolId
    ) {
        this.schoolId = schoolId;
    }

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(
            Long leadId
    ) {
        this.leadId = leadId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(
            Long sessionId
    ) {
        this.sessionId = sessionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(
            String question
    ) {
        this.question = question;
    }

    @Override
    public String toString() {

        return "AIRequest{" +
                "schoolId=" + schoolId +
                ", leadId=" + leadId +
                ", sessionId=" + sessionId +
                ", question='" + question + '\'' +
                '}';

    }

}