package org.anddev.andengine.extension.multiplayer.protocol.adt.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class CharMessage extends Message {
    protected char mChar;

    public CharMessage(char pChar) {
        this.mChar = pChar;
    }

    public CharMessage(DataInputStream pDataInputStream) throws IOException {
        read(pDataInputStream);
    }

    public char getChar() {
        return this.mChar;
    }

    public void read(DataInputStream pDataInputStream) throws IOException {
        this.mChar = pDataInputStream.readChar();
    }

    protected void onAppendTransmissionDataForToString(StringBuilder pStringBuilder) {
        pStringBuilder.append(", getChar()=").append('\'').append(getChar()).append('\'');
    }

    public void onWriteTransmissionData(DataOutputStream pDataOutputStream) throws IOException {
        pDataOutputStream.writeChar(getChar());
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
        CharMessage other = (CharMessage) obj;
        if (getFlag() == other.getFlag() && getChar() == other.getChar()) {
            return true;
        }
        return false;
    }
}
