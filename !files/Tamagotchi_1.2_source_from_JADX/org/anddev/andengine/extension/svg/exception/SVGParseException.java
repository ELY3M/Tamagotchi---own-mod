package org.anddev.andengine.extension.svg.exception;

public class SVGParseException extends RuntimeException {
    private static final long serialVersionUID = 7090913212278249388L;

    public SVGParseException(String pMessage) {
        super(pMessage);
    }

    public SVGParseException(String pMessage, Throwable pThrowable) {
        super(pMessage, pThrowable);
    }

    public SVGParseException(Throwable pThrowable) {
        super(pThrowable);
    }
}
