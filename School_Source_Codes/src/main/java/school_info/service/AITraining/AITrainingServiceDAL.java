package school_info.service.AITraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.AITraining;
import school_info.models.School;
import school_info.repository.AITrainingRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.util.List;

@Service
class AITrainingServiceDAL extends AITrainingServiceImpl {

    @Autowired
    private AITrainingRepository aiTrainingRep;

    public AITrainingServiceDAL() {}

    @Override
    public AITraining updateAITraining(AITraining aiTraining){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            AITraining aiTrainingToUpdate =
                    aiTrainingRep.save(aiTraining);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "AI Training updated successfully!"
            );

            aiTrainingToUpdate.setReturnMessage(msgResp);

            return aiTrainingToUpdate;

        }catch(Exception ex)
        {
            System.out.println("Error Is: " + ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to update AI Training"
            );

            aiTraining.setReturnMessage(msgResp);

            return aiTraining;
        }
    }

    @Override
    public MessageResponse deleteAITraining(Long trainingId){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            aiTrainingRep.deleteById(trainingId);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "AI Training deleted successfully!"
            );

            return msgResp;

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to delete AI Training"
            );

            return msgResp;
        }
    }

    @Override
    public List<AITraining> findBySchool(School school){
        return aiTrainingRep.findBySchool(school);
    }

    @Override
    public List<AITraining> findByLanguageCode(String languageCode){
        return aiTrainingRep.findByLanguageCode(languageCode);
    }

    @Override
    public List<AITraining> findByQuestionContainingIgnoreCase(
            String keyword
    ){
        return aiTrainingRep
                .findByQuestionContainingIgnoreCase(keyword);
    }
}