package com.example.proyecto26022025;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

public class CalculadoraUI implements ICalculadoraUI, OnView.OnClickListener {

    CalculadoraOnResult calculadoraResult = null;
    ICalculadora logica;
    ICalculadoraMemoria memoria = new CalculadoraMemoria();
    Context context;
    TextView txvDisplay;

    Button btnPunto;
    Button btnSuma;
    Button btnResta;
    Button btnMultiplicacion;
    Button btnDivision;
    Button btnPorcentaje;
    Button btnMasMenos;
    Button btnIgual;
    Button btnClear;
    Button btnUno;
    Button btnDos;
    Button btnTres;
    Button btnCuatro;
    Button btnCinco;
    Button btnSeis;
    Button btnSiete;
    Button btnOcho;
    Button btnNueve;
    Button btnCero;

    public CalculadoraUI(Activity activity, ICalculadora logica){

        this.logica = logica;

        context = activity.getApplicationContext();
        btnCero = activity.findViewById(R.id.cero_button);
        btnUno = activity.findViewById(R.id.uno_button);
        btnDos = activity.findViewById(R.id.dos_button);
        btnTres = activity.findViewById(R.id.tres_button);
        btnCuatro = activity.findViewById(R.id.cuatro_button);
        btnCinco = activity.findViewById(R.id.cinco_button);
        btnSeis = activity.findViewById(R.id.seis_button);
        btnSiete = activity.findViewById(R.id.siete_button);
        btnOcho = activity.findViewById(R.id.ocho_button);
        btnNueve = activity.findViewById(R.id.nueve_button);
        btnIgual = activity.findViewById(R.id.igual_button);
        btnSuma = activity.findViewById(R.id.mas_button);
        btnResta = activity.findViewById(R.id.menos_button);
        btnMultiplicacion = activity.findViewById(R.id.por_button);
        btnDivision = activity.findViewById(R.id.entre_button);
        btnMasMenos = activity.findViewById(R.id.masmenos_button);
        btnPorcentaje = activity.findViewById(R.id.porciento_button);

        btnCero.setOnClickListener(v ->{

        }



        btnUno.setOnClickListener(this);
        btnDos.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnCuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);
        btnSiete.setOnClickListener(this);
        btnOcho.setOnClickListener(this);
        btnNueve.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnIgual.setOnClickListener(v -> {
            if (calculadoraResult != null){
                calculadoraResult.onResult((BigDecimal.TEN, new BigDecimal.TEN, Operacion.SUMA));

            }
        }
    });

    }

    @Override
    public void clearScreen() {
        txvDisplay.setText("");
        memoria.clear();
    }

    @Override
    public void showResult(String result) {
        txvDisplay.setText(result);
    }

    @Override
    public String addNumber(String numero) {

        txvDisplay.setText(numero);
        String newValue = memoria.concat(numero);
        txvDisplay.setText(newValue);
        return newValue;
    }

    @Override
    public void addOperation(Operacion operacion) {
        txvDisplay.setText(Operacion.conver(operacion));
        memoria.concat(operacion);
    }

    @Override
    public void onClick (View v){
        switch (v.getId()){

            case R.id.uno_button;
            add Number{

        }

    }

    public void setOnResult(CalculadoraOnResult result){

            this.calculadoraResult = result;
        }
}
