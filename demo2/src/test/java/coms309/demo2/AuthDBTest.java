package coms309.demo2;

//import coms309.demo2.authToken.Auth;
//import coms309.demo2.authToken.AuthRepository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import java.time.LocalTime;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//
//@DataJpaTest
//@Rollback(false)
//@AutoConfigureTestDatabase(exclude =
//public class AuthDBTest {
//
//    @Autowired
//    private AuthRepository newAuthRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void TestAuthDB(){
//        Auth newCode = new Auth();
//        newCode.setEndDate(LocalTime.now());
//        newCode.setAuthentication("12345");
//
////        Auth savedCode = newAuthRepository.save(newCode);
////
////        Auth currCode = entityManager.find(Auth.class, savedCode.getId());
////
////        assertThat(currCode.getEndDate()).isEqualTo(newCode.getEndDate());
//
//    }
//}
