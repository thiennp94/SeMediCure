package coms309.backend.Patients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

    /*
    This is where login logic... and everything will go.
     */
    //premade query where if they give you a username and password I will find it here.
    List<Patients> findByEmailAndPassword(String email, String password);

    Patients findByEmail(String email);
    Patients findByPassword(String password);

}
