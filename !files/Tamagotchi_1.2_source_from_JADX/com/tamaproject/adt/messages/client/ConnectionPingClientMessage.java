package com.tamaproject.adt.messages.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.client.ClientMessage;

public class ConnectionPingClientMessage extends ClientMessage implements ClientMessageFlags {
    private long mTimestamp;

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setTimestamp(long pTimestamp) {
        this.mTimestamp = pTimestamp;
    }

    public short getFlag() {
        return (short) -32766;
    }

    protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
        this.mTimestamp = pDataInputStream.readLong();
    }

    protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
        pDataOutputStream.writeLong(this.mTimestamp);
    }
}
