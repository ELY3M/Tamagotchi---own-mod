package org.anddev.andengine.opengl.texture.region;

import org.anddev.andengine.util.Library;

public class TextureRegionLibrary extends Library<BaseTextureRegion> {
    public TextureRegionLibrary(int pInitialCapacity) {
        super(pInitialCapacity);
    }

    public TextureRegion get(int pID) {
        return (TextureRegion) super.get(pID);
    }

    public TiledTextureRegion getTiled(int pID) {
        return (TiledTextureRegion) this.mItems.get(pID);
    }
}
