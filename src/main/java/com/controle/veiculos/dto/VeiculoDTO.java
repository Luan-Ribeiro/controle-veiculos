package com.controle.veiculos.dto;

import com.controle.veiculos.entities.Veiculo;

public class VeiculoDTO {
    private Long id;
    private String marca;
    private String modelo;
    private int ano;

    private UsuarioDTO usuario;

    public  VeiculoDTO(){
    }

    public VeiculoDTO(Long id, String marca, String modelo, int ano, UsuarioDTO usuario) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.usuario = usuario;
    }

    public VeiculoDTO(Veiculo entity){
        id = entity.getId();
        marca = entity.getMarca();
        modelo = entity.getModelo();
        ano = entity.getAno();
        usuario = new UsuarioDTO(entity.getUsuario());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
}
