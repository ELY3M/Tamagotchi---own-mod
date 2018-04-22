package org.anddev.andengine.opengl.texture.source;

import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;

public interface ITextureAtlasSource {
    ITextureAtlasSource deepCopy() throws DeepCopyNotSupportedException;

    int getHeight();

    int getTexturePositionX();

    int getTexturePositionY();

    int getWidth();

    void setTexturePositionX(int i);

    void setTexturePositionY(int i);
}
