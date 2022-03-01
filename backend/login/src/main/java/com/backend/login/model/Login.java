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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getStateInitials() {
		return stateInitials;
	}

	public void setStateInitials(String stateInitials) {
		this.stateInitials = stateInitials;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getInsurersName() {
		return insurersName;
	}

	public void setInsurersName(String insurersName) {
		this.insurersName = insurersName;
	}

	public String getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(String policyHolder) {
		this.policyHolder = policyHolder;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
