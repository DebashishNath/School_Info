package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.Faq;
import school_info.models.School;

import java.util.List;

public interface FaqRepository extends JpaRepository<Faq, Long> {

    List<Faq> findBySchool(School school);

    List<Faq> findBySchoolAndIsActive(
            School school,
            String isActive
    );

    List<Faq> findByCategory(String category);

    List<Faq> findByQuestionContainingIgnoreCase(String keyword);
}