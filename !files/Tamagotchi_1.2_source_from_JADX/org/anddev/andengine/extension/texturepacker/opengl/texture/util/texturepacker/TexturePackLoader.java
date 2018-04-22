package org.anddev.andengine.extension.texturepacker.opengl.texture.util.texturepacker;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.anddev.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception.TexturePackParseException;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class TexturePackLoader {
    private final String mAssetBasePath;
    private final Context mContext;

    public TexturePackLoader(Context pContext) {
        this(pContext, "");
    }

    public TexturePackLoader(Context pContext, String pAssetBasePath) {
        this.mContext = pContext;
        this.mAssetBasePath = pAssetBasePath;
    }

    public TexturePack loadFromAsset(Context pContext, String pAssetPath) throws TexturePackParseException {
        try {
            return load(pContext.getAssets().open(this.mAssetBasePath + pAssetPath));
        } catch (IOException e) {
            throw new TexturePackParseException("Could not load " + getClass().getSimpleName() + " data from asset: " + pAssetPath, e);
        }
    }

    public TexturePack load(InputStream pInputStream) throws TexturePackParseException {
        try {
            XMLReader xr = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            TexturePackParser texturePackerParser = new TexturePackParser(this.mContext, this.mAssetBasePath);
            xr.setContentHandler(texturePackerParser);
            xr.parse(new InputSource(new BufferedInputStream(pInputStream)));
            return texturePackerParser.getTexturePackerResult();
        } catch (Exception e) {
            throw new TexturePackParseException(e);
        } catch (ParserConfigurationException e2) {
            return null;
        } catch (Exception e3) {
            throw new TexturePackParseException(e3);
        }
    }
}
