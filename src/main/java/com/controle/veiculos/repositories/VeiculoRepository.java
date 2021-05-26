package com.controle.veiculos.repositories;

import com.controle.veiculos.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
