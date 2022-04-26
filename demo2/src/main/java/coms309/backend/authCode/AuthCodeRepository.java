package coms309.backend.authCode;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthCodeRepository extends JpaRepository<AuthCode, Long> {

//    GenerateAuthCode authCode = new GenerateAuthCode().newAuthCode();

    //figure out how to put the auth code into the actual database.

    AuthCode findByAuthCode(String authCode);


}
