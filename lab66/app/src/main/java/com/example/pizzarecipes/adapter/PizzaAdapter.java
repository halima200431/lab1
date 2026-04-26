package com.example.pizzarecipes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private Context context;
    private List<Produit> produits;
    private LayoutInflater inflater;

    public PizzaAdapter(Context context, List<Produit> produits) {
        this.context = context;
        this.produits = produits;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produits.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_pizza, parent, false);
        }

        ImageView photo = convertView.findViewById(R.id.pizzaPhoto);
        TextView nom = convertView.findViewById(R.id.pizzaNom);
        TextView nbrIngredients = convertView.findViewById(R.id.pizzaNbrIngredients);
        TextView duree = convertView.findViewById(R.id.pizzaDuree);

        Produit p = produits.get(position);
        photo.setImageResource(p.getPhoto());
        nom.setText(p.getNom());
        nbrIngredients.setText(String.valueOf(p.getNbrIngredients()));
        duree.setText(p.getDuree());

        return convertView;
    }
}
