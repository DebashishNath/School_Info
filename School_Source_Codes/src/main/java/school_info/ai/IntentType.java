package school_info.ai;

public enum IntentType {

    /*
     * ===========================================
     * Structured Database Intents
     * ===========================================
     */

    FEE_ENQUIRY,

    ADMISSION_ENQUIRY,

    DOCUMENT_ENQUIRY,

    TRANSPORT_ENQUIRY,

    CLASS_ENQUIRY,

    SEAT_ENQUIRY,

    SCHOOL_TIMING,

    SCHOOL_ADDRESS,

    CONTACT_ENQUIRY,

    HOLIDAY_ENQUIRY,

    EVENT_ENQUIRY,

    RESULT_ENQUIRY,

    SYLLABUS_ENQUIRY,

    TEACHER_ENQUIRY,

    PRINCIPAL_ENQUIRY,

    /*
     * ===========================================
     * Workflow / Actions
     * ===========================================
     */

    CREATE_LEAD,

    UPDATE_LEAD,

    BOOK_VISIT,

    SCHEDULE_CALLBACK,

    SEND_BROCHURE,

    SEND_ADMISSION_FORM,

    FOLLOW_UP,

    /*
     * ===========================================
     * Knowledge Base
     * ===========================================
     */

    FAQ,

    GENERAL_CHAT,

    PARENT_GUIDANCE,

    STUDENT_COUNSELLING,

    /*
     * ===========================================
     * Future Extensions
     * ===========================================
     */

    ATTENDANCE_ENQUIRY,

    HOMEWORK_ENQUIRY,

    EXAM_ENQUIRY,

    NOTICE_ENQUIRY,

    PAYMENT_STATUS,

    PAYMENT_HISTORY,

    SCHOLARSHIP_ENQUIRY,

    /*
     * ===========================================
     * Default
     * ===========================================
     */

    UNKNOWN

}