package coms309.backend.Admins;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Vivek Bengre
 * 
 */ 

public interface AdminsRepository extends JpaRepository<Admins, Long> {
    Admins findById(int id);

    @Transactional
    void deleteById(int id);
}
