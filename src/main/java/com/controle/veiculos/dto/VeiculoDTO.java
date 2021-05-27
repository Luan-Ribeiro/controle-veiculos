package com.controle.veiculos.dto;

import com.controle.veiculos.entities.Veiculo;

public class VeiculoDTO {
    private String marca;
    private String modelo;
    private String ano;
    private String valor;

    private UsuarioDTO usuario;

    public  VeiculoDTO(){
    }

    public VeiculoDTO(String marca, String modelo, String ano, String valor, UsuarioDTO usuario) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.usuario = usuario;
    }

    public VeiculoDTO(Veiculo entity){
        marca = entity.getMarca();
        modelo = entity.getModelo();
        ano = entity.getAno();
        valor = entity.getValor();
        usuario = new UsuarioDTO(entity.getUsuario());
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
}
