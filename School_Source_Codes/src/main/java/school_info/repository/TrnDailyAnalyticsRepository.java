package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.School;
import school_info.models.TrnDailyAnalytics;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TrnDailyAnalyticsRepository extends JpaRepository<TrnDailyAnalytics, Long> {

    List<TrnDailyAnalytics> findBySchool(School school);

    Optional<TrnDailyAnalytics> findBySchoolAndAnalyticsDate(
            School school,
            LocalDate analyticsDate
    );
}