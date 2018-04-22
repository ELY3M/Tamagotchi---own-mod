package org.anddev.andengine.extension.svg.opengl.texture.atlas.bitmap.source;

import org.anddev.andengine.extension.svg.adt.SVG;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.PictureBitmapTextureAtlasSource;
import org.anddev.andengine.util.Debug;

public class SVGBaseBitmapTextureAtlasSource extends PictureBitmapTextureAtlasSource {
    private final SVG mSVG;

    public SVGBaseBitmapTextureAtlasSource(SVG pSVG) {
        this(pSVG, 0, 0);
    }

    public SVGBaseBitmapTextureAtlasSource(SVG pSVG, float pScale) {
        this(pSVG, 0, 0, pScale);
    }

    public SVGBaseBitmapTextureAtlasSource(SVG pSVG, int pTexturePositionX, int pTexturePositionY, float pScale) {
        super(pSVG.getPicture(), pTexturePositionX, pTexturePositionY, pScale);
        this.mSVG = pSVG;
    }

    public SVGBaseBitmapTextureAtlasSource(SVG pSVG, int pWidth, int pHeight) {
        this(pSVG, 0, 0, pWidth, pHeight);
    }

    public SVGBaseBitmapTextureAtlasSource(SVG pSVG, int pTexturePositionX, int pTexturePositionY, int pWidth, int pHeight) {
        super(pSVG.getPicture(), pTexturePositionX, pTexturePositionY, pWidth, pHeight);
        this.mSVG = pSVG;
    }

    public SVGBaseBitmapTextureAtlasSource deepCopy() {
        Debug.m68w("SVGBaseBitmapTextureAtlasSource.deepCopy() does not actually deepCopy the SVG!");
        return new SVGBaseBitmapTextureAtlasSource(this.mSVG, this.mTexturePositionX, this.mTexturePositionY, this.mWidth, this.mHeight);
    }
}
