package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View button;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = (Button) findViewById(R.id.menuBtn);
        this.registerForContextMenu(this.button);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Menu Menu");

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        tv = findViewById(R.id.indicator);
        int id = item.getItemId();
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
        return super.onOptionsItemSelected(item);
    }
}