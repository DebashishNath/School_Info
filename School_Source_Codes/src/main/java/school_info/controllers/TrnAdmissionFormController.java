package school_info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school_info.models.TrnAdmissionForm;
import school_info.models.TrnParentLead;
import school_info.service.TrnAdmissionForm.TrnAdmissionFormService;
import utils.MessageResponse;

import java.util.List;

@RestController
@RequestMapping("/api/school_info/trnAdmissionForm")
@CrossOrigin(origins = "*")
public class TrnAdmissionFormController {

    @Autowired
    private TrnAdmissionFormService trnAdmissionFormService;

    @PostMapping("/updateTrnAdmissionForm")
    public TrnAdmissionForm updateTrnAdmissionForm(
            @RequestBody TrnAdmissionForm trnAdmissionForm
    ){
        return trnAdmissionFormService
                .updateTrnAdmissionForm(
                        trnAdmissionForm
                );
    }

    @DeleteMapping("/deleteTrnAdmissionForm/{formId}")
    public MessageResponse deleteTrnAdmissionForm(
            @PathVariable Long formId
    ){
        return trnAdmissionFormService
                .deleteTrnAdmissionForm(formId);
    }

    @PostMapping("/findByLead")
    public List<TrnAdmissionForm> findByLead(
            @RequestBody TrnParentLead lead
    ){
        return trnAdmissionFormService
                .findByLead(lead);
    }

    @GetMapping("/findByFormSent/{formSent}")
    public List<TrnAdmissionForm> findByFormSent(
            @PathVariable String formSent
    ){
        return trnAdmissionFormService
                .findByFormSent(formSent);
    }

    @GetMapping("/findByFormSubmitted/{formSubmitted}")
    public List<TrnAdmissionForm> findByFormSubmitted(
            @PathVariable String formSubmitted
    ){
        return trnAdmissionFormService
                .findByFormSubmitted(formSubmitted);
    }
}