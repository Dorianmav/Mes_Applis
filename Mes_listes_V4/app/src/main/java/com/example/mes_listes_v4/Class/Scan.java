package com.example.mes_listes_v4.Class;

import java.util.ArrayList;
import java.util.List;

public class Scan {
    private String title;
    private String summary;
    private int progress;
    private String link;
    private List<String> genres;

    public Scan(String title, String summary, int progress, String link, List<String> genres) {
        this.title = title;
        this.summary = summary;
        this.progress = progress;
        this.link = link;
        this.genres = genres;
    }

    // Getter et Setter pour tous les attributs

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
