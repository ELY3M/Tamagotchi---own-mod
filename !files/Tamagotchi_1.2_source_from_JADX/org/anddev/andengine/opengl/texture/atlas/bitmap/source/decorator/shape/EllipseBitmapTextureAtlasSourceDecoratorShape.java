package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;

public class EllipseBitmapTextureAtlasSourceDecoratorShape implements IBitmapTextureAtlasSourceDecoratorShape {
    private static EllipseBitmapTextureAtlasSourceDecoratorShape sDefaultInstance;
    private final RectF mRectF = new RectF();

    public static EllipseBitmapTextureAtlasSourceDecoratorShape getDefaultInstance() {
        if (sDefaultInstance == null) {
            sDefaultInstance = new EllipseBitmapTextureAtlasSourceDecoratorShape();
        }
        return sDefaultInstance;
    }

    public void onDecorateBitmap(Canvas pCanvas, Paint pPaint, TextureAtlasSourceDecoratorOptions pDecoratorOptions) {
        this.mRectF.set(pDecoratorOptions.getInsetLeft(), pDecoratorOptions.getInsetTop(), ((float) pCanvas.getWidth()) - pDecoratorOptions.getInsetRight(), ((float) pCanvas.getHeight()) - pDecoratorOptions.getInsetBottom());
        pCanvas.drawOval(this.mRectF, pPaint);
    }
}
