package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.AITraining;
import school_info.models.School;

import java.util.List;

public interface AITrainingRepository extends JpaRepository<AITraining, Long> {

    List<AITraining> findBySchool(School school);

    List<AITraining> findByLanguageCode(String languageCode);

    List<AITraining> findByQuestionContainingIgnoreCase(String keyword);
}