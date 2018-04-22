package net.rbgrn.opengl;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.EGLWindowSurfaceFactory;
import android.opengl.GLSurfaceView.GLWrapper;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import org.anddev.andengine.opengl.view.GLSurfaceView.Renderer;

class GLThread extends Thread {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_THREADS = false;
    public boolean mDone = false;
    private final EGLConfigChooser mEGLConfigChooser;
    private final EGLContextFactory mEGLContextFactory;
    private final EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private EglHelper mEglHelper;
    private GLThread mEglOwner;
    private final ArrayList<Runnable> mEventQueue = new ArrayList();
    private boolean mEventsWaiting;
    private final GLWrapper mGLWrapper;
    private boolean mHasSurface;
    private boolean mHaveEgl;
    private int mHeight = 0;
    public SurfaceHolder mHolder;
    private boolean mPaused;
    private int mRenderMode = 1;
    private final Renderer mRenderer;
    private boolean mRequestRender = true;
    private boolean mSizeChanged = true;
    private boolean mWaitingForSurface;
    private int mWidth = 0;
    private final GLThreadManager sGLThreadManager = new GLThreadManager();

    private class GLThreadManager {
        private GLThreadManager() {
        }

        public synchronized void threadExiting(GLThread thread) {
            thread.mDone = true;
            if (GLThread.this.mEglOwner == thread) {
                GLThread.this.mEglOwner = null;
            }
            notifyAll();
        }

        public synchronized boolean tryAcquireEglSurface(GLThread thread) {
            boolean z;
            if (GLThread.this.mEglOwner == thread || GLThread.this.mEglOwner == null) {
                GLThread.this.mEglOwner = thread;
                notifyAll();
                z = true;
            } else {
                z = false;
            }
            return z;
        }

        public synchronized void releaseEglSurface(GLThread thread) {
            if (GLThread.this.mEglOwner == thread) {
                GLThread.this.mEglOwner = null;
            }
            notifyAll();
        }
    }

    GLThread(Renderer renderer, EGLConfigChooser chooser, EGLContextFactory contextFactory, EGLWindowSurfaceFactory surfaceFactory, GLWrapper wrapper) {
        this.mRenderer = renderer;
        this.mEGLConfigChooser = chooser;
        this.mEGLContextFactory = contextFactory;
        this.mEGLWindowSurfaceFactory = surfaceFactory;
        this.mGLWrapper = wrapper;
    }

    public void run() {
        setName("GLThread " + getId());
        try {
            guardedRun();
        } catch (InterruptedException e) {
        } finally {
            this.sGLThreadManager.threadExiting(this);
        }
    }

    private void stopEglLocked() {
        if (this.mHaveEgl) {
            this.mHaveEgl = false;
            this.mEglHelper.destroySurface();
            this.mEglHelper.finish();
            this.sGLThreadManager.releaseEglSurface(this);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void guardedRun() throws java.lang.InterruptedException {
        /*
        r16 = this;
        r15 = 1;
        r10 = new net.rbgrn.opengl.EglHelper;
        r0 = r16;
        r11 = r0.mEGLConfigChooser;
        r0 = r16;
        r12 = r0.mEGLContextFactory;
        r0 = r16;
        r13 = r0.mEGLWindowSurfaceFactory;
        r0 = r16;
        r14 = r0.mGLWrapper;
        r10.<init>(r11, r12, r13, r14);
        r0 = r16;
        r0.mEglHelper = r10;
        r3 = 0;
        r8 = 1;
        r7 = 1;
    L_0x001d:
        r10 = r16.isDone();	 Catch:{ all -> 0x011d }
        if (r10 == 0) goto L_0x002d;
    L_0x0023:
        r0 = r16;
        r11 = r0.sGLThreadManager;
        monitor-enter(r11);
        r16.stopEglLocked();	 Catch:{ all -> 0x0179 }
        monitor-exit(r11);	 Catch:{ all -> 0x0179 }
    L_0x002c:
        return;
    L_0x002d:
        r9 = 0;
        r4 = 0;
        r1 = 0;
        r5 = 0;
        r2 = 0;
        r0 = r16;
        r11 = r0.sGLThreadManager;	 Catch:{ all -> 0x011d }
        monitor-enter(r11);	 Catch:{ all -> 0x011d }
    L_0x0037:
        r0 = r16;
        r10 = r0.mPaused;	 Catch:{ all -> 0x011a }
        if (r10 == 0) goto L_0x0040;
    L_0x003d:
        r16.stopEglLocked();	 Catch:{ all -> 0x011a }
    L_0x0040:
        r0 = r16;
        r10 = r0.mHasSurface;	 Catch:{ all -> 0x011a }
        if (r10 != 0) goto L_0x006f;
    L_0x0046:
        r0 = r16;
        r10 = r0.mWaitingForSurface;	 Catch:{ all -> 0x011a }
        if (r10 != 0) goto L_0x005b;
    L_0x004c:
        r16.stopEglLocked();	 Catch:{ all -> 0x011a }
        r10 = 1;
        r0 = r16;
        r0.mWaitingForSurface = r10;	 Catch:{ all -> 0x011a }
        r0 = r16;
        r10 = r0.sGLThreadManager;	 Catch:{ all -> 0x011a }
        r10.notifyAll();	 Catch:{ all -> 0x011a }
    L_0x005b:
        r0 = r16;
        r10 = r0.mDone;	 Catch:{ all -> 0x011a }
        if (r10 == 0) goto L_0x0094;
    L_0x0061:
        monitor-exit(r11);	 Catch:{ all -> 0x011a }
        r0 = r16;
        r11 = r0.sGLThreadManager;
        monitor-enter(r11);
        r16.stopEglLocked();	 Catch:{ all -> 0x006c }
        monitor-exit(r11);	 Catch:{ all -> 0x006c }
        goto L_0x002c;
    L_0x006c:
        r10 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x006c }
        throw r10;
    L_0x006f:
        r0 = r16;
        r10 = r0.mHaveEgl;	 Catch:{ all -> 0x011a }
        if (r10 != 0) goto L_0x005b;
    L_0x0075:
        r0 = r16;
        r10 = r0.sGLThreadManager;	 Catch:{ all -> 0x011a }
        r0 = r16;
        r10 = r10.tryAcquireEglSurface(r0);	 Catch:{ all -> 0x011a }
        if (r10 == 0) goto L_0x005b;
    L_0x0081:
        r10 = 1;
        r0 = r16;
        r0.mHaveEgl = r10;	 Catch:{ all -> 0x011a }
        r0 = r16;
        r10 = r0.mEglHelper;	 Catch:{ all -> 0x011a }
        r10.start();	 Catch:{ all -> 0x011a }
        r10 = 1;
        r0 = r16;
        r0.mRequestRender = r10;	 Catch:{ all -> 0x011a }
        r5 = 1;
        goto L_0x005b;
    L_0x0094:
        r0 = r16;
        r10 = r0.mEventsWaiting;	 Catch:{ all -> 0x011a }
        if (r10 == 0) goto L_0x00c0;
    L_0x009a:
        r2 = 1;
        r10 = 0;
        r0 = r16;
        r0.mEventsWaiting = r10;	 Catch:{ all -> 0x011a }
    L_0x00a0:
        monitor-exit(r11);	 Catch:{ all -> 0x011a }
        if (r2 == 0) goto L_0x0131;
    L_0x00a3:
        r6 = r16.getEvent();	 Catch:{ all -> 0x011d }
        if (r6 == 0) goto L_0x001d;
    L_0x00a9:
        r6.run();	 Catch:{ all -> 0x011d }
        r10 = r16.isDone();	 Catch:{ all -> 0x011d }
        if (r10 == 0) goto L_0x00a3;
    L_0x00b2:
        r0 = r16;
        r11 = r0.sGLThreadManager;
        monitor-enter(r11);
        r16.stopEglLocked();	 Catch:{ all -> 0x00bd }
        monitor-exit(r11);	 Catch:{ all -> 0x00bd }
        goto L_0x002c;
    L_0x00bd:
        r10 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x00bd }
        throw r10;
    L_0x00c0:
        r0 = r16;
        r10 = r0.mPaused;	 Catch:{ all -> 0x011a }
        if (r10 != 0) goto L_0x0128;
    L_0x00c6:
        r0 = r16;
        r10 = r0.mHasSurface;	 Catch:{ all -> 0x011a }
        if (r10 == 0) goto L_0x0128;
    L_0x00cc:
        r0 = r16;
        r10 = r0.mHaveEgl;	 Catch:{ all -> 0x011a }
        if (r10 == 0) goto L_0x0128;
    L_0x00d2:
        r0 = r16;
        r10 = r0.mWidth;	 Catch:{ all -> 0x011a }
        if (r10 <= 0) goto L_0x0128;
    L_0x00d8:
        r0 = r16;
        r10 = r0.mHeight;	 Catch:{ all -> 0x011a }
        if (r10 <= 0) goto L_0x0128;
    L_0x00de:
        r0 = r16;
        r10 = r0.mRequestRender;	 Catch:{ all -> 0x011a }
        if (r10 != 0) goto L_0x00ea;
    L_0x00e4:
        r0 = r16;
        r10 = r0.mRenderMode;	 Catch:{ all -> 0x011a }
        if (r10 != r15) goto L_0x0128;
    L_0x00ea:
        r0 = r16;
        r1 = r0.mSizeChanged;	 Catch:{ all -> 0x011a }
        r0 = r16;
        r9 = r0.mWidth;	 Catch:{ all -> 0x011a }
        r0 = r16;
        r4 = r0.mHeight;	 Catch:{ all -> 0x011a }
        r10 = 0;
        r0 = r16;
        r0.mSizeChanged = r10;	 Catch:{ all -> 0x011a }
        r10 = 0;
        r0 = r16;
        r0.mRequestRender = r10;	 Catch:{ all -> 0x011a }
        r0 = r16;
        r10 = r0.mHasSurface;	 Catch:{ all -> 0x011a }
        if (r10 == 0) goto L_0x00a0;
    L_0x0106:
        r0 = r16;
        r10 = r0.mWaitingForSurface;	 Catch:{ all -> 0x011a }
        if (r10 == 0) goto L_0x00a0;
    L_0x010c:
        r1 = 1;
        r10 = 0;
        r0 = r16;
        r0.mWaitingForSurface = r10;	 Catch:{ all -> 0x011a }
        r0 = r16;
        r10 = r0.sGLThreadManager;	 Catch:{ all -> 0x011a }
        r10.notifyAll();	 Catch:{ all -> 0x011a }
        goto L_0x00a0;
    L_0x011a:
        r10 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x011a }
        throw r10;	 Catch:{ all -> 0x011d }
    L_0x011d:
        r10 = move-exception;
        r0 = r16;
        r11 = r0.sGLThreadManager;
        monitor-enter(r11);
        r16.stopEglLocked();	 Catch:{ all -> 0x0176 }
        monitor-exit(r11);	 Catch:{ all -> 0x0176 }
        throw r10;
    L_0x0128:
        r0 = r16;
        r10 = r0.sGLThreadManager;	 Catch:{ all -> 0x011a }
        r10.wait();	 Catch:{ all -> 0x011a }
        goto L_0x0037;
    L_0x0131:
        if (r5 == 0) goto L_0x0135;
    L_0x0133:
        r8 = 1;
        r1 = 1;
    L_0x0135:
        if (r1 == 0) goto L_0x0148;
    L_0x0137:
        r0 = r16;
        r10 = r0.mEglHelper;	 Catch:{ all -> 0x011d }
        r0 = r16;
        r11 = r0.mHolder;	 Catch:{ all -> 0x011d }
        r10 = r10.createSurface(r11);	 Catch:{ all -> 0x011d }
        r0 = r10;
        r0 = (javax.microedition.khronos.opengles.GL10) r0;	 Catch:{ all -> 0x011d }
        r3 = r0;
        r7 = 1;
    L_0x0148:
        if (r8 == 0) goto L_0x0158;
    L_0x014a:
        r0 = r16;
        r10 = r0.mRenderer;	 Catch:{ all -> 0x011d }
        r0 = r16;
        r11 = r0.mEglHelper;	 Catch:{ all -> 0x011d }
        r11 = r11.mEglConfig;	 Catch:{ all -> 0x011d }
        r10.onSurfaceCreated(r3, r11);	 Catch:{ all -> 0x011d }
        r8 = 0;
    L_0x0158:
        if (r7 == 0) goto L_0x0162;
    L_0x015a:
        r0 = r16;
        r10 = r0.mRenderer;	 Catch:{ all -> 0x011d }
        r10.onSurfaceChanged(r3, r9, r4);	 Catch:{ all -> 0x011d }
        r7 = 0;
    L_0x0162:
        if (r9 <= 0) goto L_0x001d;
    L_0x0164:
        if (r4 <= 0) goto L_0x001d;
    L_0x0166:
        r0 = r16;
        r10 = r0.mRenderer;	 Catch:{ all -> 0x011d }
        r10.onDrawFrame(r3);	 Catch:{ all -> 0x011d }
        r0 = r16;
        r10 = r0.mEglHelper;	 Catch:{ all -> 0x011d }
        r10.swap();	 Catch:{ all -> 0x011d }
        goto L_0x001d;
    L_0x0176:
        r10 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0176 }
        throw r10;
    L_0x0179:
        r10 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0179 }
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.rbgrn.opengl.GLThread.guardedRun():void");
    }

    private boolean isDone() {
        boolean z;
        synchronized (this.sGLThreadManager) {
            z = this.mDone;
        }
        return z;
    }

    public void setRenderMode(int renderMode) {
        if (renderMode < 0 || renderMode > 1) {
            throw new IllegalArgumentException("renderMode");
        }
        synchronized (this.sGLThreadManager) {
            this.mRenderMode = renderMode;
            if (renderMode == 1) {
                this.sGLThreadManager.notifyAll();
            }
        }
    }

    public int getRenderMode() {
        int i;
        synchronized (this.sGLThreadManager) {
            i = this.mRenderMode;
        }
        return i;
    }

    public void requestRender() {
        synchronized (this.sGLThreadManager) {
            this.mRequestRender = true;
            this.sGLThreadManager.notifyAll();
        }
    }

    public void surfaceCreated(SurfaceHolder holder) {
        this.mHolder = holder;
        synchronized (this.sGLThreadManager) {
            this.mHasSurface = true;
            this.sGLThreadManager.notifyAll();
        }
    }

    public void surfaceDestroyed() {
        synchronized (this.sGLThreadManager) {
            this.mHasSurface = false;
            this.sGLThreadManager.notifyAll();
            while (!this.mWaitingForSurface && isAlive() && !this.mDone) {
                try {
                    this.sGLThreadManager.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void onPause() {
        synchronized (this.sGLThreadManager) {
            this.mPaused = true;
            this.sGLThreadManager.notifyAll();
        }
    }

    public void onResume() {
        synchronized (this.sGLThreadManager) {
            this.mPaused = false;
            this.mRequestRender = true;
            this.sGLThreadManager.notifyAll();
        }
    }

    public void onWindowResize(int w, int h) {
        synchronized (this.sGLThreadManager) {
            this.mWidth = w;
            this.mHeight = h;
            this.mSizeChanged = true;
            this.sGLThreadManager.notifyAll();
        }
    }

    public void requestExitAndWait() {
        synchronized (this.sGLThreadManager) {
            this.mDone = true;
            this.sGLThreadManager.notifyAll();
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
            synchronized (this.sGLThreadManager) {
                this.mEventsWaiting = true;
                this.sGLThreadManager.notifyAll();
            }
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
