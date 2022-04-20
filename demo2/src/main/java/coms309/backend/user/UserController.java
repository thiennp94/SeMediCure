package coms309.backend.user;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

   JSONObject output = new JSONObject();
   /*
   Temp = get user from user repository by email
   if(temp == null){
        output.put("status", errorCode); //errorCode for wrong email
        output.put("userInfo", null);
        return output;
   }
   if!(password.isEqualTo(temp.getPassword()){
        output.put("status", errorCode); //errorCode for wrong password
        output.put("userInfo", null);
        return output;
   } else {
        output.put("status", errorCode); //errorCode for correct login information
        output.put("userInfo", temp);
        return output;
    */

    @GetMapping("user/all")
    List<User> GetAllUsers(){
        return userRepository.findAll();
    }

    /*
    this will display all the users in our database
    does this have to be a list since we are just pulling one user.
     */
//    @GetMapping("/login")
//    List<User> LoginUser(@RequestParam String email, @RequestParam String password){
//        return userRepository.findByEmailAndPassword(email, password);
//    }

    /*
    Status codes 0 = login success, 1 = email failed, 2 = password failed
    If we are just sending over an int as a response how are we sending over additional information
     -> one way is to create your own JSON by hand.  Spring will serialize into a JSON for you.
     -> For this request, have the return type be a JSON object (which is just a key value pair).
        -> put the current JSON return into another JSON with the status code
     */
    @GetMapping("/login2")
    JSONObject LoginEmailVerification(@RequestParam String email, @RequestParam String password) {
        User temp = userRepository.findByEmail(email);
        if (temp == null) {
            output.put("status", 1); //errorCode for wrong email
            output.put("userInfo", null);
            return output;
        }
        if (!password.equals(temp.getPassword())) {
            output.put("status", 2); //errorCode for wrong password
            output.put("userInfo", null);
            return output;
        } else {
            output.put("status", 3); //errorCode for correct login information
            output.put("userInfo", temp);
            return output;

        }

        //this post method uses the body of the site via a JSON to post to the database
//    @PostMapping("user/post")
//    @PostMapping("user/post")
//    User PostTriviaByBody(@RequestBody User newUser){
//        userRepository.save(newUser);
//        return newUser;
//    }


//    //This post method uses path variables to post to the database.
//    @PostMapping("trivia/post/{e}/{p}/{n}/{d}")
//    User PostTriviaByPath(@PathVariable String e, @PathVariable String p, @PathVariable String n, @PathVariable String d){
//        User newUser = new User();
//        newUser.setEmail(e);
//        newUser.setPassword(p);
//        newUser.setName(n);
//        newUser.setDob(d);
//        userRepository.save(newUser);
//        return newUser;
//    }
    }
}
