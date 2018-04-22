package org.anddev.andengine.entity.sprite;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.opengl.vertex.RectangleVertexBuffer;

public class TiledSprite extends BaseSprite {
    public TiledSprite(float pX, float pY, TiledTextureRegion pTiledTextureRegion) {
        super(pX, pY, (float) pTiledTextureRegion.getTileWidth(), (float) pTiledTextureRegion.getTileHeight(), pTiledTextureRegion);
    }

    public TiledSprite(float pX, float pY, float pTileWidth, float pTileHeight, TiledTextureRegion pTiledTextureRegion) {
        super(pX, pY, pTileWidth, pTileHeight, pTiledTextureRegion);
    }

    public TiledSprite(float pX, float pY, TiledTextureRegion pTiledTextureRegion, RectangleVertexBuffer pRectangleVertexBuffer) {
        super(pX, pY, (float) pTiledTextureRegion.getTileWidth(), (float) pTiledTextureRegion.getTileHeight(), pTiledTextureRegion, pRectangleVertexBuffer);
    }

    public TiledSprite(float pX, float pY, float pTileWidth, float pTileHeight, TiledTextureRegion pTiledTextureRegion, RectangleVertexBuffer pRectangleVertexBuffer) {
        super(pX, pY, pTileWidth, pTileHeight, pTiledTextureRegion, pRectangleVertexBuffer);
    }

    public TiledTextureRegion getTextureRegion() {
        return (TiledTextureRegion) super.getTextureRegion();
    }

    public int getCurrentTileIndex() {
        return getTextureRegion().getCurrentTileIndex();
    }

    public void setCurrentTileIndex(int pTileIndex) {
        getTextureRegion().setCurrentTileIndex(pTileIndex);
    }

    public void setCurrentTileIndex(int pTileColumn, int pTileRow) {
        getTextureRegion().setCurrentTileIndex(pTileColumn, pTileRow);
    }

    public void nextTile() {
        getTextureRegion().nextTile();
    }
}
