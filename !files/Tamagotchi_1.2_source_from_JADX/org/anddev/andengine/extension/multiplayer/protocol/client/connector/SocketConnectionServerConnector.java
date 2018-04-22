package org.anddev.andengine.extension.multiplayer.protocol.client.connector;

import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.client.IServerMessageReader;
import org.anddev.andengine.extension.multiplayer.protocol.client.connector.ServerConnector.IServerConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.shared.SocketConnection;
import org.anddev.andengine.util.Debug;

public class SocketConnectionServerConnector extends ServerConnector<SocketConnection> {

    public interface ISocketConnectionServerConnectorListener extends IServerConnectorListener<SocketConnection> {
    }

    public static class DefaultSocketConnectionServerConnectorListener implements ISocketConnectionServerConnectorListener {
        public void onStarted(ServerConnector<SocketConnection> pServerConnector) {
            Debug.m59d("Accepted Server-Connection from: '" + ((SocketConnection) pServerConnector.getConnection()).getSocket().getInetAddress().getHostAddress());
        }

        public void onTerminated(ServerConnector<SocketConnection> pServerConnector) {
            Debug.m59d("Closed Server-Connection from: '" + ((SocketConnection) pServerConnector.getConnection()).getSocket().getInetAddress().getHostAddress());
        }
    }

    public SocketConnectionServerConnector(SocketConnection pConnection, ISocketConnectionServerConnectorListener pSocketConnectionServerConnectorListener) throws IOException {
        super(pConnection, pSocketConnectionServerConnectorListener);
    }

    public SocketConnectionServerConnector(SocketConnection pConnection, IServerMessageReader<SocketConnection> pServerMessageReader, ISocketConnectionServerConnectorListener pSocketConnectionServerConnectorListener) throws IOException {
        super(pConnection, pServerMessageReader, pSocketConnectionServerConnectorListener);
    }
}
