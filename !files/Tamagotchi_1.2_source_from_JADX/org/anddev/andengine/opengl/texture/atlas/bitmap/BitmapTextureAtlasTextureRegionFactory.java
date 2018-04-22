package org.anddev.andengine.opengl.texture.atlas.bitmap;

import android.content.Context;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.ResourceBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.buildable.BuildableTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class BitmapTextureAtlasTextureRegionFactory {
    private static String sAssetBasePath = "";
    private static boolean sCreateTextureRegionBuffersManaged;

    public static void setAssetBasePath(String pAssetBasePath) {
        if (pAssetBasePath.endsWith("/") || pAssetBasePath.length() == 0) {
            sAssetBasePath = pAssetBasePath;
            return;
        }
        throw new IllegalArgumentException("pAssetBasePath must end with '/' or be lenght zero.");
    }

    public static void setCreateTextureRegionBuffersManaged(boolean pCreateTextureRegionBuffersManaged) {
        sCreateTextureRegionBuffersManaged = pCreateTextureRegionBuffersManaged;
    }

    public static void reset() {
        setAssetBasePath("");
        setCreateTextureRegionBuffersManaged(false);
    }

    public static TextureRegion createFromAsset(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, String pAssetPath, int pTexturePositionX, int pTexturePositionY) {
        return createFromSource(pBitmapTextureAtlas, new AssetBitmapTextureAtlasSource(pContext, sAssetBasePath + pAssetPath), pTexturePositionX, pTexturePositionY);
    }

    public static TiledTextureRegion createTiledFromAsset(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, String pAssetPath, int pTexturePositionX, int pTexturePositionY, int pTileColumns, int pTileRows) {
        return createTiledFromSource(pBitmapTextureAtlas, new AssetBitmapTextureAtlasSource(pContext, sAssetBasePath + pAssetPath), pTexturePositionX, pTexturePositionY, pTileColumns, pTileRows);
    }

    public static TextureRegion createFromResource(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, int pDrawableResourceID, int pTexturePositionX, int pTexturePositionY) {
        return createFromSource(pBitmapTextureAtlas, new ResourceBitmapTextureAtlasSource(pContext, pDrawableResourceID), pTexturePositionX, pTexturePositionY);
    }

    public static TiledTextureRegion createTiledFromResource(BitmapTextureAtlas pBitmapTextureAtlas, Context pContext, int pDrawableResourceID, int pTexturePositionX, int pTexturePositionY, int pTileColumns, int pTileRows) {
        return createTiledFromSource(pBitmapTextureAtlas, new ResourceBitmapTextureAtlasSource(pContext, pDrawableResourceID), pTexturePositionX, pTexturePositionY, pTileColumns, pTileRows);
    }

    public static TextureRegion createFromSource(BitmapTextureAtlas pBitmapTextureAtlas, IBitmapTextureAtlasSource pBitmapTextureAtlasSource, int pTexturePositionX, int pTexturePositionY) {
        return TextureRegionFactory.createFromSource(pBitmapTextureAtlas, pBitmapTextureAtlasSource, pTexturePositionX, pTexturePositionY, sCreateTextureRegionBuffersManaged);
    }

    public static TiledTextureRegion createTiledFromSource(BitmapTextureAtlas pBitmapTextureAtlas, IBitmapTextureAtlasSource pBitmapTextureAtlasSource, int pTexturePositionX, int pTexturePositionY, int pTileColumns, int pTileRows) {
        return TextureRegionFactory.createTiledFromSource(pBitmapTextureAtlas, pBitmapTextureAtlasSource, pTexturePositionX, pTexturePositionY, pTileColumns, pTileRows, sCreateTextureRegionBuffersManaged);
    }

    public static TextureRegion createFromAsset(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, String pAssetPath) {
        return createFromSource(pBuildableBitmapTextureAtlas, new AssetBitmapTextureAtlasSource(pContext, sAssetBasePath + pAssetPath));
    }

    public static TiledTextureRegion createTiledFromAsset(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, String pAssetPath, int pTileColumns, int pTileRows) {
        return createTiledFromSource(pBuildableBitmapTextureAtlas, new AssetBitmapTextureAtlasSource(pContext, sAssetBasePath + pAssetPath), pTileColumns, pTileRows);
    }

    public static TextureRegion createFromResource(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, int pDrawableResourceID) {
        return createFromSource(pBuildableBitmapTextureAtlas, new ResourceBitmapTextureAtlasSource(pContext, pDrawableResourceID));
    }

    public static TiledTextureRegion createTiledFromResource(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, Context pContext, int pDrawableResourceID, int pTileColumns, int pTileRows) {
        return createTiledFromSource(pBuildableBitmapTextureAtlas, new ResourceBitmapTextureAtlasSource(pContext, pDrawableResourceID), pTileColumns, pTileRows);
    }

    public static TextureRegion createFromSource(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, IBitmapTextureAtlasSource pBitmapTextureAtlasSource) {
        return BuildableTextureAtlasTextureRegionFactory.createFromSource(pBuildableBitmapTextureAtlas, pBitmapTextureAtlasSource, sCreateTextureRegionBuffersManaged);
    }

    public static TiledTextureRegion createTiledFromSource(BuildableBitmapTextureAtlas pBuildableBitmapTextureAtlas, IBitmapTextureAtlasSource pBitmapTextureAtlasSource, int pTileColumns, int pTileRows) {
        return BuildableTextureAtlasTextureRegionFactory.createTiledFromSource(pBuildableBitmapTextureAtlas, pBitmapTextureAtlasSource, pTileColumns, pTileRows, sCreateTextureRegionBuffersManaged);
    }
}
