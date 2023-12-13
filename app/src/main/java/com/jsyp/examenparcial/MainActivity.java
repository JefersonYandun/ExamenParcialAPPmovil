package com.jsyp.examenparcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.jsyp.examenparcial.R;


public class MainActivity extends AppCompatActivity {

    private EditText txtCedula;

    private EditText txtNombreProp;
    private EditText txtPlaca;
    private EditText txtAnio;
    private EditText txtMarca;
    private EditText txtMultas;

    private EditText txtTipoVehiculo;

    private EditText txtColor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCedula = findViewById(R.id.txtCedula);
        txtNombreProp = findViewById(R.id.txtNombreProp);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtAnio = findViewById(R.id.txtAnioVehiculo);
        txtMarca = findViewById(R.id.txtMarca);
        txtColor = findViewById(R.id.txtColor);
        txtTipoVehiculo = findViewById(R.id.txtTipoVehiculo);
        txtMultas = findViewById(R.id.txtMultas);
        txtValor = findViewById(R.id.txtValor);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                procesarCalculos();
            }
        });
    }

    private void procesarCalculos() {
        String cedula = txtCedula.getText().toString();
        String nombreProp = txtNombreProp.getText().toString();
        String placa = txtPlaca.getText().toString();
        String anio = txtAnio.getText().toString();
        String marca = txtMarca.getText().toString();
        String color = txtColor.getText().toString();
        String tipoVehiculo = txtTipoVehiculo.getText().toString();
        String multas = txtMultas.getText().toString();
        String valorVehiculoStr = txtValor.getText().toString();

        if (valorVehiculoStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese el valor del vehículo", Toast.LENGTH_SHORT).show();
            return;
        }

        double valorVehiculo = Double.parseDouble(valorVehiculoStr);
        boolean tieneMultas = !multas.isEmpty();

        double importeRenovacion = calcularImporteRenovacion(cedula, placa);
        double multaContaminacion = calcularMultaContaminacion(Integer.parseInt(anio));
        double valorMatriculacion = calcularValorMatriculacion(marca, tipoVehiculo, valorVehiculo);
        double multaPorMultas = calcularMultaPorMultas(tieneMultas);

        double totalPagar = importeRenovacion + multaContaminacion + valorMatriculacion + multaPorMultas;

        Intent intent = new Intent(MainActivity.this, activity_resultados_vehiculo.class);
        intent.putExtra("NOMBRE_PROPIETARIO", nombreProp);
        intent.putExtra("IMPORTE_RENOVACION", importeRenovacion);
        intent.putExtra("MULTA_CONTAMINACION", multaContaminacion);
        intent.putExtra("VALOR_MATRICULACION", valorMatriculacion);
        intent.putExtra("MULTA_POR_MULTAS", multaPorMultas);
        intent.putExtra("TOTAL_PAGAR", totalPagar);
        startActivity(intent);
    }

    private double calcularImporteRenovacion(String cedula, String placa) {
        double sueldoBasico = 435.0;

        if (cedula.startsWith("1") && placa.contains("I")) {
            return sueldoBasico * 0.05;
        }
        return 0.0;
    }

    private double calcularMultaContaminacion(int anioFabricacion) {
        if (anioFabricacion < 2010) {
            double porcentajeContaminacion = (2010 - anioFabricacion) * 0.02;
            return porcentajeContaminacion;
        }
        return 0.0;
    }

    private double calcularValorMatriculacion(String marca, String tipoVehiculo, double valorVehiculo) {
        double porcentajeMatriculacion = 0.0;

        if (marca.equalsIgnoreCase("Toyota")) {
            if (tipoVehiculo.equalsIgnoreCase("Jeep")) {
                porcentajeMatriculacion = 0.08;
            } else if (tipoVehiculo.equalsIgnoreCase("Camioneta")) {
                porcentajeMatriculacion = 0.12;
            }
        } else if (marca.equalsIgnoreCase("Suzuki")) {
            if (tipoVehiculo.equalsIgnoreCase("Vitara")) {
                porcentajeMatriculacion = 0.10;
            } else if (tipoVehiculo.equalsIgnoreCase("Automóvil")) {
                porcentajeMatriculacion = 0.09;
            }
        }

        return valorVehiculo * porcentajeMatriculacion;
    }

    private double calcularMultaPorMultas(boolean tieneMultas) {
        double sueldoBasico = 435.0;

        if (tieneMultas) {
            return sueldoBasico * 0.25;
        }
        return 0.0;
    }
}
