package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nomInput, adresseInput, surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultBase, resultSupplement, resultTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomInput         = findViewById(R.id.input_nom);
        adresseInput     = findViewById(R.id.input_adresse);
        surfaceInput     = findViewById(R.id.input_surface);
        piecesInput      = findViewById(R.id.input_pieces);
        piscineCheckbox  = findViewById(R.id.checkbox_piscine);
        resultBase       = findViewById(R.id.result_base);
        resultSupplement = findViewById(R.id.result_supplement);
        resultTotal      = findViewById(R.id.result_total);

        Button btnCalcul = findViewById(R.id.button_calcul);
        btnCalcul.setOnClickListener(v -> calculer());
    }

    private void calculer() {
        double surface  = Double.parseDouble(surfaceInput.getText().toString());
        int pieces      = Integer.parseInt(piecesInput.getText().toString());
        boolean piscine = piscineCheckbox.isChecked();

        double impotBase  = surface * 2;
        double supplement = pieces * 50 + (piscine ? 100 : 0);
        double total      = impotBase + supplement;

        resultBase.setText("Impôt de base : " + impotBase);
        resultBase.setVisibility(View.VISIBLE);

        resultSupplement.setText("Impôt supplémentaire : " + supplement);
        resultSupplement.setVisibility(View.VISIBLE);

        resultTotal.setText("Impôt Total en dh : " + total);
        resultTotal.setVisibility(View.VISIBLE);
    }
}