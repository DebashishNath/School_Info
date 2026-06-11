package school_info.service.Faq;

import school_info.models.Faq;
import school_info.models.School;
import utils.MessageResponse;

import java.util.List;

public interface FaqService {
    Faq updateFaq(Faq faq);
    MessageResponse deleteFaq(Long faqId);
    List<Faq> findBySchool(School school);
    List<Faq> findBySchoolAndIsActive(School school, String isActive);
    List<Faq> findByCategory(String category);
    List<Faq> findByQuestionContainingIgnoreCase(String keyword);
}