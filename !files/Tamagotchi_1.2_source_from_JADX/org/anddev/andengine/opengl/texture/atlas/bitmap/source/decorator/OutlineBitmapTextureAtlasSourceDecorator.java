package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator;

import android.graphics.Paint.Style;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape.IBitmapTextureAtlasSourceDecoratorShape;

public class OutlineBitmapTextureAtlasSourceDecorator extends BaseShapeBitmapTextureAtlasSourceDecorator {
    protected final int mOutlineColor;

    public OutlineBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pOutlineColor) {
        this(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pOutlineColor, null);
    }

    public OutlineBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pOutlineColor, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        super(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pTextureAtlasSourceDecoratorOptions);
        this.mOutlineColor = pOutlineColor;
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setColor(pOutlineColor);
    }

    public OutlineBitmapTextureAtlasSourceDecorator deepCopy() {
        return new OutlineBitmapTextureAtlasSourceDecorator(this.mBitmapTextureAtlasSource, this.mBitmapTextureAtlasSourceDecoratorShape, this.mOutlineColor, this.mTextureAtlasSourceDecoratorOptions);
    }
}
