package org.anddev.andengine.extension.multiplayer.protocol.server.connector;

import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.server.IClientMessageReader;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector.IClientConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.shared.SocketConnection;
import org.anddev.andengine.util.Debug;

public class SocketConnectionClientConnector extends ClientConnector<SocketConnection> {

    public interface ISocketConnectionClientConnectorListener extends IClientConnectorListener<SocketConnection> {
    }

    public static class DefaultSocketConnectionClientConnectorListener implements ISocketConnectionClientConnectorListener {
        public void onStarted(ClientConnector<SocketConnection> pClientConnector) {
            Debug.m59d("Accepted Client-Connection from: '" + ((SocketConnection) pClientConnector.getConnection()).getSocket().getInetAddress().getHostAddress());
        }

        public void onTerminated(ClientConnector<SocketConnection> pClientConnector) {
            Debug.m59d("Closed Client-Connection from: '" + ((SocketConnection) pClientConnector.getConnection()).getSocket().getInetAddress().getHostAddress());
        }
    }

    public SocketConnectionClientConnector(SocketConnection pSocketConnection) throws IOException {
        super(pSocketConnection);
    }

    public SocketConnectionClientConnector(SocketConnection pSocketConnection, IClientMessageReader<SocketConnection> pClientMessageReader) throws IOException {
        super(pSocketConnection, pClientMessageReader);
    }
}
