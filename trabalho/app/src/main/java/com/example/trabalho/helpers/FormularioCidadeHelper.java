package com.example.trabalho.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.trabalho.R;
import com.example.trabalho.model.Cidade;
import com.example.trabalho.activities.FormularioCidadesActivity;

public class FormularioCidadeHelper {
    private EditText descricao;
    private EditText estado_id;
    private Cidade registro;

    public FormularioCidadeHelper(FormularioCidadesActivity activity) {

        descricao = (EditText) activity.findViewById(R.id.descricao);
        estado_id = (EditText) activity.findViewById(R.id.estado_id);

        registro = new Cidade();
    }

    public Cidade pegaDoFormulario() {

        registro.setDescricao(descricao.getEditableText().toString());
        registro.setEstado_id(Long.valueOf(estado_id.getEditableText().toString()));

        return registro;
    }

    public void colocaNoFormulario(Cidade pRegistro) {
        this.registro = pRegistro;

        descricao.setText(pRegistro.getDescricao());
        estado_id.setText(pRegistro.getEstado_id().toString());

    }


}

