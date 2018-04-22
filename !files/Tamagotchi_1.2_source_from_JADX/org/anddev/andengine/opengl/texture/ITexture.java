package org.anddev.andengine.opengl.texture;

import java.io.IOException;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.opengl.texture.source.ITextureAtlasSource;
import org.anddev.andengine.util.Debug;

public interface ITexture {

    public interface ITextureStateListener {

        public static class DebugTextureStateListener<T extends ITextureAtlasSource> implements ITextureStateListener {
            public void onLoadedToHardware(ITexture pTexture) {
                Debug.m59d("Texture loaded: " + pTexture.toString());
            }

            public void onUnloadedFromHardware(ITexture pTexture) {
                Debug.m59d("Texture unloaded: " + pTexture.toString());
            }
        }

        public static class TextureStateAdapter<T extends ITextureAtlasSource> implements ITextureStateListener {
            public void onLoadedToHardware(ITexture pTexture) {
            }

            public void onUnloadedFromHardware(ITexture pTexture) {
            }
        }

        void onLoadedToHardware(ITexture iTexture);

        void onUnloadedFromHardware(ITexture iTexture);
    }

    void bind(GL10 gl10);

    int getHardwareTextureID();

    int getHeight();

    TextureOptions getTextureOptions();

    ITextureStateListener getTextureStateListener();

    int getWidth();

    boolean hasTextureStateListener();

    boolean isLoadedToHardware();

    boolean isUpdateOnHardwareNeeded();

    void loadToHardware(GL10 gl10) throws IOException;

    void reloadToHardware(GL10 gl10) throws IOException;

    void setLoadedToHardware(boolean z);

    void setUpdateOnHardwareNeeded(boolean z);

    void unloadFromHardware(GL10 gl10);
}
