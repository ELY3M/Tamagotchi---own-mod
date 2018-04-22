package org.anddev.andengine.extension.multiplayer.protocol.adt.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class EmptyMessage extends Message {
    public EmptyMessage(DataInputStream pDataInputStream) throws IOException {
    }

    protected void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
    }

    protected void onAppendTransmissionDataForToString(StringBuilder pStringBuilder) {
    }
}
