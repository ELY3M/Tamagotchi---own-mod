package com.tamaproject.entity;

import java.util.ArrayList;
import org.anddev.andengine.entity.Entity;

public class Backpack {
    private final int MAX_SIZE;
    private boolean backpackOpen;
    private ArrayList<Entity> itemPages;
    private ArrayList<Item> items;

    public Backpack(ArrayList<Item> items) {
        this.itemPages = new ArrayList();
        this.MAX_SIZE = 113;
        this.backpackOpen = false;
        this.items = items;
    }

    public Backpack() {
        this.itemPages = new ArrayList();
        this.MAX_SIZE = 113;
        this.backpackOpen = false;
        this.items = new ArrayList();
    }

    public boolean addItem(Item item) {
        boolean z;
        synchronized (this.items) {
            if (this.items.size() == 113) {
                z = false;
            } else {
                this.items.add(item);
                z = true;
            }
        }
        return z;
    }

    public int numItems() {
        return this.items.size();
    }

    public int maxSize() {
        return 113;
    }

    public boolean removeItem(Item item) {
        boolean z;
        synchronized (this.items) {
            if (this.items.remove(item)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean isBackpackOpen() {
        return this.backpackOpen;
    }

    public void setBackpackOpen(boolean backpackOpen) {
        this.backpackOpen = backpackOpen;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void resetPositions(float width, float height) {
        float xSpacing = width / 11.0f;
        float ySpacing = height / 13.0f;
        int count = 0;
        int size = this.items.size();
        for (int i = 1; i <= 13; i++) {
            int j = 1;
            while (j <= 10) {
                try {
                    ((Item) this.items.get(count)).setPosition((xSpacing * ((float) j)) - (((Item) this.items.get(count)).getWidth() / 2.0f), (ySpacing * ((float) i)) - (((Item) this.items.get(i)).getHeight() / 2.0f));
                    count++;
                    if (count <= size - 1) {
                        j++;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
