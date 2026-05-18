package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "trn_admission_form")
@Data
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
}