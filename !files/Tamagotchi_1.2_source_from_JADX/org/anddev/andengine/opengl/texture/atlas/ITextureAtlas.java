package org.anddev.andengine.opengl.texture.atlas;

import org.anddev.andengine.opengl.texture.ITexture;
import org.anddev.andengine.opengl.texture.ITexture.ITextureStateListener;
import org.anddev.andengine.opengl.texture.source.ITextureAtlasSource;
import org.anddev.andengine.util.Debug;

public interface ITextureAtlas<T extends ITextureAtlasSource> extends ITexture {

    public interface ITextureAtlasStateListener<T extends ITextureAtlasSource> extends ITextureStateListener {

        public static class DebugTextureAtlasStateListener<T extends ITextureAtlasSource> implements ITextureAtlasStateListener<T> {
            public void onLoadedToHardware(ITexture pTexture) {
                Debug.m59d("Texture loaded: " + pTexture.toString());
            }

            public void onTextureAtlasSourceLoadExeption(ITextureAtlas<T> pTextureAtlas, T pTextureAtlasSource, Throwable pThrowable) {
                Debug.m62e("Exception loading TextureAtlasSource. TextureAtlas: " + pTextureAtlas.toString() + " TextureAtlasSource: " + pTextureAtlasSource.toString(), pThrowable);
            }

            public void onUnloadedFromHardware(ITexture pTexture) {
                Debug.m59d("Texture unloaded: " + pTexture.toString());
            }
        }

        public static class TextureAtlasStateAdapter<T extends ITextureAtlasSource> implements ITextureAtlasStateListener<T> {
            public void onLoadedToHardware(ITexture pTexture) {
            }

            public void onTextureAtlasSourceLoadExeption(ITextureAtlas<T> iTextureAtlas, T t, Throwable pThrowable) {
            }

            public void onUnloadedFromHardware(ITexture pTexture) {
            }
        }

        void onTextureAtlasSourceLoadExeption(ITextureAtlas<T> iTextureAtlas, T t, Throwable th);
    }

    void addTextureAtlasSource(T t, int i, int i2) throws IllegalArgumentException;

    void clearTextureAtlasSources();

    ITextureAtlasStateListener<T> getTextureStateListener();

    void removeTextureAtlasSource(T t, int i, int i2);
}
