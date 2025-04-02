package com.example.aninterface;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Characters.MegaStats {

    protected TextView txtInfoChar, txtInfoDefChar, txtInfoWizard;

    private Characters defPerso, perso1, mage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInfoChar = findViewById(R.id.txtInfoChar);
        txtInfoDefChar = findViewById(R.id.txtInfoDefChar);
        txtInfoWizard = findViewById(R.id.txtInfoWizard);

        perso1 = new Characters("Titi", 45, 123, 89);
        String statsChar = "Nom : " + perso1.getNom() + "\n" +
                "HP : " + perso1.getVita() + "\n" +
                "STR : " + perso1.getForce() + "\n" +
                "Mana : " + perso1.getMana();
        txtInfoChar.setText(statsChar);


        defPerso = new Characters("Toto");
        defPerso.perteDePV();
        defPerso.perteDePV(5);
        String statsDefChar = "Nom : " + defPerso.getNom() + "\n" +
                "HP : " + defPerso.getVita() + "\n" +
                "STR : " + defPerso.getForce() + "\n" +
                "Mana : " + defPerso.getMana();
        txtInfoDefChar.setText(statsDefChar);

        mage = new Wizards("Tata", 100, 10, 200);
        String statsMage = "Nom : " + mage.getNom() + "\n" +
                "HP : " + mage.getVita() + "\n" +
                "STR : " + mage.getForce() + "\n" +
                "Mana : " + mage.getMana();
        txtInfoWizard.setText(statsMage);

        augmenteForce(555);
        augmenteMana(555);
        augmenteVie(555);
        changeNom("Super "+ defPerso.getNom());
        changeCouleur(Color.MAGENTA);
        
        String statsDefCharB = "Nom : " + defPerso.getNom() + "\n" +
                "HP : " + defPerso.getVita() + "\n" +
                "STR : " + defPerso.getForce() + "\n" +
                "Mana : " + defPerso.getMana();
        txtInfoDefChar.setText(statsDefCharB);

    }

    @Override
    public void augmenteForce(int f) {
        defPerso.setForce(f);
    }

    @Override
    public void augmenteVie(int v) {
        defPerso.setVita(v);
    }

    @Override
    public void augmenteMana(int m) {
        defPerso.setMana(m);
    }

    @Override
    public void changeNom(String n) {
        defPerso.setNom(n);
    }

    @Override
    public void changeCouleur(int c) {
        txtInfoDefChar.setTextColor(c);
    }
}