package com.example.trabalho.model;


import java.io.Serializable;

public class Estado implements Serializable {

    private Long id;
    private Long pais_id;
    private String descricao;
    private String sigla;

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getPais() {
        return this.pais_id;
    }
    public void setPais(String id) {
        this.pais_id = pais_id;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return this.sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
