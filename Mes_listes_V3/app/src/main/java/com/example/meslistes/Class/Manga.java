package com.example.meslistes.Class;

import android.graphics.Bitmap;

public class Manga {

    private String titre;
    private String resume;
    private String statut;
    private Bitmap image;
    private String collection;

    public Manga(String titre, String resume, String statut, Bitmap image, String collection) {
        this.titre = titre;
        this.resume = resume;
        this.statut = statut;
        this.image = image;
        this.collection = collection;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

}