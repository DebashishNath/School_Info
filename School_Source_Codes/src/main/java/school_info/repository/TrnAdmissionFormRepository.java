package school_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school_info.models.TrnAdmissionForm;
import school_info.models.TrnParentLead;

import java.util.List;

public interface TrnAdmissionFormRepository extends JpaRepository<TrnAdmissionForm, Long> {

    List<TrnAdmissionForm> findByLead(TrnParentLead lead);

    List<TrnAdmissionForm> findByFormSent(String formSent);

    List<TrnAdmissionForm> findByFormSubmitted(String formSubmitted);
}