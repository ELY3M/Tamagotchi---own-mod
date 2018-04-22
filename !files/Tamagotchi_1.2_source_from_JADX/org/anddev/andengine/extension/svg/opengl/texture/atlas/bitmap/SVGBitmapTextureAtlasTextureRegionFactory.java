package org.anddev.andengine.extension.svg.opengl.texture.atlas.bitmap;

import android.content.Context;
import org.anddev.andengine.extension.svg.adt.ISVGColorMapper;
import org.anddev.andengine.extension.svg.adt.SVG;
import org.anddev.andengine.extension.svg.opengl.texture.atlas.bitmap.source.SVGAssetBitmapTextureAtlasSource;
import org.anddev.andengine.extension.svg.opengl.texture.atlas.bitmap.source.SVGBaseBitmapTextureAtlasSource;
import org.anddev.andengine.extension.svg.opengl.texture.atlas.bitmap.source.SVGResourceBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.buildable.BuildableTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class SVGBitmapTextureAtlasTextureRegionFactory {
    private static String sAssetBasePath = "";
    private static boolean sCreateTextureRegionBuffersManaged;
    private static float sScaleFactor = 1.0f;

    public static void setAssetBasePath(String pAssetBasePath) {
        if (pAssetBasePath.endsWith("/") || pAssetBasePath.length() == 0) {
            sAssetBasePath = pAssetBasePath;
            return;
        }
        throw new IllegalArgumentException("pAssetBasePath must end with '/' or be lenght zero.");
    }

    public static void setScaleFactor(float pScaleFactor) {
        if (pScaleFactor > 0.0f) {
            sScaleFactor = pScaleFactor;
            return;
        }
        throw new IllegalArgumentException("pScaleFactor must be greater than zero.");
    }

    public static void setCreateTextureRegionBuffersManaged(boolean pCreateTextureRegionBuffersManaged) {
        sCreateTextureRegionBuffersManaged = pCreateTextureRegionBuffersManaged;
    }

    public static void reset() {
        setAssetBasePath("");
        setCreateTextureRegionBuffersManaged(false);
    }

    private static int applyScaleFactor(int pInt) {
        return Math.round(((float) pInt) * sScaleFactor);
    }

    public static TextureRegion createFromSVG(BitmapTextureAtlas pBitmapTextureAtlas, SVG pSVG, int pWidth, int pHeight, int pTexturePositionX, int pTexturePositionY) {
        return TextureRegionFactory.createFromSource(pBitmapTextureAtlas, new SVGBaseBitmapTextureAtlasSource(pSVG, applyScaleFactor(pWidth), applyScaleFactor(pHeight)), pTexturePositionX, pTexturePositionY, sCreateTextureRegionBuffersManaged);
    }

    public static TiledTextureRegion createTiledFromSVG(BitmapTextureAtlas pBitmapTextureAtlas, SVG pSVG, int pWidth, int pHeight, int pTexturePositionX, int pTexturePositionY, int pTileColumns, int pTileRows) {
        return TextureRegionFactory.createTiledFromSource(pBitmapTextureAtlas, new SVGBaseBitmapTextureAtlasSource(pSVG, applyScaleFactor(pWidth), applyScaleFactor(pHeight)), pTexturePositionX, pTexturePositionY, pTileColumns, pTileRows, sCreateTextureRegionBuffersManaged);
    }

    public static TextureRegion createFromAsset(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, String pAssetPath, int pWidth, int pHeight, int pTexturePositionX, int pTexturePositionY) {
        return createFromAsset(pBitmapTextureAtlas, pContext, pAssetPath, pWidth, pHeight, null, pTexturePositionX, pTexturePositionY);
    }

    public static TiledTextureRegion createTiledFromAsset(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, String pAssetPath, int pWidth, int pHeight, int pTexturePositionX, int pTexturePositionY, int pTileColumns, int pTileRows) {
        return createTiledFromAsset(pBitmapTextureAtlas, pContext, pAssetPath, pWidth, pHeight, null, pTexturePositionX, pTexturePositionY, pTileColumns, pTileRows);
    }

    public static TextureRegion createFromAsset(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, String pAssetPath, int pWidth, int pHeight, ISVGColorMapper pSVGColorMapper, int pTexturePositionX, int pTexturePositionY) {
        return TextureRegionFactory.createFromSource(pBitmapTextureAtlas, new SVGAssetBitmapTextureAtlasSource(pContext, sAssetBasePath + pAssetPath, applyScaleFactor(pWidth), applyScaleFactor(pHeight), pSVGColorMapper), pTexturePositionX, pTexturePositionY, sCreateTextureRegionBuffersManaged);
    }

    public static TiledTextureRegion createTiledFromAsset(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, String pAssetPath, int pWidth, int pHeight, ISVGColorMapper pSVGColorMapper, int pTexturePositionX, int pTexturePositionY, int pTileColumns, int pTileRows) {
        IBitmapTextureAtlasSource textureSource = new SVGAssetBitmapTextureAtlasSource(pContext, sAssetBasePath + pAssetPath, applyScaleFactor(pWidth), applyScaleFactor(pHeight), pSVGColorMapper);
        return TextureRegionFactory.createTiledFromSource(pBitmapTextureAtlas, textureSource, pTexturePositionX, pTexturePositionY, pTileColumns, pTileRows, sCreateTextureRegionBuffersManaged);
    }

    public static TextureRegion createFromResource(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, int pRawResourceID, int pWidth, int pHeight, int pTexturePositionX, int pTexturePositionY) {
        return createFromResource(pBitmapTextureAtlas, pContext, pRawResourceID, pWidth, pHeight, null, pTexturePositionX, pTexturePositionY);
    }

    public static TiledTextureRegion createTiledFromResource(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, int pRawResourceID, int pWidth, int pHeight, int pTexturePositionX, int pTexturePositionY, int pTileColumns, int pTileRows) {
        return createTiledFromResource(pBitmapTextureAtlas, pContext, pRawResourceID, pWidth, pHeight, null, pTexturePositionX, pTexturePositionY, pTileColumns, pTileRows);
    }

    public static TextureRegion createFromResource(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, int pRawResourceID, int pWidth, int pHeight, ISVGColorMapper pSVGColorMapper, int pTexturePositionX, int pTexturePositionY) {
        return TextureRegionFactory.createFromSource(pBitmapTextureAtlas, new SVGResourceBitmapTextureAtlasSource(pContext, applyScaleFactor(pHeight), pRawResourceID, applyScaleFactor(pWidth), pSVGColorMapper), pTexturePositionX, pTexturePositionY, sCreateTextureRegionBuffersManaged);
    }

    public static TiledTextureRegion createTiledFromResource(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, int pRawResourceID, int pWidth, int pHeight, ISVGColorMapper pSVGColorMapper, int pTexturePositionX, int pTexturePositionY, int pTileColumns, int pTileRows) {
        IBitmapTextureAtlasSource textureSource = new SVGResourceBitmapTextureAtlasSource(pContext, applyScaleFactor(pHeight), pRawResourceID, applyScaleFactor(pWidth), pSVGColorMapper);
        return TextureRegionFactory.createTiledFromSource(pBitmapTextureAtlas, textureSource, pTexturePositionX, pTexturePositionY, pTileColumns, pTileRows, sCreateTextureRegionBuffersManaged);
    }

    public static TextureRegion createFromSVG(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, SVG pSVG, int pWidth, int pHeight) {
        return BuildableTextureAtlasTextureRegionFactory.createFromSource(pBuildableBitmapTextureAtlas, new SVGBaseBitmapTextureAtlasSource(pSVG, applyScaleFactor(pWidth), applyScaleFactor(pHeight)), sCreateTextureRegionBuffersManaged);
    }

    public static TiledTextureRegion createTiledFromSVG(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, SVG pSVG, int pWidth, int pHeight, int pTileColumns, int pTileRows) {
        return BuildableTextureAtlasTextureRegionFactory.createTiledFromSource(pBuildableBitmapTextureAtlas, new SVGBaseBitmapTextureAtlasSource(pSVG, applyScaleFactor(pWidth), applyScaleFactor(pHeight)), pTileColumns, pTileRows, sCreateTextureRegionBuffersManaged);
    }

    public static TextureRegion createFromAsset(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, String pAssetPath, int pWidth, int pHeight) {
        return createFromAsset(pBuildableBitmapTextureAtlas, pContext, pAssetPath, pWidth, pHeight, null);
    }

    public static TiledTextureRegion createTiledFromAsset(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, String pAssetPath, int pWidth, int pHeight, int pTileColumns, int pTileRows) {
        return createTiledFromAsset(pBuildableBitmapTextureAtlas, pContext, pAssetPath, pWidth, pHeight, null, pTileColumns, pTileRows);
    }

    public static TextureRegion createFromAsset(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, String pAssetPath, int pWidth, int pHeight, ISVGColorMapper pSVGColorMapper) {
        return BuildableTextureAtlasTextureRegionFactory.createFromSource(pBuildableBitmapTextureAtlas, new SVGAssetBitmapTextureAtlasSource(pContext, sAssetBasePath + pAssetPath, applyScaleFactor(pWidth), applyScaleFactor(pHeight), pSVGColorMapper), sCreateTextureRegionBuffersManaged);
    }

    public static TiledTextureRegion createTiledFromAsset(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, String pAssetPath, int pWidth, int pHeight, ISVGColorMapper pSVGColorMapper, int pTileColumns, int pTileRows) {
        return BuildableTextureAtlasTextureRegionFactory.createTiledFromSource(pBuildableBitmapTextureAtlas, new SVGAssetBitmapTextureAtlasSource(pContext, sAssetBasePath + pAssetPath, applyScaleFactor(pWidth), applyScaleFactor(pHeight), pSVGColorMapper), pTileColumns, pTileRows, sCreateTextureRegionBuffersManaged);
    }

    public static TextureRegion createFromResource(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, int pRawResourceID, int pWidth, int pHeight) {
        return createFromResource(pBuildableBitmapTextureAtlas, pContext, pRawResourceID, pWidth, pHeight, null);
    }

    public static TiledTextureRegion createTiledFromResource(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, int pRawResourceID, int pWidth, int pHeight, int pTileColumns, int pTileRows) {
        return createTiledFromResource(pBuildableBitmapTextureAtlas, pContext, pRawResourceID, pWidth, pHeight, null, pTileColumns, pTileRows);
    }

    public static TextureRegion createFromResource(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, int pRawResourceID, int pWidth, int pHeight, ISVGColorMapper pSVGColorMapper) {
        return BuildableTextureAtlasTextureRegionFactory.createFromSource(pBuildableBitmapTextureAtlas, new SVGResourceBitmapTextureAtlasSource(pContext, applyScaleFactor(pHeight), pRawResourceID, applyScaleFactor(pWidth), pSVGColorMapper), sCreateTextureRegionBuffersManaged);
    }

    public static TiledTextureRegion createTiledFromResource(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, int pRawResourceID, int pWidth, int pHeight, ISVGColorMapper pSVGColorMapper, int pTileColumns, int pTileRows) {
        return BuildableTextureAtlasTextureRegionFactory.createTiledFromSource(pBuildableBitmapTextureAtlas, new SVGResourceBitmapTextureAtlasSource(pContext, applyScaleFactor(pHeight), pRawResourceID, applyScaleFactor(pWidth), pSVGColorMapper), pTileColumns, pTileRows, sCreateTextureRegionBuffersManaged);
    }
}
