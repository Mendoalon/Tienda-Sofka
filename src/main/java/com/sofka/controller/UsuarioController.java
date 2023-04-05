package com.sofka.controller;


import com.sofka.domain.Usuario;
import com.sofka.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j   //TODO: Para imprimir en consola en esping
@RestController //TODO: Para que spring reconosca que es un controlador
public class UsuarioController {
    @Autowired  //TODO: Para que spring boot entienda que va a inyectar el UsuarioService
    private UsuarioService usuarioService;

    @GetMapping(path = "/") //TODO: Peticion GET para devolver un json de ejemplo.
    public Map<String, String> index(){
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("msg", "Hola Mundo");
        return respuesta;
    }
    @GetMapping(path = "/users") //TODO: Peticion GET para optener todos los usuarios
    public List<Usuario> listado(){
       return usuarioService.listar();
    }
    @PostMapping(path = "/user") //TODO: Peticion POST para crear un usuario
    public ResponseEntity<Usuario> crear(Usuario usuario){
        log.info("Usuario a crear: {}", usuario);
        usuarioService.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/user/{id}") //TODO: Peticion DELETE para eliminar un usuario
    public ResponseEntity<Usuario> borrar(Usuario usuario){
        log.info("Usuario a eliminar: {}", usuario);
        usuarioService.delete(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping(path = "/user/{id}") //TODO: Peticion PUT para actualizar un usuario completo sus datos

    public ResponseEntity<Usuario> actualizar(Usuario usuario, @PathVariable("id") Long id ){
        log.info("Usuario a modificar: {}", usuario);

        usuarioService.update(id, usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/user/name/{id}") //TODO: Peticion PATCH para actualiza nombre de un usuario
    public ResponseEntity<Usuario> actualizarNombre(Usuario usuario, @PathVariable("id") Long id){
        log.info("Usuario a modificar nombre: {}", usuario);

        usuarioService.updateNombre(id, usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/user/typeId/{id}") //TODO: Peticion PATCH para el tipo de documento de un usuario
    public ResponseEntity<Usuario>  actualizarTipoDocumento(Usuario usuario, @PathVariable("id") Long id){
        log.info("Usuario a modificar numero typo documento: {}", usuario);
        usuarioService.updateTipoDocumento(id, usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/user/document/{id}") //TODO: Peticion PATCH para el documento de un usuario
    public ResponseEntity<Usuario>  actualizarDocumento(Usuario usuario, @PathVariable("id") Long id){
        log.info("Usuario a modificar numero documento: {}", usuario);
        usuarioService.updateDocumento(id, usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);

}
}
