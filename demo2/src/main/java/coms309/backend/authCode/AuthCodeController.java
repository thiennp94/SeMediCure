package coms309.backend.authCode;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthCodeController {

    @Autowired
    AuthCodeRepository authCodeRepository;

    //created a new JSON object to put the user JSON data in during the login process.
    JSONObject output = new JSONObject();

    /*
    I was trying to add the authcode to the databse. However the below code for some
    reason broke the program.  When the code is running for whatever reason localhost
    refuses to connect.
     */
//    AuthCode code = new GenerateAuthCode().newAuthCode();
//
//    AuthCode testCode = authCodeRepository.save(code);

    @GetMapping("/auth")
    List<AuthCode> GetAuthCode(){
        return authCodeRepository.findAll();
    }

    @GetMapping("/auth/verify")
    JSONObject VerifyAuthCode(@RequestParam String authCode){
        AuthCode temp = authCodeRepository.findByAuthCode(authCode);
        if(temp == null){
            output.put("status", 1);
            output.put("authCodeInfo", null);
            return output;
        } else {
            output.put("status", 2);
            output.put("authCodeInfo", temp);
            return output;
        }
    }


//    //this post method uses the body of the site via a JSON to post to the database
//    @PostMapping("auth/post")
//    AuthCode PostTriviaByBody(@RequestBody AuthCode newAuthCode){
//        authCodeRepository.save(newAuthCode);
//        return newAuthCode;
//    }


}
