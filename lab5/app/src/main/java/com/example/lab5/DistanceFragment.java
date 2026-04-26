package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Fragment gérant l'interface de conversion des distances.
 * Ce composant est chargé dynamiquement par le ViewPager2.
 */
public class DistanceFragment extends Fragment {

    /**
     * Méthode d'initialisation de l'interface graphique du fragment.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater constructeurInterface, 
                             @Nullable ViewGroup conteneur, 
                             @Nullable Bundle etatSauvegarde) {
        // Liaison du code Java avec le fichier de mise en page XML
        return constructeurInterface.inflate(R.layout.fragment_distance, conteneur, false);
    }
}