package com.GMHDigital.API_WorkFin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GMHDigital.API_WorkFin.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
