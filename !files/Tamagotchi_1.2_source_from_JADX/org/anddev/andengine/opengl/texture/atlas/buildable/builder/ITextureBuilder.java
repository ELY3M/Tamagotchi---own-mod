package org.anddev.andengine.opengl.texture.atlas.buildable.builder;

import java.util.ArrayList;
import org.anddev.andengine.opengl.texture.atlas.ITextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.buildable.BuildableTextureAtlas.TextureAtlasSourceWithWithLocationCallback;
import org.anddev.andengine.opengl.texture.source.ITextureAtlasSource;

public interface ITextureBuilder<T extends ITextureAtlasSource, A extends ITextureAtlas<T>> {

    public static class TextureAtlasSourcePackingException extends Exception {
        private static final long serialVersionUID = 4700734424214372671L;

        public TextureAtlasSourcePackingException(String pMessage) {
            super(pMessage);
        }
    }

    void pack(A a, ArrayList<TextureAtlasSourceWithWithLocationCallback<T>> arrayList) throws TextureAtlasSourcePackingException;
}
