package org.anddev.andengine.extension.svg.opengl.texture.atlas.bitmap.source;

import android.content.Context;
import org.anddev.andengine.extension.svg.SVGParser;
import org.anddev.andengine.extension.svg.adt.ISVGColorMapper;
import org.anddev.andengine.extension.svg.adt.SVG;
import org.anddev.andengine.util.Debug;

public class SVGResourceBitmapTextureAtlasSource extends SVGBaseBitmapTextureAtlasSource {
    private final Context mContext;
    private final int mRawResourceID;
    private final ISVGColorMapper mSVGColorMapper;

    public SVGResourceBitmapTextureAtlasSource(Context pContext, int pRawResourceID, int pTexturePositionX, int pTexturePositionY) {
        this(pContext, pRawResourceID, pTexturePositionX, pTexturePositionY, null);
    }

    public SVGResourceBitmapTextureAtlasSource(Context pContext, int pRawResourceID, int pTexturePositionX, int pTexturePositionY, float pScale) {
        this(pContext, pRawResourceID, pTexturePositionX, pTexturePositionY, pScale, null);
    }

    public SVGResourceBitmapTextureAtlasSource(Context pContext, int pRawResourceID, int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight) {
        this(pContext, pRawResourceID, pTexturePositionX, pTexturePositionY, pWidth, pHeight, null);
    }

    public SVGResourceBitmapTextureAtlasSource(Context pContext, int pRawResourceID, int pTexturePositionX, int pTexturePositionY, ISVGColorMapper pSVGColorMapper) {
        super(getSVG(pContext, pRawResourceID, pSVGColorMapper), pTexturePositionX, pTexturePositionY);
        this.mContext = pContext;
        this.mRawResourceID = pRawResourceID;
        this.mSVGColorMapper = pSVGColorMapper;
    }

    public SVGResourceBitmapTextureAtlasSource(Context pContext, int pRawResourceID, int pTexturePositionX, int pTexturePositionY, float pScale, ISVGColorMapper pSVGColorMapper) {
        super(getSVG(pContext, pRawResourceID, pSVGColorMapper), pTexturePositionX, pTexturePositionY, pScale);
        this.mContext = pContext;
        this.mRawResourceID = pRawResourceID;
        this.mSVGColorMapper = pSVGColorMapper;
    }

    public SVGResourceBitmapTextureAtlasSource(Context pContext, int pRawResourceID, int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight, ISVGColorMapper pSVGColorMapper) {
        super(getSVG(pContext, pRawResourceID, pSVGColorMapper), pTexturePositionX, pTexturePositionY, pWidth, pHeight);
        this.mContext = pContext;
        this.mRawResourceID = pRawResourceID;
        this.mSVGColorMapper = pSVGColorMapper;
    }

    public SVGResourceBitmapTextureAtlasSource deepCopy() {
        return new SVGResourceBitmapTextureAtlasSource(this.mContext, this.mRawResourceID, this.mTexturePositionX, this.mTexturePositionY, this.mWidth, this.mHeight, this.mSVGColorMapper);
    }

    private static SVG getSVG(Context pContext, int pRawResourceID, ISVGColorMapper pSVGColorMapper) {
        try {
            return SVGParser.parseSVGFromResource(pContext.getResources(), pRawResourceID, pSVGColorMapper);
        } catch (Throwable t) {
            Debug.m62e("Failed loading SVG in SVGResourceBitmapTextureAtlasSource. RawResourceID: " + pRawResourceID, t);
            return null;
        }
    }
}
