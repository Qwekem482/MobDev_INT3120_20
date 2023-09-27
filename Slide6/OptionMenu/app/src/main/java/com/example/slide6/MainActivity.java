package com.example.slide6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().setTitle("Menu");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        tv = findViewById(R.id.textView);
        int id = item.getItemId();
        if (id == R.id.item1) {
            tv.setText("Item 1 selected.");
        } else if (id == R.id.item3) {
            tv.setText("Item 3 selected.");
        } else if (id == R.id.item21) {
            tv.setText("Item 2.1 selected.");
        } else if (id == R.id.item22) {
            tv.setText("Item 2.2 selected.");
        } else if (id == R.id.item23) {
            tv.setText("Item 2.3 selected.");
        } else if (id == R.id.item24) {
            tv.setText("Item 2.4 selected.");
        }
        return super.onOptionsItemSelected(item);
    }
}