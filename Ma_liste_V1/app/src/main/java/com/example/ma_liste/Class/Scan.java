package com.example.ma_liste.Class;

import android.net.Uri;

import java.net.URL;

public class Scan {
    private String titre;
    private URL lien;
    private String chapitre;

    public Scan(String titre, URL lien, String chapitre){
        this.titre = titre;
        this.lien = lien;
        this.chapitre = chapitre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public URL getLien() {
        return lien;
    }

    public String getSLien(){
        return lien.toString();
    }

    public void setLien(URL lien) {
        this.lien = lien;
    }

    public String getChapitre() {
        return chapitre;
    }

    public void setChapitre(String chapitre) {
        this.chapitre = chapitre;
    }
}
