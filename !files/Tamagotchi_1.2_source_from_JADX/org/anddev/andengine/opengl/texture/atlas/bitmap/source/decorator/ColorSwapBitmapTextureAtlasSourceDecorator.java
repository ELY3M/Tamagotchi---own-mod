package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator;

import android.graphics.AvoidXfermode;
import android.graphics.AvoidXfermode.Mode;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape.IBitmapTextureAtlasSourceDecoratorShape;

public class ColorSwapBitmapTextureAtlasSourceDecorator extends BaseShapeBitmapTextureAtlasSourceDecorator {
    private static final int TOLERANCE_DEFAULT = 0;
    protected final int mColorKeyColor;
    protected final int mColorSwapColor;
    protected final int mTolerance;

    public ColorSwapBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pColorKeyColor, int pColorSwapColor) {
        this(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pColorKeyColor, 0, pColorSwapColor, null);
    }

    public ColorSwapBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pColorKeyColor, int pColorSwapColor, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        this(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pColorKeyColor, 0, pColorSwapColor, pTextureAtlasSourceDecoratorOptions);
    }

    public ColorSwapBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pColorKeyColor, int pTolerance, int pColorSwapColor) {
        this(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pColorKeyColor, pTolerance, pColorSwapColor, null);
    }

    public ColorSwapBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pColorKeyColor, int pTolerance, int pColorSwapColor, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        super(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pTextureAtlasSourceDecoratorOptions);
        this.mColorKeyColor = pColorKeyColor;
        this.mTolerance = pTolerance;
        this.mColorSwapColor = pColorSwapColor;
        this.mPaint.setXfermode(new AvoidXfermode(pColorKeyColor, pTolerance, Mode.TARGET));
        this.mPaint.setColor(pColorSwapColor);
    }

    public ColorSwapBitmapTextureAtlasSourceDecorator deepCopy() {
        return new ColorSwapBitmapTextureAtlasSourceDecorator(this.mBitmapTextureAtlasSource, this.mBitmapTextureAtlasSourceDecoratorShape, this.mColorKeyColor, this.mTolerance, this.mColorSwapColor, this.mTextureAtlasSourceDecoratorOptions);
    }
}
