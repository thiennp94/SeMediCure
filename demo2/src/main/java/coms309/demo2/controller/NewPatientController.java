package coms309.demo2.controller;

import coms309.demo2.model.NewPatient;
import coms309.demo2.repository.NewPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NewPatientController {

    @Autowired
    NewPatientRepository newPatientRepository;

    @GetMapping("/login/new/patient/")
    List<NewPatient> GetAllNewPatient(){
        return newPatientRepository.findAll();
    }

    @PostMapping("/login/post/new/patient")
    NewPatient PostNewPatientByPath(@RequestBody NewPatient newNewPatient){
        newPatientRepository.save(newNewPatient);
        return newNewPatient;
    }

	@GetMapping("/login/post/new/patient/{emailAddress}")
    public ResponseEntity<NewPatient> getPatientByEmail(@PathVariable("emailAddress") String emailAddress)
    {
    	boolean emailExists = NewPatientRepository.findByEmail(emailAddress);
    	if(emailExists) {
    		//boolean passwordExists = NewPatientRepository
    	}
    	else
    	{
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
    }
    
    	
    
    
}
