package school_info.ai;

public interface IntentHandler {

    /**
     * Returns true if this handler can process the intent.
     */
    boolean supports(IntentType intent);

    /**
     * Processes the request and returns the answer.
     */
    String getAnswer(
            IntentType intent,
            AIRequest request
    );

}