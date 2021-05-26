package com.controle.veiculos.controller;

import com.controle.veiculos.entities.Veiculo;
import com.controle.veiculos.repositories.VeiculoRepository;
import com.controle.veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;
    private VeiculoRepository repository;

    VeiculoController(VeiculoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll() {
        List<Veiculo> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

@PostMapping(path = "/cadastro", consumes = "application/json", produces = "application/json")
public ResponseEntity<Veiculo> adicionaVeiculo(@RequestBody Veiculo novoVeiculo) {
    return ResponseEntity.ok(repository.save(novoVeiculo));
}

}
