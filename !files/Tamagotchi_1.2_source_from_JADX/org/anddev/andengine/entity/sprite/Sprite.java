package org.anddev.andengine.entity.sprite;

import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.vertex.RectangleVertexBuffer;

public class Sprite extends BaseSprite {
    public Sprite(float pX, float pY, TextureRegion pTextureRegion) {
        super(pX, pY, (float) pTextureRegion.getWidth(), (float) pTextureRegion.getHeight(), pTextureRegion);
    }

    public Sprite(float pX, float pY, float pWidth, float pHeight, TextureRegion pTextureRegion) {
        super(pX, pY, pWidth, pHeight, pTextureRegion);
    }

    public Sprite(float pX, float pY, TextureRegion pTextureRegion, RectangleVertexBuffer pRectangleVertexBuffer) {
        super(pX, pY, (float) pTextureRegion.getWidth(), (float) pTextureRegion.getHeight(), pTextureRegion, pRectangleVertexBuffer);
    }

    public Sprite(float pX, float pY, float pWidth, float pHeight, TextureRegion pTextureRegion, RectangleVertexBuffer pRectangleVertexBuffer) {
        super(pX, pY, pWidth, pHeight, pTextureRegion, pRectangleVertexBuffer);
    }

    public TextureRegion getTextureRegion() {
        return (TextureRegion) this.mTextureRegion;
    }
}
