package coms309.backend.doctor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String dateOfBirth;
	private String username;
	private String password;
	private String streetAddress;
	private String city;
	private String zip;
	private String state;
	private String ssn;
	private String specialty;
	private String yearsOfPractice;
	
	public Doctor(String firstName, String middleName, String lastName, String phoneNumber, String email,
				  String dateOfBirth, String username, String password, String streetAddress, String city, String zip, String state,
				  String ssn, String specialty, String yearsOfPractice) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
		this.streetAddress = streetAddress;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.ssn = ssn;
		this.specialty = specialty;
		this.yearsOfPractice = yearsOfPractice;
	}
	
	public Doctor() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
		String output = "";
        for(int i=0; i<password.length(); i++)
        {
            output = output + (password.charAt(i) + 5);
        }
		this.password = output;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getYearsOfPractice() {
		return yearsOfPractice;
	}

	public void setYearsOfPractice(String yearsOfPractice) {
		this.yearsOfPractice = yearsOfPractice;
	}
}
