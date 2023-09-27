package com.example.relative;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    NumberPicker numPick;
    ProgressBar pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Donate.1.5");
        numPick  = findViewById(R.id.numbPick);
        numPick.setMinValue(0);
        numPick.setMaxValue(10000);

        EditText amount = findViewById(R.id.editText);
        Button btn = findViewById(R.id.donateButton);
        pg = findViewById(R.id.progressBar);

        numPick.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                amount.setText(String.valueOf(i1));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            int totalDonated = 0;
            final int goal = 10000;
            @Override

            public void onClick(View view) {
                TextView total = findViewById(R.id.total);
                String a = amount.getText().toString();
                int value = Integer.parseInt(a);
                totalDonated += value;
                total.setText(String.valueOf(totalDonated));

                // Calculate progress using floating-point division and cast to int
                int progress = (int) ((totalDonated / (float) goal) * 100);
                pg.setProgress(progress);
            }
        });
    }
}