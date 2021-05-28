package com.controle.veiculos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String ano;
    private String valor;
    private String diaRodizio;
    private Boolean rodizio;

    @JsonBackReference
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "id"
    )
    @ManyToOne
    private Usuario usuario;

    public Veiculo() {
    }

    public Veiculo(Long id, String marca, String modelo, String ano, String valor, String diaRodizio, Boolean rodizio, Usuario usuario) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.diaRodizio = diaRodizio;
        this.rodizio = rodizio;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }

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

    public String getValor() { return valor; }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDiaRodizio() { return diaRodizio; }

    public void setDiaRodizio(String diaRodizio) { this.diaRodizio = diaRodizio; }

    public Boolean getRodizio() { return rodizio; }

    public void setRodizio(Boolean rodizio) {
        this.rodizio = rodizio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}