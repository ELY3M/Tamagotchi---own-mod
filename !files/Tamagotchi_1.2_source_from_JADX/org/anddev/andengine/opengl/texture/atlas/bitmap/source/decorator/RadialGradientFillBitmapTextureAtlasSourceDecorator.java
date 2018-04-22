package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator;

import android.graphics.Paint.Style;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape.IBitmapTextureAtlasSourceDecoratorShape;
import org.anddev.andengine.util.ArrayUtils;

public class RadialGradientFillBitmapTextureAtlasSourceDecorator extends BaseShapeBitmapTextureAtlasSourceDecorator {
    private static /* synthetic */ int[] f22xb709433b;
    private static final float[] POSITIONS_DEFAULT = new float[]{0.0f, 1.0f};
    protected final int[] mColors;
    protected final float[] mPositions;
    protected final RadialGradientDirection mRadialGradientDirection;

    public enum RadialGradientDirection {
        INSIDE_OUT,
        OUTSIDE_IN
    }

    static /* synthetic */ int[] m73xb709433b() {
        int[] iArr = f22xb709433b;
        if (iArr == null) {
            iArr = new int[RadialGradientDirection.values().length];
            try {
                iArr[RadialGradientDirection.INSIDE_OUT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RadialGradientDirection.OUTSIDE_IN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f22xb709433b = iArr;
        }
        return iArr;
    }

    public RadialGradientFillBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pFromColor, int pToColor, RadialGradientDirection pRadialGradientDirection) {
        this(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pFromColor, pToColor, pRadialGradientDirection, null);
    }

    public RadialGradientFillBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pFromColor, int pToColor, RadialGradientDirection pRadialGradientDirection, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        IBitmapTextureAtlasSource iBitmapTextureAtlasSource = pBitmapTextureAtlasSource;
        IBitmapTextureAtlasSourceDecoratorShape iBitmapTextureAtlasSourceDecoratorShape = pBitmapTextureAtlasSourceDecoratorShape;
        this(iBitmapTextureAtlasSource, iBitmapTextureAtlasSourceDecoratorShape, new int[]{pFromColor, pToColor}, POSITIONS_DEFAULT, pRadialGradientDirection, pTextureAtlasSourceDecoratorOptions);
    }

    public RadialGradientFillBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int[] pColors, float[] pPositions, RadialGradientDirection pRadialGradientDirection) {
        this(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pColors, pPositions, pRadialGradientDirection, null);
    }

    public RadialGradientFillBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int[] pColors, float[] pPositions, RadialGradientDirection pRadialGradientDirection, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        super(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pTextureAtlasSourceDecoratorOptions);
        this.mColors = pColors;
        this.mPositions = pPositions;
        this.mRadialGradientDirection = pRadialGradientDirection;
        this.mPaint.setStyle(Style.FILL);
        float centerX = ((float) pBitmapTextureAtlasSource.getWidth()) * 0.5f;
        float centerY = ((float) pBitmapTextureAtlasSource.getHeight()) * 0.5f;
        float radius = Math.max(centerX, centerY);
        switch (m73xb709433b()[pRadialGradientDirection.ordinal()]) {
            case 1:
                this.mPaint.setShader(new RadialGradient(centerX, centerY, radius, pColors, pPositions, TileMode.CLAMP));
                return;
            case 2:
                ArrayUtils.reverse(pColors);
                this.mPaint.setShader(new RadialGradient(centerX, centerY, radius, pColors, pPositions, TileMode.CLAMP));
                return;
            default:
                return;
        }
    }

    public RadialGradientFillBitmapTextureAtlasSourceDecorator deepCopy() {
        return new RadialGradientFillBitmapTextureAtlasSourceDecorator(this.mBitmapTextureAtlasSource, this.mBitmapTextureAtlasSourceDecoratorShape, this.mColors, this.mPositions, this.mRadialGradientDirection, this.mTextureAtlasSourceDecoratorOptions);
    }
}
