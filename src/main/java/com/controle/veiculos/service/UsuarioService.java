package com.controle.veiculos.service;

import com.controle.veiculos.entities.Usuario;
import com.controle.veiculos.entities.Veiculo;
import com.controle.veiculos.exception.BusinessException;
import com.controle.veiculos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario createUsuario(Usuario usuario) throws BusinessException {
        try {
            return repository.save(usuario);
        } catch (Throwable e) {
            throw new BusinessException("Dados invalidos!Favor verificar");
        }
    }

    public Usuario findByAnoAndId(int id) throws BusinessException {
        try {
            Optional<Usuario> resultado = repository.findById((long) id);
            Optional<Usuario> resultadoCarrosRodizio = getFinalPlacaRodizio(resultado);
            List<Veiculo> veiculos = new ArrayList<>(resultadoCarrosRodizio.get().getVeiculos());
            resultado.get().setVeiculos(veiculos);
            return resultado.get();
        } catch (Throwable e) {
            throw new BusinessException("Dados não encontrados!");
        }
    }

    private Optional<Usuario> getFinalPlacaRodizio(Optional<Usuario> result) {
        LocalDate dia = LocalDate.now();
        Locale brasil = new Locale("pt", "BR");
        List<String> finalPlaca = new ArrayList<>();
        for (Veiculo veiculo : result.get().getVeiculos()) {
            if (((veiculo.getAno().endsWith("0")) || veiculo.getAno().endsWith("1"))) {
                veiculo.setDiaRodizio(DayOfWeek.MONDAY.getDisplayName(TextStyle.FULL, brasil));
                if (dia.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                    veiculo.setRodizio(true);
                } else {
                    veiculo.setRodizio(false);
                }
            } else if (veiculo.getAno().endsWith("2") || veiculo.getAno().endsWith("3")) {
                veiculo.setDiaRodizio(DayOfWeek.TUESDAY.getDisplayName(TextStyle.FULL, brasil));
                if (dia.getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
                    veiculo.setRodizio(true);
                } else {
                    veiculo.setRodizio(false);
                }
            } else if (veiculo.getAno().endsWith("4") || veiculo.getAno().endsWith("5")) {
                veiculo.setDiaRodizio(DayOfWeek.WEDNESDAY.getDisplayName(TextStyle.FULL, brasil));
                if (dia.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
                    veiculo.setRodizio(true);
                } else {
                    veiculo.setRodizio(false);
                }
            } else if (veiculo.getAno().endsWith("6") || veiculo.getAno().endsWith("7")) {
                veiculo.setDiaRodizio(DayOfWeek.THURSDAY.getDisplayName(TextStyle.FULL, brasil));
                if (dia.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
                    veiculo.setRodizio(true);
                } else {
                    veiculo.setRodizio(false);
                }
            } else if (veiculo.getAno().endsWith("8") || veiculo.getAno().endsWith("9")) {
                veiculo.setDiaRodizio(DayOfWeek.FRIDAY.getDisplayName(TextStyle.FULL, brasil));
                if (dia.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    veiculo.setRodizio(true);
                } else {
                    veiculo.setRodizio(false);
                }
            }
        }
        return result;
    }
}

