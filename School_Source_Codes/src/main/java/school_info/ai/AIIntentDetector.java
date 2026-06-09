package school_info.ai;

import org.springframework.stereotype.Component;

@Component
public class AIIntentDetector {

    public IntentType detectIntent(
            String question
    ){

        if(question == null)
        {
            return IntentType.UNKNOWN;
        }

        String q = question.toLowerCase();

        if(q.contains("fee"))
        {
            return IntentType.FEE_ENQUIRY;
        }

        if(q.contains("document"))
        {
            return IntentType.DOCUMENT_ENQUIRY;
        }

        if(q.contains("admission"))
        {
            return IntentType.ADMISSION_ENQUIRY;
        }

        if(q.contains("form"))
        {
            return IntentType.SEND_ADMISSION_FORM;
        }

        if(q.contains("transport"))
        {
            return IntentType.TRANSPORT_ENQUIRY;
        }

        return IntentType.FAQ;

    }

}