package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator;

import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape.IBitmapTextureAtlasSourceDecoratorShape;

public class ColorKeyBitmapTextureAtlasSourceDecorator extends ColorSwapBitmapTextureAtlasSourceDecorator {
    public ColorKeyBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pColorKeyColor) {
        super(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pColorKeyColor, 0);
    }

    public ColorKeyBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pColorKeyColor, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        super(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pColorKeyColor, 0, pTextureAtlasSourceDecoratorOptions);
    }

    public ColorKeyBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pColorKeyColor, int pTolerance) {
        super(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pColorKeyColor, 0, pTolerance);
    }

    public ColorKeyBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pColorKeyColor, int pTolerance, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        super(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pColorKeyColor, pTolerance, 0, pTextureAtlasSourceDecoratorOptions);
    }

    public ColorKeyBitmapTextureAtlasSourceDecorator deepCopy() {
        return new ColorKeyBitmapTextureAtlasSourceDecorator(this.mBitmapTextureAtlasSource, this.mBitmapTextureAtlasSourceDecoratorShape, this.mColorKeyColor, this.mTolerance, this.mTextureAtlasSourceDecoratorOptions);
    }
}
