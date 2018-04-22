package org.anddev.andengine.entity.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.extension.svg.util.constants.ColorUtils;

public class ScreenGrabber extends Entity {
    private int mGrabHeight;
    private int mGrabWidth;
    private int mGrabX;
    private int mGrabY;
    private IScreenGrabberCallback mScreenGrabCallback;
    private boolean mScreenGrabPending = false;

    public interface IScreenGrabberCallback {
        void onScreenGrabFailed(Exception exception);

        void onScreenGrabbed(Bitmap bitmap);
    }

    protected void onManagedDraw(GL10 pGL, Camera pCamera) {
        if (this.mScreenGrabPending) {
            try {
                this.mScreenGrabCallback.onScreenGrabbed(grab(this.mGrabX, this.mGrabY, this.mGrabWidth, this.mGrabHeight, pGL));
            } catch (Exception e) {
                this.mScreenGrabCallback.onScreenGrabFailed(e);
            }
            this.mScreenGrabPending = false;
        }
    }

    protected void onManagedUpdate(float pSecondsElapsed) {
    }

    public void reset() {
    }

    public void grab(int pGrabWidth, int pGrabHeight, IScreenGrabberCallback pScreenGrabCallback) {
        grab(0, 0, pGrabWidth, pGrabHeight, pScreenGrabCallback);
    }

    public void grab(int pGrabX, int pGrabY, int pGrabWidth, int pGrabHeight, IScreenGrabberCallback pScreenGrabCallback) {
        this.mGrabX = pGrabX;
        this.mGrabY = pGrabY;
        this.mGrabWidth = pGrabWidth;
        this.mGrabHeight = pGrabHeight;
        this.mScreenGrabCallback = pScreenGrabCallback;
        this.mScreenGrabPending = true;
    }

    private static Bitmap grab(int pGrabX, int pGrabY, int pGrabWidth, int pGrabHeight, GL10 pGL) {
        int[] source = new int[((pGrabY + pGrabHeight) * pGrabWidth)];
        IntBuffer sourceBuffer = IntBuffer.wrap(source);
        sourceBuffer.position(0);
        pGL.glReadPixels(pGrabX, 0, pGrabWidth, pGrabY + pGrabHeight, 6408, 5121, sourceBuffer);
        int[] pixels = new int[(pGrabWidth * pGrabHeight)];
        for (int y = 0; y < pGrabHeight; y++) {
            for (int x = 0; x < pGrabWidth; x++) {
                int pixel = source[((pGrabY + y) * pGrabWidth) + x];
                pixels[(((pGrabHeight - y) - 1) * pGrabWidth) + x] = ((pixel & -16711936) | ((pixel & 255) << 16)) | ((ColorUtils.COLOR_MASK_32BIT_ARGB_R & pixel) >> 16);
            }
        }
        return Bitmap.createBitmap(pixels, pGrabWidth, pGrabHeight, Config.ARGB_8888);
    }
}
