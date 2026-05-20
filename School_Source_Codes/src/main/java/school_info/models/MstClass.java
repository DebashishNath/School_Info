package school_info.models;

import jakarta.persistence.*;
import utils.MessageResponse;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "mst_class")

public class MstClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(name = "class_name")
    private String className;

    @Column(name = "yearly_fee")
    private BigDecimal yearlyFee;

    @Column(name = "admission_fee")
    private BigDecimal admissionFee;

    @Column(name = "total_seats")
    private Integer totalSeats;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Transient
    private MessageResponse returnMessage;

    public MstClass(){}

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public BigDecimal getYearlyFee() {
        return yearlyFee;
    }

    public void setYearlyFee(BigDecimal yearlyFee) {
        this.yearlyFee = yearlyFee;
    }

    public BigDecimal getAdmissionFee() {
        return admissionFee;
    }

    public void setAdmissionFee(BigDecimal admissionFee) {
        this.admissionFee = admissionFee;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
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