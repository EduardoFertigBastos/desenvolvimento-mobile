package com.example.trabalho.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.trabalho.R;
import com.example.trabalho.dao.CidadeDAO;
import com.example.trabalho.helpers.FormularioCidadeHelper;
import com.example.trabalho.model.Cidade;

public class FormularioCidadesActivity extends Activity {

    private FormularioCidadeHelper helper;
    private String localArquivoFoto;
    private static final int TIRA_FOTO = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pais_activity_formulario);

        Intent intent = getIntent();
        final Cidade registroParaSerAlterado = (Cidade) intent.getSerializableExtra("estadoSelecionado");

        this.helper = new FormularioCidadeHelper(this);

        Button botao = (Button) findViewById(R.id.botao);

        if (registroParaSerAlterado != null) {
            botao.setText("Alterar");
            helper.colocaNoFormulario(registroParaSerAlterado);
        }

        botao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Cidade registro = helper.pegaDoFormulario();

                CidadeDAO dao = new CidadeDAO(FormularioCidadesActivity.this);

                if (registroParaSerAlterado == null) {
                    dao.insere(registro);
                } else {
                    registro.setId(registroParaSerAlterado.getId());
                    dao.altera(registro);
                }

                dao.close();

                finish();
            }
        });


    }
}

