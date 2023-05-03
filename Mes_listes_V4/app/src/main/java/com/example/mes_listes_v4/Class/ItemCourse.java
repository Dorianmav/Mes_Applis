package com.example.mes_listes_v4.Class;

import java.util.Date;

public class ItemCourse {
    private String nom;
    private int quantite;
    private String magasin;
    private boolean achete;
    private Date dateRappel;

    public ItemCourse(String nom, int quantite, String magasin) {
        this.nom = nom;
        this.quantite = quantite;
        this.magasin = magasin;
        this.achete = false;
        this.dateRappel = null;
    }

    public ItemCourse(String nom, String magasin) {
        this.nom = nom;
        this.quantite = 1;
        this.magasin = magasin;
        this.achete = false;
        this.dateRappel = null;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getMagasin() {
        return magasin;
    }

    public boolean isAchete() {
        return achete;
    }

    public void setAchete(boolean achete) {
        this.achete = achete;
    }

    public Date getDateRappel() {
        return dateRappel;
    }

    public void setDateRappel(Date dateRappel) {
        this.dateRappel = dateRappel;
    }
}
