package com.example.meslistes.Autre;

import com.example.meslistes.Class.Scan;

import java.util.Comparator;

public class ScanCompare implements Comparator<Scan> {
    @Override
    public int compare(Scan o1, Scan o2) {
        return o1.getTitre().compareTo(o2.getTitre());
    }
}
