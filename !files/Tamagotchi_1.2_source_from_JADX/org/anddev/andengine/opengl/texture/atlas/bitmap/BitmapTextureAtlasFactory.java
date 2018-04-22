package org.anddev.andengine.opengl.texture.atlas.bitmap;

import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.bitmap.BitmapTexture.BitmapTextureFormat;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.util.MathUtils;

public class BitmapTextureAtlasFactory {
    public static BitmapTextureAtlas createForTextureAtlasSourceSize(BitmapTextureFormat pBitmapTextureFormat, TextureRegion pTextureRegion) {
        return createForTextureRegionSize(pBitmapTextureFormat, pTextureRegion, TextureOptions.DEFAULT);
    }

    public static BitmapTextureAtlas createForTextureRegionSize(BitmapTextureFormat pBitmapTextureFormat, TextureRegion pTextureRegion, TextureOptions pTextureOptions) {
        return new BitmapTextureAtlas(MathUtils.nextPowerOfTwo(pTextureRegion.getWidth()), MathUtils.nextPowerOfTwo(pTextureRegion.getHeight()), pBitmapTextureFormat, pTextureOptions);
    }

    public static BitmapTextureAtlas createForTextureAtlasSourceSize(BitmapTextureFormat pBitmapTextureFormat, IBitmapTextureAtlasSource pBitmapTextureAtlasSource) {
        return createForTextureAtlasSourceSize(pBitmapTextureFormat, pBitmapTextureAtlasSource, TextureOptions.DEFAULT);
    }

    public static BitmapTextureAtlas createForTextureAtlasSourceSize(BitmapTextureFormat pBitmapTextureFormat, IBitmapTextureAtlasSource pBitmapTextureAtlasSource, TextureOptions pTextureOptions) {
        return new BitmapTextureAtlas(MathUtils.nextPowerOfTwo(pBitmapTextureAtlasSource.getWidth()), MathUtils.nextPowerOfTwo(pBitmapTextureAtlasSource.getHeight()), pBitmapTextureFormat, pTextureOptions);
    }
}
