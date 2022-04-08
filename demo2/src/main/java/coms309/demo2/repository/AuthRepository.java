package coms309.demo2.repository;


import coms309.demo2.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthRepository extends JpaRepository<Auth, Long> {
}
