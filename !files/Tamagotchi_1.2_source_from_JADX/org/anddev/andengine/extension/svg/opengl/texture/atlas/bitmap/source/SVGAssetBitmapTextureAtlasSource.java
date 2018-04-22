package org.anddev.andengine.extension.svg.opengl.texture.atlas.bitmap.source;

import android.content.Context;
import org.anddev.andengine.extension.svg.SVGParser;
import org.anddev.andengine.extension.svg.adt.ISVGColorMapper;
import org.anddev.andengine.extension.svg.adt.SVG;
import org.anddev.andengine.util.Debug;

public class SVGAssetBitmapTextureAtlasSource extends SVGBaseBitmapTextureAtlasSource {
    private final String mAssetPath;
    private final Context mContext;
    private final ISVGColorMapper mSVGColorMapper;

    public SVGAssetBitmapTextureAtlasSource(Context pContext, String pAssetPath, int pTexturePositionX, int pTexturePositionY) {
        this(pContext, pAssetPath, pTexturePositionX, pTexturePositionY, null);
    }

    public SVGAssetBitmapTextureAtlasSource(Context pContext, String pAssetPath, int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight) {
        this(pContext, pAssetPath, pTexturePositionX, pTexturePositionY, pWidth, pHeight, null);
    }

    public SVGAssetBitmapTextureAtlasSource(Context pContext, String pAssetPath, int pTexturePositionX, int pTexturePositionY, float pScale) {
        this(pContext, pAssetPath, pTexturePositionX, pTexturePositionY, pScale, null);
    }

    public SVGAssetBitmapTextureAtlasSource(Context pContext, String pAssetPath, int pTexturePositionX, int pTexturePositionY, ISVGColorMapper pSVGColorMapper) {
        super(getSVG(pContext, pAssetPath, pSVGColorMapper), pTexturePositionX, pTexturePositionY);
        this.mContext = pContext;
        this.mAssetPath = pAssetPath;
        this.mSVGColorMapper = pSVGColorMapper;
    }

    public SVGAssetBitmapTextureAtlasSource(Context pContext, String pAssetPath, int pTexturePositionX, int pTexturePositionY, float pScale, ISVGColorMapper pSVGColorMapper) {
        super(getSVG(pContext, pAssetPath, pSVGColorMapper), pTexturePositionX, pTexturePositionY, pScale);
        this.mContext = pContext;
        this.mAssetPath = pAssetPath;
        this.mSVGColorMapper = pSVGColorMapper;
    }

    public SVGAssetBitmapTextureAtlasSource(Context pContext, String pAssetPath, int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight, ISVGColorMapper pSVGColorMapper) {
        super(getSVG(pContext, pAssetPath, pSVGColorMapper), pTexturePositionX, pTexturePositionY, pWidth, pHeight);
        this.mContext = pContext;
        this.mAssetPath = pAssetPath;
        this.mSVGColorMapper = pSVGColorMapper;
    }

    public SVGAssetBitmapTextureAtlasSource deepCopy() {
        return new SVGAssetBitmapTextureAtlasSource(this.mContext, this.mAssetPath, this.mTexturePositionX, this.mTexturePositionY, this.mWidth, this.mHeight, this.mSVGColorMapper);
    }

    private static SVG getSVG(Context pContext, String pAssetPath, ISVGColorMapper pSVGColorMapper) {
        try {
            return SVGParser.parseSVGFromAsset(pContext.getAssets(), pAssetPath, pSVGColorMapper);
        } catch (Throwable t) {
            Debug.m62e("Failed loading SVG in SVGAssetBitmapTextureAtlasSource. AssetPath: " + pAssetPath, t);
            return null;
        }
    }
}
