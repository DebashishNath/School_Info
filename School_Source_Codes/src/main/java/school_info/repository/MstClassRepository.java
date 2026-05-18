package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.MstClass;
import school_info.models.School;

import java.util.List;
import java.util.Optional;

public interface MstClassRepository extends JpaRepository<MstClass, Long> {

    List<MstClass> findBySchool(School school);

    Optional<MstClass> findBySchoolAndClassName(
            School school,
            String className
    );

    List<MstClass> findByAvailableSeatsGreaterThan(Integer seats);
}