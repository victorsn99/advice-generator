package com.api.advice.advicesGenerator.provider.conselho;

import jakarta.persistence.Column;

public class ConselhosQuery {

    private Long id;

    private String conselho;

    private String dataCadastro;

    public ConselhosQuery(Long id, String conselho, String dataCadastro) {
        this.id = id;
        this.conselho = conselho;
        this.dataCadastro = dataCadastro;
    }

    public ConselhosQuery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConselho() {
        return conselho;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
