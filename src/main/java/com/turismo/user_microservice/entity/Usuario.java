package com.turismo.user_microservice.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "EDAD")
    private int edad;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "WEB")
    private String web;

    @Column(name = "FOTO")
    private byte[] foto;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> redesSociales;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Credencial credencial;

    public Usuario() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public List<String> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(List<String> redesSociales) {
        this.redesSociales = redesSociales;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    
}
