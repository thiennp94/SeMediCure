//package coms309.backend.authCode;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class AuthCodeController {
//
//    @Autowired
//    AuthCodeRepository authCodeRepository;
//
//    @GetMapping("/auth")
//    List<AuthCode> GetAuthCode(){
//        return authCodeRepository.findAll();
//    }
//
//
////    //this post method uses the body of the site via a JSON to post to the database
////    @PostMapping("auth/post")
////    User PostTriviaByBody(@RequestBody AuthCode newAuthCode){
////        authCodeRepository.save(newAuthCode);
////        return newAuthCode;
////    }
//
//
//}
