package school_info.service.AITraining;

import school_info.models.AITraining;
import school_info.models.School;
import utils.MessageResponse;

import java.util.List;

abstract class AITrainingServiceImpl implements AITrainingService {

    @Override
    public AITraining updateAITraining(AITraining aiTraining){
        return new AITrainingServiceDAL().updateAITraining(aiTraining);
    }

    @Override
    public MessageResponse deleteAITraining(Long trainingId){
        return new AITrainingServiceDAL().deleteAITraining(trainingId);
    }

    @Override
    public List<AITraining> findBySchool(School school){
        return new AITrainingServiceDAL().findBySchool(school);
    }

    @Override
    public List<AITraining> findByLanguageCode(String languageCode){
        return new AITrainingServiceDAL()
                .findByLanguageCode(languageCode);
    }

    @Override
    public List<AITraining> findByQuestionContainingIgnoreCase(
            String keyword
    ){
        return new AITrainingServiceDAL()
                .findByQuestionContainingIgnoreCase(keyword);
    }
}