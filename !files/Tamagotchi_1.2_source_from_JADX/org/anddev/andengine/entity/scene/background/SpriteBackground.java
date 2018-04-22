package org.anddev.andengine.entity.scene.background;

import org.anddev.andengine.entity.sprite.BaseSprite;

public class SpriteBackground extends EntityBackground {
    public SpriteBackground(BaseSprite pBaseSprite) {
        super(pBaseSprite);
    }

    public SpriteBackground(float pRed, float pGreen, float pBlue, BaseSprite pBaseSprite) {
        super(pRed, pGreen, pBlue, pBaseSprite);
    }
}
