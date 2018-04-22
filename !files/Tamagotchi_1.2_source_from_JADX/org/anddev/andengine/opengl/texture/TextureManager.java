package org.anddev.andengine.opengl.texture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.util.Debug;

public class TextureManager {
    private final ArrayList<ITexture> mTexturesLoaded = new ArrayList();
    private final HashSet<ITexture> mTexturesManaged = new HashSet();
    private final ArrayList<ITexture> mTexturesToBeLoaded = new ArrayList();
    private final ArrayList<ITexture> mTexturesToBeUnloaded = new ArrayList();

    protected synchronized void clear() {
        this.mTexturesToBeLoaded.clear();
        this.mTexturesLoaded.clear();
        this.mTexturesManaged.clear();
    }

    public synchronized boolean loadTexture(ITexture pTexture) {
        boolean z;
        if (this.mTexturesManaged.contains(pTexture)) {
            this.mTexturesToBeUnloaded.remove(pTexture);
            z = false;
        } else {
            this.mTexturesManaged.add(pTexture);
            this.mTexturesToBeLoaded.add(pTexture);
            z = true;
        }
        return z;
    }

    public synchronized boolean unloadTexture(ITexture pTexture) {
        boolean z;
        if (this.mTexturesManaged.contains(pTexture)) {
            if (this.mTexturesLoaded.contains(pTexture)) {
                this.mTexturesToBeUnloaded.add(pTexture);
            } else if (this.mTexturesToBeLoaded.remove(pTexture)) {
                this.mTexturesManaged.remove(pTexture);
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public void loadTextures(ITexture... pTextures) {
        for (int i = pTextures.length - 1; i >= 0; i--) {
            loadTexture(pTextures[i]);
        }
    }

    public void unloadTextures(ITexture... pTextures) {
        for (int i = pTextures.length - 1; i >= 0; i--) {
            unloadTexture(pTextures[i]);
        }
    }

    public synchronized void reloadTextures() {
        Iterator it = this.mTexturesManaged.iterator();
        while (it.hasNext()) {
            ((ITexture) it.next()).setLoadedToHardware(false);
        }
        this.mTexturesToBeLoaded.addAll(this.mTexturesLoaded);
        this.mTexturesLoaded.clear();
        this.mTexturesManaged.removeAll(this.mTexturesToBeUnloaded);
        this.mTexturesToBeUnloaded.clear();
    }

    public synchronized void updateTextures(GL10 pGL) {
        int i;
        HashSet<ITexture> texturesManaged = this.mTexturesManaged;
        ArrayList<ITexture> texturesLoaded = this.mTexturesLoaded;
        ArrayList<ITexture> texturesToBeLoaded = this.mTexturesToBeLoaded;
        ArrayList<ITexture> texturesToBeUnloaded = this.mTexturesToBeUnloaded;
        int textursLoadedCount = texturesLoaded.size();
        if (textursLoadedCount > 0) {
            for (i = textursLoadedCount - 1; i >= 0; i--) {
                ITexture textureToBeReloaded = (ITexture) texturesLoaded.get(i);
                if (textureToBeReloaded.isUpdateOnHardwareNeeded()) {
                    try {
                        textureToBeReloaded.reloadToHardware(pGL);
                    } catch (Throwable e) {
                        Debug.m63e(e);
                    }
                }
            }
        }
        int texturesToBeLoadedCount = texturesToBeLoaded.size();
        if (texturesToBeLoadedCount > 0) {
            for (i = texturesToBeLoadedCount - 1; i >= 0; i--) {
                ITexture textureToBeLoaded = (ITexture) texturesToBeLoaded.remove(i);
                if (!textureToBeLoaded.isLoadedToHardware()) {
                    try {
                        textureToBeLoaded.loadToHardware(pGL);
                    } catch (Throwable e2) {
                        Debug.m63e(e2);
                    }
                }
                texturesLoaded.add(textureToBeLoaded);
            }
        }
        int texturesToBeUnloadedCount = texturesToBeUnloaded.size();
        if (texturesToBeUnloadedCount > 0) {
            for (i = texturesToBeUnloadedCount - 1; i >= 0; i--) {
                ITexture textureToBeUnloaded = (ITexture) texturesToBeUnloaded.remove(i);
                if (textureToBeUnloaded.isLoadedToHardware()) {
                    textureToBeUnloaded.unloadFromHardware(pGL);
                }
                texturesLoaded.remove(textureToBeUnloaded);
                texturesManaged.remove(textureToBeUnloaded);
            }
        }
        if (texturesToBeLoadedCount > 0 || texturesToBeUnloadedCount > 0) {
            System.gc();
        }
    }
}
