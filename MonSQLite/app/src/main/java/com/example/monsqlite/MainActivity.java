package com.example.monsqlite;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StringBuffer monBuffer;
    private Button btnSend;
    private EditText txtSearch;
//    private ListView listDataBase;

    private MonAdapter monAdapter;
    private RecyclerView recyclerView;
    private List<Items> mesItems;
    private SQLiteMaDataBase maSQLdb = new SQLiteMaDataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);
        txtSearch = findViewById(R.id.txtSearch);
        recyclerView = findViewById(R.id.recyclerView);
        mesItems = new ArrayList<>();

        initTable();

        Cursor cursorStart = maSQLdb.lireTable();
        showTableValues(cursorStart);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtSearch.getText().isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Veuillez taper un nom ou un âge",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


        maSQLdb.close();
    }

    public void infoMaBase(String titre, StringBuffer message) {
        AlertDialog ad = new AlertDialog.Builder(this).create();

        ad.setTitle(titre);
        ad.setMessage(message);
        ad.setButton(AlertDialog.BUTTON_POSITIVE, "Okay",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("DEBUG DataBase", "Bouton positif 'Okay' cliqué");
                    }
                });
        ad.setButton(AlertDialog.BUTTON_NEUTRAL, "Quit App",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("DEBUG DataBase", "Bouton neutre 'Quit App' cliqué");
                        finish();
                    }
                });
        ad.show();
    }

    private void showTableValues(Cursor cursor) {
        monBuffer = new StringBuffer();
        cursor.moveToFirst();

        if (cursor.getCount() == 0) {
            monBuffer.append("La table est vide");
            return;
        } else {
            while (!cursor.isAfterLast()) {
                monBuffer.append("ID : " + cursor.getInt(0) + "\n\r\r");
                monBuffer.append("Nom : " + cursor.getString(1) + "\n\r\r");
                monBuffer.append("Prénom : " + cursor.getString(2) + "\n\r\r");
                monBuffer.append("Age : " + cursor.getInt(3) + "\n");
                monBuffer.append("__________\n");
                cursor.moveToNext();
            }
        }
        cursor.close();
        infoMaBase("Table : " + maSQLdb.NOM_TABLE, monBuffer);
    }

    public void initTable() {
        Cursor cursor = maSQLdb.lireTable();

        if (cursor.getCount() == 0) {
            maSQLdb.insertionClients("FAVALE", "Paul", 60);
            maSQLdb.insertionClients("CORNEL", "Christine", 54);
            maSQLdb.insertionClients("FAVALE", "Valentin", 30);
            maSQLdb.insertionClients("FAVALE", "Cloé", 24);
            maSQLdb.insertionClients("FAVALE", "Gabriele", 21);
            maSQLdb.insertionClients("CORNEL", "Kena", 9);
            maSQLdb.insertionClients("FAVALE", "Macchia", 5);
        }
    }

}