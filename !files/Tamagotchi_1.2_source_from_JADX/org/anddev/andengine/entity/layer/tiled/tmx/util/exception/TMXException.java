package org.anddev.andengine.entity.layer.tiled.tmx.util.exception;

public abstract class TMXException extends Exception {
    private static final long serialVersionUID = 337819550394833109L;

    public TMXException(String pDetailMessage, Throwable pThrowable) {
        super(pDetailMessage, pThrowable);
    }

    public TMXException(String pDetailMessage) {
        super(pDetailMessage);
    }

    public TMXException(Throwable pThrowable) {
        super(pThrowable);
    }
}
