package com.tamaproject.multiplayer;

import com.tamaproject.util.TamaBattleConstants;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.client.ClientMessage;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.ServerMessage;

public interface BattleMessages extends TamaBattleConstants {

    public static class DeathMatchServerMessage extends ServerMessage {
        boolean isDeathMatch;

        public DeathMatchServerMessage(boolean vote) {
            this.isDeathMatch = vote;
        }

        public void set(boolean vote) {
            this.isDeathMatch = vote;
        }

        public short getFlag() {
            return (short) 16;
        }

        protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
            this.isDeathMatch = pDataInputStream.readBoolean();
        }

        protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
            pDataOutputStream.writeBoolean(this.isDeathMatch);
        }
    }

    public static class GetPlayerIdServerMessage extends ServerMessage {
        int playerNumber;

        public GetPlayerIdServerMessage(int playerNumber) {
            this.playerNumber = playerNumber;
        }

        public void set(int playerNumber) {
            this.playerNumber = playerNumber;
        }

        public short getFlag() {
            return (short) 3;
        }

        protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
            this.playerNumber = pDataInputStream.readInt();
        }

        protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
            pDataOutputStream.writeInt(this.playerNumber);
        }
    }

    public static class ModifyPlayerStatsServerMessage extends ServerMessage {
        int health;
        int playerID;

        public ModifyPlayerStatsServerMessage(int health, int playerID) {
            this.health = health;
            this.playerID = playerID;
        }

        public void set(int health, int playerID) {
            this.health = health;
            this.playerID = playerID;
        }

        public short getFlag() {
            return (short) 11;
        }

        protected void onReadTransmissionData(DataInputStream d) throws IOException {
            this.health = d.readInt();
            this.playerID = d.readInt();
        }

        protected void onWriteTransmissionData(DataOutputStream d) throws IOException {
            d.writeInt(this.health);
            d.writeInt(this.playerID);
        }
    }

    public static class ReceivedDamageServerMessage extends ServerMessage {
        int playerNumber;

        public ReceivedDamageServerMessage(int id) {
            this.playerNumber = id;
        }

        public void set(int id) {
            this.playerNumber = id;
        }

        public short getFlag() {
            return (short) 15;
        }

        protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
            this.playerNumber = pDataInputStream.readInt();
        }

        protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
            pDataOutputStream.writeInt(this.playerNumber);
        }
    }

    public static class RequestPlayerIdClientMessage extends ClientMessage {
        public short getFlag() {
            return (short) 4;
        }

        protected void onReadTransmissionData(DataInputStream arg0) throws IOException {
        }

        protected void onWriteTransmissionData(DataOutputStream arg0) throws IOException {
        }
    }

    public static class SendPlayerStatsClientMessage extends ClientMessage {
        int battleLevel;
        int health;
        int maxHealth;
        int playerID;

        public SendPlayerStatsClientMessage(int health, int maxHealth, int battleLevel, int playerID) {
            this.health = health;
            this.maxHealth = maxHealth;
            this.battleLevel = battleLevel;
            this.playerID = playerID;
        }

        public void set(int health, int maxHealth, int battleLevel, int playerID) {
            this.health = health;
            this.maxHealth = maxHealth;
            this.battleLevel = battleLevel;
            this.playerID = playerID;
        }

        public short getFlag() {
            return (short) 12;
        }

        protected void onReadTransmissionData(DataInputStream d) throws IOException {
            this.health = d.readInt();
            this.maxHealth = d.readInt();
            this.battleLevel = d.readInt();
            this.playerID = d.readInt();
        }

        protected void onWriteTransmissionData(DataOutputStream d) throws IOException {
            d.writeInt(this.health);
            d.writeInt(this.maxHealth);
            d.writeInt(this.battleLevel);
            d.writeInt(this.playerID);
        }
    }

    public static class SendPlayerStatsServerMessage extends ServerMessage {
        int battleLevel;
        int health;
        int maxHealth;
        int playerID;

        public SendPlayerStatsServerMessage(int health, int maxHealth, int battleLevel, int playerID) {
            this.health = health;
            this.maxHealth = maxHealth;
            this.battleLevel = battleLevel;
            this.playerID = playerID;
        }

        public void set(int health, int maxHealth, int battleLevel, int playerID) {
            this.health = health;
            this.maxHealth = maxHealth;
            this.battleLevel = battleLevel;
            this.playerID = playerID;
        }

        public short getFlag() {
            return (short) 13;
        }

        protected void onReadTransmissionData(DataInputStream d) throws IOException {
            this.health = d.readInt();
            this.maxHealth = d.readInt();
            this.battleLevel = d.readInt();
            this.playerID = d.readInt();
        }

        protected void onWriteTransmissionData(DataOutputStream d) throws IOException {
            d.writeInt(this.health);
            d.writeInt(this.maxHealth);
            d.writeInt(this.battleLevel);
            d.writeInt(this.playerID);
        }
    }

    public static abstract class SpriteClientMessage extends ClientMessage {
        int mID;
        boolean mIsPlayer;
        float mX;
        float mY;
        int playerID;

        public abstract short getFlag();

        public SpriteClientMessage(int playerID, int pID, float pX, float pY, boolean pIsPlayer) {
            this.playerID = playerID;
            this.mID = pID;
            this.mX = pX;
            this.mY = pY;
            this.mIsPlayer = pIsPlayer;
        }

        public void set(int playerID, int pID, float pX, float pY, boolean pIsPlayer) {
            this.playerID = playerID;
            this.mID = pID;
            this.mX = pX;
            this.mY = pY;
            this.mIsPlayer = pIsPlayer;
        }

        protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
            this.playerID = pDataInputStream.readInt();
            this.mID = pDataInputStream.readInt();
            this.mX = pDataInputStream.readFloat();
            this.mY = pDataInputStream.readFloat();
            this.mIsPlayer = pDataInputStream.readBoolean();
        }

        protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
            pDataOutputStream.writeInt(this.playerID);
            pDataOutputStream.writeInt(this.mID);
            pDataOutputStream.writeFloat(this.mX);
            pDataOutputStream.writeFloat(this.mY);
            pDataOutputStream.writeBoolean(this.mIsPlayer);
        }
    }

    public static abstract class SpriteServerMessage extends ServerMessage {
        int mID;
        boolean mIsPlayer;
        float mX;
        float mY;
        int playerID;

        public abstract short getFlag();

        public SpriteServerMessage(int playerID, int pID, float pX, float pY, boolean pIsPlayer) {
            this.playerID = playerID;
            this.mID = pID;
            this.mX = pX;
            this.mY = pY;
            this.mIsPlayer = pIsPlayer;
        }

        public void set(int playerID, int pID, float pX, float pY, boolean pIsPlayer) {
            this.playerID = playerID;
            this.mID = pID;
            this.mX = pX;
            this.mY = pY;
            this.mIsPlayer = pIsPlayer;
        }

        protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
            this.playerID = pDataInputStream.readInt();
            this.mID = pDataInputStream.readInt();
            this.mX = pDataInputStream.readFloat();
            this.mY = pDataInputStream.readFloat();
            this.mIsPlayer = pDataInputStream.readBoolean();
        }

        protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
            pDataOutputStream.writeInt(this.playerID);
            pDataOutputStream.writeInt(this.mID);
            pDataOutputStream.writeFloat(this.mX);
            pDataOutputStream.writeFloat(this.mY);
            pDataOutputStream.writeBoolean(this.mIsPlayer);
        }
    }

    public static class StartGameServerMessage extends ServerMessage {
        public short getFlag() {
            return (short) 14;
        }

        protected void onReadTransmissionData(DataInputStream arg0) throws IOException {
        }

        protected void onWriteTransmissionData(DataOutputStream arg0) throws IOException {
        }
    }

    public static class VoteDeathMatchClientMessage extends ClientMessage {
        boolean voteDeathMatch;

        public VoteDeathMatchClientMessage(boolean vote) {
            this.voteDeathMatch = vote;
        }

        public void set(boolean vote) {
            this.voteDeathMatch = vote;
        }

        public short getFlag() {
            return (short) 16;
        }

        protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
            this.voteDeathMatch = pDataInputStream.readBoolean();
        }

        protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
            pDataOutputStream.writeBoolean(this.voteDeathMatch);
        }
    }

    public static class AddSpriteClientMessage extends SpriteClientMessage {
        public short getFlag() {
            return (short) 7;
        }
    }

    public static class AddSpriteServerMessage extends SpriteServerMessage {
        public short getFlag() {
            return (short) 1;
        }
    }

    public static class FireBulletClientMessage extends SpriteClientMessage {
        public short getFlag() {
            return (short) 9;
        }
    }

    public static class FireBulletServerMessage extends SpriteServerMessage {
        public short getFlag() {
            return (short) 8;
        }
    }

    public static class MoveSpriteClientMessage extends SpriteClientMessage {
        public short getFlag() {
            return (short) 6;
        }
    }

    public static class MoveSpriteServerMessage extends SpriteServerMessage {
        public short getFlag() {
            return (short) 2;
        }
    }

    public static class RemoveSpriteServerMessage extends SpriteServerMessage {
        public short getFlag() {
            return (short) 10;
        }
    }
}
