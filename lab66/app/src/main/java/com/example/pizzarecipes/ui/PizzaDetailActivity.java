package com.example.pizzarecipes.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        int id = getIntent().getIntExtra("id", -1);
        Produit p = ProduitService.getInstance().findById(id);

        if (p != null) {
            ImageView photo = findViewById(R.id.detailPhoto);
            TextView nom = findViewById(R.id.detailNom);
            TextView description = findViewById(R.id.detailDescription);
            TextView ingredients = findViewById(R.id.detailIngredients);
            TextView preparation = findViewById(R.id.detailPreparation);

            photo.setImageResource(p.getPhoto());
            nom.setText(p.getNom());
            description.setText(p.getDescription());
            ingredients.setText(p.getDetailsIngred());
            preparation.setText(p.getPreparation());
        }
    }
}
