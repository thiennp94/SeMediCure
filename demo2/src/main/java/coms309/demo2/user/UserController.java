package coms309.demo2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    final private UserService userService;

    @Autowired
    public UserController(UserService userService){this.userService = userService; }

//    @GetMapping()
//    public List<User> getUser() {return userService.getUser(); }
//
//    @PostMapping
//    public void login(@RequestBody User login) { userService.login(user); }
}
