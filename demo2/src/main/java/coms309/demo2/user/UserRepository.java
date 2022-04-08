package coms309.demo2.user;

import coms309.demo2.authToken.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Auth, Long> {
}
