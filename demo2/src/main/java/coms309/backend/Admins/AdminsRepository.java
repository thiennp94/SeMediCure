package coms309.backend.Admins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, Long> {

    /*
    This is where login logic... and everything will go.
     */
    //premade query where if they give you a username and password I will find it here.
    List<Admins> findByEmailAndPassword(String email, String password);

    Admins findByEmail(String email);
    Admins findByPassword(String password);

}
