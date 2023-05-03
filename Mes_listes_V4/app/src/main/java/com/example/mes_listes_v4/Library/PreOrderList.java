package com.example.mes_listes_v4.Library;

import com.example.mes_listes_v4.Class.PreOrderItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PreOrderList {
    private List<PreOrderItem> items;

    public PreOrderList() {
        items = new ArrayList<PreOrderItem>();
    }

    public void addItem(String name, int quantity, String store, Date releaseDate) {
        PreOrderItem newItem = new PreOrderItem(name, quantity, store, releaseDate);
        items.add(newItem);
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public List<PreOrderItem> getItems() {
        return items;
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
