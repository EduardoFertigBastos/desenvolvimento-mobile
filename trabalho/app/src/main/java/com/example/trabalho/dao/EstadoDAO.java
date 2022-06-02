package com.example.trabalho.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.trabalho.model.Estado;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO extends SQLiteOpenHelper {
    private static final int VERSAO = 1;
    private static final String TABELA = "estados";
    private static final String DATABASE = "CadastroBSN";
    private static final String[] COLUNAS = { "id", "descricao", "sigla", "pais_id" };

    public EstadoDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //comando DDL para criação da tabela SQLite
        String ddl = "CREATE TABLE " + TABELA + " (id INTEGER PRIMARY KEY, "
                + " descricao TEXT UNIQUE NOT NULL, sigla TEXT UNIQUE NOT NULL, pais_id INTEGER NOT NULL," +
                "FOREIGN KEY(pais_id) REFERENCES paises(id));";

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
    public void insere(Estado estado) {
        ContentValues values = new ContentValues();

        values.put("descricao", estado.getDescricao());
        values.put("sigla", estado.getSigla());
        values.put("pais_id", estado.getPais());

        getWritableDatabase().insert(TABELA, null, values);
    }

    public List<Estado> getLista() {

        //ArraList criado para o retorno dos dados
        List<Estado> estados = new ArrayList<Estado>();

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
            Estado estado = new Estado();

            estado.setId(c.getLong(0));
            estado.setDescricao(c.getString(1));
            estado.setSigla(c.getString(2));
            estado.setPais(c.getLong(3));

            estados.add(estado);
        }

        c.close();

        return estados;
    }

    public void deletar(Estado estado) {
        String[] args = {estado.getId().toString()};
        getWritableDatabase().delete(TABELA, "id=?", args);
    }

    public void altera(Estado estado) {

        //Para realizar a alteraçãoao dos dados na base de dados SQLite é necessário
        ContentValues values = new ContentValues();

        values.put("descricao", estado.getDescricao());
        values.put("sigla", estado.getSigla());
        values.put("pais_id", estado.getPais());

        String[] args = {estado.getId().toString()};
        getWritableDatabase().update(TABELA, values, "id=?", args );
    }

}
