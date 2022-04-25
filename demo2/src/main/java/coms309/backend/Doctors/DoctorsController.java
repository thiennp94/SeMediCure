//package coms309.backend.Doctors;
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
//import coms309.backend.Doctors.Doctors;
//import coms309.backend.Doctors.DoctorsRepository;
//
///**
// * 
// * @author Vivek Bengre
// * 
// */ 
//
//@RestController
//public class DoctorsController {
//
//    @Autowired
//    DoctorsRepository doctorsRepository;
//    
//    private String success = "{\"message\":\"success\"}";
//    private String failure = "{\"message\":\"failure\"}";
//
//    @GetMapping(path = "/doctors")
//    List<Doctors> getAllDoctors(){
//        return doctorsRepository.findAll();
//    }
//
//    @GetMapping(path = "/doctors/{id}")
//    Doctors getDoctorsById(@PathVariable int id){
//        return doctorsRepository.findById(id);
//    }
//
//    @PostMapping(path = "/doctors")
//    String createDoctors(@RequestBody Doctors doctor){
//        if (doctor == null)
//            return failure;
//        doctorsRepository.save(doctor);
//        return success;
//    }
//
//    @PutMapping(path = "/doctorss/{id}")
//    Doctors updateDoctors(@PathVariable int id, @RequestBody Doctors request){
//        Doctors doctor = doctorsRepository.findById(id);
//        if(doctor == null)
//            return null;
//        doctorsRepository.save(request);
//        return doctorsRepository.findById(id);
//    }
//
//    @DeleteMapping(path = "/doctors/{id}")
//    String deleteDoctor(@PathVariable int id){
//
//        // delete the laptop if the changes have not been reflected by the above statement
//        doctorsRepository.deleteById(id);
//        return success;
//    }
//}
package coms309.backend.Doctors;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorsController {
    @Autowired
    DoctorsRepository doctorRepository;

    //created a new JSON object to put the user JSON data in during the login process.
   JSONObject output = new JSONObject();

    @GetMapping("doctors/all")
    List<Doctors> GetAllUsers(){
        return doctorRepository.findAll();
    }

    //this post method uses the body of the site via a JSON to post to the database
    @PostMapping("doctors/post")
    Doctors PostTriviaByBody(@RequestBody Doctors newDoctor){
        doctorRepository.save(newDoctor);
        return newDoctor;
    }
    /* This will verify get the login information from the front end.  It will then check the database to verify
    there their email exists and that the password matches. Once that occures it will send back the data to the frontend
    To do this and be able to display the correct error message we packed the user JSON into another JSON called output
    the output JSON will have two variables:
        the status (1 = no email, 2 = password is incorrect, 3 = successful login)
        and the userInfo which will contain the user JSON if the login is successful.
     */
    @GetMapping("/login")
    JSONObject LoginEmailVerification(@RequestParam String email, @RequestParam String password) {
        Doctors temp = doctorRepository.findByEmail(email);
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