package coms309.demo2.controller;

import coms309.demo2.model.Admin;
import coms309.demo2.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/login/new/patient/")
    List<Admin> GetAllNewPatient(){
        return adminRepository.findAll();
    }

    @PostMapping("/login/post/new/patient")
    Admin PostAdminByPath(@RequestBody Admin newAdmin){
        adminRepository.save(newAdmin);
        return newAdmin;
    }


}