package com.example.ev4.logic;

import java.util.ArrayList;

public class ItemManagement {

    private ArrayList<item> items;

    public ItemManagement() {
        items = new ArrayList<>();
    }

    public boolean addItem(item item) {
        try {
            items.add(item);
            return true;
        } catch (Exception _) {
            return false;
        }
    }

    public ArrayList<item> getItems() {
        return items;
    }
}
