package com.turismo.user_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismo.user_microservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
