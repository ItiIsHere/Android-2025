package com.example.android_2025_m1_03;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int[] numeros = new int[1_000_000];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt();
        }

        long inicio = System.currentTimeMillis();

        Arrays.sort(numeros);

        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        Log.d(TAG, "Ordenamiento completado en " + duracion + " milisegundos.");
        Log.d(TAG, "Primer elemento: " + numeros[0]);
        Log.d(TAG, "Último elemento: " + numeros[numeros.length - 1]);
    }
}
