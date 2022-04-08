package coms309.demo2.controller;

import coms309.demo2.model.Patient;
import coms309.demo2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/patient")
public class PatientController {

    @Autowired
    PatientRepository newPatientRepository;

    @GetMapping("login/new/patient")
    public List<Patient> GetPatients(){
        return newPatientRepository.findAll();
    }

//    @GetMapping("/login/patient/id?")
//    List<Patient> GetAllNewPatient(){
//        return newPatientRepository.findAll();
//    }

    @PostMapping("/login/post/patient")
    Patient PostNewPatientByPath(@RequestBody Patient newNewPatient) {
        newPatientRepository.save(newNewPatient);
        return newNewPatient;
    }


}
