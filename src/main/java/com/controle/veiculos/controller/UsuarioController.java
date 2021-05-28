package com.controle.veiculos.controller;

import com.controle.veiculos.entities.Usuario;
import com.controle.veiculos.exception.BusinessException;
import com.controle.veiculos.repositories.UsuarioRepository;
import com.controle.veiculos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepository repository;

    UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") int id) throws BusinessException {
        return new ResponseEntity<Usuario>(service.findByAnoAndId(id), HttpStatus.OK);
    }

    @PostMapping(path = "/cadastro", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Usuario> criaUsuario(@RequestBody Usuario novoUsuario) throws BusinessException {
        return new ResponseEntity<Usuario>(service.createUsuario(novoUsuario), HttpStatus.CREATED);
    }
}
