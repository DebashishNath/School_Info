package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "trn_student_class")
@Data
public class TrnStudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_class_id")
    private Long studentClassId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private MstClass mstClass;

    @Column(name = "academic_year")
    private String academicYear;

    @Column(name = "roll_number")
    private String rollNumber;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private Timestamp createdAt;
}