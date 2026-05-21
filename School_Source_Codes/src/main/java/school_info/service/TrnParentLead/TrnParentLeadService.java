package school_info.service.TrnParentLead;

import school_info.models.MstClass;
import school_info.models.School;
import school_info.models.Student;
import school_info.models.TrnParentLead;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface TrnParentLeadService {

    TrnParentLead updateTrnParentLead(
            TrnParentLead trnParentLead
    );

    MessageResponse deleteTrnParentLead(
            Long leadId
    );

    List<TrnParentLead> findBySchool(
            School school
    );

    List<TrnParentLead> findByLeadStatus(
            String leadStatus
    );

    Optional<TrnParentLead> findByMobileNumber(
            String mobileNumber
    );

    Optional<TrnParentLead> findByEmail(
            String email
    );

    List<TrnParentLead> findByInterestedClass(
            MstClass mstClass
    );

    Optional<TrnParentLead> findByStudent(
            Student student
    );

    List<TrnParentLead> findByParentNameContainingIgnoreCase(
            String parentName
    );
}