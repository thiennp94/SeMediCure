//package coms309.backend.Admins;
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
//import coms309.backend.Admins.Admins;
//import coms309.backend.Admins.AdminsRepository;
//
///**
// * 
// * @author Vivek Bengre
// * 
// */ 
//
//@RestController
//public class AdminsController {
//
//    @Autowired
//    AdminsRepository adminsRepository;
//    
//    private String success = "{\"message\":\"success\"}";
//    private String failure = "{\"message\":\"failure\"}";
//
//    @GetMapping(path = "/admins")
//    List<Admins> getAllAdmins(){
//        return adminsRepository.findAll();
//    }
//
//    @GetMapping(path = "/admins/{id}")
//    Admins getAdminsById(@PathVariable int id){
//        return adminsRepository.findById(id);
//    }
//
//    @PostMapping(path = "/admins")
//    String createAdmins(@RequestBody Admins admin){
//        if (admin == null)
//            return failure;
//        adminsRepository.save(admin);
//        return success;
//    }
//
//    @PutMapping(path = "/admins/{id}")
//    Admins updateAdmins(@PathVariable int id, @RequestBody Admins request){
//        Admins admin = adminsRepository.findById(id);
//        if(admin == null)
//            return null;
//        adminsRepository.save(request);
//        return adminsRepository.findById(id);
//    }
//
//    @DeleteMapping(path = "/admins/{id}")
//    String deleteLaptop(@PathVariable int id){
//
//        // delete the laptop if the changes have not been reflected by the above statement
//        adminsRepository.deleteById(id);
//        return success;
//    }
//}
package coms309.backend.admin;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import coms309.backend.admin.Admin;
import java.util.List;


@RestController
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    //created a new JSON object to put the user JSON data in during the login process.
   JSONObject output = new JSONObject();

    @GetMapping("admin/all")
    List<Admin> GetAllAdmins(){
        return adminRepository.findAll();
    }

    //this post method uses the body of the site via a JSON to post to the database
    @PostMapping("admin/new")
    Admin PostTriviaByBody(@RequestBody Admin newAdmin){
//    	String pass = toCipher(newAdmin.getPassword());
//    	newAdmin.setPassword(toCipher(newAdmin.getPassword()));
        adminRepository.save(newAdmin);
        return newAdmin;
    }

//    @GetMapping("admin/login")
//    JSONObject LoginEmailVerification(@RequestParam String email, @RequestParam String password) {
//        Admin temp = adminRepository.findByEmail(email);
//        if (temp == null) {
//            output.put("status", 1); //status code for wrong email
//            output.put("userInfo", null);
//            return output;
//        }
//        if (!password.equals(temp.getPassword())) {
//            output.put("status", 2); //status code for incorrect password
//            output.put("userInfo", null);
//            return output;
//        } else {
//            output.put("status", 3); //status code for correct login information
//            output.put("userInfo", temp);
//            return output;
//
//        }
//    }
    
//    public String toCipher(String input)
//    {
//        String output = "";
//        for(int i=0; i<input.length(); i++)
//        {
//            output = output + (input.charAt(i) + 5);
//        }
//        return output;
//    }

}