package com.example.intentions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyActivity2 extends AppCompatActivity {
    private Button btnSend2;
    private TextView txtMsg2;
    private EditText msg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);

        btnSend2 = findViewById(R.id.btnSend2);
        txtMsg2 = findViewById(R.id.txtMsg2);
        msg2 = findViewById(R.id.editMsg2);

        String recup_dataSend = "Activité1 a dit :\n"
                + getIntent().getSerializableExtra("dataSend");

        txtMsg2.setText(recup_dataSend);

        btnSend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String envoyerData = msg2.getText().toString().trim();

                if (envoyerData.isEmpty()) return;

                Intent monIntent = new Intent(getApplicationContext(), MyActivity2.class);
                monIntent.putExtra("dataSend", envoyerData);

                Intent iA2 = new Intent();
                iA2.putExtra("dataReSend", txtMsg2.getText().toString());
                setResult(06, iA2);

                startActivity(monIntent);

                finish();
            }
        });
    }
}