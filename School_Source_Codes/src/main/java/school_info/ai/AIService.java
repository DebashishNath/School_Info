package school_info.ai;

public interface AIService {

    String askQuestion(
            Long schoolId,
            String parentQuestion
    );
}