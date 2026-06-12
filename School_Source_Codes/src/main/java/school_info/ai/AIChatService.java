package school_info.ai;

import org.springframework.stereotype.Service;

@Service
public class AIChatService {

    private final AIIntentDetector aiIntentDetector;

    private final IntentRouter intentRouter;

    private final AIActionExecutor aiActionExecutor;

    private final ChatHistoryService chatHistoryService;

    public AIChatService(

            AIIntentDetector aiIntentDetector,

            IntentRouter intentRouter,

            AIActionExecutor aiActionExecutor,

            ChatHistoryService chatHistoryService

    ) {

        this.aiIntentDetector = aiIntentDetector;
        this.intentRouter = intentRouter;
        this.aiActionExecutor = aiActionExecutor;
        this.chatHistoryService = chatHistoryService;

    }

    public AIResponse ask(
            AIRequest request
    ) {

        validateRequest(request);

        AIResponse response =
                createResponse(request);

        try {

            IntentType intent =
                    aiIntentDetector.detectIntent(
                            request.getQuestion()
                    );

            response.setIntent(
                    intent.name()
            );

            System.out.println(
                    "Detected Intent : " + intent
            );

            String answer =
                    intentRouter.getAnswer(
                            intent,
                            request
                    );

            response.setAnswer(
                    answer
            );

            chatHistoryService.saveChatHistory(

                    request.getSessionId(),

                    request.getQuestion(),

                    answer

            );

            aiActionExecutor.execute(

                    intent,

                    request,

                    response

            );

            response.setStatus(
                    "SUCCESS"
            );

        }
        catch (Exception ex) {

            ex.printStackTrace();

            response.setStatus(
                    "FAILURE"
            );

            response.setIntent(
                    IntentType.UNKNOWN.name()
            );

            response.setAnswer(
                    "Unable to process your request."
            );

            response.setActionMessage(
                    ex.getMessage()
            );

        }

        return response;

    }

    private AIResponse createResponse(
            AIRequest request
    ) {

        AIResponse response =
                new AIResponse();

        response.setSchoolId(
                request.getSchoolId()
        );

        response.setLeadId(
                request.getLeadId()
        );

        response.setSessionId(
                request.getSessionId()
        );

        response.setActionPerformed(
                false
        );

        response.setStatus(
                "SUCCESS"
        );

        return response;

    }

    private void validateRequest(
            AIRequest request
    ) {

        if (request == null) {

            throw new RuntimeException(
                    "Invalid request."
            );

        }

        if (request.getSchoolId() == null) {

            throw new RuntimeException(
                    "School Id is mandatory."
            );

        }

        if (request.getQuestion() == null ||
                request.getQuestion().trim().isEmpty()) {

            throw new RuntimeException(
                    "Question is mandatory."
            );

        }

    }

}