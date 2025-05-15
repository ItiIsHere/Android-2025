package com.example.actividad_m3_01;


import android.os.Bundle;
import android.util.Log;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


interface Calculadora {
    double suma(double a, double b);
    double resta(double a, double b);
    double multiplicacion(double a, double b);
    double division(double a, double b);
}


// Implementación de la interfaz
class CalculadoraBasica implements Calculadora {
    @Override
    public double suma(double a, double b) {
        return a + b;
    }


    @Override
    public double resta(double a, double b) {
        return a - b;
    }


    @Override
    public double multiplicacion(double a, double b) {
        return a * b;
    }


    @Override
    public double division(double a, double b) {
        if (b == 0) {
            Log.e("Calculadora", "Error: División entre cero.");
            return Double.NaN;
        }
        return a / b;
    }
}


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        CalculadoraBasica calculadora = new CalculadoraBasica();


        double num1 = 10; // Número 1
        double num2 = 5;  // Número 2


        Log.i("Calculadora", "Resultados:");
        Log.i("Calculadora", "Suma: " + calculadora.suma(num1, num2));
        Log.i("Calculadora", "Resta: " + calculadora.resta(num1, num2));
        Log.i("Calculadora", "Multiplicación: " + calculadora.multiplicacion(num1, num2));
        Log.i("Calculadora", "División: " + calculadora.division(num1, num2));
    }
}


