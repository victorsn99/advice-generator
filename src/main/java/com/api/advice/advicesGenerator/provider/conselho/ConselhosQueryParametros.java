package com.api.advice.advicesGenerator.provider.conselho;

import java.util.List;

public class ConselhosQueryParametros {

    private Integer quantidadeResultados;

    private String parametroBusca;

    private List<ConselhosQuery> conselhos;

    public ConselhosQueryParametros() {
    }

    public Integer getQuantidadeResultados() {
        return quantidadeResultados;
    }

    public void setQuantidadeResultados(Integer quantidadeResultados) {
        this.quantidadeResultados = quantidadeResultados;
    }

    public String getParametroBusca() {
        return parametroBusca;
    }

    public void setParametroBusca(String parametroBusca) {
        this.parametroBusca = parametroBusca;
    }

    public List<ConselhosQuery> getConselhos() {
        return conselhos;
    }

    public void setConselhos(List<ConselhosQuery> conselhos) {
        this.conselhos = conselhos;
    }
}
