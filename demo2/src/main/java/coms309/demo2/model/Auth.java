package coms309.demo2.model;

import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.time.LocalTime;


@Entity
@Table(name = "auth")
public class Auth {
    //    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//    LocalTime endDate = LocalTime.now();
//    SELECT code, appointmebtdate
//    FROM authentication;


    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = true, length = 50)
    private LocalTime endDate;

    @Column(nullable = true, length = 5)
    private String authentication;

    public Auth() {
    }

    public LocalTime getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = LocalTime.now();
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        LocalTime currTime = LocalTime.now();
        if(currTime == endDate){
            this.authentication = RandomStringUtils.randomAlphanumeric(5);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
