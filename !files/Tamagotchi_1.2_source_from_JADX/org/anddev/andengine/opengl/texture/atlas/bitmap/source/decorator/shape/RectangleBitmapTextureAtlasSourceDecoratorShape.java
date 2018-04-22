package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;

public class RectangleBitmapTextureAtlasSourceDecoratorShape implements IBitmapTextureAtlasSourceDecoratorShape {
    private static RectangleBitmapTextureAtlasSourceDecoratorShape sDefaultInstance;

    public static RectangleBitmapTextureAtlasSourceDecoratorShape getDefaultInstance() {
        if (sDefaultInstance == null) {
            sDefaultInstance = new RectangleBitmapTextureAtlasSourceDecoratorShape();
        }
        return sDefaultInstance;
    }

    public void onDecorateBitmap(Canvas pCanvas, Paint pPaint, TextureAtlasSourceDecoratorOptions pDecoratorOptions) {
        pCanvas.drawRect(pDecoratorOptions.getInsetLeft(), pDecoratorOptions.getInsetTop(), ((float) pCanvas.getWidth()) - pDecoratorOptions.getInsetRight(), ((float) pCanvas.getHeight()) - pDecoratorOptions.getInsetBottom(), pPaint);
    }
}
