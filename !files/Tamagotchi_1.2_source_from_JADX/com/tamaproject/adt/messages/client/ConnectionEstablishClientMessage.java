package com.tamaproject.adt.messages.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.client.ClientMessage;

public class ConnectionEstablishClientMessage extends ClientMessage implements ClientMessageFlags {
    private short mProtocolVersion;

    public ConnectionEstablishClientMessage(short pProtocolVersion) {
        this.mProtocolVersion = pProtocolVersion;
    }

    public short getProtocolVersion() {
        return this.mProtocolVersion;
    }

    public short getFlag() {
        return (short) -32767;
    }

    protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
        this.mProtocolVersion = pDataInputStream.readShort();
    }

    protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
        pDataOutputStream.writeShort(this.mProtocolVersion);
    }
}
