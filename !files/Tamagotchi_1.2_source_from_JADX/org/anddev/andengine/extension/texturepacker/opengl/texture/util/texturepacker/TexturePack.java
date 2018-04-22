package org.anddev.andengine.extension.texturepacker.opengl.texture.util.texturepacker;

import org.anddev.andengine.opengl.texture.ITexture;

public class TexturePack {
    private final ITexture mTexture;
    private final TexturePackTextureRegionLibrary mTexturePackTextureRegionLibrary;

    public TexturePack(ITexture pTexture, TexturePackTextureRegionLibrary pTexturePackTextureRegionLibrary) {
        this.mTexture = pTexture;
        this.mTexturePackTextureRegionLibrary = pTexturePackTextureRegionLibrary;
    }

    public ITexture getTexture() {
        return this.mTexture;
    }

    public TexturePackTextureRegionLibrary getTexturePackTextureRegionLibrary() {
        return this.mTexturePackTextureRegionLibrary;
    }
}
