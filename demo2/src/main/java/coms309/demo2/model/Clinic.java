package coms309.demo2.model;
import javax.persistence.*;
@Entity
@Table(name="clinics")
public class Clinic {
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor", referencedColumnName = "lastName")
	private Doctor doctor;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "insurance", referencedColumnName = "name")
	private InsuranceProvider ip;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "phoneNumber")
	private int phoneNumber;
	
	public Doctor getDoctor()
	{
		return this.doctor;
	}
	
	public void setDoctor(Doctor doctor)
	{
		this.doctor = doctor;
	}
	
	public InsuranceProvider getInsuranceProvider()
	{
		return this.ip;
	}
	
	public void setInsuranceProvider(InsuranceProvider inpr)
	{
		this.ip = inpr;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setLocation(String loc)
	{
		this.location = loc;
	}
	
	public int getNumber()
	{
		return this.phoneNumber;
	}
	
	public void setNumber(int num)
	{
		this.phoneNumber = num;
	}
	
}
