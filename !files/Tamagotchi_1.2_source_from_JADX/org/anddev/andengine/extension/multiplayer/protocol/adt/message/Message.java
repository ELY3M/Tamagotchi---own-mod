package org.anddev.andengine.extension.multiplayer.protocol.adt.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Message implements IMessage {
    protected abstract void onReadTransmissionData(DataInputStream dataInputStream) throws IOException;

    protected abstract void onWriteTransmissionData(DataOutputStream dataOutputStream) throws IOException;

    protected void onAppendTransmissionDataForToString(StringBuilder pStringBuilder) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("[getFlag()=").append(getFlag());
        onAppendTransmissionDataForToString(sb);
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (getFlag() != ((Message) obj).getFlag()) {
            return false;
        }
        return true;
    }

    public void write(DataOutputStream pDataOutputStream) throws IOException {
        pDataOutputStream.writeShort(getFlag());
        onWriteTransmissionData(pDataOutputStream);
    }

    public void read(DataInputStream pDataInputStream) throws IOException {
        onReadTransmissionData(pDataInputStream);
    }
}
