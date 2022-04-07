package coms309.demo2.controller;

import coms309.demo2.model.Patient;
import coms309.demo2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorControllers {

    @Autowired
    PatientRepository newPatientRepository;

    @GetMapping("/login/provider/id?")
    List<Patient> GetAllNewPatient(){
        return newPatientRepository.findAll();
    }

    @PostMapping("/login/post/provider")
    Patient PostNewPatientByPath(@RequestBody Patient newNewPatient){
        newPatientRepository.save(newNewPatient);
        return newNewPatient;
    }

}