package org.anddev.andengine.extension.multiplayer.protocol.server;

import java.io.DataInputStream;
import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.client.IClientMessage;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connection;
import org.anddev.andengine.extension.multiplayer.protocol.shared.IMessageHandler;
import org.anddev.andengine.extension.multiplayer.protocol.shared.IMessageReader;
import org.anddev.andengine.extension.multiplayer.protocol.shared.MessageReader;

public interface IClientMessageReader<C extends Connection> extends IMessageReader<C, ClientConnector<C>, IClientMessage> {

    public static class ClientMessageReader<C extends Connection> extends MessageReader<C, ClientConnector<C>, IClientMessage> implements IClientMessageReader<C> {
        public /* bridge */ /* synthetic */ void handleMessage(ClientConnector clientConnector, IClientMessage iClientMessage) throws IOException {
            handleMessage(clientConnector, iClientMessage);
        }

        public /* bridge */ /* synthetic */ IClientMessage readMessage(DataInputStream dataInputStream) throws IOException {
            return (IClientMessage) readMessage(dataInputStream);
        }

        public /* bridge */ /* synthetic */ void recycleMessage(IClientMessage iClientMessage) {
            recycleMessage(iClientMessage);
        }
    }

    void handleMessage(ClientConnector<C> clientConnector, IClientMessage iClientMessage) throws IOException;

    IClientMessage readMessage(DataInputStream dataInputStream) throws IOException;

    void recycleMessage(IClientMessage iClientMessage);

    void registerMessage(short s, Class<? extends IClientMessage> cls);

    void registerMessage(short s, Class<? extends IClientMessage> cls, IMessageHandler<C, ClientConnector<C>, IClientMessage> iMessageHandler);

    void registerMessageHandler(short s, IMessageHandler<C, ClientConnector<C>, IClientMessage> iMessageHandler);
}
