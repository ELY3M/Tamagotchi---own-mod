package org.anddev.andengine.entity.layer.tiled.tmx;

import android.util.SparseArray;
import java.util.ArrayList;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.vertex.RectangleVertexBuffer;
import org.anddev.andengine.util.SAXUtils;
import org.xml.sax.Attributes;

public class TMXTiledMap implements TMXConstants {
    private final SparseArray<TMXProperties<TMXTileProperty>> mGlobalTileIDToTMXTilePropertiesCache = new SparseArray();
    private final SparseArray<TextureRegion> mGlobalTileIDToTextureRegionCache = new SparseArray();
    private final String mOrientation;
    private final RectangleVertexBuffer mSharedVertexBuffer;
    private final ArrayList<TMXLayer> mTMXLayers = new ArrayList();
    private final ArrayList<TMXObjectGroup> mTMXObjectGroups = new ArrayList();
    private final ArrayList<TMXTileSet> mTMXTileSets = new ArrayList();
    private final TMXProperties<TMXTiledMapProperty> mTMXTiledMapProperties = new TMXProperties();
    private final int mTileColumns;
    private final int mTileHeight;
    private final int mTileWidth;
    private final int mTilesRows;

    TMXTiledMap(Attributes pAttributes) {
        this.mOrientation = pAttributes.getValue("", TMXConstants.TAG_MAP_ATTRIBUTE_ORIENTATION);
        if (this.mOrientation.equals(TMXConstants.TAG_MAP_ATTRIBUTE_ORIENTATION_VALUE_ORTHOGONAL)) {
            this.mTileColumns = SAXUtils.getIntAttributeOrThrow(pAttributes, "width");
            this.mTilesRows = SAXUtils.getIntAttributeOrThrow(pAttributes, "height");
            this.mTileWidth = SAXUtils.getIntAttributeOrThrow(pAttributes, "tilewidth");
            this.mTileHeight = SAXUtils.getIntAttributeOrThrow(pAttributes, "tileheight");
            this.mSharedVertexBuffer = new RectangleVertexBuffer(35044, true);
            this.mSharedVertexBuffer.update((float) this.mTileWidth, (float) this.mTileHeight);
            return;
        }
        throw new IllegalArgumentException("orientation: '" + this.mOrientation + "' is not supported.");
    }

    public final String getOrientation() {
        return this.mOrientation;
    }

    @Deprecated
    public final int getWidth() {
        return this.mTileColumns;
    }

    public final int getTileColumns() {
        return this.mTileColumns;
    }

    @Deprecated
    public final int getHeight() {
        return this.mTilesRows;
    }

    public final int getTileRows() {
        return this.mTilesRows;
    }

    public final int getTileWidth() {
        return this.mTileWidth;
    }

    public final int getTileHeight() {
        return this.mTileHeight;
    }

    public RectangleVertexBuffer getSharedVertexBuffer() {
        return this.mSharedVertexBuffer;
    }

    void addTMXTileSet(TMXTileSet pTMXTileSet) {
        this.mTMXTileSets.add(pTMXTileSet);
    }

    public ArrayList<TMXTileSet> getTMXTileSets() {
        return this.mTMXTileSets;
    }

    void addTMXLayer(TMXLayer pTMXLayer) {
        this.mTMXLayers.add(pTMXLayer);
    }

    public ArrayList<TMXLayer> getTMXLayers() {
        return this.mTMXLayers;
    }

    void addTMXObjectGroup(TMXObjectGroup pTMXObjectGroup) {
        this.mTMXObjectGroups.add(pTMXObjectGroup);
    }

    public ArrayList<TMXObjectGroup> getTMXObjectGroups() {
        return this.mTMXObjectGroups;
    }

    public TMXProperties<TMXTileProperty> getTMXTilePropertiesByGlobalTileID(int pGlobalTileID) {
        return (TMXProperties) this.mGlobalTileIDToTMXTilePropertiesCache.get(pGlobalTileID);
    }

    public void addTMXTiledMapProperty(TMXTiledMapProperty pTMXTiledMapProperty) {
        this.mTMXTiledMapProperties.add(pTMXTiledMapProperty);
    }

    public TMXProperties<TMXTiledMapProperty> getTMXTiledMapProperties() {
        return this.mTMXTiledMapProperties;
    }

    protected void finalize() throws Throwable {
        if (this.mSharedVertexBuffer.isManaged()) {
            this.mSharedVertexBuffer.unloadFromActiveBufferObjectManager();
        }
    }

    public TMXProperties<TMXTileProperty> getTMXTileProperties(int pGlobalTileID) {
        TMXProperties<TMXTileProperty> cachedTMXTileProperties = (TMXProperties) this.mGlobalTileIDToTMXTilePropertiesCache.get(pGlobalTileID);
        if (cachedTMXTileProperties != null) {
            return cachedTMXTileProperties;
        }
        ArrayList<TMXTileSet> tmxTileSets = this.mTMXTileSets;
        for (int i = tmxTileSets.size() - 1; i >= 0; i--) {
            TMXTileSet tmxTileSet = (TMXTileSet) tmxTileSets.get(i);
            if (pGlobalTileID >= tmxTileSet.getFirstGlobalTileID()) {
                return tmxTileSet.getTMXTilePropertiesFromGlobalTileID(pGlobalTileID);
            }
        }
        throw new IllegalArgumentException("No TMXTileProperties found for pGlobalTileID=" + pGlobalTileID);
    }

    public TextureRegion getTextureRegionFromGlobalTileID(int pGlobalTileID) {
        SparseArray<TextureRegion> globalTileIDToTextureRegionCache = this.mGlobalTileIDToTextureRegionCache;
        TextureRegion cachedTextureRegion = (TextureRegion) globalTileIDToTextureRegionCache.get(pGlobalTileID);
        if (cachedTextureRegion != null) {
            return cachedTextureRegion;
        }
        ArrayList<TMXTileSet> tmxTileSets = this.mTMXTileSets;
        for (int i = tmxTileSets.size() - 1; i >= 0; i--) {
            TMXTileSet tmxTileSet = (TMXTileSet) tmxTileSets.get(i);
            if (pGlobalTileID >= tmxTileSet.getFirstGlobalTileID()) {
                TextureRegion textureRegion = tmxTileSet.getTextureRegionFromGlobalTileID(pGlobalTileID);
                globalTileIDToTextureRegionCache.put(pGlobalTileID, textureRegion);
                return textureRegion;
            }
        }
        throw new IllegalArgumentException("No TextureRegion found for pGlobalTileID=" + pGlobalTileID);
    }
}
