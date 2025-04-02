package com.example.objetsxml;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class MainActivity extends AppCompatActivity {

    private Switch mySwitch;
    private TextView txt;

    private ConstraintLayout constraintLayout;
    private SeekBar seekBar;
    private int progress;

    private RatingBar ratingBar;

    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // === === === === === === === === = Utilisation du Switch = === === === === === === === ===
        mySwitch = findViewById(R.id.switch1);
        constraintLayout = findViewById(R.id.main);

        mySwitch.setEnabled(true);
        mySwitch.setChecked(false);
        mySwitch.setClickable(true);

        boolean clickMySwitch = mySwitch.isClickable();
        boolean checkMySwitch = mySwitch.isChecked();

        String valeurs = "Valeur du checked : " + String.valueOf(checkMySwitch) + "\n"
                + "Valeur du clickable : " + String.valueOf(clickMySwitch);

        Toast.makeText(this, valeurs, Toast.LENGTH_SHORT).show();

        mySwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean clickMySwitch = mySwitch.isClickable();
                boolean checkMySwitch = mySwitch.isChecked();

                if (checkMySwitch || constraintLayout.getSolidColor() == Color.WHITE) {
                    constraintLayout.setBackgroundColor(Color.LTGRAY);
                } else constraintLayout.setBackgroundColor(Color.WHITE);

                String valeurs = "Valeur du checked : " + String.valueOf(checkMySwitch) + "\n"
                        + "Valeur du clickable : " + String.valueOf(clickMySwitch);

                Toast.makeText(MainActivity.this, valeurs, Toast.LENGTH_SHORT).show();}
        });

        // === === === === === === === === Utilisation de la SeekBar === === === === === === === ===
        seekBar = findViewById(R.id.seekBar);
        txt = findViewById(R.id.textView);

        seekBar.setMax(150);
        seekBar.setProgress(progress);
        txt.setText("" + progress);
        txt.setTextSize(progress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress2, boolean fromUser) {
                progress = progress2;
                txt.setText("" + progress);
                txt.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setBackgroundColor(Color.GRAY);
                txt.setBackgroundColor(Color.GRAY);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setBackgroundColor(Color.TRANSPARENT);
                txt.setBackgroundColor(Color.TRANSPARENT);
            }
        });

        // === === === === === === === == Utilisation de la RatingBar == === === === === === === ===
        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setNumStars(5);
        ratingBar.setRating(3);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d("tag", "Valeur de ratingBar : " + ratingBar);
                Log.d("tag", "Valeur de rating : " + rating);
                Log.d("tag", "Valeur de fromUser : " + fromUser);
            }
        });

        // === === === === === === === === Utilisation de la CheckBox == === === === === === === ===
        checkBox = findViewById(R.id.checkBox);
        checkBox.setEnabled(true);
        checkBox.setChecked(true);

        boolean monCheckBox = checkBox.isChecked();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "CheckBox " + isChecked, Toast.LENGTH_SHORT).show();
                checkBox.setEnabled(false);
            }
        });


    }
    public void monClickRadio(View radioButtonClick) {
        boolean valeurDuChecked = ((RadioButton)radioButtonClick).isChecked();
        if (radioButtonClick.getId() == R.id.radioButton) {
            if (valeurDuChecked) Toast.makeText(this, "radioButton", Toast.LENGTH_SHORT).show();
        } else if (radioButtonClick.getId() == R.id.radioButton2) {
            if (valeurDuChecked) Toast.makeText(this, "radioButton", Toast.LENGTH_SHORT).show();
        }
    }
}