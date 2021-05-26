package com.controle.veiculos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    private Long id;
    private String marca;
    private String modelo;
    private int ano;

//    @JsonBackReference
    @ManyToOne
    @JsonIgnoreProperties("usuario")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Veiculo(){
    }

    public Veiculo(Long id, String marca, String modelo, int ano, Usuario usuario) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}