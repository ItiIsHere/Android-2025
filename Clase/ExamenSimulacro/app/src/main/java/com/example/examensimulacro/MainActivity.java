package com.example.examensimulacro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examensimulacro.R;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] nombres = {"Juan", "Ana", "Carlos", "María"};
    String[] telefonos = {"123456789", "987654321", "456123789", "321654987"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, nombres);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombreSeleccionado = nombres[position];
                Intent intent = new Intent(MainActivity.this, com.example.examensimulacro.DetailActivity.class);
                intent.putExtra("nombre", nombreSeleccionado);
                startActivity(intent);
            }
        });
    }
}
