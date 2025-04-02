package com.example.myvolley;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginOKActivity extends AppCompatActivity {

    private TextView txtId, txtPseudo, txtMail;
    private Button btnLogout, btnChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_okactivity);

        txtPseudo = findViewById(R.id.txtPseudo);
        txtMail = findViewById(R.id.txtMail);
        txtId = findViewById(R.id.txtId);
        btnLogout = findViewById(R.id.btnLogout);
        btnChangePassword = findViewById(R.id.btnChangePassword);

        SessionManager sessionManager = new SessionManager(this);

//        String id = getIntent().getStringExtra("userID");
        String id = sessionManager.getId();
        txtId.setText(id);

//        String pseudo = getIntent().getStringExtra("userPseudo");
        String pseudo = sessionManager.getLogin();
        txtPseudo.setText(pseudo);

//        String mail = getIntent().getStringExtra("userEmail");
        String mail = sessionManager.getEmail();
        txtMail.setText(mail);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEBUG", "Bouton Logout cliqué");
                Toast.makeText(getApplicationContext(),
                        "Déconnexion réussie", Toast.LENGTH_SHORT).show();

                sessionManager.logout();

                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnChangePassword.setOnClickListener(view -> {
            // Redirect to ChangePasswordActivity
            Log.d("LoginOkActivity", "userId before passing: " + txtId);

            Intent intent = new Intent(getApplicationContext(), ChangePasswordActivity.class);
            intent.putExtra("USER_ID", txtId.getText());  // Pass the userId
            startActivity(intent);

        });


    }
}