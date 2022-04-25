package coms309.backend.Doctors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {

    /*
    This is where login logic... and everything will go.
     */
    //premade query where if they give you a username and password I will find it here.
    List<Doctors> findByEmailAndPassword(String email, String password);

    Doctors findByEmail(String email);
    Doctors findByPassword(String password);

}
