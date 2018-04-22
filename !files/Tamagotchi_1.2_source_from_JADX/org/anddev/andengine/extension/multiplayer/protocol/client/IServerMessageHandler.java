package org.anddev.andengine.extension.multiplayer.protocol.client;

import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.adt.message.server.IServerMessage;
import org.anddev.andengine.extension.multiplayer.protocol.client.connector.ServerConnector;
import org.anddev.andengine.extension.multiplayer.protocol.shared.Connection;
import org.anddev.andengine.extension.multiplayer.protocol.shared.IMessageHandler;

public interface IServerMessageHandler<C extends Connection> extends IMessageHandler<C, ServerConnector<C>, IServerMessage> {
    void onHandleMessage(ServerConnector<C> serverConnector, IServerMessage iServerMessage) throws IOException;
}
