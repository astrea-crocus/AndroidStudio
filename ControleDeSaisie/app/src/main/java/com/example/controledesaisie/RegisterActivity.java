package com.example.controledesaisie;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    public TextInputLayout editTextPseudo, editTextMail, editTextPassword, editTextConfirmPassword;
    private Button btnRegister;
    private ProgressBar pgbar;

    private String strPSEUDO, strEMAIL, strPASSWORD1, strPASSWORD2;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +             // Début de ligne
                            "(?=.*[0-9])" +         // Au moins 1 chiffre
                            "(?=.*[a-z])" +         // Au moins 1 minuscule
                            "(?=.*[A-Z])" +         // Au moins 1 majuscule
                            // "(?!.*[a-zA-Z])" +   // Aucune lettres possibles
                            "(?=.*[@#!$^&+=])" +    // Au moins 1 caractère spécial listé
                            "(?=\\S+$)" +           // Pas d'espace vide
                            ".{6,20}" +             // Min 6 caractères, Max 20 caractères
                            "$");                   // Fin de ligne

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextPseudo = findViewById(R.id.newUser_pseudo);
        editTextMail = findViewById(R.id.newUser_email);
        editTextPassword = findViewById(R.id.newUser_password);
        editTextConfirmPassword = findViewById(R.id.newUser_confirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        pgbar = findViewById(R.id.pgbar);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DÉBUT - Récupération & Contrôles de Saisies
                validLogin();
                validEmail();
                validPASWWORD();

                if(!validLogin() || !validEmail() || !validPASWWORD()) {
                    Log.d("DEBUG Register", "Inscription invalide.");
                    return;
                }
                // FIN - Récupération & Contrôles de Saisies

                Log.d("DEBUG Register", "Inscription valide.");
                pgbar.setVisibility(View.VISIBLE);
                btnRegister.setVisibility(View.GONE);
            }
        });

    }

    // METHODES
    private boolean validLogin() {
        strPSEUDO = editTextPseudo.getEditText().getText().toString().trim();
        if (strPSEUDO.isEmpty()) {
            editTextPseudo.setError("Pseudo doit être renseigné.");
            editTextPseudo.requestFocus();
            return false;
        } else if (strPSEUDO.length()>10) {
            editTextPseudo.setError("Pseudo trop long ! 10 caractères uniquement.");
            return false;
        } else {
            editTextPseudo.setError(null);
            return true;
        }
    }

    private boolean validEmail() {
        strEMAIL = editTextMail.getEditText().getText().toString().trim();
        if (strEMAIL.isEmpty()) {
            editTextMail.setError("L'email doit être renseigné.");
            editTextMail.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(strEMAIL).matches()) {
            editTextMail.setError("Attention !\n" + strEMAIL + " n'est pas une adresse email valide.");
            return false;

        } else {
            editTextMail.setError(null);
            return true;
        }
    }

    private boolean validPASWWORD() {
        strPASSWORD1 = editTextPassword.getEditText().getText().toString().trim();
        strPASSWORD2 = editTextConfirmPassword.getEditText().getText().toString().trim();

        if(strPASSWORD1.isEmpty() || strPASSWORD2.isEmpty()
                || !PASSWORD_PATTERN.matcher(strPASSWORD1).matches()
                || !PASSWORD_PATTERN.matcher(strPASSWORD2).matches()) {
            editTextPassword.setError("Le mot de passe saisi n'est pas valide.");
            Log.d("DEBUG PHP", "Passage passwd1");
            return false;
        } else if (!strPASSWORD1.equals(strPASSWORD2)) {    // ou écrire if (PASSWORD != PASSWORD2)
            editTextPassword.setError("Les mots de passe ne sont pas identiques.");
            editTextConfirmPassword.setError("Les mots de passe ne sont pas identiques.");
            Log.d("DEBUG PHP", "Passage passwd not equals");
            return false;

        } else {
            editTextPassword.setError(null);
            editTextConfirmPassword.setError(null);
            return true;
        }
    }

}