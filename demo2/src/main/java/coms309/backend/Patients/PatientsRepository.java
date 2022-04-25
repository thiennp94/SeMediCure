package coms309.backend.Patients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Vivek Bengre
 * 
 */ 

public interface PatientsRepository extends JpaRepository<Patients, Long> {
    Patients findById(int id);

    @Transactional
    void deleteById(int id);
}

