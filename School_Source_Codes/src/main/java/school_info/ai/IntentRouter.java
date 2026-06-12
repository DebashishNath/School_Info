package school_info.ai;

import org.springframework.stereotype.Service;

@Service
public class IntentRouter {

    private final StructuredIntentHandler structuredIntentHandler;

    private final KnowledgeIntentHandler knowledgeIntentHandler;

    private final OllamaIntentHandler ollamaIntentHandler;

    public IntentRouter(

            StructuredIntentHandler structuredIntentHandler,

            KnowledgeIntentHandler knowledgeIntentHandler,

            OllamaIntentHandler ollamaIntentHandler

    ) {

        this.structuredIntentHandler = structuredIntentHandler;
        this.knowledgeIntentHandler = knowledgeIntentHandler;
        this.ollamaIntentHandler = ollamaIntentHandler;

    }

    public String getAnswer(
            IntentType intent,
            AIRequest request
    ) {

        if (intent == null) {
            return ollamaIntentHandler.getAnswer(intent,request);
        }
        switch (intent) {
            /*
             * Structured Database Queries
             */
            case FEE_ENQUIRY:
            case CLASS_ENQUIRY:
            case RESULT_ENQUIRY:
            case HOLIDAY_ENQUIRY:
                return structuredIntentHandler.getAnswer(intent,request);
            /*
             * FAQ / AI Training
             */
            case ADMISSION_ENQUIRY:
            case DOCUMENT_ENQUIRY:
            case TRANSPORT_ENQUIRY:
            case SCHOOL_TIMING:
            case SCHOOL_ADDRESS:
            case CONTACT_ENQUIRY:
            case SYLLABUS_ENQUIRY:
            case EVENT_ENQUIRY:
            case FAQ:
                String knowledgeAnswer =
                        knowledgeIntentHandler.getAnswer(intent,request);

                if (knowledgeAnswer != null &&
                        !knowledgeAnswer.trim().isEmpty()) {

                    return knowledgeAnswer;

                }
                return ollamaIntentHandler.getAnswer(intent,request);
            /*
             * General AI
             */
            case GENERAL_CHAT:
            case PARENT_GUIDANCE:
            case STUDENT_COUNSELLING:
            case UNKNOWN:
            default:
                return ollamaIntentHandler.getAnswer(intent,request);
        }
    }
}