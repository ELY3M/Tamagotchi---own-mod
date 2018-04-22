package org.anddev.andengine.entity.layer.tiled.tmx;

import android.content.Context;
import java.util.ArrayList;
import org.anddev.andengine.entity.layer.tiled.tmx.TMXLoader.ITMXTilePropertiesListener;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;
import org.anddev.andengine.entity.layer.tiled.tmx.util.exception.TMXParseException;
import org.anddev.andengine.entity.layer.tiled.tmx.util.exception.TSXLoadException;
import org.anddev.andengine.opengl.texture.TextureManager;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.util.Debug;
import org.anddev.andengine.util.SAXUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TMXParser extends DefaultHandler implements TMXConstants {
    private final Context mContext;
    private String mDataCompression;
    private String mDataEncoding;
    private boolean mInData;
    private boolean mInImage;
    private boolean mInLayer;
    private boolean mInMap;
    private boolean mInObject;
    private boolean mInObjectGroup;
    private boolean mInProperties;
    private boolean mInProperty;
    private boolean mInTile;
    private boolean mInTileset;
    private int mLastTileSetTileID;
    private final StringBuilder mStringBuilder = new StringBuilder();
    private final ITMXTilePropertiesListener mTMXTilePropertyListener;
    private TMXTiledMap mTMXTiledMap;
    private final TextureManager mTextureManager;
    private final TextureOptions mTextureOptions;

    public TMXParser(Context pContext, TextureManager pTextureManager, TextureOptions pTextureOptions, ITMXTilePropertiesListener pTMXTilePropertyListener) {
        this.mContext = pContext;
        this.mTextureManager = pTextureManager;
        this.mTextureOptions = pTextureOptions;
        this.mTMXTilePropertyListener = pTMXTilePropertyListener;
    }

    TMXTiledMap getTMXTiledMap() {
        return this.mTMXTiledMap;
    }

    public void startElement(String pUri, String pLocalName, String pQualifiedName, Attributes pAttributes) throws SAXException {
        if (pLocalName.equals(TMXConstants.TAG_MAP)) {
            this.mInMap = true;
            this.mTMXTiledMap = new TMXTiledMap(pAttributes);
            return;
        }
        if (pLocalName.equals(TMXConstants.TAG_TILESET)) {
            TMXTileSet tmxTileSet;
            this.mInTileset = true;
            String tsxTileSetSource = pAttributes.getValue("", "source");
            if (tsxTileSetSource == null) {
                tmxTileSet = new TMXTileSet(pAttributes, this.mTextureOptions);
            } else {
                try {
                    tmxTileSet = new TSXLoader(this.mContext, this.mTextureManager, this.mTextureOptions).loadFromAsset(this.mContext, SAXUtils.getIntAttribute(pAttributes, TMXConstants.TAG_TILESET_ATTRIBUTE_FIRSTGID, 1), tsxTileSetSource);
                } catch (TSXLoadException e) {
                    throw new TMXParseException("Failed to load TMXTileSet from source: " + tsxTileSetSource, e);
                }
            }
            this.mTMXTiledMap.addTMXTileSet(tmxTileSet);
            return;
        }
        if (pLocalName.equals(TMXConstants.TAG_IMAGE)) {
            this.mInImage = true;
            ArrayList<TMXTileSet> tmxTileSets = this.mTMXTiledMap.getTMXTileSets();
            ((TMXTileSet) tmxTileSets.get(tmxTileSets.size() - 1)).setImageSource(this.mContext, this.mTextureManager, pAttributes);
            return;
        }
        if (pLocalName.equals(TMXConstants.TAG_TILE)) {
            this.mInTile = true;
            if (this.mInTileset) {
                this.mLastTileSetTileID = SAXUtils.getIntAttributeOrThrow(pAttributes, "id");
                return;
            } else if (this.mInData) {
                ArrayList<TMXLayer> tmxLayers = this.mTMXTiledMap.getTMXLayers();
                ((TMXLayer) tmxLayers.get(tmxLayers.size() - 1)).initializeTMXTileFromXML(pAttributes, this.mTMXTilePropertyListener);
                return;
            } else {
                return;
            }
        }
        if (pLocalName.equals(TMXConstants.TAG_PROPERTIES)) {
            this.mInProperties = true;
            return;
        }
        ArrayList<TMXObjectGroup> tmxObjectGroups;
        if (this.mInProperties) {
            if (pLocalName.equals(TMXConstants.TAG_PROPERTY)) {
                this.mInProperty = true;
                if (this.mInTile) {
                    tmxTileSets = this.mTMXTiledMap.getTMXTileSets();
                    ((TMXTileSet) tmxTileSets.get(tmxTileSets.size() - 1)).addTMXTileProperty(this.mLastTileSetTileID, new TMXTileProperty(pAttributes));
                    return;
                } else if (this.mInLayer) {
                    tmxLayers = this.mTMXTiledMap.getTMXLayers();
                    ((TMXLayer) tmxLayers.get(tmxLayers.size() - 1)).addTMXLayerProperty(new TMXLayerProperty(pAttributes));
                    return;
                } else if (this.mInObject) {
                    tmxObjectGroups = this.mTMXTiledMap.getTMXObjectGroups();
                    ArrayList<TMXObject> tmxObjects = ((TMXObjectGroup) tmxObjectGroups.get(tmxObjectGroups.size() - 1)).getTMXObjects();
                    ((TMXObject) tmxObjects.get(tmxObjects.size() - 1)).addTMXObjectProperty(new TMXObjectProperty(pAttributes));
                    return;
                } else if (this.mInObjectGroup) {
                    tmxObjectGroups = this.mTMXTiledMap.getTMXObjectGroups();
                    ((TMXObjectGroup) tmxObjectGroups.get(tmxObjectGroups.size() - 1)).addTMXObjectGroupProperty(new TMXObjectGroupProperty(pAttributes));
                    return;
                } else if (this.mInMap) {
                    this.mTMXTiledMap.addTMXTiledMapProperty(new TMXTiledMapProperty(pAttributes));
                    return;
                } else {
                    return;
                }
            }
        }
        if (pLocalName.equals(TMXConstants.TAG_LAYER)) {
            this.mInLayer = true;
            this.mTMXTiledMap.addTMXLayer(new TMXLayer(this.mTMXTiledMap, pAttributes));
            return;
        }
        if (pLocalName.equals(TMXConstants.TAG_DATA)) {
            this.mInData = true;
            this.mDataEncoding = pAttributes.getValue("", TMXConstants.TAG_DATA_ATTRIBUTE_ENCODING);
            this.mDataCompression = pAttributes.getValue("", TMXConstants.TAG_DATA_ATTRIBUTE_COMPRESSION);
            return;
        }
        if (pLocalName.equals(TMXConstants.TAG_OBJECTGROUP)) {
            this.mInObjectGroup = true;
            this.mTMXTiledMap.addTMXObjectGroup(new TMXObjectGroup(pAttributes));
            return;
        }
        if (pLocalName.equals(TMXConstants.TAG_OBJECT)) {
            this.mInObject = true;
            tmxObjectGroups = this.mTMXTiledMap.getTMXObjectGroups();
            ((TMXObjectGroup) tmxObjectGroups.get(tmxObjectGroups.size() - 1)).addTMXObject(new TMXObject(pAttributes));
            return;
        }
        throw new TMXParseException("Unexpected start tag: '" + pLocalName + "'.");
    }

    public void characters(char[] pCharacters, int pStart, int pLength) throws SAXException {
        this.mStringBuilder.append(pCharacters, pStart, pLength);
    }

    public void endElement(String pUri, String pLocalName, String pQualifiedName) throws SAXException {
        if (pLocalName.equals(TMXConstants.TAG_MAP)) {
            this.mInMap = false;
        } else if (pLocalName.equals(TMXConstants.TAG_TILESET)) {
            this.mInTileset = false;
        } else if (pLocalName.equals(TMXConstants.TAG_IMAGE)) {
            this.mInImage = false;
        } else if (pLocalName.equals(TMXConstants.TAG_TILE)) {
            this.mInTile = false;
        } else if (pLocalName.equals(TMXConstants.TAG_PROPERTIES)) {
            this.mInProperties = false;
        } else if (pLocalName.equals(TMXConstants.TAG_PROPERTY)) {
            this.mInProperty = false;
        } else if (pLocalName.equals(TMXConstants.TAG_LAYER)) {
            this.mInLayer = false;
        } else if (pLocalName.equals(TMXConstants.TAG_DATA)) {
            boolean binarySaved;
            if (this.mDataCompression == null || this.mDataEncoding == null) {
                binarySaved = false;
            } else {
                binarySaved = true;
            }
            if (binarySaved) {
                ArrayList<TMXLayer> tmxLayers = this.mTMXTiledMap.getTMXLayers();
                try {
                    ((TMXLayer) tmxLayers.get(tmxLayers.size() - 1)).initializeTMXTilesFromDataString(this.mStringBuilder.toString().trim(), this.mDataEncoding, this.mDataCompression, this.mTMXTilePropertyListener);
                } catch (Throwable e) {
                    Debug.m63e(e);
                }
                this.mDataCompression = null;
                this.mDataEncoding = null;
            }
            this.mInData = false;
        } else if (pLocalName.equals(TMXConstants.TAG_OBJECTGROUP)) {
            this.mInObjectGroup = false;
        } else if (pLocalName.equals(TMXConstants.TAG_OBJECT)) {
            this.mInObject = false;
        } else {
            throw new TMXParseException("Unexpected end tag: '" + pLocalName + "'.");
        }
        this.mStringBuilder.setLength(0);
    }
}
