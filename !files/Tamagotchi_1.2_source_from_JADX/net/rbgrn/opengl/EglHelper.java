package net.rbgrn.opengl;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.EGLWindowSurfaceFactory;
import android.opengl.GLSurfaceView.GLWrapper;
import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

class EglHelper {
    private final EGLConfigChooser mEGLConfigChooser;
    private final EGLContextFactory mEGLContextFactory;
    private final EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private EGL10 mEgl;
    EGLConfig mEglConfig;
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private EGLSurface mEglSurface;
    private final GLWrapper mGLWrapper;

    public EglHelper(EGLConfigChooser chooser, EGLContextFactory contextFactory, EGLWindowSurfaceFactory surfaceFactory, GLWrapper wrapper) {
        this.mEGLConfigChooser = chooser;
        this.mEGLContextFactory = contextFactory;
        this.mEGLWindowSurfaceFactory = surfaceFactory;
        this.mGLWrapper = wrapper;
    }

    public void start() {
        this.mEgl = (EGL10) EGLContext.getEGL();
        this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEgl.eglInitialize(this.mEglDisplay, new int[2]);
        this.mEglConfig = this.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
        this.mEglContext = this.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
        if (this.mEglContext == null || this.mEglContext == EGL10.EGL_NO_CONTEXT) {
            throw new RuntimeException("createContext failed");
        }
        this.mEglSurface = null;
    }

    public GL createSurface(SurfaceHolder holder) {
        if (!(this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE)) {
            this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
        }
        this.mEglSurface = this.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, holder);
        if (this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE) {
            throw new RuntimeException("createWindowSurface failed");
        } else if (this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
            GL gl = this.mEglContext.getGL();
            return this.mGLWrapper != null ? this.mGLWrapper.wrap(gl) : gl;
        } else {
            throw new RuntimeException("eglMakeCurrent failed.");
        }
    }

    public boolean swap() {
        this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
        return this.mEgl.eglGetError() != 12302;
    }

    public void destroySurface() {
        if (this.mEglSurface != null && this.mEglSurface != EGL10.EGL_NO_SURFACE) {
            this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
            this.mEglSurface = null;
        }
    }

    public void finish() {
        if (this.mEglContext != null) {
            this.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
            this.mEglContext = null;
        }
        if (this.mEglDisplay != null) {
            this.mEgl.eglTerminate(this.mEglDisplay);
            this.mEglDisplay = null;
        }
    }
}
