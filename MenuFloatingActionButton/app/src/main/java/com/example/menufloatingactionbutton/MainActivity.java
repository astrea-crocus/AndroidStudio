package com.example.menufloatingactionbutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabMain, fabOpt1, fabOpt2;
    private boolean isFABOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabMain = findViewById(R.id.fabMain);
        fabOpt1 = findViewById(R.id.fabOpt1);
        fabOpt2 = findViewById(R.id.fabOpt2);

        fabMain.setOnClickListener(new View.OnClickListener() {
            // Gérer le clic sur le FAB main
            @Override
            public void onClick(View v) {
                if (!isFABOpen) {
                    showFABMenu(); //Afficher le menu
                } else {
                    closeFABMenu(); //Fermer le menu
                }
            }
        });

        fabOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Option 1", Toast.LENGTH_SHORT).show();
                closeFABMenu();
            }
        });

        fabOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Option 2", Toast.LENGTH_SHORT).show();
                closeFABMenu();
            }
        });

    }

    private void showFABMenu() {
        isFABOpen = true;
        fabMain.setImageResource(android.R.drawable.arrow_down_float);

        fabOpt1.setVisibility(View.VISIBLE);
        fabOpt2.setVisibility(View.VISIBLE);

        fabOpt1.animate().translationY(-400);
        fabOpt2.animate().translationY(-200);

    }

    private void closeFABMenu() {
        isFABOpen = false;
        fabMain.setImageResource(android.R.drawable.arrow_up_float);

        fabOpt2.animate().translationY(0);
        fabOpt1.animate().translationY(0).withEndAction(new Runnable() {
            @Override
            public void run() {
                fabOpt1.setVisibility(View.INVISIBLE);
                fabOpt2.setVisibility(View.INVISIBLE);
            }
        });
    }
}