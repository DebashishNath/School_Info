package school_info.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "mst_ai_training")
@Data
public class AITraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private Long trainingId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "language_code")
    private String languageCode;

    @Column(name = "created_at")
    private Timestamp createdAt;
}
