package com.backend.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "firstName")
	private String firstName;

	@Column(name = "middleName")
	private String middleName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "phoneNumber")
	private int phoneNumber;

	@Column(name = "emailAddress")
	private String emailAddress;

	@Column(name = "dateOfBirth")
	private int dateOfBirth;

	@Column(name = "streetAddress")
	private String streetAddress;

	@Column(name = "city")
	private String city;

	@Column(name = "zip")
	private String zip;

	@Column(name = "stateInitials")
	private String stateInitials;

	@Column(name = "ssn")
	private int ssn;

	@Column(name = "insurersName")
	private String insurersName;

	@Column(name = "policyHoldersName")
	private String policyHolder;
	
	@Column(name = "groupNumber")
	private int groupNumber;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
}
