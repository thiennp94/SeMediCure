package com.semedicure.h2.controller;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class controller   
{  
@RequestMapping("/")  
public String hello()   
{  
return "Hello User";  
}  
}  