package school_info.service.TrnAdmissionForm;

import school_info.models.TrnAdmissionForm;
import school_info.models.TrnParentLead;
import utils.MessageResponse;

import java.util.List;

public interface TrnAdmissionFormService {

    TrnAdmissionForm updateTrnAdmissionForm(
            TrnAdmissionForm trnAdmissionForm
    );

    MessageResponse deleteTrnAdmissionForm(Long formId);

    List<TrnAdmissionForm> findByLead(TrnParentLead lead);

    List<TrnAdmissionForm> findByFormSent(String formSent);

    List<TrnAdmissionForm> findByFormSubmitted(String formSubmitted);
}