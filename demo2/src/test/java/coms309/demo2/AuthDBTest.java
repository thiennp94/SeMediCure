package coms309.demo2;

import coms309.demo2.model.Auth;
import coms309.demo2.repository.AuthRepository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthDBTest {

    @Autowired
    private AuthRepository newAuthRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void TestAuthDB(){
//        String currentTime = String.valueOf(LocalTime.now());
//        private void insertAuthCode(AuthRepository repository) {
//            repository.save(new Auth("12345", currentTime));
//        }
        Auth newCode = new Auth();
        newCode.setEndDate(String.valueOf(LocalTime.now()));
        newCode.setAuthentication("12345");

    }
}
