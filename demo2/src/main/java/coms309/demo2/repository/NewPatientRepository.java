package coms309.demo2.repository;

import coms309.demo2.model.NewPatient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewPatientRepository extends JpaRepository<NewPatient, Long> {
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM NewPatient n where n.emailAddress = :emailAddress") 
	public boolean findByEmail(String emailAddress) ;
	
}
//yes