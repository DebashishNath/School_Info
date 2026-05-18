package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.School;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {

    Optional<School> findBySchoolName(String schoolName);

    boolean existsBySchoolName(String schoolName);
}