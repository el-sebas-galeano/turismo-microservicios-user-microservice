package com.turismo.user_microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turismo.user_microservice.entity.User;
import com.turismo.user_microservice.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserRESTController {
    
    @Autowired
  private UserService userService;

  @GetMapping("/listarUsuarios")
  public ResponseEntity<List<User>> obtenerUsuarios() {
    List<User> usuarios = userService.obtenerTodosLosUsuarios();
    return new ResponseEntity<>(usuarios, HttpStatus.OK);
  }

  @GetMapping("/findUsuario/{iduser}")
  public ResponseEntity<User> obtenerUsuario(@PathVariable Long iduser) {
    User usuario = userService.obtenerUsuario(iduser); // Asegúrate de usar iduser
    return new ResponseEntity<>(usuario, HttpStatus.OK);
  }

  @PostMapping("/crearUsuario")
  public ResponseEntity<User> crearUsuario(@RequestBody User usuario) {
    User nuevoUsuario = userService.crearUsuario(usuario);
    return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
  }

  @DeleteMapping("/eliminarUsuario/{iduser}")
  public ResponseEntity<Void> eliminarUser(@PathVariable Long iduser) {
    boolean eliminado = userService.eliminarUsuario(iduser);

    if (eliminado) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/actualizarUsuario/{iduser}")
  public ResponseEntity<User> actualizarUsuario(@PathVariable Long iduser, @RequestBody User datosActualizados) {
    User usuarioActualizado = userService.actualizarUsuario(iduser, datosActualizados);
    if (usuarioActualizado != null) {
      return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
