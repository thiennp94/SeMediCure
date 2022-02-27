package com.backend.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.login.model.Login;
import com.backend.login.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/patients", method=RequestMethod.POST)
	public Login createEmployee(@RequestBody Login login)
	{
		return loginService.createLogin(login);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public List<Login> readLogins() {
		return loginService.getLogins();
	}
	
	@RequestMapping(value="/patients/{ssn}", method=RequestMethod.PUT)
	public Login readEmployees(@PathVariable(value = "ssn") Long id, @RequestBody Login loginDetails)
	{
		return loginService.updateLogin(id, loginDetails);
	}
	
	@RequestMapping(value="/patients/{ssn}", method=RequestMethod.DELETE)
	public void deleteLogin(@PathVariable(value = "ssn") Long id)
	{
		loginService.deleteLogin(id);
	}
}
