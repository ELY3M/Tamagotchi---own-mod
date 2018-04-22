package org.anddev.andengine.opengl.texture.atlas;

import java.util.ArrayList;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.Texture.PixelFormat;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.ITextureAtlas.ITextureAtlasStateListener;
import org.anddev.andengine.opengl.texture.source.ITextureAtlasSource;
import org.anddev.andengine.util.MathUtils;

public abstract class TextureAtlas<T extends ITextureAtlasSource> extends Texture implements ITextureAtlas<T> {
    protected final int mHeight;
    protected final ArrayList<T> mTextureAtlasSources = new ArrayList();
    protected final int mWidth;

    public TextureAtlas(int pWidth, int pHeight, PixelFormat pPixelFormat, TextureOptions pTextureOptions, ITextureAtlasStateListener<T> pTextureAtlasStateListener) {
        super(pPixelFormat, pTextureOptions, pTextureAtlasStateListener);
        if (MathUtils.isPowerOfTwo(pWidth) && MathUtils.isPowerOfTwo(pHeight)) {
            this.mWidth = pWidth;
            this.mHeight = pHeight;
            return;
        }
        throw new IllegalArgumentException("pWidth and pHeight must be a power of 2!");
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public ITextureAtlasStateListener<T> getTextureStateListener() {
        return (ITextureAtlasStateListener) super.getTextureStateListener();
    }

    public void addTextureAtlasSource(T pTextureAtlasSource, int pTexturePositionX, int pTexturePositionY) throws IllegalArgumentException {
        checkTextureAtlasSourcePosition(pTextureAtlasSource, pTexturePositionX, pTexturePositionY);
        pTextureAtlasSource.setTexturePositionX(pTexturePositionX);
        pTextureAtlasSource.setTexturePositionY(pTexturePositionY);
        this.mTextureAtlasSources.add(pTextureAtlasSource);
        this.mUpdateOnHardwareNeeded = true;
    }

    public void removeTextureAtlasSource(T pTextureAtlasSource, int pTexturePositionX, int pTexturePositionY) {
        ArrayList<T> textureSources = this.mTextureAtlasSources;
        for (int i = textureSources.size() - 1; i >= 0; i--) {
            T textureSource = (ITextureAtlasSource) textureSources.get(i);
            if (textureSource == pTextureAtlasSource && textureSource.getTexturePositionX() == pTexturePositionX && textureSource.getTexturePositionY() == pTexturePositionY) {
                textureSources.remove(i);
                this.mUpdateOnHardwareNeeded = true;
                return;
            }
        }
    }

    public void clearTextureAtlasSources() {
        this.mTextureAtlasSources.clear();
        this.mUpdateOnHardwareNeeded = true;
    }

    private void checkTextureAtlasSourcePosition(T pTextureAtlasSource, int pTexturePositionX, int pTexturePositionY) throws IllegalArgumentException {
        if (pTexturePositionX < 0) {
            throw new IllegalArgumentException("Illegal negative pTexturePositionX supplied: '" + pTexturePositionX + "'");
        } else if (pTexturePositionY < 0) {
            throw new IllegalArgumentException("Illegal negative pTexturePositionY supplied: '" + pTexturePositionY + "'");
        } else if (pTextureAtlasSource.getWidth() + pTexturePositionX > getWidth() || pTextureAtlasSource.getHeight() + pTexturePositionY > getHeight()) {
            throw new IllegalArgumentException("Supplied pTextureAtlasSource must not exceed bounds of Texture.");
        }
    }
}
