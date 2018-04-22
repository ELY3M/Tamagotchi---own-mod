package org.anddev.andengine.extension.multiplayer.protocol.server;

import java.io.IOException;
import java.net.ServerSocket;
import javax.net.ServerSocketFactory;
import org.anddev.andengine.extension.multiplayer.protocol.server.Server.IServerListener;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector.IClientConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.SocketConnectionClientConnector.DefaultSocketConnectionClientConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.shared.SocketConnection;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.SocketUtils;

public abstract class SocketServer<CC extends ClientConnector<SocketConnection>> extends Server<SocketConnection, CC> {
    private final int mPort;
    private ServerSocket mServerSocket;

    public interface ISocketServerListener<CC extends ClientConnector<SocketConnection>> extends IServerListener<SocketServer<CC>> {

        public static class DefaultSocketServerListener<CC extends ClientConnector<SocketConnection>> implements ISocketServerListener<CC> {
            public void onStarted(SocketServer<CC> pSocketServer) {
                Debug.m59d("SocketServer started on port: " + pSocketServer.getPort());
            }

            public void onTerminated(SocketServer<CC> pSocketServer) {
                Debug.m59d("SocketServer terminated on port: " + pSocketServer.getPort());
            }

            public void onException(SocketServer<CC> socketServer, Throwable pThrowable) {
                Debug.m63e(pThrowable);
            }
        }

        void onException(SocketServer<CC> socketServer, Throwable th);

        void onStarted(SocketServer<CC> socketServer);

        void onTerminated(SocketServer<CC> socketServer);
    }

    protected abstract CC newClientConnector(SocketConnection socketConnection) throws IOException;

    public SocketServer(int pPort) {
        this(pPort, new DefaultSocketConnectionClientConnectorListener());
    }

    public SocketServer(int pPort, IClientConnectorListener<SocketConnection> pClientConnectorListener) {
        this(pPort, pClientConnectorListener, new DefaultSocketServerListener());
    }

    public SocketServer(int pPort, ISocketServerListener<CC> pSocketServerListener) {
        this(pPort, new DefaultSocketConnectionClientConnectorListener(), pSocketServerListener);
    }

    public SocketServer(int pPort, IClientConnectorListener<SocketConnection> pClientConnectorListener, ISocketServerListener<CC> pSocketServerListener) {
        super(pClientConnectorListener, pSocketServerListener);
        if (pPort < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal port '< 0'.");
            onException(illegalArgumentException);
            throw illegalArgumentException;
        }
        this.mPort = pPort;
    }

    public int getPort() {
        return this.mPort;
    }

    public ISocketServerListener<CC> getServerListener() {
        return (ISocketServerListener) super.getServerListener();
    }

    public void setSocketServerListener(ISocketServerListener<CC> pSocketServerListener) {
        super.setServerListener(pSocketServerListener);
    }

    protected void onStart() throws IOException {
        this.mServerSocket = ServerSocketFactory.getDefault().createServerSocket(this.mPort);
        getServerListener().onStarted(this);
    }

    protected CC acceptClientConnector() throws IOException {
        return newClientConnector(new SocketConnection(this.mServerSocket.accept()));
    }

    protected void onTerminate() {
        SocketUtils.closeSocket(this.mServerSocket);
        getServerListener().onTerminated(this);
    }

    protected void onException(Throwable pThrowable) {
        getServerListener().onException(this, pThrowable);
    }
}
