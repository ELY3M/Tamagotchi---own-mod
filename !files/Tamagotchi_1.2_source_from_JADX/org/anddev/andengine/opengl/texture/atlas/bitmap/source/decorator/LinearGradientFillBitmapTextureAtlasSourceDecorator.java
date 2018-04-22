package org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator;

import android.graphics.LinearGradient;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.BaseBitmapTextureAtlasSourceDecorator.TextureAtlasSourceDecoratorOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.decorator.shape.IBitmapTextureAtlasSourceDecoratorShape;

public class LinearGradientFillBitmapTextureAtlasSourceDecorator extends BaseShapeBitmapTextureAtlasSourceDecorator {
    protected final int[] mColors;
    protected final LinearGradientDirection mLinearGradientDirection;
    protected final float[] mPositions;

    public enum LinearGradientDirection {
        LEFT_TO_RIGHT(1, 0, 0, 0),
        RIGHT_TO_LEFT(0, 0, 1, 0),
        BOTTOM_TO_TOP(0, 1, 0, 0),
        TOP_TO_BOTTOM(0, 0, 0, 1),
        TOPLEFT_TO_BOTTOMRIGHT(0, 0, 1, 1),
        BOTTOMRIGHT_TO_TOPLEFT(1, 1, 0, 0),
        TOPRIGHT_TO_BOTTOMLEFT(1, 0, 0, 1),
        BOTTOMLEFT_TO_TOPRIGHT(0, 1, 1, 0);
        
        private final int mFromX;
        private final int mFromY;
        private final int mToX;
        private final int mToY;

        private LinearGradientDirection(int pFromX, int pFromY, int pToX, int pToY) {
            this.mFromX = pFromX;
            this.mFromY = pFromY;
            this.mToX = pToX;
            this.mToY = pToY;
        }

        final int getFromX(int pRight) {
            return this.mFromX * pRight;
        }

        final int getFromY(int pBottom) {
            return this.mFromY * pBottom;
        }

        final int getToX(int pRight) {
            return this.mToX * pRight;
        }

        final int getToY(int pBottom) {
            return this.mToY * pBottom;
        }
    }

    public LinearGradientFillBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pFromColor, int pToColor, LinearGradientDirection pLinearGradientDirection) {
        this(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pFromColor, pToColor, pLinearGradientDirection, null);
    }

    public LinearGradientFillBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int pFromColor, int pToColor, LinearGradientDirection pLinearGradientDirection, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        this(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, new int[]{pFromColor, pToColor}, null, pLinearGradientDirection, pTextureAtlasSourceDecoratorOptions);
    }

    public LinearGradientFillBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int[] pColors, float[] pPositions, LinearGradientDirection pLinearGradientDirection) {
        this(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pColors, pPositions, pLinearGradientDirection, null);
    }

    public LinearGradientFillBitmapTextureAtlasSourceDecorator(IBitmapTextureAtlasSource pBitmapTextureAtlasSource, IBitmapTextureAtlasSourceDecoratorShape pBitmapTextureAtlasSourceDecoratorShape, int[] pColors, float[] pPositions, LinearGradientDirection pLinearGradientDirection, TextureAtlasSourceDecoratorOptions pTextureAtlasSourceDecoratorOptions) {
        super(pBitmapTextureAtlasSource, pBitmapTextureAtlasSourceDecoratorShape, pTextureAtlasSourceDecoratorOptions);
        this.mColors = pColors;
        this.mPositions = pPositions;
        this.mLinearGradientDirection = pLinearGradientDirection;
        this.mPaint.setStyle(Style.FILL);
        int right = pBitmapTextureAtlasSource.getWidth() - 1;
        int bottom = pBitmapTextureAtlasSource.getHeight() - 1;
        this.mPaint.setShader(new LinearGradient((float) pLinearGradientDirection.getFromX(right), (float) pLinearGradientDirection.getFromY(bottom), (float) pLinearGradientDirection.getToX(right), (float) pLinearGradientDirection.getToY(bottom), pColors, pPositions, TileMode.CLAMP));
    }

    public LinearGradientFillBitmapTextureAtlasSourceDecorator deepCopy() {
        return new LinearGradientFillBitmapTextureAtlasSourceDecorator(this.mBitmapTextureAtlasSource, this.mBitmapTextureAtlasSourceDecoratorShape, this.mColors, this.mPositions, this.mLinearGradientDirection, this.mTextureAtlasSourceDecoratorOptions);
    }
}
