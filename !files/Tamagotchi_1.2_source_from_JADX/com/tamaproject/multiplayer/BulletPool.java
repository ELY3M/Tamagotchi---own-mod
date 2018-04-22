package com.tamaproject.multiplayer;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.util.pool.GenericPool;

public class BulletPool extends GenericPool<Sprite> {
    private TextureRegion mTextureRegion;

    public BulletPool(TextureRegion pTextureRegion) {
        if (pTextureRegion == null) {
            throw new IllegalArgumentException("The texture region must not be NULL");
        }
        this.mTextureRegion = pTextureRegion;
    }

    protected Sprite onAllocatePoolItem() {
        return new Sprite(0.0f, 0.0f, this.mTextureRegion);
    }

    protected void onHandleRecycleItem(Sprite pBullet) {
        pBullet.setIgnoreUpdate(true);
        pBullet.setVisible(false);
    }

    protected void onHandleObtainItem(Sprite pBullet) {
        pBullet.reset();
    }
}
