package com.controle.veiculos.controller;

import com.controle.veiculos.dto.VeiculoDTO;
import com.controle.veiculos.entities.Veiculo;
import com.controle.veiculos.exception.BusinessException;
import com.controle.veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @PostMapping(path = "/cadastro", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Veiculo> adicionaVeiculo(@RequestBody VeiculoDTO novoVeiculo) throws BusinessException {
        return new ResponseEntity<Veiculo>(service.createVeiculo(novoVeiculo), HttpStatus.CREATED);
    }
}
