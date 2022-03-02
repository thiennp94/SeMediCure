package coms309.demo2.repository;

import coms309.demo2.model.NewPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewPatientRepository extends JpaRepository<NewPatient, Long> {
}
