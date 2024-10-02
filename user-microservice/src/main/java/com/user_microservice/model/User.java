package com.user_microservice.model;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType)
    private Long id;

    private String nombre;
    private int edad;
    private String foto;
    private String descripcion;
    private String email;
    private String password;
    private String rol;
}
