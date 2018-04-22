package com.tamaproject.adt.messages.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.ServerMessage;

public class ConnectionPongServerMessage extends ServerMessage implements ServerMessageFlags {
    private long mTimestamp;

    public ConnectionPongServerMessage(long pTimestamp) {
        this.mTimestamp = pTimestamp;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setTimestamp(long pTimestamp) {
        this.mTimestamp = pTimestamp;
    }

    public short getFlag() {
        return ServerMessageFlags.FLAG_MESSAGE_SERVER_CONNECTION_PONG;
    }

    protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
        this.mTimestamp = pDataInputStream.readLong();
    }

    protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
        pDataOutputStream.writeLong(this.mTimestamp);
    }
}
