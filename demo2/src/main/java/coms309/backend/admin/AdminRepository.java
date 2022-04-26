package coms309.backend.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    /*
    This is where login logic... and everything will go.
     */
    //premade query where if they give you a username and password I will find it here.
    List<Admin> findByEmailAndPassword(String email, String password);

    Admin findByEmail(String email);
    Admin findByPassword(String password);

}
