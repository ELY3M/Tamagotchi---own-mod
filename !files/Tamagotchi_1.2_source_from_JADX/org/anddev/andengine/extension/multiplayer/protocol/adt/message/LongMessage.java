package org.anddev.andengine.extension.multiplayer.protocol.adt.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class LongMessage extends Message {
    protected long mLong;

    public LongMessage(long pLong) {
        this.mLong = pLong;
    }

    public LongMessage(DataInputStream pDataInputStream) throws IOException {
        read(pDataInputStream);
    }

    public long getLong() {
        return this.mLong;
    }

    public void read(DataInputStream pDataInputStream) throws IOException {
        this.mLong = pDataInputStream.readLong();
    }

    protected void onAppendTransmissionDataForToString(StringBuilder pStringBuilder) {
        pStringBuilder.append(", getLong()=").append(getLong());
    }

    public void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
        pDataOutputStream.writeLong(getLong());
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
        LongMessage other = (LongMessage) obj;
        if (getFlag() == other.getFlag() && getLong() == other.getLong()) {
            return true;
        }
        return false;
    }
}
