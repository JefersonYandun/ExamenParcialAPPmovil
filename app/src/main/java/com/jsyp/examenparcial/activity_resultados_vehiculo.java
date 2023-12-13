package com.jsyp.examenparcial;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class activity_resultados_vehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_vehiculo);

        Intent intent = getIntent();
        String nombrePropietario = intent.getStringExtra("NOMBRE_PROPIETARIO");
        double importeRenovacion = intent.getDoubleExtra("IMPORTE_RENOVACION", 0.0);

        // Usa los datos como sea necesario y actualiza los TextViews
        TextView lblNombreResult = findViewById(R.id.lblNombreResult);
        lblNombreResult.setText(nombrePropietario);

        TextView lblRenovacionPlacas = findViewById(R.id.lblRenovacionPlacas);
        lblRenovacionPlacas.setText(String.valueOf(importeRenovacion));

        // Actualiza otros TextViews según sea necesario
        // ...
    }
}
