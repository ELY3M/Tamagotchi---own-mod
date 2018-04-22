package com.tamaproject.adt.messages.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.ServerMessage;

public class ConnectionRejectedProtocolMissmatchServerMessage extends ServerMessage implements ServerMessageFlags {
    private short mProtocolVersion;

    public ConnectionRejectedProtocolMissmatchServerMessage(short pProtocolVersion) {
        this.mProtocolVersion = pProtocolVersion;
    }

    public short getProtocolVersion() {
        return this.mProtocolVersion;
    }

    public void setProtocolVersion(short pProtocolVersion) {
        this.mProtocolVersion = pProtocolVersion;
    }

    public short getFlag() {
        return (short) -32766;
    }

    protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
        this.mProtocolVersion = pDataInputStream.readShort();
    }

    protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
        pDataOutputStream.writeShort(this.mProtocolVersion);
    }
}
