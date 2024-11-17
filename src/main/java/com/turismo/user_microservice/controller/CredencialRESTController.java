package com.turismo.user_microservice.controller;

import com.turismo.user_microservice.entity.Credencial;
import com.turismo.user_microservice.service.CredencialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/credenciales")
public class CredencialRESTController {

    private final CredencialService credencialService;

    public CredencialRESTController(CredencialService credencialService) {
        this.credencialService = credencialService;
    }

    @PostMapping
    public ResponseEntity<Credencial> crearCredencial(@RequestBody Credencial credencial) {
        Credencial nuevaCredencial = credencialService.guardarCredencial(credencial);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCredencial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Credencial> obtenerCredencialPorId(@PathVariable Long id) {
        Optional<Credencial> credencial = credencialService.obtenerCredencialPorId(id);
        return credencial.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Credencial> obtenerCredencialPorUsername(@PathVariable String username) {
        Optional<Credencial> credencial = credencialService.obtenerCredencialPorUsername(username);
        return credencial.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCredencial(@PathVariable Long id) {
        credencialService.eliminarCredencial(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
