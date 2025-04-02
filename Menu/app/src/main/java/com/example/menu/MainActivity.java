package com.example.menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("");

        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar s = Snackbar.make(v, "Contactez l'assistance",
                        BaseTransientBottomBar.LENGTH_INDEFINITE);
                s.setAction("Appeler", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0605040302"));
                        startActivity(i);
                    }
                }).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId()==R.id.item_search) {
            Toast.makeText(this, "Item_Search", Toast.LENGTH_SHORT).show();
        }
        if (menuItem.getItemId()==R.id.item_search2) {
            Toast.makeText(this, "Item_Search2", Toast.LENGTH_SHORT).show();
        }
        if (menuItem.getItemId()==R.id.item_quit) {
            Toast.makeText(this, "Item_Quit", Toast.LENGTH_SHORT).show();
        }
        if (menuItem.getItemId()==R.id.item_quit2) {
            Toast.makeText(this, "Item_Quit2", Toast.LENGTH_SHORT).show();
        }
        if (menuItem.getItemId()==R.id.item_quit3) {
            Toast.makeText(this, "Item_Quit3", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}