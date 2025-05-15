package com.example.gato;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LogicaJuego logicaJuego;
    private ImageView[] celdasTablero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logicaJuego = new LogicaJuego();
        celdasTablero = new ImageView[9];

        int[] idsCeldas = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9};

        for (int i = 0; i < celdasTablero.length; i++) {
            final int indice = i;
            celdasTablero[i] = findViewById(idsCeldas[i]);
            celdasTablero[i].setOnClickListener(v -> manejarClicCelda(indice));
        }
    }

    private void manejarClicCelda(int indice) {
        if (logicaJuego.realizarMovimiento(indice)) {
            celdasTablero[indice].setImageResource(logicaJuego.obtenerJugadorActual() == 'X' ? R.drawable.img_cross : R.drawable.img_circle);
            if (logicaJuego.verificarVictoria()) {
                Toast.makeText(this, "El ganador es: " + logicaJuego.obtenerJugadorActual(), Toast.LENGTH_LONG).show();
                reiniciarJuego();
            } else if (logicaJuego.estaTableroLleno()) {
                Toast.makeText(this, "Empate!", Toast.LENGTH_LONG).show();
                reiniciarJuego();
            } else {
                logicaJuego.cambiarJugador();
            }
        }
    }

    private void reiniciarJuego() {
        logicaJuego.reiniciar();
        for (ImageView celda : celdasTablero) {
            celda.setImageResource(0);
        }
    }
}