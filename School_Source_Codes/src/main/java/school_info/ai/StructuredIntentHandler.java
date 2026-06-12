package school_info.ai;

import org.springframework.stereotype.Service;
import school_info.models.MstClass;
import school_info.models.School;
import school_info.service.MstClass.MstClassService;
import school_info.service.School.SchoolService;

import java.util.Optional;

@Service
public class StructuredIntentHandler implements IntentHandler {

    private final SchoolService schoolService;

    private final MstClassService mstClassService;

    private final ClassExtractor classExtractor;

    public StructuredIntentHandler(

            SchoolService schoolService,

            MstClassService mstClassService,

            ClassExtractor classExtractor

    ) {

        this.schoolService = schoolService;
        this.mstClassService = mstClassService;
        this.classExtractor = classExtractor;

    }

    @Override
    public boolean supports(
            IntentType intent
    ) {

        return intent == IntentType.FEE_ENQUIRY
                || intent == IntentType.CLASS_ENQUIRY
                || intent == IntentType.RESULT_ENQUIRY
                || intent == IntentType.HOLIDAY_ENQUIRY;

    }

    @Override
    public String getAnswer(

            IntentType intent,

            AIRequest request

    ) {

        if (request == null ||
                request.getSchoolId() == null ||
                request.getQuestion() == null) {

            return null;

        }

        School school =
                schoolService
                        .findBySchoolId(
                                request.getSchoolId()
                        )
                        .orElse(null);

        if (school == null) {

            return "School not found.";

        }

        switch (intent) {

            case FEE_ENQUIRY:

                return getFeeAnswer(

                        school,

                        request.getQuestion()

                );

            case CLASS_ENQUIRY:

                return getClassAnswer(

                        school,

                        request.getQuestion()

                );

            case RESULT_ENQUIRY:

                return "Result information is currently unavailable.";

            case HOLIDAY_ENQUIRY:

                return "Holiday information is currently unavailable.";

            default:

                return null;

        }

    }

    private String getFeeAnswer(

            School school,

            String question

    ) {

        String classNumber =
                classExtractor.extract(question);

        if (classNumber == null) {

            return "Please specify the class. Example: STD 1 or STD 2.";

        }

        String className =
                "STD " + classNumber;

        Optional<MstClass> mstClass =
                mstClassService.findBySchoolAndClassName(

                        school,

                        className

                );

        if (mstClass.isEmpty()) {

            return "Fee information is not available for "
                    + className
                    + ".";

        }

        return "The annual fee for "
                + className
                + " is Rs "
                + mstClass.get().getYearlyFee()
                + ".";

    }

    private String getClassAnswer(

            School school,

            String question

    ) {

        String classNumber =
                classExtractor.extract(question);

        if (classNumber == null) {

            return "Please specify the class.";

        }

        String className =
                "STD " + classNumber;

        Optional<MstClass> mstClass =
                mstClassService.findBySchoolAndClassName(

                        school,

                        className

                );

        if (mstClass.isEmpty()) {

            return className + " is not available.";

        }

        MstClass cls =
                mstClass.get();

        return className
                + " has "
                + cls.getAvailableSeats()
                + " seats available out of "
                + cls.getTotalSeats()
                + ".";

    }

}