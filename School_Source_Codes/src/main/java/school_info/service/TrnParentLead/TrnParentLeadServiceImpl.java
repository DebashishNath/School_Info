package school_info.service.TrnParentLead;

import school_info.models.MstClass;
import school_info.models.School;
import school_info.models.Student;
import school_info.models.TrnParentLead;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

abstract class TrnParentLeadServiceImpl
        implements TrnParentLeadService {

    @Override
    public TrnParentLead updateTrnParentLead(
            TrnParentLead trnParentLead
    ){
        return new TrnParentLeadServiceDAL()
                .updateTrnParentLead(trnParentLead);
    }

    @Override
    public MessageResponse deleteTrnParentLead(
            Long leadId
    ){
        return new TrnParentLeadServiceDAL()
                .deleteTrnParentLead(leadId);
    }

    @Override
    public List<TrnParentLead> findBySchool(
            School school
    ){
        return new TrnParentLeadServiceDAL()
                .findBySchool(school);
    }

    @Override
    public List<TrnParentLead> findByLeadStatus(
            String leadStatus
    ){
        return new TrnParentLeadServiceDAL()
                .findByLeadStatus(leadStatus);
    }

    @Override
    public Optional<TrnParentLead> findByMobileNumber(
            String mobileNumber
    ){
        return new TrnParentLeadServiceDAL()
                .findByMobileNumber(mobileNumber);
    }

    @Override
    public Optional<TrnParentLead> findByEmail(
            String email
    ){
        return new TrnParentLeadServiceDAL()
                .findByEmail(email);
    }

    @Override
    public List<TrnParentLead> findByInterestedClass(
            MstClass mstClass
    ){
        return new TrnParentLeadServiceDAL()
                .findByInterestedClass(mstClass);
    }

    @Override
    public Optional<TrnParentLead> findByStudent(
            Student student
    ){
        return new TrnParentLeadServiceDAL()
                .findByStudent(student);
    }

    @Override
    public List<TrnParentLead>
    findByParentNameContainingIgnoreCase(
            String parentName
    ){
        return new TrnParentLeadServiceDAL()
                .findByParentNameContainingIgnoreCase(
                        parentName
                );
    }
}