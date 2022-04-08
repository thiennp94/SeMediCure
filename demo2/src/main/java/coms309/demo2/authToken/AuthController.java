package coms309.demo2.authToken;

import coms309.demo2.authToken.Auth;
import coms309.demo2.authToken.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {

//    @Autowired
//    AuthRepository newAuthRepository;

    final private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/authCode")
    public List<Auth> getNewAuth(){
        return authService.getAuth();
    }


    @PostMapping
    public void getNewCode(@RequestBody Auth newCode){
        authService.getNewCode(newCode);
    }
//    @PostMapping("/authCode")
//    Auth PostNewAuthCode(@RequestBody Auth newAuthCode) {
//        newAuthRepository.save(newAuthCode);
//        return newAuthCode;
//    }


}
