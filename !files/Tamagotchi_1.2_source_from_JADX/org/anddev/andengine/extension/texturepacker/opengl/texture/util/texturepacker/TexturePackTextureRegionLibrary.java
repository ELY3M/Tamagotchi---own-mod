package org.anddev.andengine.extension.texturepacker.opengl.texture.util.texturepacker;

import android.util.SparseArray;
import java.util.HashMap;

public class TexturePackTextureRegionLibrary {
    private final SparseArray<TexturePackerTextureRegion> mIDMapping;
    private final HashMap<String, TexturePackerTextureRegion> mSourceMapping;

    public TexturePackTextureRegionLibrary(int pInitialCapacity) {
        this.mIDMapping = new SparseArray(pInitialCapacity);
        this.mSourceMapping = new HashMap(pInitialCapacity);
    }

    public void add(TexturePackerTextureRegion pTexturePackTextureRegion) {
        throwOnCollision(pTexturePackTextureRegion);
        this.mIDMapping.put(pTexturePackTextureRegion.getID(), pTexturePackTextureRegion);
        this.mSourceMapping.put(pTexturePackTextureRegion.getSource(), pTexturePackTextureRegion);
    }

    public void remove(int pID) {
        this.mIDMapping.remove(pID);
    }

    public TexturePackerTextureRegion get(int pID) {
        return (TexturePackerTextureRegion) this.mIDMapping.get(pID);
    }

    public TexturePackerTextureRegion get(String pSource) {
        return (TexturePackerTextureRegion) this.mSourceMapping.get(pSource);
    }

    public TexturePackerTextureRegion get(String pSource, boolean pStripExtension) {
        if (!pStripExtension) {
            return get(pSource);
        }
        int indexOfExtension = pSource.lastIndexOf(46);
        if (indexOfExtension == -1) {
            return get(pSource);
        }
        return (TexturePackerTextureRegion) this.mSourceMapping.get(pSource.substring(0, indexOfExtension));
    }

    private void throwOnCollision(TexturePackerTextureRegion pTexturePackTextureRegion) throws IllegalArgumentException {
        if (this.mIDMapping.get(pTexturePackTextureRegion.getID()) != null) {
            throw new IllegalArgumentException("Collision with ID: '" + pTexturePackTextureRegion.getID() + "'.");
        } else if (this.mSourceMapping.get(pTexturePackTextureRegion.getSource()) != null) {
            throw new IllegalArgumentException("Collision with Source: '" + pTexturePackTextureRegion.getSource() + "'.");
        }
    }
}
