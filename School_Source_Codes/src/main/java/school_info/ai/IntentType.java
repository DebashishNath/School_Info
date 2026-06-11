package school_info.ai;

public enum IntentType {

    /*
     * Database / Direct Response
     */
    FEE_ENQUIRY,

    ADMISSION_ENQUIRY,

    DOCUMENT_ENQUIRY,

    TRANSPORT_ENQUIRY,

    SCHOOL_TIMING,

    SCHOOL_ADDRESS,

    CONTACT_ENQUIRY,

    HOLIDAY_ENQUIRY,

    CLASS_ENQUIRY,

    SYLLABUS_ENQUIRY,

    RESULT_ENQUIRY,

    EVENT_ENQUIRY,

    /*
     * Agent Actions
     */
    CREATE_LEAD,

    UPDATE_LEAD,

    SEND_ADMISSION_FORM,

    BOOK_VISIT,

    SCHEDULE_CALLBACK,

    FOLLOWUP,

    SEND_BROCHURE,

    /*
     * AI / Knowledge
     */
    FAQ,

    GENERAL_CHAT,

    PARENT_GUIDANCE,

    STUDENT_COUNSELLING,

    /*
     * Default
     */
    UNKNOWN

}