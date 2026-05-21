package school_info.service.AITraining;

import school_info.models.AITraining;
import school_info.models.School;
import utils.MessageResponse;
import java.util.List;

public interface AITrainingService {

    AITraining updateAITraining(AITraining aiTraining);

    MessageResponse deleteAITraining(Long trainingId);

    List<AITraining> findBySchool(School school);

    List<AITraining> findByLanguageCode(String languageCode);

    List<AITraining> findByQuestionContainingIgnoreCase(String keyword);
}