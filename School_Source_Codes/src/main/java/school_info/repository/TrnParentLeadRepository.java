package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.MstClass;
import school_info.models.School;
import school_info.models.Student;
import school_info.models.TrnParentLead;

import java.util.List;
import java.util.Optional;

public interface TrnParentLeadRepository extends JpaRepository<TrnParentLead, Long> {

    List<TrnParentLead> findBySchool(School school);

    List<TrnParentLead> findByLeadStatus(String leadStatus);

    Optional<TrnParentLead> findByMobileNumber(String mobileNumber);

    Optional<TrnParentLead> findByEmail(String email);

    List<TrnParentLead> findByInterestedClass(MstClass mstClass);

    Optional<TrnParentLead> findByStudent(Student student);

    List<TrnParentLead> findByParentNameContainingIgnoreCase(String parentName);
}