package com.example.secondrelative;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nameInput, phoneInput;
    TextView orderBox;
    Button exitButton;
    RadioGroup cheese, shape;
    RadioButton cheesebtn, cheese2btn, nonebtn, squarebtn, roundbtn;
    CheckBox pep, mus, veg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Essentials of Developing Android 5.0");

        exitButton = findViewById(R.id.exitbtn);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });


        nameInput = findViewById(R.id.nameInput);
        phoneInput = findViewById(R.id.phoneInput);
        orderBox = findViewById(R.id.orderBox);
        cheese = findViewById(R.id.cheeseRadioGroup);
        shape = findViewById(R.id.shapeRadioGroup);
        pep = (CheckBox) findViewById(R.id.pep);
        mus = (CheckBox) findViewById(R.id.mus);
        veg = (CheckBox) findViewById(R.id.veg);

        cheese.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                updateOrder();
            }
        });

        shape.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                updateOrder();
            }
        });

        pep.setOnCheckedChangeListener((buttonView, isChecked) -> updateOrder());
        mus.setOnCheckedChangeListener((buttonView, isChecked) -> updateOrder());
        veg.setOnCheckedChangeListener((buttonView, isChecked) -> updateOrder());
    }

    private void updateOrder() {
        StringBuilder order = new StringBuilder();
        cheesebtn = (RadioButton) findViewById(R.id.cheese);
        cheese2btn = (RadioButton) findViewById(R.id.cheese2);
        nonebtn = (RadioButton) findViewById(R.id.noneCheese);
        squarebtn = (RadioButton) findViewById(R.id.square);
        roundbtn = (RadioButton) findViewById(R.id.round);

        if(cheesebtn.isChecked()) {
            order.append("Cheese").append("\n");
        }

        if(cheese2btn.isChecked()) {
            order.append("2 x Cheese").append("\n");
        }

        if(nonebtn.isChecked()) {
            order.append("No Cheese").append("\n");
        }

        if(squarebtn.isChecked()) {
            order.append("Square").append("\n");
        }

        if(roundbtn.isChecked()) {
            order.append("Round").append("\n");
        }

        if(pep.isChecked()) {
            order.append(pep.getText());
        }

        if(mus.isChecked()) {
            if(pep.isChecked()) {
                order.append(", ");
            }
            order.append(mus.getText());

        }

        if(veg.isChecked()) {
            if(pep.isChecked() || mus.isChecked()) {
                order.append(", ");
            }
            order.append(veg.getText());
        }

        orderBox.setText(order.toString());
    }
}