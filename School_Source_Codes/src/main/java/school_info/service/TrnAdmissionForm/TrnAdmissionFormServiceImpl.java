package school_info.service.TrnAdmissionForm;

import school_info.models.TrnAdmissionForm;
import school_info.models.TrnParentLead;
import utils.MessageResponse;

import java.util.List;

abstract class TrnAdmissionFormServiceImpl
        implements TrnAdmissionFormService {

    @Override
    public TrnAdmissionForm updateTrnAdmissionForm(
            TrnAdmissionForm trnAdmissionForm
    ){
        return new TrnAdmissionFormServiceDAL()
                .updateTrnAdmissionForm(trnAdmissionForm);
    }

    @Override
    public MessageResponse deleteTrnAdmissionForm(Long formId){
        return new TrnAdmissionFormServiceDAL()
                .deleteTrnAdmissionForm(formId);
    }

    @Override
    public List<TrnAdmissionForm> findByLead(
            TrnParentLead lead
    ){
        return new TrnAdmissionFormServiceDAL()
                .findByLead(lead);
    }

    @Override
    public List<TrnAdmissionForm> findByFormSent(
            String formSent
    ){
        return new TrnAdmissionFormServiceDAL()
                .findByFormSent(formSent);
    }

    @Override
    public List<TrnAdmissionForm> findByFormSubmitted(
            String formSubmitted
    ){
        return new TrnAdmissionFormServiceDAL()
                .findByFormSubmitted(formSubmitted);
    }
}