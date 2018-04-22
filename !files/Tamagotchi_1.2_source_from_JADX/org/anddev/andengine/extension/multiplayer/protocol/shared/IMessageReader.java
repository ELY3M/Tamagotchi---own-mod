package org.anddev.andengine.extension.multiplayer.protocol.shared;

import java.io.DataInputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.IMessage;

public interface IMessageReader<C extends Connection, CC extends Connector<C>, M extends IMessage> {
    void handleMessage(CC cc, M m) throws IOException;

    M readMessage(DataInputStream dataInputStream) throws IOException;

    void recycleMessage(M m);

    void registerMessage(short s, Class<? extends M> cls);

    void registerMessage(short s, Class<? extends M> cls, IMessageHandler<C, CC, M> iMessageHandler);

    void registerMessageHandler(short s, IMessageHandler<C, CC, M> iMessageHandler);
}
