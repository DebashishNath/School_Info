package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.School;
import school_info.models.TrnDailyAnalytics;
import school_info.service.TrnDailyAnalytics.TrnDailyAnalyticsService;
import utils.MessageResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/school_info/trnDailyAnalytics")
@CrossOrigin(origins = "*")
public class TrnDailyAnalyticsController {

    @Autowired
    private TrnDailyAnalyticsService trnDailyAnalyticsService;

    @PostMapping("/updateTrnDailyAnalytics")
    public TrnDailyAnalytics updateTrnDailyAnalytics(
            @RequestBody TrnDailyAnalytics trnDailyAnalytics
    ){
        return trnDailyAnalyticsService
                .updateTrnDailyAnalytics(
                        trnDailyAnalytics
                );
    }

    @DeleteMapping("/deleteTrnDailyAnalytics/{analyticsId}")
    public MessageResponse deleteTrnDailyAnalytics(
            @PathVariable Long analyticsId
    ){
        return trnDailyAnalyticsService
                .deleteTrnDailyAnalytics(
                        analyticsId
                );
    }

    @PostMapping("/findBySchool")
    public List<TrnDailyAnalytics> findBySchool(
            @RequestBody School school
    ){
        return trnDailyAnalyticsService
                .findBySchool(school);
    }

    @PostMapping("/findBySchoolAndAnalyticsDate/{analyticsDate}")
    public Optional<TrnDailyAnalytics>
    findBySchoolAndAnalyticsDate(
            @RequestBody School school,
            @PathVariable LocalDate analyticsDate
    ){
        return trnDailyAnalyticsService
                .findBySchoolAndAnalyticsDate(
                        school,
                        analyticsDate
                );
    }
}