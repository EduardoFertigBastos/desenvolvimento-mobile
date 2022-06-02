package com.example.trabalho.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trabalho.R;
import com.example.trabalho.model.Estado;
import com.example.trabalho.model.Pais;

import java.util.List;

@SuppressLint("ViewHolder")
public class ListaEstadosAdapter extends BaseAdapter {
    private final List<Estado> estados;
    private final Activity activity;

    public ListaEstadosAdapter(Activity activity, List<Estado> estados) {
        this.activity = activity;
        this.estados = estados;
    }

    public long getItemId(int posicao) {
        return estados.get(posicao).getId();
    }

    public Object getItem(int posicao) {
        return estados.get(posicao);
    }

    public int getCount() {
        return estados.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item, null);

        if (position % 2 == 0) {
            view.setBackgroundColor(activity.getResources().
                    getColor(R.color.linha_par));
        }

        Estado estado = estados.get(position);

        TextView descricao = (TextView) view.findViewById(R.id.descricao);
        TextView sigla = (TextView) view.findViewById(R.id.sigla);
        TextView pais = (TextView) view.findViewById(R.id.pais_id);

        descricao.setText(estado.getDescricao());
        sigla.setText(estado.getSigla());
        pais.setText(estado.getPais().toString());

        return view;
    }
}

