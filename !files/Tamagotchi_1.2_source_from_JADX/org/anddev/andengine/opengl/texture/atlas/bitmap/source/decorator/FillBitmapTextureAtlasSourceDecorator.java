package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator;

import android.graphics.Paint.Style;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape.IBitmapTextureAtlasSourceDecoratorShape;

public class FillBitmapTextureAtlasSourceDecorator extends BaseShapeBitmapTextureAtlasSourceDecorator {
    protected final int mFillColor;

    public FillBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pFillColor) {
        this(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pFillColor, null);
    }

    public FillBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pFillColor, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        super(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pTextureAtlasSourceDecoratorOptions);
        this.mFillColor = pFillColor;
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setColor(pFillColor);
    }

    public FillBitmapTextureAtlasSourceDecorator deepCopy() {
        return new FillBitmapTextureAtlasSourceDecorator(this.mBitmapTextureAtlasSource, this.mBitmapTextureAtlasSourceDecoratorShape, this.mFillColor, this.mTextureAtlasSourceDecoratorOptions);
    }
}
