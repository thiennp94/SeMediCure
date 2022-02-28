package com.semedicure.h2.models;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

@DynamicUpdate
public class login {
	@Id
	@GeneratedValue
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//base page for object
	//methods / manipulation
}
