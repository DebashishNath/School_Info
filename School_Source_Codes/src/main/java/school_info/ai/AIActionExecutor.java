package school_info.ai;

import org.springframework.stereotype.Service;
import school_info.models.TrnAdmissionForm;
import school_info.models.TrnFollowup;
import school_info.models.TrnParentLead;
import school_info.repository.TrnAdmissionFormRepository;
import school_info.repository.TrnFollowupRepository;
import school_info.repository.TrnParentLeadRepository;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class AIActionExecutor {

    private static final String FORM_LINK =
            "https://school.demo/admission";

    private static final String FOLLOWUP_MESSAGE =
            "Reminder: Complete admission process.";

    private static final long FOLLOWUP_DELAY =
            24L * 60L * 60L * 1000L;

    private final TrnAdmissionFormRepository admissionRepository;

    private final TrnFollowupRepository followupRepository;

    private final TrnParentLeadRepository parentLeadRepository;

    public AIActionExecutor(

            TrnAdmissionFormRepository admissionRepository,

            TrnFollowupRepository followupRepository,

            TrnParentLeadRepository parentLeadRepository

    ) {

        this.admissionRepository =
                admissionRepository;

        this.followupRepository =
                followupRepository;

        this.parentLeadRepository =
                parentLeadRepository;

    }

    public void execute(

            IntentType intent,

            AIRequest request,

            AIResponse response

    ) {

        if (request == null ||
                request.getLeadId() == null) {

            return;

        }

        Optional<TrnParentLead> optionalLead =
                parentLeadRepository.findById(
                        request.getLeadId()
                );

        if (optionalLead.isEmpty()) {

            response.setActionPerformed(
                    false
            );

            response.setActionMessage(
                    "Parent lead not found."
            );

            return;

        }

        TrnParentLead lead =
                optionalLead.get();

        switch (intent) {

            case SEND_ADMISSION_FORM:

                sendAdmissionForm(
                        lead
                );

                createFollowup(
                        lead
                );

                response.setActionPerformed(
                        true
                );

                response.setActionMessage(
                        "Admission form sent successfully."
                );

                break;

            case ADMISSION_ENQUIRY:

                createFollowup(
                        lead
                );

                response.setActionPerformed(
                        true
                );

                response.setActionMessage(
                        "Admission follow-up scheduled."
                );

                break;

            case BOOK_VISIT:

                response.setActionPerformed(
                        true
                );

                response.setActionMessage(
                        "School visit request registered."
                );

                break;

            case SCHEDULE_CALLBACK:

                response.setActionPerformed(
                        true
                );

                response.setActionMessage(
                        "Callback request registered."
                );

                break;

            default:

                response.setActionPerformed(
                        false
                );

                response.setActionMessage(
                        null
                );

        }

    }

    private void sendAdmissionForm(

            TrnParentLead lead

    ) {

        TrnAdmissionForm form =
                new TrnAdmissionForm();

        form.setLead(
                lead
        );

        form.setSchool(
                lead.getSchool()
        );

        form.setFormSent(
                "Y"
        );

        form.setFormSentDate(

                new Timestamp(

                        System.currentTimeMillis()

                )

        );

        form.setFormLink(
                FORM_LINK
        );

        admissionRepository.save(
                form
        );

    }

    private void createFollowup(

            TrnParentLead lead

    ) {

        TrnFollowup followup =
                new TrnFollowup();

        followup.setLead(
                lead
        );

        followup.setReminderStatus(
                "PENDING"
        );

        followup.setReminderMessage(
                FOLLOWUP_MESSAGE
        );

        followup.setReminderDate(

                new Timestamp(

                        System.currentTimeMillis()

                                + FOLLOWUP_DELAY

                )

        );

        followupRepository.save(
                followup
        );

    }

}