package org.anddev.andengine.extension.texturepacker.opengl.texture.util.texturepacker;

import org.anddev.andengine.opengl.texture.ITexture;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class TexturePackerTextureRegion extends TextureRegion {
    private final int mID;
    private final boolean mRotated;
    private final String mSource;
    private final int mSourceHeight;
    private final int mSourceWidth;
    private final int mSourceX;
    private final int mSourceY;
    private final boolean mTrimmed;

    public TexturePackerTextureRegion(ITexture pTexture, int pX, int pY, int pWidth, int pHeight, int pID, String pSource, boolean pRotated, boolean pTrimmed, int pSourceX, int pSourceY, int pSourceWidth, int pSourceHeight) {
        super(pTexture, pX, pY, pWidth, pHeight);
        this.mID = pID;
        this.mSource = pSource;
        this.mRotated = pRotated;
        this.mTrimmed = pTrimmed;
        this.mSourceX = pSourceX;
        this.mSourceY = pSourceY;
        this.mSourceWidth = pSourceWidth;
        this.mSourceHeight = pSourceHeight;
    }

    public int getID() {
        return this.mID;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean isRotated() {
        return this.mRotated;
    }

    public boolean isTrimmed() {
        return this.mTrimmed;
    }

    public int getSourceX() {
        return this.mSourceX;
    }

    public int getSourceY() {
        return this.mSourceY;
    }

    public int getSourceWidth() {
        return this.mSourceWidth;
    }

    public int getSourceHeight() {
        return this.mSourceHeight;
    }
}
