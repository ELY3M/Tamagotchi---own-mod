package org.anddev.andengine.entity.layer.tiled.tmx;

import android.content.Context;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;
import org.anddev.andengine.entity.layer.tiled.tmx.util.exception.TMXParseException;
import org.anddev.andengine.opengl.texture.TextureManager;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.util.SAXUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TSXParser extends DefaultHandler implements TMXConstants {
    private final Context mContext;
    private final int mFirstGlobalTileID;
    private boolean mInImage;
    private boolean mInProperties;
    private boolean mInProperty;
    private boolean mInTile;
    private boolean mInTileset;
    private int mLastTileSetTileID;
    private TMXTileSet mTMXTileSet;
    private final TextureManager mTextureManager;
    private final TextureOptions mTextureOptions;

    public TSXParser(Context pContext, TextureManager pTextureManager, TextureOptions pTextureOptions, int pFirstGlobalTileID) {
        this.mContext = pContext;
        this.mTextureManager = pTextureManager;
        this.mTextureOptions = pTextureOptions;
        this.mFirstGlobalTileID = pFirstGlobalTileID;
    }

    TMXTileSet getTMXTileSet() {
        return this.mTMXTileSet;
    }

    public void startElement(String pUri, String pLocalName, String pQualifiedName, Attributes pAttributes) throws SAXException {
        if (pLocalName.equals(TMXConstants.TAG_TILESET)) {
            this.mInTileset = true;
            this.mTMXTileSet = new TMXTileSet(this.mFirstGlobalTileID, pAttributes, this.mTextureOptions);
        } else if (pLocalName.equals(TMXConstants.TAG_IMAGE)) {
            this.mInImage = true;
            this.mTMXTileSet.setImageSource(this.mContext, this.mTextureManager, pAttributes);
        } else if (pLocalName.equals(TMXConstants.TAG_TILE)) {
            this.mInTile = true;
            this.mLastTileSetTileID = SAXUtils.getIntAttributeOrThrow(pAttributes, "id");
        } else if (pLocalName.equals(TMXConstants.TAG_PROPERTIES)) {
            this.mInProperties = true;
        } else if (pLocalName.equals(TMXConstants.TAG_PROPERTY)) {
            this.mInProperty = true;
            this.mTMXTileSet.addTMXTileProperty(this.mLastTileSetTileID, new TMXTileProperty(pAttributes));
        } else {
            throw new TMXParseException("Unexpected start tag: '" + pLocalName + "'.");
        }
    }

    public void endElement(String pUri, String pLocalName, String pQualifiedName) throws SAXException {
        if (pLocalName.equals(TMXConstants.TAG_TILESET)) {
            this.mInTileset = false;
        } else if (pLocalName.equals(TMXConstants.TAG_IMAGE)) {
            this.mInImage = false;
        } else if (pLocalName.equals(TMXConstants.TAG_TILE)) {
            this.mInTile = false;
        } else if (pLocalName.equals(TMXConstants.TAG_PROPERTIES)) {
            this.mInProperties = false;
        } else if (pLocalName.equals(TMXConstants.TAG_PROPERTY)) {
            this.mInProperty = false;
        } else {
            throw new TMXParseException("Unexpected end tag: '" + pLocalName + "'.");
        }
    }
}
