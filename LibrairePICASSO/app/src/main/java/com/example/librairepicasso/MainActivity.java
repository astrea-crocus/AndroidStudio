package com.example.librairepicasso;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class MainActivity extends AppCompatActivity {
    protected ImageView img;
    protected Button btn;
    private String url, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        btn = findViewById(R.id.btn);

        url="https://images.ctfassets.net/ub3bwfd53mwy/5zi8myLobtihb1cWl3tj8L/45a40e66765f26beddf7eeee29f74723/6_Image.jpg";

        token ="RequestCreator";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affichageIMG(url, token);
            }
        });

    }

    protected void affichageIMG(String url, String token) {
        if (token.equals("RequestCreator")) {
            RequestCreator pica = new Picasso.Builder(MainActivity.this).build().load(url);

            pica.placeholder(R.drawable.loading);
            pica.error(R.drawable.image_load_failed);
            pica.into(img);
        } else if (token.equals("get")) {
            Picasso.get()
                    .load(url)
                    .resize(600,600)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.image_load_failed)
                    .into(img);
        }
    }
}