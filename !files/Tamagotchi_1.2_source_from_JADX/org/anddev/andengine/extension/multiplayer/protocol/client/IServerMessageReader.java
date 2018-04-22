package org.anddev.andengine.extension.multiplayer.protocol.client;

import java.io.DataInputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.IServerMessage;
import org.anddev.andengine.extension.multiplayer.protocol.client.connector.ServerConnector;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connection;
import org.anddev.andengine.extension.multiplayer.protocol.shared.IMessageHandler;
import org.anddev.andengine.extension.multiplayer.protocol.shared.IMessageReader;
import org.anddev.andengine.extension.multiplayer.protocol.shared.MessageReader;

public interface IServerMessageReader<C extends Connection> extends IMessageReader<C, ServerConnector<C>, IServerMessage> {

    public static class ServerMessageReader<C extends Connection> extends MessageReader<C, ServerConnector<C>, IServerMessage> implements IServerMessageReader<C> {
        public /* bridge */ /* synthetic */ void handleMessage(ServerConnector serverConnector, IServerMessage iServerMessage) throws IOException {
            handleMessage(serverConnector, iServerMessage);
        }

        public /* bridge */ /* synthetic */ IServerMessage readMessage(DataInputStream dataInputStream) throws IOException {
            return (IServerMessage) readMessage(dataInputStream);
        }

        public /* bridge */ /* synthetic */ void recycleMessage(IServerMessage iServerMessage) {
            recycleMessage(iServerMessage);
        }
    }

    void handleMessage(ServerConnector<C> serverConnector, IServerMessage iServerMessage) throws IOException;

    IServerMessage readMessage(DataInputStream dataInputStream) throws IOException;

    void recycleMessage(IServerMessage iServerMessage);

    void registerMessage(short s, Class<? extends IServerMessage> cls);

    void registerMessage(short s, Class<? extends IServerMessage> cls, IMessageHandler<C, ServerConnector<C>, IServerMessage> iMessageHandler);

    void registerMessageHandler(short s, IMessageHandler<C, ServerConnector<C>, IServerMessage> iMessageHandler);
}
