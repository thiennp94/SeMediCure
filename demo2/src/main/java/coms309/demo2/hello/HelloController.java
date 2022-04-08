package coms309.demo2.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
