package org.anddev.andengine.opengl.texture.atlas.buildable;

import java.io.IOException;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.ITextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.ITextureAtlas.ITextureAtlasStateListener;
import org.anddev.andengine.opengl.texture.atlas.buildable.builder.ITextureBuilder;
import org.anddev.andengine.opengl.texture.atlas.buildable.builder.ITextureBuilder.TextureAtlasSourcePackingException;
import org.anddev.andengine.opengl.texture.source.ITextureAtlasSource;
import org.anddev.andengine.util.Callback;

public class BuildableTextureAtlas<T extends ITextureAtlasSource, A extends ITextureAtlas<T>> implements ITextureAtlas<T> {
    private final A mTextureAtlas;
    private final ArrayList<TextureAtlasSourceWithWithLocationCallback<T>> mTextureAtlasSourcesToPlace = new ArrayList();

    public static class TextureAtlasSourceWithWithLocationCallback<T extends ITextureAtlasSource> {
        private final Callback<T> mCallback;
        private final T mTextureAtlasSource;

        public TextureAtlasSourceWithWithLocationCallback(T pTextureAtlasSource, Callback<T> pCallback) {
            this.mTextureAtlasSource = pTextureAtlasSource;
            this.mCallback = pCallback;
        }

        public Callback<T> getCallback() {
            return this.mCallback;
        }

        public T getTextureAtlasSource() {
            return this.mTextureAtlasSource;
        }
    }

    public BuildableTextureAtlas(A pTextureAtlas) {
        this.mTextureAtlas = pTextureAtlas;
    }

    public int getWidth() {
        return this.mTextureAtlas.getWidth();
    }

    public int getHeight() {
        return this.mTextureAtlas.getHeight();
    }

    public int getHardwareTextureID() {
        return this.mTextureAtlas.getHardwareTextureID();
    }

    public boolean isLoadedToHardware() {
        return this.mTextureAtlas.isLoadedToHardware();
    }

    public void setLoadedToHardware(boolean pLoadedToHardware) {
        this.mTextureAtlas.setLoadedToHardware(pLoadedToHardware);
    }

    public boolean isUpdateOnHardwareNeeded() {
        return this.mTextureAtlas.isUpdateOnHardwareNeeded();
    }

    public void setUpdateOnHardwareNeeded(boolean pUpdateOnHardwareNeeded) {
        this.mTextureAtlas.setUpdateOnHardwareNeeded(pUpdateOnHardwareNeeded);
    }

    public void loadToHardware(GL10 pGL) throws IOException {
        this.mTextureAtlas.loadToHardware(pGL);
    }

    public void unloadFromHardware(GL10 pGL) {
        this.mTextureAtlas.unloadFromHardware(pGL);
    }

    public void reloadToHardware(GL10 pGL) throws IOException {
        this.mTextureAtlas.reloadToHardware(pGL);
    }

    public void bind(GL10 pGL) {
        this.mTextureAtlas.bind(pGL);
    }

    public TextureOptions getTextureOptions() {
        return this.mTextureAtlas.getTextureOptions();
    }

    @Deprecated
    public void addTextureAtlasSource(T pTextureAtlasSource, int pTexturePositionX, int pTexturePositionY) {
        this.mTextureAtlas.addTextureAtlasSource(pTextureAtlasSource, pTexturePositionX, pTexturePositionY);
    }

    public void removeTextureAtlasSource(T pTextureAtlasSource, int pTexturePositionX, int pTexturePositionY) {
        this.mTextureAtlas.removeTextureAtlasSource(pTextureAtlasSource, pTexturePositionX, pTexturePositionY);
    }

    public void clearTextureAtlasSources() {
        this.mTextureAtlas.clearTextureAtlasSources();
        this.mTextureAtlasSourcesToPlace.clear();
    }

    public boolean hasTextureStateListener() {
        return this.mTextureAtlas.hasTextureStateListener();
    }

    public ITextureAtlasStateListener<T> getTextureStateListener() {
        return this.mTextureAtlas.getTextureStateListener();
    }

    public void addTextureAtlasSource(T pTextureAtlasSource, Callback<T> pCallback) {
        this.mTextureAtlasSourcesToPlace.add(new TextureAtlasSourceWithWithLocationCallback(pTextureAtlasSource, pCallback));
    }

    public void removeTextureAtlasSource(ITextureAtlasSource pTextureAtlasSource) {
        ArrayList<TextureAtlasSourceWithWithLocationCallback<T>> textureSources = this.mTextureAtlasSourcesToPlace;
        for (int i = textureSources.size() - 1; i >= 0; i--) {
            if (((TextureAtlasSourceWithWithLocationCallback) textureSources.get(i)).mTextureAtlasSource == pTextureAtlasSource) {
                textureSources.remove(i);
                this.mTextureAtlas.setUpdateOnHardwareNeeded(true);
                return;
            }
        }
    }

    public void build(ITextureBuilder<T, A> pTextureAtlasSourcePackingAlgorithm) throws TextureAtlasSourcePackingException {
        pTextureAtlasSourcePackingAlgorithm.pack(this.mTextureAtlas, this.mTextureAtlasSourcesToPlace);
        this.mTextureAtlasSourcesToPlace.clear();
        this.mTextureAtlas.setUpdateOnHardwareNeeded(true);
    }
}
