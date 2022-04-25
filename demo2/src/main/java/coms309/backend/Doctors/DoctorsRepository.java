package coms309.backend.Doctors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Vivek Bengre
 * 
 */ 

public interface DoctorsRepository extends JpaRepository<Doctors, Long> {
    Doctors findById(int id);

    @Transactional
    void deleteById(int id);
}
