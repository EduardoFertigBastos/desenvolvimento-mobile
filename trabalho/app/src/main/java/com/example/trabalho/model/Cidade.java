package com.example.trabalho.model;


import android.text.Editable;

import java.io.Serializable;

public class Cidade implements Serializable {

    private Long id;
    private Long estado_id;
    private String descricao;

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getEstado() {
        return this.estado_id;
    }
    public void setEstado(Editable id) {
        this.estado_id = estado_id;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}