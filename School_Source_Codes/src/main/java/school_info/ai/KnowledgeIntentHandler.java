package school_info.ai;

import org.springframework.stereotype.Service;
import school_info.models.School;
import school_info.service.School.SchoolService;

@Service
public class KnowledgeIntentHandler implements IntentHandler {

    private final SchoolService schoolService;

    private final KnowledgeSearchService knowledgeSearchService;

    public KnowledgeIntentHandler(

            SchoolService schoolService,

            KnowledgeSearchService knowledgeSearchService

    ) {

        this.schoolService = schoolService;
        this.knowledgeSearchService = knowledgeSearchService;

    }

    @Override
    public boolean supports(
            IntentType intent
    ) {

        return intent == IntentType.ADMISSION_ENQUIRY
                || intent == IntentType.DOCUMENT_ENQUIRY
                || intent == IntentType.TRANSPORT_ENQUIRY
                || intent == IntentType.SCHOOL_TIMING
                || intent == IntentType.SCHOOL_ADDRESS
                || intent == IntentType.CONTACT_ENQUIRY
                || intent == IntentType.EVENT_ENQUIRY
                || intent == IntentType.SYLLABUS_ENQUIRY
                || intent == IntentType.FAQ;

    }

    @Override
    public String getAnswer(

            IntentType intent,

            AIRequest request

    ) {

        if (request == null) {

            return null;

        }

        if (request.getSchoolId() == null) {

            return null;

        }

        if (request.getQuestion() == null ||
                request.getQuestion().trim().isEmpty()) {

            return null;

        }

        School school =
                schoolService
                        .findBySchoolId(
                                request.getSchoolId()
                        )
                        .orElse(null);

        if (school == null) {

            return null;

        }

        return knowledgeSearchService.search(

                school,

                request.getQuestion()

        );

    }

}