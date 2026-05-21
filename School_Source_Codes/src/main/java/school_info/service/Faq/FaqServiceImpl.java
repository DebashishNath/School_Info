package school_info.service.Faq;

import school_info.models.Faq;
import school_info.models.School;
import utils.MessageResponse;

import java.util.List;

abstract class FaqServiceImpl implements FaqService {

    @Override
    public Faq updateFaq(Faq faq){
        return new FaqServiceDAL().updateFaq(faq);
    }

    @Override
    public MessageResponse deleteFaq(Long faqId){
        return new FaqServiceDAL().deleteFaq(faqId);
    }

    @Override
    public List<Faq> findBySchool(School school){
        return new FaqServiceDAL().findBySchool(school);
    }

    @Override
    public List<Faq> findBySchoolAndIsActive(
            School school,
            String isActive
    ){
        return new FaqServiceDAL().findBySchoolAndIsActive(
                school,
                isActive
        );
    }

    @Override
    public List<Faq> findByCategory(String category){
        return new FaqServiceDAL().findByCategory(category);
    }

    @Override
    public List<Faq> findByQuestionContainingIgnoreCase(String keyword){
        return new FaqServiceDAL()
                .findByQuestionContainingIgnoreCase(keyword);
    }
}
