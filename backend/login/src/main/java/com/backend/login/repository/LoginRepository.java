package com.backend.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.login.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	

	
	
}
