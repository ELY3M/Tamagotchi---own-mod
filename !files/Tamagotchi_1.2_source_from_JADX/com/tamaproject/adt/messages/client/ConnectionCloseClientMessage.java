package com.tamaproject.adt.messages.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.client.ClientMessage;

public class ConnectionCloseClientMessage extends ClientMessage implements ClientMessageFlags {
    public short getFlag() {
        return Short.MIN_VALUE;
    }

    protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
    }

    protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
    }
}
