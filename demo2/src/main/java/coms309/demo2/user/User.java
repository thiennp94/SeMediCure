package coms309.demo2.user;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "auth")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 20)
    private String first;

    @Column(nullable = true, length = 20)
    private String middle;

    @Column(nullable = true, length = 20)
    private String last;

    @Column(nullable = true, length = 20)
    private String phone;

    @Column(nullable = true, length = 20)
    private String email;

    @Column(nullable = true, length = 20)
    private String dob;

    @Column(nullable = true, length = 20)
    private String type;

    @Column(nullable = true, length = 20)
    private String user;

    @Column(nullable = true, length = 20)
    private String pass;

    @Column(nullable = true, length = 20)
    private String street;

    @Column(nullable = true, length = 20)
    private String city;

    @Column(nullable = true, length = 20)
    private String zip;

    @Column(nullable = true, length = 20)
    private String state;

    @Column(nullable = true, length = 20)
    private String ssn;

    public User() {
    }

    public User(Long id, String first, String middle, String last, String phone, String email, String dob, String type, String user, String pass, String street, String city, String zip, String state, String ssn) {
        this.id = id;
        this.first = first;
        this.middle = middle;
        this.last = last;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.type = type;
        this.user = user;
        this.pass = pass;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.ssn = ssn;
    }

    public User(String first, String middle, String last, String phone, String email, String dob, String type, String user, String pass, String street, String city, String zip, String state, String ssn) {
        this.first = first;
        this.middle = middle;
        this.last = last;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.type = type;
        this.user = user;
        this.pass = pass;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.ssn = ssn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", middle='" + middle + '\'' +
                ", last='" + last + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", state='" + state + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
