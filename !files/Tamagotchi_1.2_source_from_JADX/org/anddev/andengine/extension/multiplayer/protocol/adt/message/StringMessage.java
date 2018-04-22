package org.anddev.andengine.extension.multiplayer.protocol.adt.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class StringMessage extends Message {
    protected String mString;

    public StringMessage(String pString) {
        this.mString = pString;
    }

    public StringMessage(DataInputStream pDataInputStream) throws IOException {
        read(pDataInputStream);
    }

    public String getString() {
        return this.mString;
    }

    public void read(DataInputStream pDataInputStream) throws IOException {
        this.mString = pDataInputStream.readUTF();
    }

    protected void onAppendTransmissionDataForToString(StringBuilder pStringBuilder) {
        pStringBuilder.append(", getString()=").append('\"').append(getString()).append('\"');
    }

    public void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
        pDataOutputStream.writeUTF(getString());
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
        StringMessage other = (StringMessage) obj;
        if (getFlag() == other.getFlag() && getString() == other.getString()) {
            return true;
        }
        return false;
    }
}
