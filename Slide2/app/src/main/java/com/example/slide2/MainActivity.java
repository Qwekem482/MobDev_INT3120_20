package com.example.slide2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.NumberPicker;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    NumberPicker numPick;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Donation.1.5");

        numPick = findViewById(R.id.numberPicker);
        numPick.setMinValue(0);
        numPick.setMaxValue(1000);
    }
}