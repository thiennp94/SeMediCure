package com.semedicure.h2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.semedicure.h2.models.login;

@Repository
public interface loginRepository extends JpaRepository<login, String> {

}
