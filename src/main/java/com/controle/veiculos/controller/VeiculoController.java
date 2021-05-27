package com.controle.veiculos.controller;

import com.controle.veiculos.dto.VeiculoDTO;
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

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll() {
        List<Veiculo> list = service.getVeiculos();
        return ResponseEntity.ok(list);
    }

    @PostMapping(path = "/cadastro", consumes = "application/json", produces = "application/json")
    public Veiculo adicionaVeiculo(@RequestBody VeiculoDTO novoVeiculo) {
        Veiculo response = service.createVeiculo(novoVeiculo);
        return response;
    }

}
