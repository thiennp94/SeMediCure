package coms309.demo2.controller;

import coms309.demo2.model.Auth;
import coms309.demo2.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
public class AuthController {
    @Autowired
    AuthRepository newAuthRepository;

//    String currentTime = String.valueOf(LocalTime.now());
//    private void insertAuthCode(AuthRepository repository) {
//        repository.save(new Auth("12345", currentTime));
//    }

    @GetMapping("/authCode")
    public List<Auth> GetAuth(){
        return newAuthRepository.findAll();
    }

    @PostMapping("/authCode")
    Auth PostNewAuthCode(@RequestBody Auth newAuthCode) {
        newAuthRepository.save(newAuthCode);
        return newAuthCode;
    }


}
