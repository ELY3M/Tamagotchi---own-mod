package org.anddev.andengine.opengl.view;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.location.places.Place;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.opengl.util.GLHelper;
import org.anddev.andengine.util.Debug;

public class RenderSurfaceView extends GLSurfaceView {
    private Renderer mRenderer;

    public static class Renderer implements org.anddev.andengine.opengl.view.GLSurfaceView.Renderer {
        private final Engine mEngine;

        public Renderer(Engine pEngine) {
            this.mEngine = pEngine;
        }

        public void onSurfaceChanged(GL10 pGL, int pWidth, int pHeight) {
            Debug.m59d("onSurfaceChanged: pWidth=" + pWidth + "  pHeight=" + pHeight);
            this.mEngine.setSurfaceSize(pWidth, pHeight);
            pGL.glViewport(0, 0, pWidth, pHeight);
            pGL.glLoadIdentity();
        }

        public void onSurfaceCreated(GL10 pGL, EGLConfig pConfig) {
            Debug.m59d("onSurfaceCreated");
            GLHelper.reset(pGL);
            GLHelper.setPerspectiveCorrectionHintFastest(pGL);
            GLHelper.setShadeModelFlat(pGL);
            GLHelper.disableLightning(pGL);
            GLHelper.disableDither(pGL);
            GLHelper.disableDepthTest(pGL);
            GLHelper.disableMultisample(pGL);
            GLHelper.enableBlend(pGL);
            GLHelper.enableTextures(pGL);
            GLHelper.enableTexCoordArray(pGL);
            GLHelper.enableVertexArray(pGL);
            GLHelper.enableCulling(pGL);
            pGL.glFrontFace(2305);
            pGL.glCullFace(Place.TYPE_SYNTHETIC_GEOCODE);
            GLHelper.enableExtensions(pGL, this.mEngine.getEngineOptions().getRenderOptions());
        }

        public void onDrawFrame(GL10 pGL) {
            try {
                this.mEngine.onDrawFrame(pGL);
            } catch (InterruptedException e) {
                Debug.m62e("GLThread interrupted!", e);
            }
        }
    }

    public RenderSurfaceView(Context pContext) {
        super(pContext);
    }

    public RenderSurfaceView(Context pContext, AttributeSet pAttrs) {
        super(pContext, pAttrs);
    }

    public void setRenderer(Engine pEngine) {
        setOnTouchListener(pEngine);
        this.mRenderer = new Renderer(pEngine);
        setRenderer(this.mRenderer);
    }

    protected void onMeasure(int pWidthMeasureSpec, int pHeightMeasureSpec) {
        this.mRenderer.mEngine.getEngineOptions().getResolutionPolicy().onMeasure(this, pWidthMeasureSpec, pHeightMeasureSpec);
    }

    public void setMeasuredDimensionProxy(int pMeasuredWidth, int pMeasuredHeight) {
        setMeasuredDimension(pMeasuredWidth, pMeasuredHeight);
    }
}
