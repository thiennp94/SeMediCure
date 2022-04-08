package coms309.demo2.authToken;

import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.time.LocalTime;


@Entity
@Table(name = "auth")
public class Auth {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 50)
    private LocalTime endDate;

    @Column(nullable = true, length = 5)
    private String authentication;

    public Auth() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getEndDate() {
        return LocalTime.now();
    }

    public void setEndDate(LocalTime endDate) {
        this.endDate = endDate;
    }

    public String getAuthentication() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public Auth(Long id, LocalTime endDate, String authentication) {
        this.id = id;
        this.endDate = endDate;
        this.authentication = authentication;
    }

    public Auth(LocalTime endDate, String authentication) {
        this.endDate = endDate;
        this.authentication = authentication;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id=" + id +
                ", endDate=" + endDate +
                ", authentication='" + authentication + '\'' +
                '}';
    }

}
