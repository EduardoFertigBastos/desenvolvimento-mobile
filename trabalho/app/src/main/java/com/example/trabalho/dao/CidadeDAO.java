package com.example.trabalho.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.trabalho.model.Cidade;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO extends SQLiteOpenHelper {
    private static final int VERSAO = 1;
    private static final String TABELA = "cidades";
    private static final String DATABASE = "CadastroBSN";
    private static final String[] COLUNAS = { "id", "descricao", "estado_id" };

    public CidadeDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //comando DDL para criação da tabela SQLite
        String ddl = "CREATE TABLE " + TABELA + " (id INTEGER PRIMARY KEY, "
                + " descricao TEXT UNIQUE NOT NULL, estado_id INTEGER NOT NULL," +
                "FOREIGN KEY(estado_id) REFERENCES estados(id));";

        db.execSQL(ddl);
    }


    @Override
    //Esse método é executado automaticamente pelo sistema android, quando ele detectar que a versão do banco de dados mudou
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    //método utilizado para inserir um novo cadastro no banco de dados SQLite. Esse método irá receber uma instância do Modelo Aluno por parâmetro.
    public void insere(Cidade cidade) {
        ContentValues values = new ContentValues();

        values.put("descricao", cidade.getDescricao());
        values.put("estado_id", cidade.getEstado());

        getWritableDatabase().insert(TABELA, null, values);
    }

    public List<Cidade> getLista() {

        //ArraList criado para o retorno dos dados
        List<Cidade> cidades = new ArrayList<Cidade>();

        Cursor c = getWritableDatabase().query(
                TABELA,
                COLUNAS,
                null,
                null,
                null,
                null,
                null
        );

        //após abrir o cursor, deve-se percorrê-lo para popular o ArrayList que será retornado.
        while (c.moveToNext()) {
            Cidade cidade = new Cidade();

            cidade.setId(c.getLong(0));
            cidade.setDescricao(c.getString(1));
            cidade.setEstado(c.getLong(2));

            cidades.add(cidade);
        }

        c.close();

        return cidades;
    }

    public void deletar(Cidade cidade) {
        String[] args = {cidade.getId().toString()};
        getWritableDatabase().delete(TABELA, "id=?", args);
    }

    public void altera(Cidade cidade) {

        //Para realizar a alteraçãoao dos dados na base de dados SQLite é necessário
        ContentValues values = new ContentValues();

        values.put("descricao", cidade.getDescricao());
        values.put("estado_id", cidade.getEstado());

        String[] args = {cidade.getId().toString()};
        getWritableDatabase().update(TABELA, values, "id=?", args );
    }

}

