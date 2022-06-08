package com.example.trabalho.helpers;

import android.widget.EditText;

import com.example.trabalho.R;
import com.example.trabalho.activities.FormularioEstadosActivity;
import com.example.trabalho.model.Estado;

public class FormularioEstadoHelper {
    private EditText descricao;
    private EditText sigla;
    private EditText pais_id;
    private Estado registro;

    public FormularioEstadoHelper(FormularioEstadosActivity activity) {

        descricao = (EditText) activity.findViewById(R.id.descricao);
        sigla = (EditText) activity.findViewById(R.id.sigla);
        pais_id = (EditText) activity.findViewById(R.id.pais_id);

        registro = new Estado();
    }

    public Estado pegaDoFormulario() {

        registro.setDescricao(descricao.getEditableText().toString());
        registro.setSigla(sigla.getEditableText().toString());
        registro.setPais_id(Long.valueOf(pais_id.getText().toString()));

        return registro;
    }

    public void colocaNoFormulario(Estado pRegistro) {
        this.registro = pRegistro;

        descricao.setText(pRegistro.getDescricao());
        sigla.setText(pRegistro.getSigla());
        pais_id.setText(pRegistro.getPais_id().toString());
    }


}

