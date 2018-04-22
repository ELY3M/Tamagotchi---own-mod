package org.anddev.andengine.extension.multiplayer.protocol.client.connector;

import java.io.IOException;
import org.anddev.andengine.extension.multiplayer.protocol.client.IServerMessageReader;
import org.anddev.andengine.extension.multiplayer.protocol.client.connector.ServerConnector.IServerConnectorListener;
import org.anddev.andengine.extension.multiplayer.protocol.shared.BluetoothSocketConnection;
import org.anddev.andengine.util.Debug;

public class BluetoothSocketConnectionServerConnector extends ServerConnector<BluetoothSocketConnection> {

    public interface IBluetoothSocketConnectionServerConnectorListener extends IServerConnectorListener<BluetoothSocketConnection> {
    }

    public static class DefaultBluetoothConnectionSocketServerConnectorListener implements IBluetoothSocketConnectionServerConnectorListener {
        public void onStarted(ServerConnector<BluetoothSocketConnection> pServerConnector) {
            Debug.m59d("Accepted Server-Connection from: '" + ((BluetoothSocketConnection) pServerConnector.getConnection()).getBluetoothSocket().getRemoteDevice().getAddress());
        }

        public void onTerminated(ServerConnector<BluetoothSocketConnection> pServerConnector) {
            Debug.m59d("Closed Server-Connection from: '" + ((BluetoothSocketConnection) pServerConnector.getConnection()).getBluetoothSocket().getRemoteDevice().getAddress());
        }
    }

    public BluetoothSocketConnectionServerConnector(BluetoothSocketConnection pBluetoothSocketConnection, IBluetoothSocketConnectionServerConnectorListener pBlutetoothSocketConnectionServerConnectorListener) throws IOException {
        super(pBluetoothSocketConnection, pBlutetoothSocketConnectionServerConnectorListener);
    }

    public BluetoothSocketConnectionServerConnector(BluetoothSocketConnection pBluetoothSocketConnection, IServerMessageReader<BluetoothSocketConnection> pServerMessageReader, IBluetoothSocketConnectionServerConnectorListener pBlutetoothSocketConnectionServerConnectorListener) throws IOException {
        super(pBluetoothSocketConnection, pServerMessageReader, pBlutetoothSocketConnectionServerConnectorListener);
    }
}
