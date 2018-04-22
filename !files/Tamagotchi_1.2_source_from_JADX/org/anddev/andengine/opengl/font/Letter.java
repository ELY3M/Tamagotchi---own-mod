package org.anddev.andengine.opengl.font;

public class Letter {
    public final int mAdvance;
    public final char mCharacter;
    public final int mHeight;
    public final float mTextureHeight;
    public final float mTextureWidth;
    public final float mTextureX;
    public final float mTextureY;
    public final int mWidth;

    Letter(char pCharacter, int pAdvance, int pWidth, int pHeight, float pTextureX, float pTextureY, float pTextureWidth, float pTextureHeight) {
        this.mCharacter = pCharacter;
        this.mAdvance = pAdvance;
        this.mWidth = pWidth;
        this.mHeight = pHeight;
        this.mTextureX = pTextureX;
        this.mTextureY = pTextureY;
        this.mTextureWidth = pTextureWidth;
        this.mTextureHeight = pTextureHeight;
    }

    public int hashCode() {
        return this.mCharacter + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.mCharacter != ((Letter) obj).mCharacter) {
            return false;
        }
        return true;
    }
}
