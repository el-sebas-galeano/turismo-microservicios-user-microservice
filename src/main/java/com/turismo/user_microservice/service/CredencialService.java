package com.turismo.user_microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismo.user_microservice.entity.Credencial;
import com.turismo.user_microservice.repository.CredencialRepository;

@Service
public class CredencialService {
    
    @Autowired
    private CredencialRepository credencialRepository;

    public Credencial guardarCredencial(Credencial credencial) {
        return credencialRepository.save(credencial);
    }

    public Optional<Credencial> obtenerCredencialPorId(Long id) {
        return credencialRepository.findById(id);
    }

    public Optional<Credencial> obtenerCredencialPorUsername(String username) {
        return credencialRepository.findByUsername(username);
    }

    public void eliminarCredencial(Long id) {
        credencialRepository.deleteById(id);
    }
}
