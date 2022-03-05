package coms309.demo2.controller;

import coms309.demo2.model.NewPatient;
import coms309.demo2.repository.NewPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewPatientController {

    @Autowired
    NewPatientRepository newPatientRepository;

    @GetMapping("/login/patient/id?")
    List<NewPatient> GetAllNewPatient(){
        return newPatientRepository.findAll();
    }

    @PostMapping("/login/post/patient")
    NewPatient PostNewPatientByPath(@RequestBody NewPatient newNewPatient){
        newPatientRepository.save(newNewPatient);
        return newNewPatient;
    }


}
