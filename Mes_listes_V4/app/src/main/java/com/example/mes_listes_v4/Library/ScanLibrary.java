package com.example.mes_listes_v4.Library;

import com.example.mes_listes_v4.Class.Scan;

import java.util.ArrayList;
import java.util.List;

public class ScanLibrary {
    private List<Scan> scans;

    public ScanLibrary() {
        scans = new ArrayList<>();
    }

    public void addScan(Scan scan) {
        scans.add(scan);
    }

    public List<Scan> searchByTitle(String query) {
        List<Scan> results = new ArrayList<>();
        for (Scan scan : scans) {
            if (scan.getTitle().contains(query)) {
                results.add(scan);
            }
        }
        return results;
    }

    public List<Scan> searchBySite(String query) {
        List<Scan> results = new ArrayList<>();
        for (Scan scan : scans) {
            if (scan.getLink().contains(query)) {
                results.add(scan);
            }
        }
        return results;
    }

    public List<Scan> searchByGenre(String genre) {
        List<Scan> results = new ArrayList<>();
        for (Scan scan : scans) {
            if (scan.getGenres().contains(genre)) {
                results.add(scan);
            }
        }
        return results;
    }

    public List<Scan> getReadingScans() {
        List<Scan> results = new ArrayList<>();
        for (Scan scan : scans) {
            if (scan.getProgress() < 100) {
                results.add(scan);
            }
        }
        return results;
    }
}
