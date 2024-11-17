package com.turismo.user_microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismo.user_microservice.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByNombre(String nombre);
    Optional<Usuario> findByCredencial_Username(String username);
}
