package school_info.service.Faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.Faq;
import school_info.models.School;
import school_info.repository.FaqRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.util.List;

@Service
class FaqServiceDAL extends FaqServiceImpl {

    @Autowired
    private FaqRepository faqRep;

    public FaqServiceDAL() {}

    @Override
    public Faq updateFaq(Faq faq){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            Faq faqToUpdate = faqRep.save(faq);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "FAQ updated successfully!"
            );

            faqToUpdate.setReturnMessage(msgResp);

            return faqToUpdate;

        }catch(Exception ex)
        {
            System.out.println("Error Is: " + ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to update FAQ"
            );

            faq.setReturnMessage(msgResp);

            return faq;
        }
    }

    @Override
    public MessageResponse deleteFaq(Long faqId){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            faqRep.deleteById(faqId);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "FAQ deleted successfully!"
            );

            return msgResp;

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to delete FAQ"
            );

            return msgResp;
        }
    }

    @Override
    public List<Faq> findBySchool(School school){
        return faqRep.findBySchool(school);
    }

    @Override
    public List<Faq> findBySchoolAndIsActive(
            School school,
            String isActive
    ){
        return faqRep.findBySchoolAndIsActive(
                school,
                isActive
        );
    }

    @Override
    public List<Faq> findByCategory(String category){
        return faqRep.findByCategory(category);
    }

    @Override
    public List<Faq> findByQuestionContainingIgnoreCase(
            String keyword
    ){
        return faqRep.findByQuestionContainingIgnoreCase(keyword);
    }
}