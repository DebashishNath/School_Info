package school_info.service.TrnDailyAnalytics;

import school_info.models.School;
import school_info.models.TrnDailyAnalytics;
import utils.MessageResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TrnDailyAnalyticsService {

    TrnDailyAnalytics updateTrnDailyAnalytics(
            TrnDailyAnalytics trnDailyAnalytics
    );

    MessageResponse deleteTrnDailyAnalytics(
            Long analyticsId
    );

    List<TrnDailyAnalytics> findBySchool(
            School school
    );

    Optional<TrnDailyAnalytics> findBySchoolAndAnalyticsDate(
            School school,
            LocalDate analyticsDate
    );
}