package com.example.lab6.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab6.R;
import com.example.lab6.classes.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private List<Produit> produits;
    private LayoutInflater inflater;

    public PizzaAdapter(Activity activity, List<Produit> produits) {
        this.produits = produits;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        if (convertView == null)
            convertView = inflater.inflate(R.layout.row_pizza, null);

        ImageView photo = convertView.findViewById(R.id.img_pizza);
        TextView nom = convertView.findViewById(R.id.nom_pizza);
        TextView duree = convertView.findViewById(R.id.duree_pizza);
        TextView nbrIngredients = convertView.findViewById(R.id.nbr_ingredients);

        Produit p = produits.get(position);
        photo.setImageResource(p.getPhoto());
        nom.setText(p.getNom());
        duree.setText(p.getDuree());
        nbrIngredients.setText(p.getNbrIngredients() + " ingrédients");

        return convertView;
    }
}
