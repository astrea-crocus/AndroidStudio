package com.example.blocnote;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected Button btnBackground, btnText;
    protected EditText txtColorBackground, txtColorText, texte;
    protected String colorBg, colorTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBackground = findViewById(R.id.btnBackground);
        btnText = findViewById(R.id.btnText);

        txtColorBackground = findViewById(R.id.txtColorBackground);
        txtColorText = findViewById(R.id.txtColorText);

        texte = findViewById(R.id.texte);

        texte.setBackgroundColor(Color.WHITE);
        texte.setTextColor(Color.BLACK);
        texte.setHintTextColor(setAlpha("black", 0.75F));

        btnBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorBg = txtColorBackground.getText().toString().trim();
                if (colorBg.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Saissisez une couleur de fond !", Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    texte.setBackgroundColor(Color.parseColor(colorBg));
                } catch (IllegalArgumentException e) {
                    Toast.makeText(MainActivity.this,
                            "Couleur de fond invalide !", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorTxt = txtColorText.getText().toString().trim();
                if (colorTxt.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Saissisez une couleur de texte !", Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    texte.setTextColor(setAlpha(colorTxt, 0.75f));
                    texte.setHintTextColor(Color.parseColor(colorTxt));
                } catch (IllegalArgumentException e) {
                    Toast.makeText(MainActivity.this,
                            "Couleur de texte invalide !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected int setAlpha(String color, float alpha) {
        int parsedColor = Color.parseColor(color);

        int red = Color.red(parsedColor);
        int green = Color.green(parsedColor);
        int blue = Color.blue(parsedColor);

        return Color.argb((int) (alpha * 255), red, green, blue);
    }
}