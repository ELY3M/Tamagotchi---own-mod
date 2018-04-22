package com.tamaproject.multiplayer;

public class BulletInfo {
    private int ID;
    private int playerID;

    public BulletInfo(int playerID, int ID) {
        this.playerID = playerID;
        this.ID = ID;
    }

    public int getPlayerID() {
        return this.playerID;
    }

    public int getID() {
        return this.ID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setID(int iD) {
        this.ID = iD;
    }
}
