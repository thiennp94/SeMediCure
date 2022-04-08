package coms309.demo2.admin;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    public Admin() {
    }
// not done, need to set up DB and then modify this
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

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", ssn='" + ssn + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", stateInitials='" + stateInitials + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
