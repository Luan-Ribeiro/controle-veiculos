package com.controle.veiculos.service;

import com.controle.veiculos.client.TabelaFipeClient;
import com.controle.veiculos.dto.VeiculoDTO;
import com.controle.veiculos.entities.Usuario;
import com.controle.veiculos.entities.Veiculo;
import com.controle.veiculos.exception.BusinessException;
import com.controle.veiculos.repositories.VeiculoRepository;
import com.controle.veiculos.response.VeiculoModelosResponse;
import com.controle.veiculos.response.VeiculoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Veiculo createVeiculo(VeiculoDTO novoVeiculo) throws BusinessException {
        try {
            HashMap<String, String> dadosVeiculo = capturaDadosFipe(novoVeiculo);
            Veiculo veiculo = new Veiculo();
            Usuario usuario = new Usuario();
            usuario.setId(novoVeiculo.getUsuario_id());
            veiculo.setMarca(dadosVeiculo.get("Marca"));
            veiculo.setModelo(dadosVeiculo.get("Modelo"));
            veiculo.setAno(dadosVeiculo.get("AnoModelo"));
            veiculo.setValor(dadosVeiculo.get("Valor"));
            veiculo.setUsuario(usuario);
            try {
                repository.save(veiculo);
            } catch (DataIntegrityViolationException ex) {
                throw new DataIntegrityViolationException("Usuário não encontrado!");
            }
            return veiculo;
        } catch (NullPointerException e) {
            throw new BusinessException("Dados do Veiculo invalidos! Favor Verificar");
        }
    }

    public HashMap<String, String> capturaDadosFipe(VeiculoDTO novoVeiculo) {
        List<VeiculoResponse> marcas = tabelaFipeClient.getMarcas();
        if (novoVeiculo.getMarca().equalsIgnoreCase("volkswagen")) {
            novoVeiculo.setMarca("VW - VolksWagen");
        } else if (novoVeiculo.getMarca().equalsIgnoreCase("chevrolet")) {
            novoVeiculo.setMarca("GM - Chevrolet");
        }
        Optional<VeiculoResponse> marca = marcas.stream().filter(ma -> ma.getNome().equalsIgnoreCase(novoVeiculo.getMarca())).findFirst();
        if (marca.isPresent()) {
            VeiculoModelosResponse modelos = tabelaFipeClient.getModelos(marca.get().getCodigo());
            Optional<VeiculoResponse> modelo = modelos.getModelos().stream().filter(mo -> mo.getNome().startsWith(novoVeiculo.getModelo())).findFirst();
            if (modelo.isPresent()) {
                List<VeiculoResponse> anos = tabelaFipeClient.getAnos(marca.get().getCodigo(), modelo.get().getCodigo());
                Optional<VeiculoResponse> ano = anos.stream().filter(a -> a.getNome().equalsIgnoreCase(novoVeiculo.getAno())).findFirst();
                if (ano.isPresent()) {
                    HashMap<String, String> veiculo = tabelaFipeClient.getValor(marca.get().getCodigo(), modelo.get().getCodigo(), ano.get().getCodigo());
                    return veiculo;
                }
            }
        }
        return null;
    }
}

