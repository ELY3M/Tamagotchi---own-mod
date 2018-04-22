package org.anddev.andengine.opengl.texture.atlas.bitmap.source;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import org.anddev.andengine.opengl.texture.source.ITextureAtlasSource;

public interface IBitmapTextureAtlasSource extends ITextureAtlasSource {
    IBitmapTextureAtlasSource deepCopy();

    Bitmap onLoadBitmap(Config config);
}
