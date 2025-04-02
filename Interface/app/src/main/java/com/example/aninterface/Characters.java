package com.example.aninterface;

public class Characters {

    private String nom;
    private int vita;
    private int force;
    private int mana;

    public Characters(String nom) {
        this.nom = nom;
        vita = 80;
        force = 50;
        mana = 50;
    }

    public Characters(String nom, int vita, int force, int mana) {
        this.nom = nom;
        this.vita = vita;
        this.force = force;
        this.mana = mana;
    }

    public void perteDePV () {
        vita -= 10; //ou vita = vita - 10
    }

    public void perteDePV (int dmg) {
        vita -= dmg; //ou vita = vita - 10
    }

    /*  Getters & Setters   */

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVita() {
        return vita;
    }
    public void setVita(int vita) {
        this.vita = vita;
    }

    public int getForce() {
        return force;
    }
    public void setForce(int force) {
        this.force = force;
    }

    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    public interface MegaStats {
        public void augmenteForce(int f);
        public void augmenteVie(int v);
        public void augmenteMana(int m);
        public void changeNom(String s);

        public void changeCouleur(int c);
    }
}
