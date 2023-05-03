package com.example.mes_listes_v4.Library;

import com.example.mes_listes_v4.Class.Anime;

import java.util.ArrayList;
import java.util.List;

public class AnimeLibrary {
    private List<Anime> animeList;

    public AnimeLibrary() {
        animeList = new ArrayList<>();
    }

    public void addAnime(Anime anime) {
        animeList.add(anime);
    }

    public List<Anime> searchByTitle(String title) {
        List<Anime> results = new ArrayList<>();
        for (Anime anime : animeList) {
            if (anime.getTitle().equals(title)) {
                results.add(anime);
            }
        }
        return results;
    }

    public List<Anime> searchByGenre(String genre) {
        List<Anime> results = new ArrayList<>();
        for (Anime anime : animeList) {
            if (anime.getGenres().contains(genre)) {
                results.add(anime);
            }
        }
        return results;
    }

    public List<Anime> searchByStreamingSite(String site) {
        List<Anime> results = new ArrayList<>();
        for (Anime anime : animeList) {
            if (anime.getStreamingLink().contains(site)) {
                results.add(anime);
            }
        }
        return results;
    }

    public List<Anime> getWatchingAnimes() {
        List<Anime> results = new ArrayList<>();
        for (Anime anime : animeList) {
            if (anime.getProgress() > 0 && anime.getProgress() < anime.getTotalEpisodes()) {
                results.add(anime);
            }
        }
        return results;
    }
}
