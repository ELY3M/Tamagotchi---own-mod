package org.anddev.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception;

import org.xml.sax.SAXException;

public class TexturePackParseException extends SAXException {
    private static final long serialVersionUID = 5773816582330137037L;

    public TexturePackParseException(String pDetailMessage) {
        super(pDetailMessage);
    }

    public TexturePackParseException(Exception pException) {
        super(pException);
    }

    public TexturePackParseException(String pMessage, Exception pException) {
        super(pMessage, pException);
    }
}
