package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "mst_faq")
@Data
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faq_id")
    private Long faqId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "category")
    private String category;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "created_at")
    private Timestamp createdAt;
}