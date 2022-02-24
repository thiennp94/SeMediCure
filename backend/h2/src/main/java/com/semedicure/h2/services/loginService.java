package com.semedicure.h2.services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semedicure.h2.models.login;
import com.semedicure.h2.repositories.loginRepository;

@Service
public class loginService
{
	@Autowired
	private static loginRepository LR;
	
	public static java.util.List<login> list() {
		return LR.findAll();
	}
	
	//where you lay out methods for restful api
}
