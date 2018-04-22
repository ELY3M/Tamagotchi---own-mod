package org.anddev.andengine.extension.multiplayer.protocol.adt.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface IMessage {
    short getFlag();

    void read(DataInputStream dataInputStream) throws IOException;

    void write(DataOutputStream dataOutputStream) throws IOException;
}
