package org.anddev.andengine.opengl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class GLSurfaceView extends SurfaceView implements Callback {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final Semaphore sEglSemaphore = new Semaphore(1);
    private int mDebugFlags;
    private EGLConfigChooser mEGLConfigChooser;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mHasSurface;
    private int mRenderMode;
    private Renderer mRenderer;
    private int mSurfaceHeight;
    private int mSurfaceWidth;

    class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;

        public void start() {
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEgl.eglInitialize(this.mEglDisplay, new int[2]);
            this.mEglConfig = GLSurfaceView.this.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
            this.mEglContext = this.mEgl.eglCreateContext(this.mEglDisplay, this.mEglConfig, EGL10.EGL_NO_CONTEXT, null);
            this.mEglSurface = null;
        }

        public GL createSurface(SurfaceHolder holder) {
            if (this.mEglSurface != null) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
            }
            this.mEglSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, holder, null);
            this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext);
            GL gl = this.mEglContext.getGL();
            return GLSurfaceView.this.mGLWrapper != null ? GLSurfaceView.this.mGLWrapper.wrap(gl) : gl;
        }

        public boolean swap() {
            this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
            return this.mEgl.eglGetError() != 12302;
        }

        public void finish() {
            if (this.mEglSurface != null) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
                this.mEglSurface = null;
            }
            if (this.mEglContext != null) {
                this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.mEglDisplay != null) {
                this.mEgl.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = null;
            }
        }
    }

    class GLThread extends Thread {
        private boolean mDone = false;
        private EglHelper mEglHelper;
        private final ArrayList<Runnable> mEventQueue = new ArrayList();
        private boolean mHasSurface;
        private int mHeight = 0;
        private boolean mPaused;
        private int mRenderMode = 1;
        private final Renderer mRenderer;
        private boolean mRequestRender = true;
        private boolean mSizeChanged;
        private int mWidth = 0;

        GLThread(Renderer renderer) {
            this.mRenderer = renderer;
            this.mSizeChanged = true;
            setName("GLThread");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r1 = org.anddev.andengine.opengl.view.GLSurfaceView.sEglSemaphore;	 Catch:{ InterruptedException -> 0x0012, all -> 0x0024 }
            r1.acquire();	 Catch:{ InterruptedException -> 0x0012, all -> 0x0024 }
            r3.guardedRun();	 Catch:{ InterruptedException -> 0x001b, all -> 0x0024 }
            r1 = org.anddev.andengine.opengl.view.GLSurfaceView.sEglSemaphore;
            r1.release();
        L_0x0011:
            return;
        L_0x0012:
            r0 = move-exception;
            r1 = org.anddev.andengine.opengl.view.GLSurfaceView.sEglSemaphore;
            r1.release();
            goto L_0x0011;
        L_0x001b:
            r1 = move-exception;
            r1 = org.anddev.andengine.opengl.view.GLSurfaceView.sEglSemaphore;
            r1.release();
            goto L_0x0011;
        L_0x0024:
            r1 = move-exception;
            r2 = org.anddev.andengine.opengl.view.GLSurfaceView.sEglSemaphore;
            r2.release();
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.anddev.andengine.opengl.view.GLSurfaceView.GLThread.run():void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
            r10 = this;
            r8 = new org.anddev.andengine.opengl.view.GLSurfaceView$EglHelper;
            r9 = org.anddev.andengine.opengl.view.GLSurfaceView.this;
            r8.<init>();
            r10.mEglHelper = r8;
            r8 = r10.mEglHelper;
            r8.start();
            r1 = 0;
            r6 = 1;
            r5 = 1;
        L_0x0011:
            r8 = r10.mDone;
            if (r8 == 0) goto L_0x001b;
        L_0x0015:
            r8 = r10.mEglHelper;
            r8.finish();
            return;
        L_0x001b:
            r3 = 0;
            monitor-enter(r10);
        L_0x001d:
            r4 = r10.getEvent();	 Catch:{ all -> 0x0039 }
            if (r4 != 0) goto L_0x003c;
        L_0x0023:
            r8 = r10.mPaused;	 Catch:{ all -> 0x0039 }
            if (r8 == 0) goto L_0x002d;
        L_0x0027:
            r8 = r10.mEglHelper;	 Catch:{ all -> 0x0039 }
            r8.finish();	 Catch:{ all -> 0x0039 }
            r3 = 1;
        L_0x002d:
            r8 = r10.needToWait();	 Catch:{ all -> 0x0039 }
            if (r8 != 0) goto L_0x0040;
        L_0x0033:
            r8 = r10.mDone;	 Catch:{ all -> 0x0039 }
            if (r8 == 0) goto L_0x0044;
        L_0x0037:
            monitor-exit(r10);	 Catch:{ all -> 0x0039 }
            goto L_0x0015;
        L_0x0039:
            r8 = move-exception;
            monitor-exit(r10);	 Catch:{ all -> 0x0039 }
            throw r8;
        L_0x003c:
            r4.run();	 Catch:{ all -> 0x0039 }
            goto L_0x001d;
        L_0x0040:
            r10.wait();	 Catch:{ all -> 0x0039 }
            goto L_0x002d;
        L_0x0044:
            r0 = r10.mSizeChanged;	 Catch:{ all -> 0x0039 }
            r7 = r10.mWidth;	 Catch:{ all -> 0x0039 }
            r2 = r10.mHeight;	 Catch:{ all -> 0x0039 }
            r8 = 0;
            r10.mSizeChanged = r8;	 Catch:{ all -> 0x0039 }
            r8 = 0;
            r10.mRequestRender = r8;	 Catch:{ all -> 0x0039 }
            monitor-exit(r10);	 Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x005a;
        L_0x0053:
            r8 = r10.mEglHelper;
            r8.start();
            r6 = 1;
            r0 = 1;
        L_0x005a:
            if (r0 == 0) goto L_0x006b;
        L_0x005c:
            r8 = r10.mEglHelper;
            r9 = org.anddev.andengine.opengl.view.GLSurfaceView.this;
            r9 = r9.getHolder();
            r1 = r8.createSurface(r9);
            r1 = (javax.microedition.khronos.opengles.GL10) r1;
            r5 = 1;
        L_0x006b:
            if (r6 == 0) goto L_0x0077;
        L_0x006d:
            r8 = r10.mRenderer;
            r9 = r10.mEglHelper;
            r9 = r9.mEglConfig;
            r8.onSurfaceCreated(r1, r9);
            r6 = 0;
        L_0x0077:
            if (r5 == 0) goto L_0x007f;
        L_0x0079:
            r8 = r10.mRenderer;
            r8.onSurfaceChanged(r1, r7, r2);
            r5 = 0;
        L_0x007f:
            if (r7 <= 0) goto L_0x0011;
        L_0x0081:
            if (r2 <= 0) goto L_0x0011;
        L_0x0083:
            r8 = r10.mRenderer;
            r8.onDrawFrame(r1);
            r8 = r10.mEglHelper;
            r8.swap();
            goto L_0x0011;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.anddev.andengine.opengl.view.GLSurfaceView.GLThread.guardedRun():void");
        }

        private boolean needToWait() {
            if (this.mDone) {
                return false;
            }
            if (this.mPaused || !this.mHasSurface) {
                return true;
            }
            if (this.mWidth <= 0 || this.mHeight <= 0 || (!this.mRequestRender && this.mRenderMode != 1)) {
                return true;
            }
            return false;
        }

        public void setRenderMode(int renderMode) {
            if (renderMode < 0 || renderMode > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (this) {
                this.mRenderMode = renderMode;
                if (renderMode == 1) {
                    notify();
                }
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (this) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (this) {
                this.mRequestRender = true;
                notify();
            }
        }

        public void surfaceCreated() {
            synchronized (this) {
                this.mHasSurface = true;
                notify();
            }
        }

        public void surfaceDestroyed() {
            synchronized (this) {
                this.mHasSurface = false;
                notify();
            }
        }

        public void onPause() {
            synchronized (this) {
                this.mPaused = true;
            }
        }

        public void onResume() {
            synchronized (this) {
                this.mPaused = false;
                notify();
            }
        }

        public void onWindowResize(int w, int h) {
            synchronized (this) {
                this.mWidth = w;
                this.mHeight = h;
                this.mSizeChanged = true;
                notify();
            }
        }

        public void requestExitAndWait() {
            synchronized (this) {
                this.mDone = true;
                notify();
            }
            try {
                join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public void queueEvent(Runnable r) {
            synchronized (this) {
                this.mEventQueue.add(r);
            }
        }

        private Runnable getEvent() {
            synchronized (this) {
                if (this.mEventQueue.size() > 0) {
                    Runnable runnable = (Runnable) this.mEventQueue.remove(0);
                    return runnable;
                }
                return null;
            }
        }
    }

    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    public GLSurfaceView(Context context) {
        super(context);
        init();
    }

    public GLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setType(2);
        this.mRenderMode = 1;
    }

    public void setGLWrapper(GLWrapper glWrapper) {
        this.mGLWrapper = glWrapper;
    }

    public void setDebugFlags(int debugFlags) {
        this.mDebugFlags = debugFlags;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setRenderer(Renderer renderer) {
        if (this.mRenderer != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
        this.mRenderer = renderer;
    }

    public void setEGLConfigChooser(EGLConfigChooser configChooser) {
        if (this.mRenderer != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
        this.mEGLConfigChooser = configChooser;
    }

    public void setEGLConfigChooser(boolean needDepth) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(needDepth));
    }

    public void setEGLConfigChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize) {
        setEGLConfigChooser(new ComponentSizeChooser(redSize, greenSize, blueSize, alphaSize, depthSize, stencilSize));
    }

    public void setRenderMode(int renderMode) {
        this.mRenderMode = renderMode;
        if (this.mGLThread != null) {
            this.mGLThread.setRenderMode(renderMode);
        }
    }

    public int getRenderMode() {
        return this.mRenderMode;
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void surfaceCreated(SurfaceHolder holder) {
        if (this.mGLThread != null) {
            this.mGLThread.surfaceCreated();
        }
        this.mHasSurface = true;
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        if (this.mGLThread != null) {
            this.mGLThread.surfaceDestroyed();
        }
        this.mHasSurface = false;
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        if (this.mGLThread != null) {
            this.mGLThread.onWindowResize(w, h);
        }
        this.mSurfaceWidth = w;
        this.mSurfaceHeight = h;
    }

    public void onPause() {
        this.mGLThread.onPause();
        this.mGLThread.requestExitAndWait();
        this.mGLThread = null;
    }

    public void onResume() {
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        this.mGLThread = new GLThread(this.mRenderer);
        this.mGLThread.start();
        this.mGLThread.setRenderMode(this.mRenderMode);
        if (this.mHasSurface) {
            this.mGLThread.surfaceCreated();
        }
        if (this.mSurfaceWidth > 0 && this.mSurfaceHeight > 0) {
            this.mGLThread.onWindowResize(this.mSurfaceWidth, this.mSurfaceHeight);
        }
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable r) {
        if (this.mGLThread != null) {
            this.mGLThread.queueEvent(r);
        }
    }
}
