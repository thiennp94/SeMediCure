package coms309.backend.Patients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coms309.backend.Patients.Patients;
import coms309.backend.Patients.PatientsRepository;

/**
 * 
 * @author Vivek Bengre
 * 
 */ 

@RestController
public class PatientsController {

    @Autowired
    PatientsRepository patientsRepository;
    
    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";

    @GetMapping(path = "/patients")
    List<Patients> getAllAdmins(){
        return patientsRepository.findAll();
    }

    @GetMapping(path = "/patients/{id}")
    Patients getPatientsById(@PathVariable int id){
        return patientsRepository.findById(id);
    }

    @PostMapping(path = "/patients")
    String createPatients(@RequestBody Patients patient){
        if (patient == null)
            return failure;
        patientsRepository.save(patient);
        return success;
    }

    @PutMapping(path = "/patients/{id}")
    Patients updatePatients(@PathVariable int id, @RequestBody Patients request){
        Patients patient = patientsRepository.findById(id);
        if(patient == null)
            return null;
        patientsRepository.save(request);
        return patientsRepository.findById(id);
    }

    @DeleteMapping(path = "/patients/{id}")
    String deleteLaptop(@PathVariable int id){

        // delete the laptop if the changes have not been reflected by the above statement
        patientsRepository.deleteById(id);
        return success;
    }
}
