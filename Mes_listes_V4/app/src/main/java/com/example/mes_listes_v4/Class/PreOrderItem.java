package com.example.mes_listes_v4.Class;

import java.util.Date;

public class PreOrderItem {
    private String name;
    private int quantity;
    private String store;
    private Date releaseDate;

    public PreOrderItem(String name, int quantity, String store, Date releaseDate) {
        this.name = name;
        this.quantity = quantity;
        this.store = store;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}

