package coms309.backend.Doctors;

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

import coms309.backend.Doctors.Doctors;
import coms309.backend.Doctors.DoctorsRepository;

/**
 * 
 * @author Vivek Bengre
 * 
 */ 

@RestController
public class DoctorsController {

    @Autowired
    DoctorsRepository doctorsRepository;
    
    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";

    @GetMapping(path = "/doctors")
    List<Doctors> getAllDoctors(){
        return doctorsRepository.findAll();
    }

    @GetMapping(path = "/doctors/{id}")
    Doctors getDoctorsById(@PathVariable int id){
        return doctorsRepository.findById(id);
    }

    @PostMapping(path = "/doctors")
    String createDoctors(@RequestBody Doctors doctor){
        if (doctor == null)
            return failure;
        doctorsRepository.save(doctor);
        return success;
    }

    @PutMapping(path = "/doctorss/{id}")
    Doctors updateDoctors(@PathVariable int id, @RequestBody Doctors request){
        Doctors doctor = doctorsRepository.findById(id);
        if(doctor == null)
            return null;
        doctorsRepository.save(request);
        return doctorsRepository.findById(id);
    }

    @DeleteMapping(path = "/doctors/{id}")
    String deleteDoctor(@PathVariable int id){

        // delete the laptop if the changes have not been reflected by the above statement
        doctorsRepository.deleteById(id);
        return success;
    }
}
