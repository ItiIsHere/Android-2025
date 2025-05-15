package com.example.actividad_m4_01;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLifecycle";

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

        Log.i(TAG, "onCreate: La actividad ha sido creada.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: La actividad está a punto de hacerse visible.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: La actividad está interactuando con el usuario.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: La actividad está a punto de ser pausada.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: La actividad ya no es visible.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: La actividad está siendo reiniciada.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: La actividad está siendo destruida.");
    }
}
