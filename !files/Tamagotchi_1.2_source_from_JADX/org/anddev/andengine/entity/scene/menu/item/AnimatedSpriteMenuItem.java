package org.anddev.andengine.entity.scene.menu.item;

import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class AnimatedSpriteMenuItem extends AnimatedSprite implements IMenuItem {
    private final int mID;

    public AnimatedSpriteMenuItem(int pID, TiledTextureRegion pTiledTextureRegion) {
        super(0.0f, 0.0f, pTiledTextureRegion);
        this.mID = pID;
    }

    public int getID() {
        return this.mID;
    }

    public void onSelected() {
    }

    public void onUnselected() {
    }
}
