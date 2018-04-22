package org.anddev.andengine.extension.multiplayer.protocol.adt.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class IntMessage extends Message {
    protected int mInt;

    public IntMessage(int pInt) {
        this.mInt = pInt;
    }

    public IntMessage(DataInputStream pDataInputStream) throws IOException {
        read(pDataInputStream);
    }

    public int getInt() {
        return this.mInt;
    }

    public void read(DataInputStream pDataInputStream) throws IOException {
        this.mInt = pDataInputStream.readInt();
    }

    protected void onAppendTransmissionDataForToString(StringBuilder pStringBuilder) {
        pStringBuilder.append(", getInt()=").append(getInt());
    }

    public void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
        pDataOutputStream.writeInt(getInt());
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
        IntMessage other = (IntMessage) obj;
        if (getFlag() == other.getFlag() && getInt() == other.getInt()) {
            return true;
        }
        return false;
    }
}
