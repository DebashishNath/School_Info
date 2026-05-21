package school_info.service.TrnAdmissionForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.TrnAdmissionForm;
import school_info.models.TrnParentLead;
import school_info.repository.TrnAdmissionFormRepository;
import utils.CodeConstants;
import utils.MessageResponse;

import java.util.List;

@Service
class TrnAdmissionFormServiceDAL
        extends TrnAdmissionFormServiceImpl {

    @Autowired
    private TrnAdmissionFormRepository trnAdmissionFormRep;

    public TrnAdmissionFormServiceDAL() {}

    @Override
    public TrnAdmissionForm updateTrnAdmissionForm(
            TrnAdmissionForm trnAdmissionForm
    ){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            TrnAdmissionForm trnAdmissionFormToUpdate =
                    trnAdmissionFormRep.save(trnAdmissionForm);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Admission form updated successfully!"
            );

            trnAdmissionFormToUpdate.setReturnMessage(msgResp);

            return trnAdmissionFormToUpdate;

        }catch(Exception ex)
        {
            System.out.println("Error Is: " + ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to update admission form"
            );

            trnAdmissionForm.setReturnMessage(msgResp);

            return trnAdmissionForm;
        }
    }

    @Override
    public MessageResponse deleteTrnAdmissionForm(Long formId){

        MessageResponse msgResp = new MessageResponse();

        try
        {
            trnAdmissionFormRep.deleteById(formId);

            msgResp = new MessageResponse(
                    CodeConstants.SUCCESS.getID(),
                    "Admission form deleted successfully!"
            );

            return msgResp;

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());

            msgResp = new MessageResponse(
                    CodeConstants.FAILURE.getID(),
                    "Failed to delete admission form"
            );

            return msgResp;
        }
    }

    @Override
    public List<TrnAdmissionForm> findByLead(
            TrnParentLead lead
    ){
        return trnAdmissionFormRep.findByLead(lead);
    }

    @Override
    public List<TrnAdmissionForm> findByFormSent(
            String formSent
    ){
        return trnAdmissionFormRep.findByFormSent(formSent);
    }

    @Override
    public List<TrnAdmissionForm> findByFormSubmitted(
            String formSubmitted
    ){
        return trnAdmissionFormRep
                .findByFormSubmitted(formSubmitted);
    }
}