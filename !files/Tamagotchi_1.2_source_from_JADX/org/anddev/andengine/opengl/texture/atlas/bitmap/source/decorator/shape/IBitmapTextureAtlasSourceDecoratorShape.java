package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;

public interface IBitmapTextureAtlasSourceDecoratorShape {
    void onDecorateBitmap(Canvas canvas, Paint paint, TextureAtlasSourceDecoratorOptions textureAtlasSourceDecoratorOptions);
}
