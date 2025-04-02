package com.example.intentions;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnSend1;
    private TextView txtMsg1;
    private EditText msg1;
    private final static int idActivity2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend1 = findViewById(R.id.btnSend1);
        txtMsg1 = findViewById(R.id.txtMsg1);
        msg1 = findViewById(R.id.editMsg1);

        txtMsg1.setVisibility(View.GONE);

        btnSend1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String envoyerData = msg1.getText().toString().trim();

                        if (envoyerData.isEmpty()) return;

                        Intent monIntent = new Intent(getApplicationContext(), MyActivity2.class);
                        monIntent.putExtra("dataSend", envoyerData);
//                        startActivity(monIntent);
                        startActivityForResult(monIntent, idActivity2);

                        finish();
                    }
                }
        );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        super.onActivityResult(requestCode, resultCode, data, caller);

        if (resultCode == 06 && requestCode == idActivity2) {
            String recup_datareSend = (String) data.getSerializableExtra("dataSend");

            String newMsg = "La réponse d'Activity2 est : "
                    + recup_datareSend + "\n avec un resultCode de : "
                    + resultCode + "\n et un requestCode de  :" + requestCode;

            txtMsg1.setText(newMsg);

            txtMsg1.setVisibility(View.VISIBLE);
        }
    }
}