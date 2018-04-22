package org.anddev.andengine.entity.layer.tiled.tmx;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseArray;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;
import org.anddev.andengine.entity.layer.tiled.tmx.util.exception.TMXParseException;
import org.anddev.andengine.opengl.texture.TextureManager;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasFactory;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.ColorKeyBitmapTextureAtlasSourceDecorator;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape.RectangleBitmapTextureAtlasSourceDecoratorShape;
import org.anddev.andengine.opengl.texture.bitmap.BitmapTexture.BitmapTextureFormat;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.util.SAXUtils;
import org.xml.sax.Attributes;

public class TMXTileSet implements TMXConstants {
    private BitmapTextureAtlas mBitmapTextureAtlas;
    private final int mFirstGlobalTileID;
    private String mImageSource;
    private final int mMargin;
    private final String mName;
    private final int mSpacing;
    private final SparseArray<TMXProperties<TMXTileProperty>> mTMXTileProperties;
    private final TextureOptions mTextureOptions;
    private final int mTileHeight;
    private final int mTileWidth;
    private int mTilesHorizontal;
    private int mTilesVertical;

    TMXTileSet(Attributes pAttributes, TextureOptions pTextureOptions) {
        this(SAXUtils.getIntAttribute(pAttributes, TMXConstants.TAG_TILESET_ATTRIBUTE_FIRSTGID, 1), pAttributes, pTextureOptions);
    }

    TMXTileSet(int pFirstGlobalTileID, Attributes pAttributes, TextureOptions pTextureOptions) {
        this.mTMXTileProperties = new SparseArray();
        this.mFirstGlobalTileID = pFirstGlobalTileID;
        this.mName = pAttributes.getValue("", "name");
        this.mTileWidth = SAXUtils.getIntAttributeOrThrow(pAttributes, "tilewidth");
        this.mTileHeight = SAXUtils.getIntAttributeOrThrow(pAttributes, "tileheight");
        this.mSpacing = SAXUtils.getIntAttribute(pAttributes, TMXConstants.TAG_TILESET_ATTRIBUTE_SPACING, 0);
        this.mMargin = SAXUtils.getIntAttribute(pAttributes, TMXConstants.TAG_TILESET_ATTRIBUTE_MARGIN, 0);
        this.mTextureOptions = pTextureOptions;
    }

    public final int getFirstGlobalTileID() {
        return this.mFirstGlobalTileID;
    }

    public final String getName() {
        return this.mName;
    }

    public final int getTileWidth() {
        return this.mTileWidth;
    }

    public final int getTileHeight() {
        return this.mTileHeight;
    }

    public BitmapTextureAtlas getBitmapTextureAtlas() {
        return this.mBitmapTextureAtlas;
    }

    public void setImageSource(Context pContext, TextureManager pTextureManager, Attributes pAttributes) throws TMXParseException {
        this.mImageSource = pAttributes.getValue("", "source");
        AssetBitmapTextureAtlasSource assetBitmapTextureAtlasSource = new AssetBitmapTextureAtlasSource(pContext, this.mImageSource);
        this.mTilesHorizontal = determineCount(assetBitmapTextureAtlasSource.getWidth(), this.mTileWidth, this.mMargin, this.mSpacing);
        this.mTilesVertical = determineCount(assetBitmapTextureAtlasSource.getHeight(), this.mTileHeight, this.mMargin, this.mSpacing);
        this.mBitmapTextureAtlas = BitmapTextureAtlasFactory.createForTextureAtlasSourceSize(BitmapTextureFormat.RGBA_8888, assetBitmapTextureAtlasSource, this.mTextureOptions);
        String transparentColor = SAXUtils.getAttribute(pAttributes, TMXConstants.TAG_IMAGE_ATTRIBUTE_TRANS, null);
        if (transparentColor == null) {
            BitmapTextureAtlasTextureRegionFactory.createFromSource(this.mBitmapTextureAtlas, assetBitmapTextureAtlasSource, 0, 0);
        } else {
            try {
                BitmapTextureAtlasTextureRegionFactory.createFromSource(this.mBitmapTextureAtlas, new ColorKeyBitmapTextureAtlasSourceDecorator(assetBitmapTextureAtlasSource, RectangleBitmapTextureAtlasSourceDecoratorShape.getDefaultInstance(), Color.parseColor(transparentColor.charAt(0) == '#' ? transparentColor : "#" + transparentColor)), 0, 0);
            } catch (IllegalArgumentException e) {
                throw new TMXParseException("Illegal value: '" + transparentColor + "' for attribute 'trans' supplied!", e);
            }
        }
        pTextureManager.loadTexture(this.mBitmapTextureAtlas);
    }

    public String getImageSource() {
        return this.mImageSource;
    }

    public SparseArray<TMXProperties<TMXTileProperty>> getTMXTileProperties() {
        return this.mTMXTileProperties;
    }

    public TMXProperties<TMXTileProperty> getTMXTilePropertiesFromGlobalTileID(int pGlobalTileID) {
        return (TMXProperties) this.mTMXTileProperties.get(pGlobalTileID - this.mFirstGlobalTileID);
    }

    public void addTMXTileProperty(int pLocalTileID, TMXTileProperty pTMXTileProperty) {
        TMXProperties<TMXTileProperty> existingProperties = (TMXProperties) this.mTMXTileProperties.get(pLocalTileID);
        if (existingProperties != null) {
            existingProperties.add(pTMXTileProperty);
            return;
        }
        TMXProperties<TMXTileProperty> newProperties = new TMXProperties();
        newProperties.add(pTMXTileProperty);
        this.mTMXTileProperties.put(pLocalTileID, newProperties);
    }

    public TextureRegion getTextureRegionFromGlobalTileID(int pGlobalTileID) {
        int localTileID = pGlobalTileID - this.mFirstGlobalTileID;
        return new TextureRegion(this.mBitmapTextureAtlas, this.mMargin + ((this.mSpacing + this.mTileWidth) * (localTileID % this.mTilesHorizontal)), this.mMargin + ((this.mSpacing + this.mTileHeight) * (localTileID / this.mTilesHorizontal)), this.mTileWidth, this.mTileHeight);
    }

    private static int determineCount(int pTotalExtent, int pTileExtent, int pMargin, int pSpacing) {
        int count = 0;
        int remainingExtent = pTotalExtent - (pMargin * 2);
        while (remainingExtent > 0) {
            remainingExtent = (remainingExtent - pTileExtent) - pSpacing;
            count++;
        }
        return count;
    }
}
