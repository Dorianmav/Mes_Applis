package com.example.mes_listes_v4.Class;
import java.time.LocalDate;

public class Jeux {

    private String image;
    private String name;
    private String summary;
    private String author;
    private String genre;
    private int rating;
    private LocalDate releaseDate;
    private String console;

    public Jeux(String image, String name, String summary, String author, String genre, int rating, LocalDate releaseDate, String console) {
        this.image = image;
        this.name = name;
        this.summary = summary;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.console = console;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    @Override
    public String toString() {
        return "Jeux{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate +
                ", console='" + console + '\'' +
                '}';
    }
}
