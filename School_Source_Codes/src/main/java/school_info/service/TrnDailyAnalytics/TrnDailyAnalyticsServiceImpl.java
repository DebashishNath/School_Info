package school_info.service.TrnDailyAnalytics;

import school_info.models.School;
import school_info.models.TrnDailyAnalytics;
import utils.MessageResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

abstract class TrnDailyAnalyticsServiceImpl
        implements TrnDailyAnalyticsService {

    @Override
    public TrnDailyAnalytics updateTrnDailyAnalytics(
            TrnDailyAnalytics trnDailyAnalytics
    ){
        return new TrnDailyAnalyticsServiceDAL()
                .updateTrnDailyAnalytics(trnDailyAnalytics);
    }

    @Override
    public MessageResponse deleteTrnDailyAnalytics(
            Long analyticsId
    ){
        return new TrnDailyAnalyticsServiceDAL()
                .deleteTrnDailyAnalytics(analyticsId);
    }

    @Override
    public List<TrnDailyAnalytics> findBySchool(
            School school
    ){
        return new TrnDailyAnalyticsServiceDAL()
                .findBySchool(school);
    }

    @Override
    public Optional<TrnDailyAnalytics>
    findBySchoolAndAnalyticsDate(
            School school,
            LocalDate analyticsDate
    ){
        return new TrnDailyAnalyticsServiceDAL()
                .findBySchoolAndAnalyticsDate(
                        school,
                        analyticsDate
                );
    }
}