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
import com.example.trabalho.model.Pais;

import java.util.List;

@SuppressLint("ViewHolder")
public class ListaPaisesAdapter extends BaseAdapter {
    private final List<Pais> paises;
    private final Activity activity;

    public ListaPaisesAdapter(Activity activity, List<Pais> paises) {
        this.activity = activity;
        this.paises = paises;
    }

    public long getItemId(int posicao) {
        return paises.get(posicao).getId();
    }

    public Object getItem(int posicao) {
        return paises.get(posicao);
    }

    public int getCount() {
        return paises.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item, null);

        if (position % 2 == 0) {
            view.setBackgroundColor(activity.getResources().
                    getColor(R.color.linha_par));
        }

        Pais pais = paises.get(position);

        TextView descricao = (TextView) view.findViewById(R.id.descricao);
        TextView sigla = (TextView) view.findViewById(R.id.sigla);

        descricao.setText(pais.getDescricao());
        sigla.setText(pais.getSigla());

        return view;
    }
}

