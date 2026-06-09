package school_info.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school_info.models.TrnAdmissionForm;
import school_info.models.TrnFollowup;
import school_info.models.TrnParentLead;
import school_info.repository.TrnAdmissionFormRepository;
import school_info.repository.TrnFollowupRepository;

import java.sql.Timestamp;

@Service
public class AIActionExecutor {

    @Autowired
    private TrnAdmissionFormRepository admissionFormRep;

    @Autowired
    private TrnFollowupRepository followupRep;

    public void execute(

            IntentType intent,

            TrnParentLead lead

    ){

        switch(intent)
        {

            case SEND_ADMISSION_FORM:

                sendAdmissionForm(lead);

                scheduleFollowup(lead);

                break;

            case ADMISSION_ENQUIRY:

                scheduleFollowup(lead);

                break;

            default:

                break;

        }

    }

    private void sendAdmissionForm(

            TrnParentLead lead

    ){

        TrnAdmissionForm form =
                new TrnAdmissionForm();

        form.setLead(lead);

        form.setSchool(
                lead.getSchool()
        );

        form.setFormSent("Y");

        form.setFormSentDate(
                new Timestamp(
                        System.currentTimeMillis()
                )
        );

        form.setFormLink(
                "https://school.demo/admission"
        );

        admissionFormRep.save(form);

    }

    private void scheduleFollowup(

            TrnParentLead lead

    ){

        TrnFollowup followup =
                new TrnFollowup();

        followup.setLead(lead);

        followup.setReminderStatus(
                "PENDING"
        );

        followup.setReminderMessage(

                "Reminder: Complete admission process."

        );

        followup.setReminderDate(

                new Timestamp(

                        System.currentTimeMillis()

                                + 86400000

                )

        );

        followupRep.save(followup);

    }

}