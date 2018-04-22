package org.anddev.andengine.opengl.texture.atlas.buildable;

import org.anddev.andengine.opengl.texture.atlas.ITextureAtlas;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;
import org.anddev.andengine.opengl.texture.source.ITextureAtlasSource;
import org.anddev.andengine.util.Callback;

public class BuildableTextureAtlasTextureRegionFactory {

    class C09231 implements Callback<T> {
        private final /* synthetic */ TextureRegion val$textureRegion;

        C09231(TextureRegion textureRegion) {
            this.val$textureRegion = textureRegion;
        }

        public void onCallback(T pCallbackValue) {
            this.val$textureRegion.setTexturePosition(pCallbackValue.getTexturePositionX(), pCallbackValue.getTexturePositionY());
        }
    }

    class C09242 implements Callback<T> {
        private final /* synthetic */ TiledTextureRegion val$tiledTextureRegion;

        C09242(TiledTextureRegion tiledTextureRegion) {
            this.val$tiledTextureRegion = tiledTextureRegion;
        }

        public void onCallback(T pCallbackValue) {
            this.val$tiledTextureRegion.setTexturePosition(pCallbackValue.getTexturePositionX(), pCallbackValue.getTexturePositionY());
        }
    }

    public static <T extends ITextureAtlasSource, A extends ITextureAtlas<T>> TextureRegion createFromSource(BuildableTextureAtlas<T, A> pBuildableTextureAtlas, T pTextureAtlasSource, boolean pTextureRegionBufferManaged) {
        TextureRegion textureRegion = new TextureRegion(pBuildableTextureAtlas, 0, 0, pTextureAtlasSource.getWidth(), pTextureAtlasSource.getHeight());
        pBuildableTextureAtlas.addTextureAtlasSource(pTextureAtlasSource, new C09231(textureRegion));
        textureRegion.setTextureRegionBufferManaged(pTextureRegionBufferManaged);
        return textureRegion;
    }

    public static <T extends ITextureAtlasSource, A extends ITextureAtlas<T>> TiledTextureRegion createTiledFromSource(BuildableTextureAtlas<T, A> pBuildableTextureAtlas, T pTextureAtlasSource, int pTileColumns, int pTileRows, boolean pTextureRegionBufferManaged) {
        TiledTextureRegion tiledTextureRegion = new TiledTextureRegion(pBuildableTextureAtlas, 0, 0, pTextureAtlasSource.getWidth(), pTextureAtlasSource.getHeight(), pTileColumns, pTileRows);
        pBuildableTextureAtlas.addTextureAtlasSource(pTextureAtlasSource, new C09242(tiledTextureRegion));
        tiledTextureRegion.setTextureRegionBufferManaged(pTextureRegionBufferManaged);
        return tiledTextureRegion;
    }
}
