package org.anddev.andengine.entity.primitive;

import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.collision.LineCollisionChecker;
import org.anddev.andengine.collision.RectangularShapeCollisionChecker;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.shape.IShape;
import org.anddev.andengine.entity.shape.RectangularShape;
import org.anddev.andengine.entity.shape.Shape;
import org.anddev.andengine.opengl.util.GLHelper;
import org.anddev.andengine.opengl.vertex.LineVertexBuffer;

public class Line extends Shape {
    private static final float LINEWIDTH_DEFAULT = 1.0f;
    private final LineVertexBuffer mLineVertexBuffer;
    private float mLineWidth;
    protected float mX2;
    protected float mY2;

    public Line(float pX1, float pY1, float pX2, float pY2) {
        this(pX1, pY1, pX2, pY2, 1.0f);
    }

    public Line(float pX1, float pY1, float pX2, float pY2, float pLineWidth) {
        super(pX1, pY1);
        this.mX2 = pX2;
        this.mY2 = pY2;
        this.mLineWidth = pLineWidth;
        this.mLineVertexBuffer = new LineVertexBuffer(35044, true);
        updateVertexBuffer();
        float width = getWidth();
        float height = getHeight();
        this.mRotationCenterX = width * 0.5f;
        this.mRotationCenterY = height * 0.5f;
        this.mScaleCenterX = this.mRotationCenterX;
        this.mScaleCenterY = this.mRotationCenterY;
    }

    @Deprecated
    public float getX() {
        return super.getX();
    }

    @Deprecated
    public float getY() {
        return super.getY();
    }

    public float getX1() {
        return super.getX();
    }

    public float getY1() {
        return super.getY();
    }

    public float getX2() {
        return this.mX2;
    }

    public float getY2() {
        return this.mY2;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setLineWidth(float pLineWidth) {
        this.mLineWidth = pLineWidth;
    }

    public float getBaseHeight() {
        return this.mY2 - this.mY;
    }

    public float getBaseWidth() {
        return this.mX2 - this.mX;
    }

    public float getHeight() {
        return this.mY2 - this.mY;
    }

    public float getWidth() {
        return this.mX2 - this.mX;
    }

    @Deprecated
    public void setPosition(float pX, float pY) {
        float dX = this.mX - pX;
        float dY = this.mY - pY;
        super.setPosition(pX, pY);
        this.mX2 += dX;
        this.mY2 += dY;
    }

    public void setPosition(float pX1, float pY1, float pX2, float pY2) {
        this.mX2 = pX2;
        this.mY2 = pY2;
        super.setPosition(pX1, pY1);
        updateVertexBuffer();
    }

    protected boolean isCulled(Camera pCamera) {
        return pCamera.isLineVisible(this);
    }

    protected void onInitDraw(GL10 pGL) {
        super.onInitDraw(pGL);
        GLHelper.disableTextures(pGL);
        GLHelper.disableTexCoordArray(pGL);
        GLHelper.lineWidth(pGL, this.mLineWidth);
    }

    public LineVertexBuffer getVertexBuffer() {
        return this.mLineVertexBuffer;
    }

    protected void onUpdateVertexBuffer() {
        this.mLineVertexBuffer.update(0.0f, 0.0f, this.mX2 - this.mX, this.mY2 - this.mY);
    }

    protected void drawVertices(GL10 pGL, Camera pCamera) {
        pGL.glDrawArrays(1, 0, 2);
    }

    public float[] getSceneCenterCoordinates() {
        return null;
    }

    @Deprecated
    public boolean contains(float pX, float pY) {
        return false;
    }

    @Deprecated
    public float[] convertSceneToLocalCoordinates(float pX, float pY) {
        return null;
    }

    @Deprecated
    public float[] convertLocalToSceneCoordinates(float pX, float pY) {
        return null;
    }

    public boolean collidesWith(IShape pOtherShape) {
        if (pOtherShape instanceof Line) {
            Line otherLine = (Line) pOtherShape;
            return LineCollisionChecker.checkLineCollision(this.mX, this.mY, this.mX2, this.mY2, otherLine.mX, otherLine.mY, otherLine.mX2, otherLine.mY2);
        } else if (pOtherShape instanceof RectangularShape) {
            return RectangularShapeCollisionChecker.checkCollision((RectangularShape) pOtherShape, this);
        } else {
            return false;
        }
    }
}
