package com.example.trabalho.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
import com.example.trabalho.adapters.ListaPaisesAdapter;
import com.example.trabalho.dao.PaisDAO;
import com.example.trabalho.model.Pais;
import com.example.trabalho.extras.Extras;

import java.util.List;

public class ListaPaisesActivity extends Activity {

    private ListView listaRegistros;

    protected Pais registroSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pais_activity_main);

        listaRegistros = (ListView) findViewById(R.id.lista_paises);
        registerForContextMenu(listaRegistros);
        listaRegistros.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long id) {

                Intent edicao = new Intent(ListaPaisesActivity.this,
                        FormularioPaisesActivity.class);

                Pais regSelecionado = (Pais) listaRegistros
                        .getItemAtPosition(position);

                edicao.putExtra("registroSelecionado", regSelecionado);
                startActivity(edicao);

            }
        });

        listaRegistros.setOnItemLongClickListener(new OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapter, View view,
                                           int posicao, long id) {

                registroSelecionado = (Pais) adapter.getItemAtPosition(posicao);

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

                Intent intent = new Intent(ListaPaisesActivity.this,
                        FormularioPaisesActivity.class);

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

        List<Pais> lista;
        PaisDAO dao = new PaisDAO(this);
        lista = dao.getLista();
        dao.close();

        ListaPaisesAdapter adapter = new ListaPaisesAdapter(this, lista);

        listaRegistros.setAdapter(adapter);

        listaRegistros = (ListView) findViewById(R.id.lista_paises);
        listaRegistros.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public void deleta() {
        PaisDAO dao = new PaisDAO(ListaPaisesActivity.this);
        dao.deletar(registroSelecionado);
        dao.close();

        carregaLista();
    }
}
