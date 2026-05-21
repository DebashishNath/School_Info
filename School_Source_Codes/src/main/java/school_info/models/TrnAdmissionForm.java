package school_info.models;

import jakarta.persistence.*;
import utils.MessageResponse;

import java.sql.Timestamp;

@Entity
@Table(name = "trn_admission_form")
public class TrnAdmissionForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id")
    private Long formId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "lead_id")
    private TrnParentLead lead;

    @Column(name = "form_sent")
    private String formSent;

    @Column(name = "form_sent_date")
    private Timestamp formSentDate;

    @Column(name = "form_submitted")
    private String formSubmitted;

    @Column(name = "form_submitted_date")
    private Timestamp formSubmittedDate;

    @Column(name = "form_link")
    private String formLink;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Transient
    private MessageResponse returnMessage;

    public TrnAdmissionForm(){}

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
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

    public String getFormSent() {
        return formSent;
    }

    public void setFormSent(String formSent) {
        this.formSent = formSent;
    }

    public Timestamp getFormSentDate() {
        return formSentDate;
    }

    public void setFormSentDate(Timestamp formSentDate) {
        this.formSentDate = formSentDate;
    }

    public String getFormSubmitted() {
        return formSubmitted;
    }

    public void setFormSubmitted(String formSubmitted) {
        this.formSubmitted = formSubmitted;
    }

    public Timestamp getFormSubmittedDate() {
        return formSubmittedDate;
    }

    public void setFormSubmittedDate(Timestamp formSubmittedDate) {
        this.formSubmittedDate = formSubmittedDate;
    }

    public String getFormLink() {
        return formLink;
    }

    public void setFormLink(String formLink) {
        this.formLink = formLink;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public MessageResponse getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(MessageResponse returnMessage) {
        this.returnMessage = returnMessage;
    }
}