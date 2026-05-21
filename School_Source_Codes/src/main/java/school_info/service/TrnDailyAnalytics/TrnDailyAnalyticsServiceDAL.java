package school_info.service.TrnDailyAnalytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.School;
import school_info.models.TrnDailyAnalytics;
import school_info.repository.TrnDailyAnalyticsRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
class TrnDailyAnalyticsServiceDAL
        extends TrnDailyAnalyticsServiceImpl {

    @Autowired
    private TrnDailyAnalyticsRepository trnDailyAnalyticsRep;

    public TrnDailyAnalyticsServiceDAL() {}

    @Override
    public TrnDailyAnalytics updateTrnDailyAnalytics(
            TrnDailyAnalytics trnDailyAnalytics
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            TrnDailyAnalytics trnDailyAnalyticsToUpdate =
                    trnDailyAnalyticsRep.save(
                            trnDailyAnalytics
                    );

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Daily analytics updated successfully!"
            );

            trnDailyAnalyticsToUpdate
                    .setReturnMessage(msgResp);

            return trnDailyAnalyticsToUpdate;

        }catch(Exception ex)
        {
            System.out.println(
                    "Error Is: " + ex.getMessage()
            );

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to update daily analytics"
            );

            trnDailyAnalytics.setReturnMessage(msgResp);

            return trnDailyAnalytics;
        }
    }

    @Override
    public MessageResponse deleteTrnDailyAnalytics(
            Long analyticsId
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            trnDailyAnalyticsRep.deleteById(
                    analyticsId
            );

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Daily analytics deleted successfully!"
            );

            return msgResp;

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to delete daily analytics"
            );

            return msgResp;
        }
    }

    @Override
    public List<TrnDailyAnalytics> findBySchool(
            School school
    ){
        return trnDailyAnalyticsRep.findBySchool(
                school
        );
    }

    @Override
    public Optional<TrnDailyAnalytics>
    findBySchoolAndAnalyticsDate(
            School school,
            LocalDate analyticsDate
    ){
        return trnDailyAnalyticsRep
                .findBySchoolAndAnalyticsDate(
                        school,
                        analyticsDate
                );
    }
}