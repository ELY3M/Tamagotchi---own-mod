package org.anddev.andengine.entity.layer.tiled.tmx.util.exception;

import org.xml.sax.SAXException;

public class TSXParseException extends SAXException {
    private static final long serialVersionUID = -7598783248970268198L;

    public TSXParseException(String pDetailMessage) {
        super(pDetailMessage);
    }

    public TSXParseException(Exception pException) {
        super(pException);
    }

    public TSXParseException(String pMessage, Exception pException) {
        super(pMessage, pException);
    }
}
