package org.anddev.andengine.extension.multiplayer.protocol.exception;

public class WifiException extends Exception {
    private static final long serialVersionUID = -8647288255044498718L;

    public WifiException(String pMessage) {
        super(pMessage);
    }

    public WifiException(String pMessage, Throwable pThrowable) {
        super(pMessage, pThrowable);
    }
}
