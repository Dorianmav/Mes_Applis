package com.example.meslistes.Class;

public class Produit {

    private String nom;
    private String quantite;

    public Produit(String nom, String quantite) {
        this.nom = nom;
        this.quantite = quantite;
    }

    public  Produit(String nom){
        this.nom = nom;
        quantite = "1";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
}
