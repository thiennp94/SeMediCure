//package coms309.backend.Patients;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import coms309.backend.Patients.Patients;
//import coms309.backend.Patients.PatientsRepository;
//
///**
// * 
// * @author Vivek Bengre
// * 
// */ 
//
//@RestController
//public class PatientsController {
//
//    @Autowired
//    PatientsRepository patientsRepository;
//    
//    private String success = "{\"message\":\"success\"}";
//    private String failure = "{\"message\":\"failure\"}";
//
//    @GetMapping(path = "/patients")
//    List<Patients> getAllAdmins(){
//        return patientsRepository.findAll();
//    }
//
//    @GetMapping(path = "/patients/{id}")
//    Patients getPatientsById(@PathVariable int id){
//        return patientsRepository.findById(id);
//    }
//
//    @PostMapping(path = "/patients")
//    String createPatients(@RequestBody Patients patient){
//        if (patient == null)
//            return failure;
//        patientsRepository.save(patient);
//        return success;
//    }
//
//    @PutMapping(path = "/patients/{id}")
//    Patients updatePatients(@PathVariable int id, @RequestBody Patients request){
//        Patients patient = patientsRepository.findById(id);
//        if(patient == null)
//            return null;
//        patientsRepository.save(request);
//        return patientsRepository.findById(id);
//    }
//
//    @DeleteMapping(path = "/patients/{id}")
//    String deleteLaptop(@PathVariable int id){
//
//        // delete the laptop if the changes have not been reflected by the above statement
//        patientsRepository.deleteById(id);
//        return success;
//    }
//}

package coms309.backend.patient;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    //created a new JSON object to put the user JSON data in during the login process.
   JSONObject output = new JSONObject();

    @GetMapping("patient/all")
    List<Patient> GetAllPatients(){
        return patientRepository.findAll();
    }

    //this post method uses the body of the site via a JSON to post to the database
    @PostMapping("patient/post")
    Patient PostTriviaByBody(@RequestBody Patient newPatient){
        patientRepository.save(newPatient);
        return newPatient;
    }
    /* This will verify get the login information from the front end.  It will then check the database to verify
    there their email exists and that the password matches. Once that occures it will send back the data to the frontend
    To do this and be able to display the correct error message we packed the user JSON into another JSON called output
    the output JSON will have two variables:
        the status (1 = no email, 2 = password is incorrect, 3 = successful login)
        and the userInfo which will contain the user JSON if the login is successful.
     */
    @GetMapping("login/patient")
    JSONObject LoginEmailVerification(@RequestParam String email, @RequestParam String password) {
        Patient temp = patientRepository.findByEmail(email);
        if (temp == null) {
            output.put("status", 1); //status code for wrong email
            output.put("userInfo", null);
            return output;
        }
        if (!password.equals(temp.getPassword())) {
            output.put("status", 2); //status code for incorrect password
            output.put("userInfo", null);
            return output;
        } else {
            output.put("status", 3); //status code for correct login information
            output.put("userInfo", temp);
            return output;

        }
    }
}

