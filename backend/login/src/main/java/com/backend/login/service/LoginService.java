//This class has the basic CRUD operations!
package com.backend.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.login.model.Login;
import com.backend.login.repository.LoginRepository;
import java.util.List;

@Service
public class LoginService {

	@Autowired
		LoginRepository LoginRepository;
	
	//CREATE
	public Login createLogin(Login login)
	{
		return LoginRepository.save(login);
	}
	
	//READ
	public List<Login> getLogins()
	{
		return LoginRepository.findAll();
	}
	
	// DELETE
	public void deleteLogin(Long ssn)
	{
		LoginRepository.deleteById(ssn);
	}
	
	public Login updateLogin(Long ssn, Login LoginDetails)
	{
		Login login = LoginRepository.findById(ssn).get();
		login.setUsername(LoginDetails.getUsername());
		login.setPassword(LoginDetails.getPassword());
		
		return LoginRepository.save(login);
	}
}

