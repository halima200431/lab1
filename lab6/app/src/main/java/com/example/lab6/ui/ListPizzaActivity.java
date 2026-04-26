package com.example.lab6.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.lab6.R;
import com.example.lab6.adapter.PizzaAdapter;
import com.example.lab6.classes.Produit;
import com.example.lab6.service.ProduitService;

public class ListPizzaActivity extends AppCompatActivity {
    private ListView listView;
    private ProduitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Nos Pizzas");
        }

        service = ProduitService.getInstance();
        // Ajout de quelques données de test si la liste est vide
        if (service.findAll().isEmpty()) {
            service.create(new Produit(1, "Margherita", 5, R.mipmap.ic_launcher, "15 min", "Sauce tomate, Mozzarella, Basilic", "Une pizza classique", "1. Préparer la pâte..."));
            service.create(new Produit(2, "4 Saisons", 8, R.mipmap.ic_launcher, "20 min", "Jambon, Champignons, Artichauts", "La pizza variée", "1. Étaler la sauce..."));
            service.create(new Produit(3, "Végétarienne", 7, R.mipmap.ic_launcher, "25 min", "Poivrons, Oignons, Olives", "Saine et délicieuse", "1. Couper les légumes..."));
        }

        listView = findViewById(R.id.list_pizza);
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
