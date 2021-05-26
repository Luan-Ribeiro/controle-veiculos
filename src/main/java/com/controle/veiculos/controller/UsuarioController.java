package com.controle.veiculos.controller;

import com.controle.veiculos.entities.Usuario;
import com.controle.veiculos.repositories.UsuarioRepository;
import com.controle.veiculos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable("id") Long id) {
        Optional<Usuario> byId = repository.findById(id);
        return ResponseEntity.ok(byId);
    }

    @PostMapping(path = "/cadastro", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Usuario> criaUsuario(@RequestBody Usuario novoUsuario) {
        return ResponseEntity.ok(repository.save(novoUsuario));
    }
//
//    @GetMapping(value = "/sucess-by-seller")
//    public ResponseEntity<List<SaleSucessDTO>> sucessGroupedBySeller() {
//        List<SaleSucessDTO> list = service.sucessGroupedBySeller();
//        return ResponseEntity.ok(list);
//    }
}
