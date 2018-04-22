package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator;

import android.graphics.Canvas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape.IBitmapTextureAtlasSourceDecoratorShape;

public abstract class BaseShapeBitmapTextureAtlasSourceDecorator extends BaseBitmapTextureAtlasSourceDecorator {
    protected final IBitmapTextureAtlasSourceDecoratorShape mBitmapTextureAtlasSourceDecoratorShape;

    public abstract BaseShapeBitmapTextureAtlasSourceDecorator deepCopy();

    public BaseShapeBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        super(pBitmapTextureAtlasSource, pTextureAtlasSourceDecoratorOptions);
        this.mBitmapTextureAtlasSourceDecoratorShape = pBitmapTextureAtlasSourceDecoratorShape;
    }

    protected void onDecorateBitmap(Canvas pCanvas) {
        this.mBitmapTextureAtlasSourceDecoratorShape.onDecorateBitmap(pCanvas, this.mPaint, this.mTextureAtlasSourceDecoratorOptions == null ? TextureAtlasSourceDecoratorOptions.DEFAULT : this.mTextureAtlasSourceDecoratorOptions);
    }
}
