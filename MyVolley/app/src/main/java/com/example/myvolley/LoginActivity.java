package com.example.myvolley;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin, buttonRegister;
    private RequestQueue queue;
    private MyRequest request;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_loginactivity);

         editTextEmail = findViewById(R.id.editTextTextEmailAddress);
         editTextPassword = findViewById(R.id.editTextTextPassword);

         buttonLogin = findViewById(R.id.buttonLogin);
         buttonRegister = findViewById(R.id.buttonRegister);

        queue = MySingleton.getInstance(this).getRequestQueue();
        request = new MyRequest(this, queue);

        sessionManager = new SessionManager(this);
        if (sessionManager.isLogged()) {
            Intent i = new Intent(getApplicationContext(), LoginOKActivity.class);
            startActivity(i);
            finish();
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EMAIL = editTextEmail.getText().toString();
                String PASSWORD = editTextPassword.getText().toString();

                request.login(EMAIL, PASSWORD, new MyRequest.loginPHP() {
                    @Override
                    public void toutOK(String id, String pseudo, String email, String message) {
                        Log.d("PHP", "messagesPHP : " + message);
                        Toast.makeText(LoginActivity.this,
                                "" + message, Toast.LENGTH_SHORT).show();

                        sessionManager.insertUser(id,pseudo,email);

                        Intent i = new Intent(getApplicationContext(), LoginOKActivity.class);
//                        i.putExtra("userID", id);
//                        i.putExtra("userPseudo", pseudo);
//                        i.putExtra("userEmail", email);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void pasOK(String message) {
                        buttonRegister.setVisibility(View.VISIBLE);
                        Log.d("PHP", "passage dans PAS OK de LoginActivity");
                        Toast.makeText(LoginActivity.this,
                                "Attention : " + message, Toast.LENGTH_SHORT).show();
                        return;
                    }

                    @Override
                    public void systemError(String message) {
                        buttonRegister.setVisibility(View.VISIBLE);
                        Toast.makeText(LoginActivity.this,
                                message, Toast.LENGTH_SHORT).show();
                        return;
                    }
                });

                /* ----- ----- ----- ----- ----- Ancienne Méthode (?) : -----   ----- ----- -----
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this,
                            "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Connexion réussie !", Toast.LENGTH_SHORT).show();
                }
                   ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- */
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
