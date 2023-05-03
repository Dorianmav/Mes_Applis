package com.example.mes_listes_v4.Class;

import java.util.ArrayList;
import java.util.List;

public class Anime {
    private String title;
    private String summary;
    private int progress;
    private int totalEpisodes;
    private String streamingLink;
    private List<String> genres;

    public Anime(String title, String summary, int progress, int totalEpisodes, String streamingLink, List<String> genres) {
        this.title = title;
        this.summary = summary;
        this.progress = progress;
        this.totalEpisodes = totalEpisodes;
        this.streamingLink = streamingLink;
        this.genres = genres;
    }

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

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", progress=" + progress +
                ", totalEpisodes=" + totalEpisodes +
                ", streamingLink='" + streamingLink + '\'' +
                ", genres=" + genres +
                '}';
    }
}