package com.example.implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button dialButton, browserButton, lookUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dialButton = findViewById(R.id.dialButton);
        this.browserButton = findViewById(R.id.browserButton);
        this.lookUpButton = findViewById(R.id.lookUpButton);
        dialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCall();
            }
        });
        browserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBrowser();
            }
        });
        lookUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lookUp();
            }
        });
    }

    private void makeCall() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 123456"));
        this.startActivity(intent);
    }

    private void openBrowser() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://stackoverflow.com/questions/3004515/sending-an-intent-to-browser-to-open-specific-url"));
        this.startActivity(intent);
    }

    private void lookUp() {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "stack overflow");
        this.startActivity(intent);
    }
}