package com.example.lab6.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab6.R;
import com.example.lab6.classes.Produit;
import com.example.lab6.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {
    private ProduitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        service = ProduitService.getInstance();
        int id = getIntent().getIntExtra("id", -1);
        Produit p = service.findById(id);

        if (p != null) {
            ImageView img = findViewById(R.id.img_detail);
            TextView nom = findViewById(R.id.nom_detail);
            TextView desc = findViewById(R.id.desc_detail);
            TextView ingred = findViewById(R.id.ingred_detail);
            TextView prep = findViewById(R.id.prep_detail);

            img.setImageResource(p.getPhoto());
            nom.setText(p.getNom());
            desc.setText(p.getDescription());
            ingred.setText(p.getDetailsIngred());
            prep.setText(p.getPreparation());
        }
    }
}
