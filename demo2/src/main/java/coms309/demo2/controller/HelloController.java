package coms309.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
