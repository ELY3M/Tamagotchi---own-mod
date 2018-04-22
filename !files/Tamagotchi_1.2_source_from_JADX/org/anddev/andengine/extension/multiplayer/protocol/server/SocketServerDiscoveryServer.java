package org.anddev.andengine.extension.multiplayer.protocol.server;

import android.os.Process;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.anddev.andengine.extension.multiplayer.protocol.shared.IDiscoveryData;
import org.anddev.andengine.extension.multiplayer.protocol.shared.IDiscoveryData.DiscoveryDataFactory;
import org.anddev.andengine.util.ArrayUtils;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.SocketUtils;

public abstract class SocketServerDiscoveryServer<T extends IDiscoveryData> extends Thread {
    public static final int DISCOVERYPORT_DEFAULT = 9999;
    public static final byte[] MAGIC_IDENTIFIER = new byte[]{(byte) 65, (byte) 110, (byte) 100, (byte) 69, (byte) 110, (byte) 103, (byte) 105, (byte) 110, (byte) 101, (byte) 45, (byte) 83, (byte) 111, (byte) 99, (byte) 107, (byte) 101, (byte) 116, (byte) 83, (byte) 101, (byte) 114, (byte) 118, (byte) 101, (byte) 114, (byte) 68, (byte) 105, (byte) 115, (byte) 99, (byte) 111, (byte) 118, (byte) 101, (byte) 114, (byte) 121};
    private DatagramSocket mDatagramSocket;
    private final int mDiscoveryPort;
    private final byte[] mDiscoveryRequestData;
    private final DatagramPacket mDiscoveryRequestDatagramPacket;
    protected AtomicBoolean mRunning;
    protected ISocketServerDiscoveryServerListener<T> mSocketServerDiscoveryServerListener;
    protected AtomicBoolean mTerminated;

    public interface ISocketServerDiscoveryServerListener<T extends IDiscoveryData> {

        public static class DefaultSocketServerDiscoveryServerListener<T extends IDiscoveryData> implements ISocketServerDiscoveryServerListener<T> {
            public void onStarted(SocketServerDiscoveryServer<T> pSocketServerDiscoveryServer) {
                Debug.m59d("SocketServerDiscoveryServer started on discoveryPort: " + pSocketServerDiscoveryServer.getDiscoveryPort());
            }

            public void onTerminated(SocketServerDiscoveryServer<T> pSocketServerDiscoveryServer) {
                Debug.m59d("SocketServerDiscoveryServer terminated on discoveryPort: " + pSocketServerDiscoveryServer.getDiscoveryPort());
            }

            public void onDiscovered(SocketServerDiscoveryServer<T> socketServerDiscoveryServer, InetAddress pInetAddress, int pPort) {
                Debug.m59d("SocketServerDiscoveryServer discovered by: " + pInetAddress.getHostAddress() + ":" + pPort);
            }

            public void onException(SocketServerDiscoveryServer<T> socketServerDiscoveryServer, Throwable pThrowable) {
                Debug.m63e(pThrowable);
            }
        }

        void onDiscovered(SocketServerDiscoveryServer<T> socketServerDiscoveryServer, InetAddress inetAddress, int i);

        void onException(SocketServerDiscoveryServer<T> socketServerDiscoveryServer, Throwable th);

        void onStarted(SocketServerDiscoveryServer<T> socketServerDiscoveryServer);

        void onTerminated(SocketServerDiscoveryServer<T> socketServerDiscoveryServer);
    }

    protected abstract T onCreateDiscoveryResponse();

    public SocketServerDiscoveryServer() {
        this((int) DISCOVERYPORT_DEFAULT);
    }

    public SocketServerDiscoveryServer(int pDiscoveryPort) {
        this(pDiscoveryPort, new DefaultSocketServerDiscoveryServerListener());
    }

    public SocketServerDiscoveryServer(ISocketServerDiscoveryServerListener<T> pSocketServerDiscoveryServerListener) {
        this(DISCOVERYPORT_DEFAULT, pSocketServerDiscoveryServerListener);
    }

    public SocketServerDiscoveryServer(int pDiscoveryPort, ISocketServerDiscoveryServerListener<T> pSocketServerDiscoveryServerListener) {
        this.mDiscoveryRequestData = new byte[1024];
        this.mDiscoveryRequestDatagramPacket = new DatagramPacket(this.mDiscoveryRequestData, this.mDiscoveryRequestData.length);
        this.mRunning = new AtomicBoolean(false);
        this.mTerminated = new AtomicBoolean(false);
        this.mDiscoveryPort = pDiscoveryPort;
        this.mSocketServerDiscoveryServerListener = pSocketServerDiscoveryServerListener;
        initName();
    }

    private void initName() {
        setName(getClass().getName());
    }

    public boolean isRunning() {
        return this.mRunning.get();
    }

    public boolean isTerminated() {
        return this.mTerminated.get();
    }

    public int getDiscoveryPort() {
        return this.mDiscoveryPort;
    }

    public boolean hasSocketServerDiscoveryServerListener() {
        return this.mSocketServerDiscoveryServerListener != null;
    }

    public ISocketServerDiscoveryServerListener<T> getSocketServerDiscoveryServerListener() {
        return this.mSocketServerDiscoveryServerListener;
    }

    public void run() {
        try {
            onStart();
            this.mRunning.set(true);
            Process.setThreadPriority(1);
            while (!Thread.interrupted() && this.mRunning.get() && !this.mTerminated.get()) {
                this.mDatagramSocket.receive(this.mDiscoveryRequestDatagramPacket);
                if (verifyDiscoveryRequest(this.mDiscoveryRequestDatagramPacket)) {
                    onDiscovered(this.mDiscoveryRequestDatagramPacket);
                    sendDiscoveryResponse(this.mDiscoveryRequestDatagramPacket);
                }
            }
            terminate();
        } catch (Throwable pThrowable) {
            try {
                onException(pThrowable);
            } finally {
                terminate();
            }
        }
    }

    protected void finalize() throws Throwable {
        terminate();
        super.finalize();
    }

    protected boolean verifyDiscoveryRequest(DatagramPacket pDiscoveryRequest) {
        return ArrayUtils.equals(MAGIC_IDENTIFIER, 0, pDiscoveryRequest.getData(), pDiscoveryRequest.getOffset(), MAGIC_IDENTIFIER.length);
    }

    protected void onDiscovered(DatagramPacket pDiscoveryRequest) throws IOException {
        this.mSocketServerDiscoveryServerListener.onDiscovered(this, pDiscoveryRequest.getAddress(), pDiscoveryRequest.getPort());
    }

    protected void sendDiscoveryResponse(DatagramPacket pDatagramPacket) throws IOException {
        byte[] discoveryResponseData = DiscoveryDataFactory.write(onCreateDiscoveryResponse());
        this.mDatagramSocket.send(new DatagramPacket(discoveryResponseData, discoveryResponseData.length, pDatagramPacket.getAddress(), pDatagramPacket.getPort()));
    }

    protected void onStart() throws SocketException {
        this.mDatagramSocket = new DatagramSocket(this.mDiscoveryPort);
        this.mSocketServerDiscoveryServerListener.onStarted(this);
    }

    protected void onTerminate() {
        SocketUtils.closeSocket(this.mDatagramSocket);
        this.mSocketServerDiscoveryServerListener.onTerminated(this);
    }

    protected void onException(Throwable pThrowable) {
        this.mSocketServerDiscoveryServerListener.onException(this, pThrowable);
    }

    public void terminate() {
        if (!this.mTerminated.getAndSet(true)) {
            this.mRunning.set(false);
            interrupt();
            onTerminate();
        }
    }
}
