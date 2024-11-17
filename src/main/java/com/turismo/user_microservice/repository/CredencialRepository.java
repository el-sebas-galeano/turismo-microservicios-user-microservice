package com.turismo.user_microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismo.user_microservice.entity.Credencial;


@Repository
public interface CredencialRepository extends JpaRepository<Credencial, Long>{
    Optional<Credencial> findByUsername(String username);
}
