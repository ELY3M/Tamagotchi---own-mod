package org.anddev.andengine.extension.multiplayer.protocol.server;

import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.client.IClientMessage;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connection;
import org.anddev.andengine.extension.multiplayer.protocol.shared.IMessageHandler;

public interface IClientMessageHandler<C extends Connection> extends IMessageHandler<C, ClientConnector<C>, IClientMessage> {
    void onHandleMessage(ClientConnector<C> clientConnector, IClientMessage iClientMessage) throws IOException;
}
