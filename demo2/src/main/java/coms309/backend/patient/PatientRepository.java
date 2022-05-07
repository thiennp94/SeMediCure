package coms309.backend.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /*
    This is where login logic... and everything will go.
     */
    Patient findByEmail(String email);
    Patient findByPassword(String password);

    

}
