package org.anddev.andengine.entity.scene.menu.item;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class SpriteMenuItem extends Sprite implements IMenuItem {
    private final int mID;

    public SpriteMenuItem(int pID, TextureRegion pTextureRegion) {
        super(0.0f, 0.0f, pTextureRegion);
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
