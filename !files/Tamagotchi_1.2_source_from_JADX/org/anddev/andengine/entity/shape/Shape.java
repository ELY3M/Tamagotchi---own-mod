package org.anddev.andengine.entity.shape;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.util.GLHelper;
import org.anddev.andengine.opengl.vertex.VertexBuffer;

public abstract class Shape extends Entity implements IShape {
    public static final int BLENDFUNCTION_DESTINATION_DEFAULT = 771;
    public static final int BLENDFUNCTION_DESTINATION_PREMULTIPLYALPHA_DEFAULT = 771;
    public static final int BLENDFUNCTION_SOURCE_DEFAULT = 770;
    public static final int BLENDFUNCTION_SOURCE_PREMULTIPLYALPHA_DEFAULT = 1;
    private boolean mCullingEnabled = false;
    protected int mDestinationBlendFunction = 771;
    protected int mSourceBlendFunction = BLENDFUNCTION_SOURCE_DEFAULT;

    protected abstract void drawVertices(GL10 gl10, Camera camera);

    protected abstract VertexBuffer getVertexBuffer();

    protected abstract boolean isCulled(Camera camera);

    protected abstract void onUpdateVertexBuffer();

    public Shape(float pX, float pY) {
        super(pX, pY);
    }

    public void setBlendFunction(int pSourceBlendFunction, int pDestinationBlendFunction) {
        this.mSourceBlendFunction = pSourceBlendFunction;
        this.mDestinationBlendFunction = pDestinationBlendFunction;
    }

    public boolean isCullingEnabled() {
        return this.mCullingEnabled;
    }

    public void setCullingEnabled(boolean pCullingEnabled) {
        this.mCullingEnabled = pCullingEnabled;
    }

    public float getWidthScaled() {
        return getWidth() * this.mScaleX;
    }

    public float getHeightScaled() {
        return getHeight() * this.mScaleY;
    }

    public boolean isVertexBufferManaged() {
        return getVertexBuffer().isManaged();
    }

    public void setVertexBufferManaged(boolean pVertexBufferManaged) {
        getVertexBuffer().setManaged(pVertexBufferManaged);
    }

    protected void doDraw(GL10 pGL, Camera pCamera) {
        onInitDraw(pGL);
        onApplyVertices(pGL);
        drawVertices(pGL, pCamera);
    }

    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
        return false;
    }

    protected void onManagedDraw(GL10 pGL, Camera pCamera) {
        if (!this.mCullingEnabled || !isCulled(pCamera)) {
            super.onManagedDraw(pGL, pCamera);
        }
    }

    public void reset() {
        super.reset();
        this.mSourceBlendFunction = BLENDFUNCTION_SOURCE_DEFAULT;
        this.mDestinationBlendFunction = 771;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        VertexBuffer vertexBuffer = getVertexBuffer();
        if (vertexBuffer.isManaged()) {
            vertexBuffer.unloadFromActiveBufferObjectManager();
        }
    }

    protected void onInitDraw(GL10 pGL) {
        GLHelper.setColor(pGL, this.mRed, this.mGreen, this.mBlue, this.mAlpha);
        GLHelper.enableVertexArray(pGL);
        GLHelper.blendFunction(pGL, this.mSourceBlendFunction, this.mDestinationBlendFunction);
    }

    protected void onApplyVertices(GL10 pGL) {
        if (GLHelper.EXTENSIONS_VERTEXBUFFEROBJECTS) {
            GL11 gl11 = (GL11) pGL;
            getVertexBuffer().selectOnHardware(gl11);
            GLHelper.vertexZeroPointer(gl11);
            return;
        }
        GLHelper.vertexPointer(pGL, getVertexBuffer().getFloatBuffer());
    }

    protected void updateVertexBuffer() {
        onUpdateVertexBuffer();
    }
}
