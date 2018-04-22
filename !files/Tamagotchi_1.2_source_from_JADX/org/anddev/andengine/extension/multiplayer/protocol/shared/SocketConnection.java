package org.anddev.andengine.extension.multiplayer.protocol.shared;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import org.anddev.andengine.util.SocketUtils;

public class SocketConnection extends Connection {
    private final Socket mSocket;

    public static SocketConnection create(byte[] pIPAddress, int pPort, int pTimeoutMilliseconds) throws IOException {
        return create(new InetSocketAddress(InetAddress.getByAddress(pIPAddress), pPort), pTimeoutMilliseconds);
    }

    public static SocketConnection create(SocketAddress pSocketAddress, int pTimeoutMilliseconds) throws IOException {
        Socket socket = new Socket();
        socket.connect(pSocketAddress, pTimeoutMilliseconds);
        return new SocketConnection(socket);
    }

    public SocketConnection(Socket pSocket) throws IOException {
        super(new DataInputStream(pSocket.getInputStream()), new DataOutputStream(pSocket.getOutputStream()));
        this.mSocket = pSocket;
    }

    public Socket getSocket() {
        return this.mSocket;
    }

    protected void onTerminate() {
        SocketUtils.closeSocket(this.mSocket);
        super.onTerminate();
    }
}
