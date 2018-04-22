package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;

public class RoundedRectangleBitmapTextureAtlasSourceDecoratorShape implements IBitmapTextureAtlasSourceDecoratorShape {
    private static final float CORNER_RADIUS_DEFAULT = 1.0f;
    private static RoundedRectangleBitmapTextureAtlasSourceDecoratorShape sDefaultInstance;
    private final float mCornerRadiusX;
    private final float mCornerRadiusY;
    private final RectF mRectF;

    public RoundedRectangleBitmapTextureAtlasSourceDecoratorShape() {
        this(1.0f, 1.0f);
    }

    public RoundedRectangleBitmapTextureAtlasSourceDecoratorShape(float pCornerRadiusX, float pCornerRadiusY) {
        this.mRectF = new RectF();
        this.mCornerRadiusX = pCornerRadiusX;
        this.mCornerRadiusY = pCornerRadiusY;
    }

    public static RoundedRectangleBitmapTextureAtlasSourceDecoratorShape getDefaultInstance() {
        if (sDefaultInstance == null) {
            sDefaultInstance = new RoundedRectangleBitmapTextureAtlasSourceDecoratorShape();
        }
        return sDefaultInstance;
    }

    public void onDecorateBitmap(Canvas pCanvas, Paint pPaint, TextureAtlasSourceDecoratorOptions pDecoratorOptions) {
        this.mRectF.set(pDecoratorOptions.getInsetLeft(), pDecoratorOptions.getInsetTop(), ((float) pCanvas.getWidth()) - pDecoratorOptions.getInsetRight(), ((float) pCanvas.getHeight()) - pDecoratorOptions.getInsetBottom());
        pCanvas.drawRoundRect(this.mRectF, this.mCornerRadiusX, this.mCornerRadiusY, pPaint);
    }
}
