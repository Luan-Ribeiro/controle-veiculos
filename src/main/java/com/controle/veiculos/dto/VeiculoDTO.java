package com.controle.veiculos.dto;

import com.controle.veiculos.entities.Veiculo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = "usuario")
public class VeiculoDTO {
    private String marca;
    private String modelo;
    private String ano;
    private String valor;
    private String diaRodizio;
    private Boolean rodizio;

    private Long usuario_id;

    public VeiculoDTO() {
    }

    public VeiculoDTO(String marca, String modelo, String ano, String valor, String diaRodizio, Boolean rodizio, Long usuario_id) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.diaRodizio = diaRodizio;
        this.rodizio = rodizio;
        this.usuario_id = usuario_id;
    }

    public VeiculoDTO(Veiculo entity) {
        marca = entity.getMarca();
        modelo = entity.getModelo();
        ano = entity.getAno();
        valor = entity.getValor();
        rodizio = entity.getRodizio();
        usuario_id = entity.getUsuario().getId();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDiaRodizio() { return diaRodizio; }

    public void setDiaRodizio(String diaRodizio) { this.diaRodizio = diaRodizio; }

    public Boolean getRodizio() {
        return rodizio;
    }

    public void setRodizio(Boolean rodizio) {
        this.rodizio = rodizio;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
}
