package com.example.lab5;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * Composant principal de l'application qui orchestre l'affichage 
 * des différents convertisseurs via un système d'onglets.
 */
public class MainActivity extends AppCompatActivity {

    private TabLayout gestionnaireOnglets;
    private ViewPager2 visionneusePages;
    private MyViewPagerAdapter adaptateurContenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Chargement de l'interface graphique définie dans XML
        setContentView(R.layout.activity_main);

        // Initialisation des références vers les vues du layout
        gestionnaireOnglets = findViewById(R.id.tabLayout);
        visionneusePages = findViewById(R.id.viewPager);

        // Mise en place de l'adaptateur qui fournira les fragments au ViewPager
        adaptateurContenu = new MyViewPagerAdapter(this);
        visionneusePages.setAdapter(adaptateurContenu);

        // Configuration de la médiation entre les onglets et le ViewPager
        new TabLayoutMediator(gestionnaireOnglets, visionneusePages,
                (onglet, position) -> {
                    // Attribution dynamique du titre selon l'index de la page
                    if (position == 0) {
                        onglet.setText("Température");
                    } else {
                        onglet.setText("Distance");
                    }
                }
        ).attach();
    }

    /**
     * Surcharge de la méthode de retour arrière pour ajouter une
     * boîte de dialogue de confirmation avant de quitter.
     */
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Confirmation de sortie")
                .setMessage("Souhaitez-vous réellement fermer l'application ?")
                .setPositiveButton("Oui", (dialogue, action) -> finish())
                .setNegativeButton("Annuler", null)
                .show();
    }
}