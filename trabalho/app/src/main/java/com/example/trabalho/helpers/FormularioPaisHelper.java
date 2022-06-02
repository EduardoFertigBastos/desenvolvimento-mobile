package com.example.trabalho.helpers;

import android.widget.EditText;

import com.example.trabalho.R;
import com.example.trabalho.activities.FormularioPaisesActivity;
import com.example.trabalho.model.Pais;

public class FormularioPaisHelper {
    private EditText descricao;
    private EditText sigla;
    private Pais registro;

    public FormularioPaisHelper(FormularioPaisesActivity activity) {

        descricao = (EditText) activity.findViewById(R.id.descricao);
        sigla = (EditText) activity.findViewById(R.id.sigla);

        registro = new Pais();
    }

    public Pais pegaDoFormulario() {

        registro.setDescricao(descricao.getEditableText().toString());
        registro.setSigla(sigla.getEditableText().toString());

        return registro;
    }

    public void colocaNoFormulario(Pais pRegistro) {
        this.registro = pRegistro;

        descricao.setText(pRegistro.getDescricao());
        sigla.setText(pRegistro.getSigla());
    }


}

