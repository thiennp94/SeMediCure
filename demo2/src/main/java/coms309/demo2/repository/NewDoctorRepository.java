package coms309.demo2.repository;

import coms309.demo2.model.NewDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewDoctorRepository extends JpaRepository<NewDoctor, Long> {
}
