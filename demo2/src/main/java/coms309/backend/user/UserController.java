package coms309.backend.user;

import coms309.backend.admin.Admin;
import coms309.backend.admin.AdminRepository;
import coms309.backend.doctor.Doctor;
import coms309.backend.doctor.DoctorRepository;
import coms309.backend.patient.Patient;
import coms309.backend.patient.PatientRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class UserController {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AdminRepository adminRepository;

    //created a new JSON object to put the user JSON data in during the login process.
   JSONObject output = new JSONObject();

    /*
    This will verify get the login information from the front end.  It will then check the database to verify
    there their email exists and that the password matches. Once that occurs it will send back the data to the frontend
    To do this and be able to display the correct error message we packed the user JSON into another JSON called output
    the output JSON will have two variables:
        the status (1 = no email, 2 = password is incorrect, 3 = successful login)
        and the userInfo which will contain the user JSON if the login is successful.
     */
    @GetMapping("/login")
    JSONObject LoginEmailVerification(@RequestParam String email, @RequestParam String password, @RequestParam String user) {
        if(user.equals("patient")){
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

        if(user.equals("doctor")){
            Doctor temp = doctorRepository.findByEmail(email);
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

        if(user.equals("admin")) {
            Admin temp = adminRepository.findByEmail(email);
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
        } else {
            return null;
        }

    }
}
