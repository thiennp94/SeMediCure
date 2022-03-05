package coms309.demo2.model;

import javax.persistence.*;

@Entity
@Table(name = "Doctor")
public class NewDoctor {

    public NewDoctor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = true, length = 20)
    private String middleName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(nullable = false, unique = true, length = 55)
    private String emailAddress;

    //NPI = national provider id
    @Column(nullable = false, unique = true, length = 20)
    private String npi;

    //DEA number
    @Column(nullable = false, unique = true, length = 20)
    private String dea;

    //professional license number
    @Column(nullable = false, unique = true, length = 20)
    private String licenseNum;

    //state controlled substance number
    @Column(nullable = false, unique = true, length = 20)
    private String stateControlledSubstrance;

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getDea() {
        return dea;
    }

    public void setDea(String dea) {
        this.dea = dea;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getStateControlledSubstrance() {
        return stateControlledSubstrance;
    }

    public void setStateControlledSubstrance(String stateControlledSubstrance) {
        this.stateControlledSubstrance = stateControlledSubstrance;
    }

    @Column(nullable = false, length = 20)
    private String dateOfBirth;

    @Column(nullable = false, length = 20)
    private String ssn;

    @Column(nullable = false, length = 55)
    private String streetAddress;

    @Column(nullable = false, length = 20)
    private String city;

    @Column(nullable = false, length = 10)
    private String zip;

    @Column(nullable = false, length = 2)
    private String stateInitials;

    @Column(nullable = false, length = 64)
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
