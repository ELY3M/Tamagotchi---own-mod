package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;

public class CircleBitmapTextureAtlasSourceDecoratorShape implements IBitmapTextureAtlasSourceDecoratorShape {
    private static CircleBitmapTextureAtlasSourceDecoratorShape sDefaultInstance;

    public static CircleBitmapTextureAtlasSourceDecoratorShape getDefaultInstance() {
        if (sDefaultInstance == null) {
            sDefaultInstance = new CircleBitmapTextureAtlasSourceDecoratorShape();
        }
        return sDefaultInstance;
    }

    public void onDecorateBitmap(Canvas pCanvas, Paint pPaint, TextureAtlasSourceDecoratorOptions pDecoratorOptions) {
        pCanvas.drawCircle(((((float) pCanvas.getWidth()) + pDecoratorOptions.getInsetLeft()) - pDecoratorOptions.getInsetRight()) * 0.5f, ((((float) pCanvas.getHeight()) + pDecoratorOptions.getInsetTop()) - pDecoratorOptions.getInsetBottom()) * 0.5f, Math.min(((((float) pCanvas.getWidth()) - pDecoratorOptions.getInsetLeft()) - pDecoratorOptions.getInsetRight()) * 0.5f, ((((float) pCanvas.getHeight()) - pDecoratorOptions.getInsetTop()) - pDecoratorOptions.getInsetBottom()) * 0.5f), pPaint);
    }
}
