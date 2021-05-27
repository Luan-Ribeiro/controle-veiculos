package com.controle.veiculos.service;

import com.controle.veiculos.client.TabelaFipeClient;
import com.controle.veiculos.dto.VeiculoDTO;
import com.controle.veiculos.entities.Veiculo;
import com.controle.veiculos.repositories.VeiculoRepository;
import com.controle.veiculos.response.VeiculoModelosResponse;
import com.controle.veiculos.response.VeiculoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository repository;

    @Autowired
    TabelaFipeClient tabelaFipeClient;

    public List<Veiculo> getVeiculos(){
        return repository.findAll();
    }

    public Veiculo createVeiculo(VeiculoDTO novoVeiculo) {
        HashMap<String,String> dadosVeiculo = capturaDadosFipe(novoVeiculo);
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(dadosVeiculo.get("Marca"));
        veiculo.setModelo(dadosVeiculo.get("Modelo"));
        veiculo.setAno(dadosVeiculo.get("AnoModelo"));
        veiculo.setValor(dadosVeiculo.get("Valor"));
        repository.save(veiculo);
        return veiculo;
    }

    public HashMap<String, String> capturaDadosFipe(VeiculoDTO novoVeiculo){
        List<VeiculoResponse> marcas = tabelaFipeClient.getMarcas();
        if (novoVeiculo.getMarca().equalsIgnoreCase("volkswagen")) {
            novoVeiculo.setMarca("VW - VolksWagen");
        }else if(novoVeiculo.getMarca().equalsIgnoreCase("chevrolet")){
            novoVeiculo.setMarca("GM - Chevrolet");
        }
        Optional<VeiculoResponse> marca = marcas.stream().filter(ma -> ma.getNome().equalsIgnoreCase(novoVeiculo.getMarca())).findFirst();
        if (marca.isPresent()) {
            VeiculoModelosResponse modelos = tabelaFipeClient.getModelos(marca.get().getCodigo());
            Optional<VeiculoResponse> modelo = modelos.getModelos().stream().filter(mo -> mo.getNome().startsWith(novoVeiculo.getModelo())).findFirst();
            if (modelo.isPresent()) {
                List<VeiculoResponse> anos = tabelaFipeClient.getAnos(marca.get().getCodigo(),modelo.get().getCodigo());
                Optional<VeiculoResponse> ano = anos.stream().filter(a -> a.getNome().equalsIgnoreCase(novoVeiculo.getAno())).findFirst();
                if (ano.isPresent()){
                    HashMap<String,String> valor = tabelaFipeClient.getValor(marca.get().getCodigo(),modelo.get().getCodigo(),ano.get().getCodigo());
                    return valor;
                }
            }
        }
        return null;
    }
}

