package com.semedicure.h2.models;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

@SuppressWarnings("deprecation")
@Entity
public class login {
	@Id
	@GeneratedValue
	private String userName;
	private String password;
}
