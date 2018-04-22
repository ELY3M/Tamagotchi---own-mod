package com.tamaproject.multiplayer;

public class PlayerInfo {
    private int battleLevel;
    private int health;
    private int maxHealth;
    private int playerID;

    public PlayerInfo(int health, int maxHealth, int battleLevel, int playerID) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.battleLevel = battleLevel;
        this.playerID = playerID;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getBattleLevel() {
        return this.battleLevel;
    }

    public int getPlayerID() {
        return this.playerID;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setBattleLevel(int battleLevel) {
        this.battleLevel = battleLevel;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
}
