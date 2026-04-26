package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Fragment dédié à la conversion des unités de température.
 */
public class TempFragment extends Fragment {

    /**
     * Crée et configure la vue associée à ce fragment.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater generalInflater, 
                             @Nullable ViewGroup parentContainer, 
                             @Nullable Bundle savedState) {
        // Chargement du layout spécifique pour la température
        return generalInflater.inflate(R.layout.fragment_temp, parentContainer, false);
    }
}