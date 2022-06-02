package com.example.trabalho.dao;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.trabalho.model.Pais;
public class PaisDAO extends SQLiteOpenHelper {
    private static final int VERSAO = 1;
    private static final String TABELA = "paises";
    private static final String DATABASE = "CadastroBSN";
    private static final String[] COLUNAS = { "id", "descricao", "sigla" };

    public PaisDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //comando DDL para criação da tabela SQLite
        String ddl = "CREATE TABLE " + TABELA + " (id INTEGER PRIMARY KEY, "
                + " descricao TEXT UNIQUE NOT NULL, sigla TEXT);";

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
    public void insere(Pais pais) {
        ContentValues values = new ContentValues();

        values.put("descricao", pais.getDescricao());
        values.put("sigla", pais.getSigla());

        getWritableDatabase().insert(TABELA, null, values);
    }

    public List<Pais> getLista() {

        //ArraList criado para o retorno dos dados
        List<Pais> paises = new ArrayList<Pais>();

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
            Pais pais = new Pais();

            pais.setId(c.getLong(0));
            pais.setDescricao(c.getString(1));
            pais.setSigla(c.getString(2));

            paises.add(pais);
        }

        c.close();

        return paises;
    }

    public void deletar(Pais pais) {
        String[] args = {pais.getId().toString()};
        getWritableDatabase().delete(TABELA, "id=?", args);
    }

    public void altera(Pais pais) {

        //Para realizar a alteraçãoao dos dados na base de dados SQLite é necessário
        ContentValues values = new ContentValues();

        values.put("descricao", pais.getDescricao());
        values.put("sigla", pais.getSigla());

        String[] args = {pais.getId().toString()};
        getWritableDatabase().update(TABELA, values, "id=?", args );
    }

}
