package com.example.meslistes.Class;

public class Scan {

    private String titre, chapitre, statut, site_internet, site_chapitre;

    public Scan(String titre, String chapitre, String site_internet) {
        this.titre = titre;
        this.chapitre = chapitre;
        this.site_internet = site_internet;
    }

    public Scan(String titre, String chapitre, String site_internet, String site_chapitre){
        this.titre = titre;
        this.chapitre = chapitre;
        this.site_internet = site_internet;
        this.site_chapitre = site_chapitre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getChapitre() {
        return chapitre;
    }

    public void setChapitre(String chapitre) {
        this.chapitre = chapitre;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }

    public String getSite_internet() {
        return site_internet;
    }

    public void setSite_internet(String site_internet) {
        this.site_internet = site_internet;
    }

    public String getSite_chapitre() {
        return site_chapitre;
    }

    public void setSite_chapitre(String site_chapitre) {
        this.site_chapitre = site_chapitre;
    }
}
