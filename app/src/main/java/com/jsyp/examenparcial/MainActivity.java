package com.jsyp.examenparcial;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declara los EditText
    private EditText txtCedula, txtNombreProp, txtPlaca, txtAnio, txtMarca, txtColor, txtTipoVehiculo, txtMultas, txtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa los EditText
        txtCedula = findViewById(R.id.txtCedula);
        txtNombreProp = findViewById(R.id.txtNombreProp);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtAnio = findViewById(R.id.txtAnioVehiculo);
        txtMarca = findViewById(R.id.txtMarca);
        txtColor = findViewById(R.id.txtColor);
        txtTipoVehiculo = findViewById(R.id.txtTipoVehiculo);
        txtMultas = findViewById(R.id.txtMultas);
        txtValor = findViewById(R.id.txtValor);

        // Configura el evento clic del botón
        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Llama a la función para procesar los cálculos
                procesarCalculos();
            }
        });
    }

    private void procesarCalculos() {
        // Obtén datos de los EditText
        String cedula = txtCedula.getText().toString();
        String nombreProp = txtNombreProp.getText().toString();
        String placa = txtPlaca.getText().toString();
        String anio = txtAnio.getText().toString();
        String marca = txtMarca.getText().toString();
        String color = txtColor.getText().toString();
        String tipoVehiculo = txtTipoVehiculo.getText().toString();
        String multas = txtMultas.getText().toString();

        // Obtén el valor del vehículo ingresado por el usuario
        String valorVehiculoStr = txtValor.getText().toString();

        // Verifica si el campo de valor del vehículo no está vacío
        if (valorVehiculoStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese el valor del vehículo", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convierte el valor del vehículo a double
        double valorVehiculo = Double.parseDouble(valorVehiculoStr);

        // Resto del código...
        // (Añade el resto del código de cálculos después de esta sección)
    }


    // Resto del código...

}
