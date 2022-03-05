package coms309.demo2.controller;

import coms309.demo2.model.NewPatient;
import coms309.demo2.repository.NewPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewDoctorControllers {

    @Autowired
    NewPatientRepository newPatientRepository;

    @GetMapping("/login/provider/id?")
    List<NewPatient> GetAllNewPatient(){
        return newPatientRepository.findAll();
    }

    @PostMapping("/login/post/provider")
    NewPatient PostNewPatientByPath(@RequestBody NewPatient newNewPatient){
        newPatientRepository.save(newNewPatient);
        return newNewPatient;
    }

}
