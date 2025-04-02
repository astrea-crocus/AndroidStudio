package com.example.random_number;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private TextView hintNumber;
    private TextView memory;
    private EditText guessedNumber;
    private Button btnValidate;
    private ProgressBar pgBar;

    private int nbreRandom;
    private int nbreCoup= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hintNumber = findViewById(R.id.textViewHint);
        memory = findViewById(R.id.textViewMemoryLog);
        guessedNumber = findViewById(R.id.editTextNumber);
        btnValidate = findViewById(R.id.btnValidate);
        pgBar = findViewById(R.id.progressBar);

        init();
        //btnValidate.setOnClickListener(btnListener);
    }
    // MÉTHODES
    private void init() {
        //Méthode d'initialisation
        nbreCoup = 0;
        nbreRandom = (int) (Math.random() * 100) + 1;
        Log.i("tagNbreRandom", "random est : " + nbreRandom);

        guessedNumber.setText("");
        hintNumber.setText("");
        memory.setText("");

        pgBar.setProgress(nbreCoup);

    }
}