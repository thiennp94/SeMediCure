package com.semedicure.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class controller   
{  


@Autowired
loginService loginService;


@PostMapping(value = "/test", Request = RequestMethod.POST)
public String test() {
	return loginService.createLogin()
}

}  