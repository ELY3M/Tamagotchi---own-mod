package org.anddev.andengine.opengl.texture.compressed.pvr;

import java.io.IOException;
import java.util.zip.GZIPInputStream;
import org.anddev.andengine.opengl.texture.ITexture.ITextureStateListener;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.compressed.pvr.PVRTexture.PVRTextureFormat;

public abstract class PVRGZTexture extends PVRTexture {
    public PVRGZTexture(PVRTextureFormat pPVRTextureFormat) throws IllegalArgumentException, IOException {
        super(pPVRTextureFormat);
    }

    public PVRGZTexture(PVRTextureFormat pPVRTextureFormat, ITextureStateListener pTextureStateListener) throws IllegalArgumentException, IOException {
        super(pPVRTextureFormat, pTextureStateListener);
    }

    public PVRGZTexture(PVRTextureFormat pPVRTextureFormat, TextureOptions pTextureOptions) throws IllegalArgumentException, IOException {
        super(pPVRTextureFormat, pTextureOptions);
    }

    public PVRGZTexture(PVRTextureFormat pPVRTextureFormat, TextureOptions pTextureOptions, ITextureStateListener pTextureStateListener) throws IllegalArgumentException, IOException {
        super(pPVRTextureFormat, pTextureOptions, pTextureStateListener);
    }

    protected GZIPInputStream getInputStream() throws IOException {
        return new GZIPInputStream(onGetInputStream());
    }
}
