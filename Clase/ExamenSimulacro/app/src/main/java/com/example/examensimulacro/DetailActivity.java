package com.example.examensimulacro;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examensimulacro.R;

public class DetailActivity extends AppCompatActivity {

    TextView textViewNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        textViewNombre = findViewById(R.id.textViewNombre);

        String nombre = getIntent().getStringExtra("nombre");
        textViewNombre.setText(nombre);
    }
}