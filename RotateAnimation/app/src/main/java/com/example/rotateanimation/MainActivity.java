package com.example.rotateanimation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    protected ImageView arrows;
    protected Button btnRotate;
    protected MyRotation rotation, clickRotation;

    public String tokenToggleRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrows = findViewById(R.id.imageView);
        btnRotate = findViewById(R.id.btnRotate);

        toggleRotation(tokenToggleRotation = "MyRotation");
    }

    protected void toggleRotation(String token) {
        if (Objects.equals(token, "RotateAnimation")) {
            Log.i("DEBUG", "On utilise la classe <RotateAnimation>");
            RotateAnimation rotate = new RotateAnimation(0,360,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);

            rotate.setDuration(2000);
            rotate.setInterpolator(new LinearInterpolator());

            arrows.startAnimation(rotate);

            btnRotate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("DEBUG", "Bouton <Fais moi tourner !> cliqué.");
                    arrows.startAnimation(rotate);
                }
            });
        } else if (Objects.equals(token, "MyRotation")) {
            Log.i("DEBUG", "On utilise la classe <MyRotate> qui prolongue la classe <RotateAnimation>");
            rotation = new MyRotation(0,360,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    arrows, 2000);


            btnRotate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("DEBUG", "Bouton <Fais moi tourner !> cliqué.");
                    clickRotation = new MyRotation(0,360,
                            0.5f, 0.5f,
                            arrows, 2000);
                }
            });
        }
    }
}