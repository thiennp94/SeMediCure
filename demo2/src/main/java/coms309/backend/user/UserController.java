package coms309.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    //this will display all the users in our database
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

    //This post method uses path variables to post to the database.
    @PostMapping("trivia/post/{e}/{p}/{n}/{d}")
    User PostTriviaByPath(@PathVariable String e, @PathVariable String p, @PathVariable String n, @PathVariable String d){
        User newUser = new User();
        newUser.setEmail(e);
        newUser.setPassword(p);
        newUser.setName(n);
        newUser.setDob(d);
        userRepository.save(newUser);
        return newUser;
    }

}
