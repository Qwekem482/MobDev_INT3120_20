package com.example.boardcastintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity {
    private TextView helloString;
    private String fullName, message;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        this.back = findViewById(R.id.goBack);
        Intent intent = this.getIntent();
        this.fullName = intent.getStringExtra("fullName");
        helloString = findViewById(R.id.helloString);
        helloString.setText("Hello " + fullName +"!");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }

    private void goBack() {
        this.onBackPressed();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        String feedback = "Hello, " + this.fullName + ". How are you?";
        data.putExtra("feedback", feedback);

        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }
}
