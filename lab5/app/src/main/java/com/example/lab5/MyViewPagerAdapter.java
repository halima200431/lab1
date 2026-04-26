package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Adaptateur personnalisé pour gérer le cycle de vie et l'affichage des fragments
 * à l'intérieur du ViewPager2.
 */
public class MyViewPagerAdapter extends FragmentStateAdapter {

    // Constructeur recevant l'activité parente
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**
     * Méthode responsable de l'instanciation des fragments selon la position.
     * @param index Position de l'onglet sélectionné
     * @return Une nouvelle instance du fragment correspondant
     */
    @NonNull
    @Override
    public Fragment createFragment(int index) {
        // Logique de sélection du fragment à afficher
        switch (index) {
            case 1:
                return new DistanceFragment();
            case 0:
            default:
                return new TempFragment();
        }
    }

    /**
     * Définit le nombre total d'onglets à afficher.
     * @return Nombre de pages
     */
    @Override
    public int getItemCount() {
        return 2; // Nous avons deux onglets : Température et Distance
    }
}