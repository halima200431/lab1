package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.adapter.PizzaAdapter;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

public class ListPizzaActivity extends AppCompatActivity {
    private ListView listView;
    private ProduitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        service = ProduitService.getInstance();
        // Optionnel : Ajouter des données de test si la liste est vide
        if(service.findAll().isEmpty()){
             service.create(new Produit(1, "Margherita", 3, R.mipmap.ic_launcher, "15 min", "Tomate, Mozzarella, Basilic", "Classique italienne", "1. Etaler la pâte..."));
             service.create(new Produit(2, "Neapolitana", 4, R.mipmap.ic_launcher, "20 min", "Tomate, Anchois, Olives", "Goût prononcé", "1. Préparer les anchois..."));
        }

        listView = findViewById(R.id.listView);
        PizzaAdapter adapter = new PizzaAdapter(this, service.findAll());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produit p = (Produit) parent.getItemAtPosition(position);
                Intent intent = new Intent(ListPizzaActivity.this, PizzaDetailActivity.class);
                intent.putExtra("id", p.getId());
                startActivity(intent);
            }
        });
    }
}
