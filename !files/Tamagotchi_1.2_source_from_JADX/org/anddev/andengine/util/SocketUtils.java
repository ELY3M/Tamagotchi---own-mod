package org.anddev.andengine.util;

import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketUtils {
    public static void closeSocket(DatagramSocket pDatagramSocket) {
        if (pDatagramSocket != null && !pDatagramSocket.isClosed()) {
            pDatagramSocket.close();
        }
    }

    public static void closeSocket(Socket pSocket) {
        if (pSocket != null && !pSocket.isClosed()) {
            try {
                pSocket.close();
            } catch (Throwable e) {
                Debug.m63e(e);
            }
        }
    }

    public static void closeSocket(ServerSocket pServerSocket) {
        if (pServerSocket != null && !pServerSocket.isClosed()) {
            try {
                pServerSocket.close();
            } catch (Throwable e) {
                Debug.m63e(e);
            }
        }
    }
}
