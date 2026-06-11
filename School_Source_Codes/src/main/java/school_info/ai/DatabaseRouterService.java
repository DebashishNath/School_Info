package school_info.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.AITraining;
import school_info.models.Faq;
import school_info.models.MstClass;
import school_info.models.School;
import school_info.service.AITraining.AITrainingService;
import school_info.service.Faq.FaqService;
import school_info.service.MstClass.MstClassService;
import school_info.service.School.SchoolService;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseRouterService {

    private final SchoolService schoolService;
    private final FaqService faqService;
    private final AITrainingService aiTrainingService;
    @Autowired
    private MstClassService classService;

    public DatabaseRouterService(
            SchoolService schoolService,
            FaqService faqService,
            AITrainingService aiTrainingService
    ) {
        this.schoolService = schoolService;
        this.faqService = faqService;
        this.aiTrainingService = aiTrainingService;
    }

    // =========================
    // ENTRY POINT
    // =========================
    public String getResponse(IntentType intent, AIRequest request) {

        if (request == null ||
                request.getSchoolId() == null ||
                request.getQuestion() == null) {
            return null;
        }
        System.out.println("Inside getResponse() school id is " + request.getSchoolId());
        School school = schoolService.findBySchoolId(request.getSchoolId()).orElse(null);

        if (school == null) {
            return null;
        }
        System.out.println("Inside getResponse() after school retrieval ");

        String question = request.getQuestion().toLowerCase().trim();

        System.out.println("Intent inside getResponse() " + intent);

        // 🔥 STEP 1: STRUCTURED ROUTING (IMPORTANT FIX)
        if (intent == IntentType.FEE_ENQUIRY ||
                intent == IntentType.ADMISSION_ENQUIRY ||
                intent == IntentType.TRANSPORT_ENQUIRY) {

            return handleStructuredQuery(school, question, intent);
        }

        System.out.println("Intent inside getResponse() and after handleStructuredQuery() " + intent);

        // 🔥 STEP 2: FUZZY ROUTING
        return handleFuzzyQuery(school, question);
    }

    // =========================
    // STRUCTURED QUERY (FIX YOUR ISSUE HERE)
    // =========================
    private String handleStructuredQuery(School school, String question,IntentType intent) {

        String userClass = extractClass(question);

        if (userClass == null) {
            return null; // force fallback to fuzzy/AI
        }
        System.out.println("Inside handleStructuredQuery() class is: " + userClass);
        // =========================
        // 1. FEE ENQUIRY (STRICT DB LOOKUP)
        // =========================
        String studentClass="STD " + userClass;
        if (intent == IntentType.FEE_ENQUIRY) {
            Optional<MstClass> mstClass = classService.findBySchoolAndClassName(school,studentClass);
            return mstClass.map(aClass -> "The annual fee for STD " + userClass +
                    " is Rs " + aClass.getYearlyFee()).
                    orElseGet(() -> "Fee information for STD " + userClass +
                    " is not available. Please contact the school office.");
        }

        List<Faq> faqList = faqService.findBySchoolAndIsActive(school, "Y");

        for (Faq faq : faqList) {

            String faqClass = extractClass(faq.getQuestion());

            if (userClass.equals(faqClass)) {
                return faq.getAnswer(); // 🔥 DIRECT MATCH (NO FUZZY)
            }
        }
        System.out.println("Inside handleStructuredQuery() after faqList");
        return null;
    }

    // =========================
    // FUZZY QUERY (SAFE ONLY FOR FAQ)
    // =========================
    private String handleFuzzyQuery(School school, String question) {

        String bestAnswer = null;
        int bestScore = 0;

        List<Faq> faqList = faqService.findBySchoolAndIsActive(school, "Y");
        List<AITraining> trainingList = aiTrainingService.findBySchool(school);

        for (Faq faq : faqList) {
            int score = calculateScore(faq.getQuestion(), question);
            if (score > bestScore) {
                bestScore = score;
                bestAnswer = faq.getAnswer();
            }
        }

        for (AITraining training : trainingList) {
            int score = calculateScore(training.getQuestion(), question);
            if (score > bestScore) {
                bestScore = score;
                bestAnswer = training.getAnswer();
            }
        }

        System.out.println("QUESTION: " + question);
        System.out.println("BEST ANSWER: " + bestAnswer);

        return bestAnswer;
    }

    // =========================
    // SCORING (ONLY FOR FUZZY CASE)
    // =========================
    private int calculateScore(String stored, String user) {

        if (stored == null) return 0;

        stored = stored.toLowerCase();

        int score = 0;

        if (stored.equals(user)) return 100;

        if (stored.contains(user) || user.contains(stored)) {
            score += 40;
        }

        String[] words = stored.split("\\s+");
        int match = 0;

        for (String w : words) {
            if (w.length() < 3) continue;
            if (user.contains(w)) match++;
        }

        score += match * 10;

        return score;
    }

    // =========================
    // STD / CLASS EXTRACTION
    // =========================
    private String extractClass(String text) {

        if (text == null) return null;

        text = text.toLowerCase();

        if (text.contains("std 1") || text.contains("class 1")) return "1";
        if (text.contains("std 2") || text.contains("class 2")) return "2";
        if (text.contains("std 3") || text.contains("class 3")) return "3";
        if (text.contains("std 4") || text.contains("class 4")) return "4";
        if (text.contains("std 5") || text.contains("class 5")) return "5";
        if (text.contains("std 6") || text.contains("class 6")) return "6";

        return null;
    }
}