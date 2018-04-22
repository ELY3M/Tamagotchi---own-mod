package org.anddev.andengine.extension.multiplayer.protocol.server.connector;

import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.exception.BluetoothException;
import org.anddev.andengine.extension.multiplayer.protocol.server.IClientMessageReader;
import org.anddev.andengine.extension.multiplayer.protocol.server.connector.ClientConnector.IClientConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.shared.BluetoothSocketConnection;
import org.anddev.andengine.extension.multiplayer.protocol.util.Bluetooth;
import org.anddev.andengine.util.Debug;

public class BluetoothSocketConnectionClientConnector extends ClientConnector<BluetoothSocketConnection> {

    public interface IBluetoothSocketConnectionClientConnectorListener extends IClientConnectorListener<BluetoothSocketConnection> {
    }

    public static class DefaultBluetoothSocketClientConnectorListener implements IBluetoothSocketConnectionClientConnectorListener {
        public void onStarted(ClientConnector<BluetoothSocketConnection> pClientConnector) {
            Debug.m59d("Accepted Client-Connection from: '" + ((BluetoothSocketConnection) pClientConnector.getConnection()).getBluetoothSocket().getRemoteDevice().getAddress());
        }

        public void onTerminated(ClientConnector<BluetoothSocketConnection> pClientConnector) {
            Debug.m59d("Closed Client-Connection from: '" + ((BluetoothSocketConnection) pClientConnector.getConnection()).getBluetoothSocket().getRemoteDevice().getAddress());
        }
    }

    public BluetoothSocketConnectionClientConnector(BluetoothSocketConnection pBluetoothSocketConnection) throws IOException, BluetoothException {
        super(pBluetoothSocketConnection);
        if (!Bluetooth.isSupportedByAndroidVersion()) {
            throw new BluetoothException();
        }
    }

    public BluetoothSocketConnectionClientConnector(BluetoothSocketConnection pBluetoothSocketConnection, IClientMessageReader<BluetoothSocketConnection> pClientMessageReader) throws IOException, BluetoothException {
        super(pBluetoothSocketConnection, pClientMessageReader);
        if (!Bluetooth.isSupportedByAndroidVersion()) {
            throw new BluetoothException();
        }
    }
}
