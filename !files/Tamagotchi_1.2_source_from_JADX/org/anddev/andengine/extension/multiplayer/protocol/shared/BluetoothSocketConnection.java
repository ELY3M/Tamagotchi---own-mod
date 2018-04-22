package org.anddev.andengine.extension.multiplayer.protocol.shared;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;
import org.anddev.andengine.extension.multiplayer.protocol.exception.BluetoothException;
import org.anddev.andengine.extension.multiplayer.protocol.util.Bluetooth;
import org.anddev.andengine.util.Debug;

public class BluetoothSocketConnection extends Connection {
    private final BluetoothSocket mBluetoothSocket;

    public BluetoothSocketConnection(BluetoothAdapter pBluetoothAdapter, String pMacAddress, String pUUID) throws IOException, BluetoothException {
        this(pBluetoothAdapter.getRemoteDevice(pMacAddress), pUUID);
    }

    public BluetoothSocketConnection(BluetoothDevice pBluetoothDevice, String pUUID) throws IOException, BluetoothException {
        this(pBluetoothDevice.createRfcommSocketToServiceRecord(UUID.fromString(pUUID)));
    }

    public BluetoothSocketConnection(BluetoothSocket pBluetoothSocket) throws IOException, BluetoothException {
        super(new DataInputStream(pBluetoothSocket.getInputStream()), new DataOutputStream(pBluetoothSocket.getOutputStream()));
        this.mBluetoothSocket = pBluetoothSocket;
        if (!Bluetooth.isSupportedByAndroidVersion()) {
            throw new BluetoothException();
        }
    }

    public BluetoothSocket getBluetoothSocket() {
        return this.mBluetoothSocket;
    }

    protected void onTerminate() {
        try {
            this.mBluetoothSocket.close();
        } catch (Throwable e) {
            Debug.m63e(e);
        }
    }
}
