package com.turismo.user_microservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CREDENCIAL")
public class Credencial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCredencial;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROL")
    private Rol rol;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Usuario usuario;

    public Credencial() {
    }

    public Long getIdCredencial() {
        return idCredencial;
    }

    public void setIdCredencial(Long idCredencial) {
        this.idCredencial = idCredencial;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
