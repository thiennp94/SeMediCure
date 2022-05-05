package coms309.backend.user;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    //created a new JSON object to put the user JSON data in during the login process.
   JSONObject output = new JSONObject();

    @GetMapping("user/all")
    List<User> GetAllUsers(){
        return userRepository.findAll();
    }

    //this post method uses the body of the site via a JSON to post to the database
    @PostMapping("user/post")
    User PostTriviaByBody(@RequestBody User newUser){
        userRepository.save(newUser);
        return newUser;
    }

    /*
    Notes from Will's meeting with David:
    Status codes 0 = login success, 1 = email failed, 2 = password failed
    If we are just sending over an int as a response how are we sending over additional information
     -> one way is to create your own JSON by hand.  Spring will serialize into a JSON for you.
     -> For this request, have the return type be a JSON object (which is just a key value pair).
        -> put the current JSON return into another JSON with the status code
     */

    /*
    This will verify get the login information from the front end.  It will then check the database to verify
    there their email exists and that the password matches. Once that occures it will send back the data to the frontend
    To do this and be able to display the correct error message we packed the user JSON into another JSON called output
    the output JSON will have two variables:
        the status (1 = no email, 2 = password is incorrect, 3 = successful login)
        and the userInfo which will contain the user JSON if the login is successful.
     */
    @GetMapping("login/user")
    JSONObject LoginEmailVerification(@RequestParam String email, @RequestParam String password) {
        User temp = userRepository.findByEmail(email);
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
