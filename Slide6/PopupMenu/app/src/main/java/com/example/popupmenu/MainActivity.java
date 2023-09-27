package com.example.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Button btn1, btn2;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btn1 = findViewById(R.id.pressBtn);
        this.btn2 = findViewById(R.id.menuBtn);

        this.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressBtn();
            }
        });
    }

    private void pressBtn() {
        PopupMenu popupMenu = new PopupMenu(this, this.btn2);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        tv = findViewById(R.id.indicator);
        int id = menuItem.getItemId();
        if (id == R.id.item1) {
            tv.setText("Item 1 selected.");
            Toast.makeText(MainActivity.this, "Item 1", Toast.LENGTH_LONG).show();
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
        return true;
    }
}