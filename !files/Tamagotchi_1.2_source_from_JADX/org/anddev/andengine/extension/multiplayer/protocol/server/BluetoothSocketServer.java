package org.anddev.andengine.extension.multiplayer.protocol.server;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import java.io.IOException;
import java.util.UUID;
import org.anddev.andengine.extension.multiplayer.protocol.exception.BluetoothException;
import org.anddev.andengine.extension.multiplayer.protocol.server.Server.IServerListener;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.BluetoothSocketConnectionClientConnector.DefaultBluetoothSocketClientConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector.IClientConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.shared.BluetoothSocketConnection;
import org.anddev.andengine.extension.multiplayer.protocol.util.Bluetooth;
import org.anddev.andengine.util.Debug;

public abstract class BluetoothSocketServer<CC extends ClientConnector<BluetoothSocketConnection>> extends Server<BluetoothSocketConnection, CC> {
    private BluetoothServerSocket mBluetoothServerSocket;
    private final String mUUID;

    public interface IBluetoothSocketServerListener<CC extends ClientConnector<BluetoothSocketConnection>> extends IServerListener<BluetoothSocketServer<CC>> {

        public static class DefaultBluetoothSocketServerListener<CC extends ClientConnector<BluetoothSocketConnection>> implements IBluetoothSocketServerListener<CC> {
            public void onStarted(BluetoothSocketServer<CC> pBluetoothSocketServer) {
                Debug.m59d("Server started on port: " + pBluetoothSocketServer.getUUID());
            }

            public void onTerminated(BluetoothSocketServer<CC> pBluetoothSocketServer) {
                Debug.m59d("Server terminated on port: " + pBluetoothSocketServer.getUUID());
            }

            public void onException(BluetoothSocketServer<CC> bluetoothSocketServer, Throwable pThrowable) {
                Debug.m63e(pThrowable);
            }
        }

        void onException(BluetoothSocketServer<CC> bluetoothSocketServer, Throwable th);

        void onStarted(BluetoothSocketServer<CC> bluetoothSocketServer);

        void onTerminated(BluetoothSocketServer<CC> bluetoothSocketServer);
    }

    protected abstract CC newClientConnector(BluetoothSocketConnection bluetoothSocketConnection) throws IOException;

    public BluetoothSocketServer(String pUUID) throws BluetoothException {
        this(pUUID, new DefaultBluetoothSocketClientConnectorListener());
    }

    public BluetoothSocketServer(String pUUID, IClientConnectorListener<BluetoothSocketConnection> pClientConnectorListener) throws BluetoothException {
        this(pUUID, pClientConnectorListener, new DefaultBluetoothSocketServerListener());
    }

    public BluetoothSocketServer(String pUUID, IBluetoothSocketServerListener<CC> pBluetoothSocketServerListener) throws BluetoothException {
        this(pUUID, new DefaultBluetoothSocketClientConnectorListener(), pBluetoothSocketServerListener);
    }

    public BluetoothSocketServer(String pUUID, IClientConnectorListener<BluetoothSocketConnection> pClientConnectorListener, IBluetoothSocketServerListener<CC> pBluetoothSocketServerListener) throws BluetoothException {
        super(pClientConnectorListener, pBluetoothSocketServerListener);
        this.mUUID = pUUID;
        if (!Bluetooth.isSupportedByAndroidVersion()) {
            throw new BluetoothException();
        }
    }

    public String getUUID() {
        return this.mUUID;
    }

    public IBluetoothSocketServerListener<CC> getServerListener() {
        return (IBluetoothSocketServerListener) super.getServerListener();
    }

    protected void onStart() throws IOException {
        this.mBluetoothServerSocket = BluetoothAdapter.getDefaultAdapter().listenUsingRfcommWithServiceRecord(getClass().getName(), UUID.fromString(this.mUUID));
    }

    protected CC acceptClientConnector() throws IOException {
        try {
            return newClientConnector(new BluetoothSocketConnection(this.mBluetoothServerSocket.accept()));
        } catch (BluetoothException e) {
            return null;
        }
    }

    public void onTerminate() {
        try {
            this.mBluetoothServerSocket.close();
        } catch (Throwable e) {
            Debug.m63e(e);
        }
        getServerListener().onTerminated(this);
    }

    protected void onException(Throwable pThrowable) {
        getServerListener().onException(this, pThrowable);
    }
}
