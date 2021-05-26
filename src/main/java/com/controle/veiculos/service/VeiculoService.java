package com.controle.veiculos.service;

import com.controle.veiculos.entities.Veiculo;
import com.controle.veiculos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "veiculoService", url = "https://parallelum.com.br/fipe/api/v1/carros/marcas")
public interface VeiculoService {

  @GetMapping()
  Veiculo getMarcas();

//    @Transactional(readOnly = true)
//    public void createUser(Usuario novoUsuario) {
//        repository.save(novoUsuario);
//    }
////
//    @Transactional(readOnly = true)
//    public List<SaleSucessDTO> sucessGroupedBySeller() {
//        return repository.sucessGroupedBySeller();
//    }
}

