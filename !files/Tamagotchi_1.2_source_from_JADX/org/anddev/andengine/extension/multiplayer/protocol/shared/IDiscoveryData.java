package org.anddev.andengine.extension.multiplayer.protocol.shared;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.anddev.andengine.util.StreamUtils;

public interface IDiscoveryData {

    public static class DiscoveryDataFactory {
        public static byte[] write(IDiscoveryData pDiscoveryData) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                pDiscoveryData.write(dataOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                return toByteArray;
            } finally {
                StreamUtils.close(dataOutputStream);
            }
        }

        public static void read(byte[] pData, IDiscoveryData pDiscoveryData) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(pData));
            try {
                pDiscoveryData.read(dataInputStream);
            } finally {
                StreamUtils.close(dataInputStream);
            }
        }
    }

    public static class DefaultDiscoveryData implements IDiscoveryData {
        private byte[] mServerIP;
        private int mServerPort;

        public DefaultDiscoveryData(byte[] pServerIP, int pServerPort) {
            this.mServerIP = pServerIP;
            this.mServerPort = pServerPort;
        }

        public final byte[] getServerIP() {
            return this.mServerIP;
        }

        public final int getServerPort() {
            return this.mServerPort;
        }

        public void read(DataInputStream pDataInputStream) throws IOException {
            this.mServerIP = new byte[pDataInputStream.readByte()];
            for (int i = 0; i < this.mServerIP.length; i++) {
                this.mServerIP[i] = pDataInputStream.readByte();
            }
            this.mServerPort = pDataInputStream.readShort();
        }

        public void write(DataOutputStream pDataOutputStream) throws IOException {
            pDataOutputStream.writeByte((byte) this.mServerIP.length);
            pDataOutputStream.write(this.mServerIP);
            pDataOutputStream.writeShort((short) this.mServerPort);
        }
    }

    void read(DataInputStream dataInputStream) throws IOException;

    void write(DataOutputStream dataOutputStream) throws IOException;
}
