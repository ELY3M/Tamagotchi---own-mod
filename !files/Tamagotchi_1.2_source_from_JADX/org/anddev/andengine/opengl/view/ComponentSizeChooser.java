package org.anddev.andengine.opengl.view;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class ComponentSizeChooser extends BaseConfigChooser {
    protected int mAlphaSize;
    protected int mBlueSize;
    protected int mDepthSize;
    protected int mGreenSize;
    protected int mRedSize;
    protected int mStencilSize;
    private final int[] mValue = new int[1];

    public /* bridge */ /* synthetic */ EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        return super.chooseConfig(egl10, eGLDisplay);
    }

    public ComponentSizeChooser(int pRedSize, int pGreenSize, int pBlueSize, int pAlphaSize, int pDepthSize, int pStencilSize) {
        super(new int[]{12324, pRedSize, 12323, pGreenSize, 12322, pBlueSize, 12321, pAlphaSize, 12325, pDepthSize, 12326, pStencilSize, 12344});
        this.mRedSize = pRedSize;
        this.mGreenSize = pGreenSize;
        this.mBlueSize = pBlueSize;
        this.mAlphaSize = pAlphaSize;
        this.mDepthSize = pDepthSize;
        this.mStencilSize = pStencilSize;
    }

    public EGLConfig chooseConfig(EGL10 pEGL, EGLDisplay pEGLDisplay, EGLConfig[] pEGLConfigs) {
        EGLConfig closestConfig = null;
        int closestDistance = 1000;
        for (EGLConfig config : pEGLConfigs) {
            int distance = ((((Math.abs(findConfigAttrib(pEGL, pEGLDisplay, config, 12324, 0) - this.mRedSize) + Math.abs(findConfigAttrib(pEGL, pEGLDisplay, config, 12323, 0) - this.mGreenSize)) + Math.abs(findConfigAttrib(pEGL, pEGLDisplay, config, 12322, 0) - this.mBlueSize)) + Math.abs(findConfigAttrib(pEGL, pEGLDisplay, config, 12321, 0) - this.mAlphaSize)) + Math.abs(findConfigAttrib(pEGL, pEGLDisplay, config, 12325, 0) - this.mDepthSize)) + Math.abs(findConfigAttrib(pEGL, pEGLDisplay, config, 12326, 0) - this.mStencilSize);
            if (distance < closestDistance) {
                closestDistance = distance;
                closestConfig = config;
            }
        }
        return closestConfig;
    }

    private int findConfigAttrib(EGL10 pEGL, EGLDisplay pEGLDisplay, EGLConfig pEGLConfig, int pAttribute, int pDefaultValue) {
        if (pEGL.eglGetConfigAttrib(pEGLDisplay, pEGLConfig, pAttribute, this.mValue)) {
            return this.mValue[0];
        }
        return pDefaultValue;
    }
}
