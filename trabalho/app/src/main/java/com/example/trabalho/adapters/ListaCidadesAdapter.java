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
import com.example.trabalho.model.Cidade;
import com.example.trabalho.model.Pais;

import java.util.List;

@SuppressLint("ViewHolder")
public class ListaCidadesAdapter extends BaseAdapter {
    private final List<Cidade> cidades;
    private final Activity activity;

    public ListaCidadesAdapter(Activity activity, List<Cidade> cidades) {
        this.activity = activity;
        this.cidades = cidades;
    }

    public long getItemId(int posicao) {
        return cidades.get(posicao).getId();
    }

    public Object getItem(int posicao) {
        return cidades.get(posicao);
    }

    public int getCount() {
        return cidades.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item, null);

        if (position % 2 == 0) {
            view.setBackgroundColor(activity.getResources().
                    getColor(R.color.linha_par));
        }

        Cidade cidade = cidades.get(position);

        TextView descricao = (TextView) view.findViewById(R.id.descricao);
        TextView estado = (TextView) view.findViewById(R.id.estado_id);

        descricao.setText(cidade.getDescricao());
        estado.setText(cidade.getEstado_id().toString());

        return view;
    }
}

