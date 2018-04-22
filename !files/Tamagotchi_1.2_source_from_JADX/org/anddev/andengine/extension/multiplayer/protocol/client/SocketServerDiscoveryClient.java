package org.anddev.andengine.extension.multiplayer.protocol.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.anddev.andengine.extension.multiplayer.protocol.server.SocketServerDiscoveryServer;
import org.anddev.andengine.extension.multiplayer.protocol.shared.IDiscoveryData;
import org.anddev.andengine.extension.multiplayer.protocol.shared.IDiscoveryData.DiscoveryDataFactory;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.SocketUtils;
import org.anddev.andengine.util.pool.GenericPool;

public class SocketServerDiscoveryClient<T extends IDiscoveryData> {
    public static final int LOCALPORT_DEFAULT = 9998;
    protected static final int TIMEOUT_DEFAULT = 5000;
    private final InetAddress mDiscoveryBroadcastInetAddress;
    private final GenericPool<T> mDiscoveryDataPool;
    private final int mDiscoveryPort;
    private final DatagramPacket mDiscoveryRequestDatagramPacket;
    private final byte[] mDiscoveryResponseData;
    private final DatagramPacket mDiscoveryResponseDatagramPacket;
    private final ExecutorService mExecutorService;
    private final int mLocalPort;
    private final ISocketServerDiscoveryClientListener<T> mSocketServerDiscoveryClientListener;
    protected AtomicBoolean mTerminated;
    private int mTimeout;

    class C05942 implements Runnable {
        C05942() {
        }

        public void run() {
            SocketServerDiscoveryClient.this.discover();
        }
    }

    public interface ISocketServerDiscoveryClientListener<T extends IDiscoveryData> {
        void onDiscovery(SocketServerDiscoveryClient<T> socketServerDiscoveryClient, T t);

        void onException(SocketServerDiscoveryClient<T> socketServerDiscoveryClient, Throwable th);

        void onTimeout(SocketServerDiscoveryClient<T> socketServerDiscoveryClient, SocketTimeoutException socketTimeoutException);
    }

    public SocketServerDiscoveryClient(byte[] pDiscoveryBroadcastIPAddress, Class<? extends T> pDiscoveryDataClass, ISocketServerDiscoveryClientListener<T> pSocketServerDiscoveryClientListener) throws UnknownHostException {
        this(pDiscoveryBroadcastIPAddress, SocketServerDiscoveryServer.DISCOVERYPORT_DEFAULT, LOCALPORT_DEFAULT, pDiscoveryDataClass, pSocketServerDiscoveryClientListener);
    }

    public SocketServerDiscoveryClient(byte[] pDiscoveryBroadcastIPAddress, int pDiscoveryPort, Class<? extends T> pDiscoveryDataClass, ISocketServerDiscoveryClientListener<T> pSocketServerDiscoveryClientListener) throws UnknownHostException {
        this(pDiscoveryBroadcastIPAddress, pDiscoveryPort, LOCALPORT_DEFAULT, pDiscoveryDataClass, pSocketServerDiscoveryClientListener);
    }

    public SocketServerDiscoveryClient(byte[] pDiscoveryBroadcastIPAddress, int pDiscoveryPort, int pLocalPort, final Class<? extends T> pDiscoveryDataClass, ISocketServerDiscoveryClientListener<T> pSocketServerDiscoveryClientListener) throws UnknownHostException {
        this.mTerminated = new AtomicBoolean(false);
        this.mTimeout = 5000;
        this.mExecutorService = Executors.newSingleThreadExecutor();
        this.mDiscoveryResponseData = new byte[1024];
        this.mDiscoveryResponseDatagramPacket = new DatagramPacket(this.mDiscoveryResponseData, this.mDiscoveryResponseData.length);
        this.mDiscoveryPort = pDiscoveryPort;
        this.mLocalPort = pLocalPort;
        this.mSocketServerDiscoveryClientListener = pSocketServerDiscoveryClientListener;
        this.mDiscoveryBroadcastInetAddress = InetAddress.getByAddress(pDiscoveryBroadcastIPAddress);
        byte[] out = SocketServerDiscoveryServer.MAGIC_IDENTIFIER;
        this.mDiscoveryRequestDatagramPacket = new DatagramPacket(out, out.length, this.mDiscoveryBroadcastInetAddress, this.mDiscoveryPort);
        this.mDiscoveryDataPool = new GenericPool<T>() {
            protected T onAllocatePoolItem() {
                try {
                    return (IDiscoveryData) pDiscoveryDataClass.newInstance();
                } catch (Throwable t) {
                    Debug.m63e(t);
                    return null;
                }
            }
        };
    }

    public int getDiscoveryPort() {
        return this.mDiscoveryPort;
    }

    public int getLocalPort() {
        return this.mLocalPort;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public void setTimeout(int pTimeout) {
        this.mTimeout = pTimeout;
    }

    public InetAddress getDiscoveryBroadcastInetAddress() {
        return this.mDiscoveryBroadcastInetAddress;
    }

    public void discoverAsync() throws IllegalStateException {
        if (this.mTerminated.get()) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(getClass().getSimpleName())).append(" was already terminated.").toString());
        }
        this.mExecutorService.execute(new C05942());
    }

    private void discover() {
        SocketTimeoutException t;
        Throwable th;
        Throwable t2;
        DatagramSocket datagramSocket = null;
        try {
            DatagramSocket datagramSocket2 = new DatagramSocket(this.mLocalPort);
            try {
                datagramSocket2.setBroadcast(true);
                sendDiscoveryRequest(datagramSocket2);
                handleDiscoveryResponseData(receiveDiscoveryResponseData(datagramSocket2));
                SocketUtils.closeSocket(datagramSocket2);
                datagramSocket = datagramSocket2;
            } catch (SocketTimeoutException e) {
                t = e;
                datagramSocket = datagramSocket2;
                try {
                    this.mSocketServerDiscoveryClientListener.onTimeout(this, t);
                    SocketUtils.closeSocket(datagramSocket);
                } catch (Throwable th2) {
                    th = th2;
                    SocketUtils.closeSocket(datagramSocket);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                datagramSocket = datagramSocket2;
                SocketUtils.closeSocket(datagramSocket);
                throw th;
            }
        } catch (SocketTimeoutException e2) {
            t = e2;
            this.mSocketServerDiscoveryClientListener.onTimeout(this, t);
            SocketUtils.closeSocket(datagramSocket);
        } catch (Throwable th4) {
            t2 = th4;
            this.mSocketServerDiscoveryClientListener.onException(this, t2);
            SocketUtils.closeSocket(datagramSocket);
        }
    }

    private void sendDiscoveryRequest(DatagramSocket datagramSocket) throws IOException {
        datagramSocket.send(this.mDiscoveryRequestDatagramPacket);
    }

    protected byte[] receiveDiscoveryResponseData(DatagramSocket datagramSocket) throws SocketException, IOException {
        datagramSocket.setSoTimeout(this.mTimeout);
        datagramSocket.receive(this.mDiscoveryResponseDatagramPacket);
        byte[] discoveryResponseData = new byte[this.mDiscoveryResponseDatagramPacket.getLength()];
        System.arraycopy(this.mDiscoveryResponseDatagramPacket.getData(), this.mDiscoveryResponseDatagramPacket.getOffset(), discoveryResponseData, 0, this.mDiscoveryResponseDatagramPacket.getLength());
        return discoveryResponseData;
    }

    private void handleDiscoveryResponseData(byte[] pDiscoveryResponseData) {
        IDiscoveryData discoveryResponse = (IDiscoveryData) this.mDiscoveryDataPool.obtainPoolItem();
        try {
            DiscoveryDataFactory.read(pDiscoveryResponseData, discoveryResponse);
            this.mSocketServerDiscoveryClientListener.onDiscovery(this, discoveryResponse);
        } catch (Throwable t) {
            this.mSocketServerDiscoveryClientListener.onException(this, t);
        }
        this.mDiscoveryDataPool.recyclePoolItem(discoveryResponse);
    }

    public void terminate() {
        if (!this.mTerminated.getAndSet(true)) {
            onTerminate();
        }
    }

    private void onTerminate() {
        this.mExecutorService.shutdownNow();
    }
}
