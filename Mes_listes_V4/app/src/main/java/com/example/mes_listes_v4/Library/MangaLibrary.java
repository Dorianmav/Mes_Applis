package com.example.mes_listes_v4.Library;

import com.example.mes_listes_v4.Class.Manga;

import java.util.ArrayList;
import java.util.List;

public class MangaLibrary {

    private List<Manga> mangas;

    public MangaLibrary() {
        mangas = new ArrayList<>();
    }

    public void addManga(Manga manga) {
        mangas.add(manga);
    }

    public List<Manga> searchMangas(String query) {
        List<Manga> results = new ArrayList<>();
        for (Manga manga : mangas) {
            if (manga.getTitle().contains(query)) {
                results.add(manga);
            }
        }
        return results;
    }

    public List<Manga> getReadingMangas() {
        List<Manga> results = new ArrayList<>();
        for (Manga manga : mangas) {
            if (manga.getProgress() < manga.getVolumes()) {
                results.add(manga);
            }
        }
        return results;
    }

    public void addComment(Manga manga, String comment) {
        manga.addComment(comment);
    }

}
