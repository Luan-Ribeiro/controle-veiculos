package com.controle.veiculos.response;

import java.util.List;

public class VeiculoModelosResponse {
    private List<VeiculoResponse> anos;
    private List<VeiculoResponse> modelos;

    public List<VeiculoResponse> getAnos() {
        return anos;
    }

    public void setAnos(List<VeiculoResponse> anos) {
        this.anos = anos;
    }

    public List<VeiculoResponse> getModelos() {
        return modelos;
    }

    public void setModelos(List<VeiculoResponse> modelos) {
        this.modelos = modelos;
    }
}
