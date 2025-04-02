package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        arrayList = new ArrayList<>();
        arrayList.add("Faîtes un choix");
        arrayList.add("Fraise");
        arrayList.add("Mandarine");
        arrayList.add("Pêche");
        arrayList.add("Pastèque");
        arrayList.add("Melon");
        arrayList.add("Ajouter un choix");

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(MainActivity.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                arrayList);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    String monItem = parent.getItemAtPosition(position).toString();
                    Toast.makeText(MainActivity.this,
                            "ID : " + id + ", position " + position + " sur : " + monItem,
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,
                        "Une erreur est survenue.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}