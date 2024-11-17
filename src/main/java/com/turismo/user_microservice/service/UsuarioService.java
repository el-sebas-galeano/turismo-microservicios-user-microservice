package com.turismo.user_microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turismo.user_microservice.entity.Usuario;
import com.turismo.user_microservice.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obtenerUsuarioPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }   

    public Optional<Usuario> obtenerUsuarioPorUsername(String username) {
        return usuarioRepository.findByCredencial_Username(username);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
