package xyz.nodstuff.controller;

import xyz.nodstuff.interfaces.PatientDAO;
import xyz.nodstuff.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by tmeaney on 11/02/16.
 */
@RestController
public class PatientsController {

    @Autowired
    private PatientDAO patientDAO;

    @RequestMapping("/patient")
    public Patient patient(@RequestParam(value = "mrn", defaultValue = "") String mrn) {
        return patientDAO.findByMrn(mrn);
    }
}
