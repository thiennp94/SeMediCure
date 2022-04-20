package onetoone.Doctors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Doctors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private int phoneNumber;
	private String email;
	private int dateOfBirth;
	private String username;
	private String password;
	private String streetAddress;
	private String city;
	private int zip;
	private String state;
	private int ssn;
	private String specialty;
	private int yearsOfPractice;
	
	public Doctors(String firstName, String middleName, String lastName, int phoneNumber, String email, int dateOfBirth, String username, String password, String streetAddress, String city,
			int zip, String state, int ssn, String specialty, int yearsOfPractice)
	{
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
	
	public Doctors() {}
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getMiddleName()
	{
		return middleName;
	}
	
	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public int getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(int phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public int getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	public void setDateOfBirth(int dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getStreetAddress()
	{
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public int getZip()
	{
		return zip;
	}
	
	public void setZip(int zip)
	{
		this.zip = zip;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public int getSsn()
	{
		return ssn;
	}
	
	public void setSsn(int ssn)
	{
		this.ssn = ssn;
	}
	
	public String getSpecialty()
	{
		return specialty;
	}
	
	public void setSpecialty(String specialty)
	{
		this.specialty = specialty;
	}
	
	public int getYearsOfPractice()
	{
		return yearsOfPractice;
	}
	
	public void setYearsOfPractice(int yearsOfPractice)
	{
		this.yearsOfPractice = yearsOfPractice;
	}
}
