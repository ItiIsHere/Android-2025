package com.example.m1_02;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.example.m1_01.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Hello world! 0w0");

    }
}