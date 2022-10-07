package com.example.ma_liste;

public class Produit {
    private String nom;
    private int qte;

    public Produit(String nom, int qte) {
        this.nom = nom;
        this.qte = qte;
    }

    public Produit(String nom) {
        this.nom = nom;
        this.qte = 1;
    }

    public int getQte() {
        return qte;
    }

    public void setPopulation(int qte) {
        this.qte = qte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString()  {
        return this.nom ;
    }
}
