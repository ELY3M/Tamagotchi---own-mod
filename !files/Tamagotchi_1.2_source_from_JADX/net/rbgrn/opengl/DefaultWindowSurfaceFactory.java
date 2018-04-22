package net.rbgrn.opengl;

import android.opengl.GLSurfaceView.EGLWindowSurfaceFactory;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
    DefaultWindowSurfaceFactory() {
    }

    public EGLSurface createWindowSurface(EGL10 egl, EGLDisplay display, EGLConfig config, Object nativeWindow) {
        return egl.eglCreateWindowSurface(display, config, nativeWindow, null);
    }

    public void destroySurface(EGL10 egl, EGLDisplay display, EGLSurface surface) {
        egl.eglDestroySurface(display, surface);
    }
}
