package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "mst_class")
@Data
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
}