package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "trn_parent_lead")
@Data
public class TrnParentLead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lead_id")
    private Long leadId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(name = "parent_name")
    private String parentName;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "interested_class_id")
    private MstClass interestedClass;

    @Column(name = "enquiry_source")
    private String enquirySource;

    @Column(name = "lead_status")
    private String leadStatus;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}