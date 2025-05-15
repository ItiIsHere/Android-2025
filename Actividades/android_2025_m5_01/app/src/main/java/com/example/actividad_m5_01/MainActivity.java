package com.example.actividad_m5_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView tvFibonacciValue;
    private Button btnAdvance, btnRetrocede;

    private int currentIndex = 0;
    private final HashMap<Integer, Integer> memoizationMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFibonacciValue = findViewById(R.id.tvFibonacciValue);
        btnAdvance = findViewById(R.id.btnAdvance);
        btnRetrocede = findViewById(R.id.btnRetrocede);

        memoizationMap.put(0, 0);
        memoizationMap.put(1, 1);

        btnAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                int value = calculateFibonacci(currentIndex);
                tvFibonacciValue.setText(String.valueOf(value));
            }
        });

        btnRetrocede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) {
                    currentIndex--;
                    int value = calculateFibonacci(currentIndex);
                    tvFibonacciValue.setText(String.valueOf(value));
                }
            }
        });
    }

    private int calculateFibonacci(int n) {
        if (memoizationMap.containsKey(n)) {
            return memoizationMap.get(n);
        }

        int result = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        memoizationMap.put(n, result);
        return result;
    }
}
