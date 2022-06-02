package com.example.trabalho.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import com.example.trabalho.R;
import com.example.trabalho.adapters.ListaEstadosAdapter;
import com.example.trabalho.dao.EstadoDAO;
import com.example.trabalho.model.Estado;

import java.util.List;

public class ListaEstadosActivity extends Activity {

    private ListView listaRegistros;

    protected Estado registroSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estado_activity_main);

        listaRegistros = (ListView) findViewById(R.id.lista_estados);
        registerForContextMenu(listaRegistros);
        listaRegistros.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long id) {

                Intent edicao = new Intent(ListaEstadosActivity.this,
                        FormularioActivity.class);

                Estado regSelecionado = (Estado) listaRegistros
                        .getItemAtPosition(position);

                edicao.putExtra("registroSelecionado", regSelecionado);
                startActivity(edicao);

            }
        });

        listaRegistros.setOnItemLongClickListener(new OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapter, View view,
                                           int posicao, long id) {

                registroSelecionado = (Estado) adapter.getItemAtPosition(posicao);

                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);

        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                deleta();
                carregaLista();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_novo:

                Intent intent = new Intent(ListaEstadosActivity.this,
                        FormularioActivity.class);

                startActivity(intent);

                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        this.carregaLista();
        super.onResume();
    }

    private void carregaLista() {

        List<Estado> lista;
        EstadoDAO dao = new EstadoDAO(this);
        lista = dao.getLista();
        dao.close();

        ListaEstadosAdapter adapter = new ListaEstadosAdapter(this, lista);

        listaRegistros.setAdapter(adapter);

        listaRegistros = (ListView) findViewById(R.id.lista_estados);
        listaRegistros.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void deleta() {
        EstadoDAO dao = new EstadoDAO(ListaEstadosActivity.this);
        dao.deletar(registroSelecionado);
        dao.close();

        carregaLista();
    }
}
