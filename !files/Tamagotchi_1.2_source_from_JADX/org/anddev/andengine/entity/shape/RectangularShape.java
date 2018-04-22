package org.anddev.andengine.entity.shape;

import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.collision.RectangularShapeCollisionChecker;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.primitive.Line;
import org.anddev.andengine.opengl.vertex.VertexBuffer;

public abstract class RectangularShape extends Shape {
    protected float mBaseHeight;
    protected float mBaseWidth;
    protected float mHeight;
    protected final VertexBuffer mVertexBuffer;
    protected float mWidth;

    public RectangularShape(float pX, float pY, float pWidth, float pHeight, VertexBuffer pVertexBuffer) {
        super(pX, pY);
        this.mBaseWidth = pWidth;
        this.mBaseHeight = pHeight;
        this.mWidth = pWidth;
        this.mHeight = pHeight;
        this.mVertexBuffer = pVertexBuffer;
        this.mRotationCenterX = pWidth * 0.5f;
        this.mRotationCenterY = pHeight * 0.5f;
        this.mScaleCenterX = this.mRotationCenterX;
        this.mScaleCenterY = this.mRotationCenterY;
    }

    public VertexBuffer getVertexBuffer() {
        return this.mVertexBuffer;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getBaseWidth() {
        return this.mBaseWidth;
    }

    public float getBaseHeight() {
        return this.mBaseHeight;
    }

    public void setWidth(float pWidth) {
        this.mWidth = pWidth;
        updateVertexBuffer();
    }

    public void setHeight(float pHeight) {
        this.mHeight = pHeight;
        updateVertexBuffer();
    }

    public void setSize(float pWidth, float pHeight) {
        this.mWidth = pWidth;
        this.mHeight = pHeight;
        updateVertexBuffer();
    }

    public void setBaseSize() {
        if (this.mWidth != this.mBaseWidth || this.mHeight != this.mBaseHeight) {
            this.mWidth = this.mBaseWidth;
            this.mHeight = this.mBaseHeight;
            updateVertexBuffer();
        }
    }

    protected boolean isCulled(Camera pCamera) {
        float x = this.mX;
        float y = this.mY;
        return x > pCamera.getMaxX() || y > pCamera.getMaxY() || getWidth() + x < pCamera.getMinX() || getHeight() + y < pCamera.getMinY();
    }

    protected void drawVertices(GL10 pGL, Camera pCamera) {
        pGL.glDrawArrays(5, 0, 4);
    }

    public void reset() {
        super.reset();
        setBaseSize();
        float baseWidth = getBaseWidth();
        float baseHeight = getBaseHeight();
        this.mRotationCenterX = baseWidth * 0.5f;
        this.mRotationCenterY = baseHeight * 0.5f;
        this.mScaleCenterX = this.mRotationCenterX;
        this.mScaleCenterY = this.mRotationCenterY;
    }

    public boolean contains(float pX, float pY) {
        return RectangularShapeCollisionChecker.checkContains(this, pX, pY);
    }

    public float[] getSceneCenterCoordinates() {
        return convertLocalToSceneCoordinates(this.mWidth * 0.5f, this.mHeight * 0.5f);
    }

    public boolean collidesWith(IShape pOtherShape) {
        if (pOtherShape instanceof RectangularShape) {
            return RectangularShapeCollisionChecker.checkCollision(this, (RectangularShape) pOtherShape);
        }
        if (pOtherShape instanceof Line) {
            return RectangularShapeCollisionChecker.checkCollision(this, (Line) pOtherShape);
        }
        return false;
    }
}
