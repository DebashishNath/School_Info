package school_info.ai;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class AIIntentDetector {

    private final Map<String, IntentType> intentMap =
            new LinkedHashMap<>();

    public AIIntentDetector() {

        /*
         * Fee Enquiry
         */
        register(

                IntentType.FEE_ENQUIRY,

                "fee",
                "fees",
                "annual fee",
                "yearly fee",
                "tuition fee",
                "payment",
                "charges",
                "cost"

        );

        /*
         * Admission
         */
        register(

                IntentType.ADMISSION_ENQUIRY,

                "admission",
                "admission date",
                "admission process",
                "admission open",
                "admission start",
                "apply"

        );

        /*
         * Admission Form
         */
        register(

                IntentType.SEND_ADMISSION_FORM,

                "form",
                "application form",
                "admission form",
                "send form"

        );

        /*
         * Documents
         */
        register(

                IntentType.DOCUMENT_ENQUIRY,

                "document",
                "documents",
                "certificate",
                "birth certificate",
                "aadhaar",
                "paper",
                "papers"

        );

        /*
         * Transport
         */
        register(

                IntentType.TRANSPORT_ENQUIRY,

                "transport",
                "bus",
                "school bus",
                "pickup",
                "drop",
                "vehicle"

        );

        /*
         * School Timing
         */
        register(

                IntentType.SCHOOL_TIMING,

                "timing",
                "timings",
                "school time",
                "opening time",
                "closing time",
                "working hours"

        );

    }

    public IntentType detectIntent(
            String question
    ) {

        if (question == null ||
                question.trim().isEmpty()) {

            return IntentType.UNKNOWN;

        }

        String normalizedQuestion =
                question.toLowerCase().trim();

        for (Map.Entry<String, IntentType> entry :
                intentMap.entrySet()) {

            if (normalizedQuestion.contains(
                    entry.getKey()
            )) {

                return entry.getValue();

            }

        }

        return IntentType.GENERAL_CHAT;

    }

    private void register(

            IntentType intent,

            String... keywords

    ) {

        for (String keyword : keywords) {

            intentMap.put(

                    keyword.toLowerCase(),

                    intent

            );

        }

    }

}