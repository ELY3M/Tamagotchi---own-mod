package com.tamaproject.entity;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class Item extends Sprite {
    public static final int EQUIP = 1;
    public static final int NORMAL = 0;
    private String description;
    private int health;
    private int hunger;
    private String name;
    private int price = 0;
    private int protection = -1;
    private int sickness;
    private int type = 0;
    private int xp;

    public Item(float x, float y, TextureRegion textureRegion) {
        super(x, y, textureRegion);
        setSize(48.0f, 48.0f);
        setDefault();
    }

    public Item(float x, float y, TextureRegion textureRegion, String name, String description, int health, int hunger, int sickness, int xp) {
        super(x, y, textureRegion);
        this.name = name;
        this.description = description;
        this.health = health;
        this.hunger = hunger;
        this.sickness = sickness;
        this.xp = xp;
        setSize(48.0f, 48.0f);
    }

    public Item(float x, float y, TextureRegion textureRegion, String name, int health, int hunger, int sickness, int xp) {
        super(x, y, textureRegion);
        this.name = name;
        this.description = "No description.";
        this.health = health;
        this.hunger = hunger;
        this.sickness = sickness;
        this.xp = xp;
        setSize(48.0f, 48.0f);
    }

    public Item(float pX, float pY, TextureRegion pTextureRegion, String name, String description, int health, int hunger, int sickness, int xp, int type, int protection) {
        super(pX, pY, pTextureRegion);
        this.name = name;
        this.description = description;
        this.health = health;
        this.hunger = hunger;
        this.sickness = sickness;
        this.xp = xp;
        this.type = type;
        this.protection = protection;
        setSize(48.0f, 48.0f);
    }

    public Item(float pX, float pY, TextureRegion pTextureRegion, String name, String description, int health, int hunger, int sickness, int xp, int type, int protection, int price) {
        super(pX, pY, pTextureRegion);
        this.name = name;
        this.description = description;
        this.health = health;
        this.hunger = hunger;
        this.sickness = sickness;
        this.xp = xp;
        this.type = type;
        this.protection = protection;
        this.price = price;
        setSize(48.0f, 48.0f);
    }

    private void setDefault() {
        this.name = "Dummy";
        this.description = "This is a dummy item.";
        this.health = 0;
        this.hunger = 0;
        this.sickness = 0;
        this.xp = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getHunger() {
        return this.hunger;
    }

    public int getSickness() {
        return this.sickness;
    }

    public int getXp() {
        return this.xp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setSickness(int sickness) {
        this.sickness = sickness;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStringType() {
        switch (this.type) {
            case 0:
                return "Normal";
            case 1:
                return "Equipment";
            default:
                return "Normal";
        }
    }

    public String getInfo() {
        return "Item name: " + this.name + "\nType: " + getStringType() + "\nDescription: " + this.description + "\nHealth: " + this.health + "\nHunger: " + this.hunger + "\nSickness: " + this.sickness + "\nExperience: " + this.xp + "\nProtection: " + Protection.getString(this.protection);
    }

    public String getInfoWithPrice() {
        return "Item name: " + this.name + "\nType: " + getStringType() + "\nDescription: " + this.description + "\nHealth: " + this.health + "\nHunger: " + this.hunger + "\nSickness: " + this.sickness + "\nExperience: " + this.xp + "\nProtection: " + Protection.getString(this.protection) + "\nPrice: $" + this.price;
    }

    public int getProtection() {
        return this.protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "Item [name=" + this.name + ", description=" + this.description + ", health=" + this.health + ", hunger=" + this.hunger + ", sickness=" + this.sickness + ", xp=" + this.xp + ", type=" + this.type + ", protection=" + this.protection + ", price=" + this.price + "]";
    }
}
