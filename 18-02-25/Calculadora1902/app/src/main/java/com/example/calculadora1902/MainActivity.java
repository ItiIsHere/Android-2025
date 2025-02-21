package com.example.calculadora1902;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txvMiTexto;
    private Button btnReinicio;
    private Fibonoacci fibonoacci;

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

        Log.i("CicloVida", "onCreate");

        txvMiTexto = findViewById(R.id.txv_main);
        btnReinicio = findViewById(R.id.btn_reinicio);

        btnReinicio.setOnClickListener(this);

        fibonoacci = new Fibonoacci();

        txvMiTexto.setText(fibonoacci.getNumero1().toString());
    }

    @Override
    public void onClick(View v) {
        BigInteger resultado = fibonoacci.calcularSiguiente();
        txvMiTexto.setText(resultado.toString());
    }
}


    /*
    @Override
    protected void onStart() {
        super.onStart();
        Log.println(Log.INFO, null, "onStart");
        cadena += " onStart()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.println(Log.INFO, null, "onPause");
        cadena += " onPause()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.println(Log.INFO, null, "onStop");
        cadena += " onStop()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.println(Log.INFO, null, "onDestroy");
        cadena += " onDestroy()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.println(Log.INFO, null, "onRestart");
        cadena += " onRestart()";
        txvMiTexto.setText(cadena);
    }

}

*/
