package school_info.models;

import jakarta.persistence.*;
import utils.MessageResponse;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "trn_daily_analytics")

public class TrnDailyAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analytics_id")
    private Long analyticsId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(name = "analytics_date")
    private LocalDate analyticsDate;

    @Column(name = "total_enquiries")
    private Integer totalEnquiries;

    @Column(name = "total_forms_sent")
    private Integer totalFormsSent;

    @Column(name = "total_forms_submitted")
    private Integer totalFormsSubmitted;

    @Column(name = "total_admissions_confirmed")
    private Integer totalAdmissionsConfirmed;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Transient
    private MessageResponse returnMessage;

    public TrnDailyAnalytics(){}

    public Long getAnalyticsId() {
        return analyticsId;
    }

    public void setAnalyticsId(Long analyticsId) {
        this.analyticsId = analyticsId;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public LocalDate getAnalyticsDate() {
        return analyticsDate;
    }

    public void setAnalyticsDate(LocalDate analyticsDate) {
        this.analyticsDate = analyticsDate;
    }

    public Integer getTotalEnquiries() {
        return totalEnquiries;
    }

    public void setTotalEnquiries(Integer totalEnquiries) {
        this.totalEnquiries = totalEnquiries;
    }

    public Integer getTotalFormsSent() {
        return totalFormsSent;
    }

    public void setTotalFormsSent(Integer totalFormsSent) {
        this.totalFormsSent = totalFormsSent;
    }

    public Integer getTotalFormsSubmitted() {
        return totalFormsSubmitted;
    }

    public void setTotalFormsSubmitted(Integer totalFormsSubmitted) {
        this.totalFormsSubmitted = totalFormsSubmitted;
    }

    public Integer getTotalAdmissionsConfirmed() {
        return totalAdmissionsConfirmed;
    }

    public void setTotalAdmissionsConfirmed(Integer totalAdmissionsConfirmed) {
        this.totalAdmissionsConfirmed = totalAdmissionsConfirmed;
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