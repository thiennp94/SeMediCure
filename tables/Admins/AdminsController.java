package onetoone.Admins;

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

import onetoone.Admins.Admins;
import onetoone.Admins.AdminsRepository;

/**
 * 
 * @author Vivek Bengre
 * 
 */ 

@RestController
public class AdminsController {

    @Autowired
    AdminsRepository adminsRepository;
    
    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";

    @GetMapping(path = "/admins")
    List<Admins> getAllAdmins(){
        return adminsRepository.findAll();
    }

    @GetMapping(path = "/admins/{id}")
    Admins getAdminsById(@PathVariable int id){
        return adminsRepository.findById(id);
    }

    @PostMapping(path = "/admins")
    String createAdmins(@RequestBody Admins admin){
        if (admin == null)
            return failure;
        adminsRepository.save(admin);
        return success;
    }

    @PutMapping(path = "/admins/{id}")
    Admins updateAdmins(@PathVariable int id, @RequestBody Admins request){
        Admins admin = adminsRepository.findById(id);
        if(admin == null)
            return null;
        adminsRepository.save(request);
        return adminsRepository.findById(id);
    }

    @DeleteMapping(path = "/admins/{id}")
    String deleteLaptop(@PathVariable int id){

        // delete the laptop if the changes have not been reflected by the above statement
        adminsRepository.deleteById(id);
        return success;
    }
}
