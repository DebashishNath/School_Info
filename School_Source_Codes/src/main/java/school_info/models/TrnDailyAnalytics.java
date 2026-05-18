package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "trn_daily_analytics")
@Data
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
}