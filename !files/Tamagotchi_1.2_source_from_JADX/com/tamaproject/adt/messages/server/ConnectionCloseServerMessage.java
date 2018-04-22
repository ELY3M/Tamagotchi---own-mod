package com.tamaproject.adt.messages.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.ServerMessage;

public class ConnectionCloseServerMessage extends ServerMessage implements ServerMessageFlags {
    public short getFlag() {
        return Short.MIN_VALUE;
    }

    protected void onReadTransmissionData(DataInputStream pDataInputStream) throws IOException {
    }

    protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
    }
}
