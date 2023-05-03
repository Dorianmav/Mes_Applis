package com.example.mes_listes_v4.Class;

public class Manga {

    private String title;
    private String author;
    private String publisher;
    private String summary;
    private int volumes;
    private int progress;

    public Manga(String title, String author, String publisher, String summary, int volumes) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.summary = summary;
        this.volumes = volumes;
        this.progress = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getVolumes() {
        return volumes;
    }

    public void setVolumes(int volumes) {
        this.volumes = volumes;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void addComment(String comment) {
        // Ajouter le commentaire au manga
        // ...
    }

    @Override
    public String toString() {
        return "Manga{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", summary='" + summary + '\'' +
                ", volumes=" + volumes +
                ", progress=" + progress +
                '}';
    }
}
