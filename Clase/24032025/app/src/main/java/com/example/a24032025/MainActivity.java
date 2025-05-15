package com.example.a24032025;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import static com.example.a24032025.R.id.btnAgrega2;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

/*
public class MainActivity extends AppCompatActivity {

    Button btnAgrega;
    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        root = findViewById(R.id.lytMain);

        btnAgrega = findViewById(R.id.btnAgrega);

        btnAgrega.setOnClickListener(v -> {

            generaImagen();

        });

        //Inflado de vistas tomar un xml desde un java y agregamos el contenido

    }

    private void generaImagen() {

        LinearLayout lytItemPrueba = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);

        ImageView img = new ImageView(this);

        //Se genera la imagen
        img.setImageResource(R.mipmap.ic_launcher);
        img.setMinimumHeight(100);
        img.setMinimumWidth(MATCH_PARENT);
        //Se agrega la imagen al layout inflado
        lytItemPrueba.setGravity(Gravity.CENTER);
        lytItemPrueba.addView(img);

        //Se agrega el layout inflado a la vista root
        root.addView(lytItemPrueba);
         lytItemPrueba.setMinimumWidth(MATCH_PARENT);
         lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.orange, getTheme()));

    }
}

 */

public class MainActivity extends AppCompatActivity {

    Button btnAgrega;
    Button btnAgrega2;

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        root = findViewById(R.id.lytMain);

        btnAgrega = findViewById(R.id.btnAgrega);
        btnAgrega2 = findViewById(R.id.btnAgrega2);

        btnAgrega.setOnClickListener(v -> {

            generaBotonIzquierda();


        });


        btnAgrega2.setOnClickListener(v -> {

            generaBotonDerecha();


        });


        //Inflado de vistas tomar un xml desde un java y agregamos el contenido

    }

    private void generaBotonIzquierda() {


        LinearLayout lytItemPrueba = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);

        Button btn = new Button(this);

        btn.setMinHeight(100);
        btn.setMinWidth(MATCH_PARENT);
        btn.setText("1");

        lytItemPrueba.setGravity(Gravity.LEFT);
        lytItemPrueba.addView(btn);

        root.addView(lytItemPrueba);
        lytItemPrueba.setMinimumWidth(MATCH_PARENT);
        lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.orange, getTheme()));
    }

        //-------------------



    private void generaBotonDerecha() {

        LinearLayout lytItemPrueba = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);

        Button btn2 = new Button(this);

        btn2.setMinHeight(100);
        btn2.setMinWidth(MATCH_PARENT);
        btn2.setText("1");

        lytItemPrueba.setGravity(Gravity.RIGHT);
        lytItemPrueba.addView(btn2);

        root.addView(lytItemPrueba);
        lytItemPrueba.setMinimumWidth(MATCH_PARENT);
        lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.blue, getTheme()));
    }

        /*
        ImageView img = new ImageView(this);

        //Se genera la imagen
        img.setImageResource(R.mipmap.ic_launcher);
        img.setMinimumHeight(100);
        img.setMinimumWidth(MATCH_PARENT);
        //Se agrega la imagen al layout inflado
        lytItemPrueba.setGravity(Gravity.CENTER);
        lytItemPrueba.addView(img);

        //Se agrega el layout inflado a la vista root
        root.addView(lytItemPrueba);
        lytItemPrueba.setMinimumWidth(MATCH_PARENT);
        lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.orange, getTheme()));

         */

    }

