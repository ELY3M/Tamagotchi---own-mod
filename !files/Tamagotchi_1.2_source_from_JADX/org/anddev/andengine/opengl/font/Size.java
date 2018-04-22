package org.anddev.andengine.opengl.font;

class Size {
    private float mHeight;
    private float mWidth;

    public Size() {
        this(0.0f, 0.0f);
    }

    public Size(float pWidth, float pHeight) {
        setWidth(pWidth);
        setHeight(pHeight);
    }

    public void setWidth(float width) {
        this.mWidth = width;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public void setHeight(float height) {
        this.mHeight = height;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public void set(int pWidth, int pHeight) {
        setWidth((float) pWidth);
        setHeight((float) pHeight);
    }
}
