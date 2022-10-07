package com.example.ma_liste;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;

import java.io.File;

public class Manga {
    private String titre;
    private String resume;
    private String statut;
    private Bitmap image;
    private String collection;


    // Initialisation des constructeurs

    public Manga(String titre, String resume, String statut, Bitmap image, String collection){
        this.titre = titre;
        this.resume = resume;
        this.statut = statut;
        this.image = image;
        this.collection = collection;
    }

    public String getTitre(){return titre;}

    public void setTitre(String nvTitre){this.titre = nvTitre;}

    public String getResume(){return resume;}

    public void setResume(String nvResume){this.resume = nvResume;}

    public String getStatut(){return statut;}

    public void setStatut(String nvStatut){this.statut = nvStatut;}

    public Bitmap getImage(){return image;}

    public void setImage(Bitmap nvImage){this.image = nvImage;}

    public String getCollection(){return collection;}

    public void setCollection(String nvCollection){this.collection = nvCollection;}

}
