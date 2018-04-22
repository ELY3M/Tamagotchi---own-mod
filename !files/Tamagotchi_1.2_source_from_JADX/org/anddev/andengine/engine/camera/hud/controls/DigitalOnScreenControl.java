package org.anddev.andengine.engine.camera.hud.controls;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.camera.hud.controls.BaseOnScreenControl.IOnScreenControlListener;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.util.MathUtils;

public class DigitalOnScreenControl extends BaseOnScreenControl {
    private static final float ANGLE_DELTA = 22.5f;
    private static final float EXTENT_DIAGONAL = 0.354f;
    private static final float EXTENT_SIDE = 0.5f;
    private boolean mAllowDiagonal;

    public DigitalOnScreenControl(float pX, float pY, Camera pCamera, TextureRegion pControlBaseTextureRegion, TextureRegion pControlKnobTextureRegion, float pTimeBetweenUpdates, IOnScreenControlListener pOnScreenControlListener) {
        this(pX, pY, pCamera, pControlBaseTextureRegion, pControlKnobTextureRegion, pTimeBetweenUpdates, false, pOnScreenControlListener);
    }

    public DigitalOnScreenControl(float pX, float pY, Camera pCamera, TextureRegion pControlBaseTextureRegion, TextureRegion pControlKnobTextureRegion, float pTimeBetweenUpdates, boolean pAllowDiagonal, IOnScreenControlListener pOnScreenControlListener) {
        super(pX, pY, pCamera, pControlBaseTextureRegion, pControlKnobTextureRegion, pTimeBetweenUpdates, pOnScreenControlListener);
        this.mAllowDiagonal = pAllowDiagonal;
    }

    public boolean isAllowDiagonal() {
        return this.mAllowDiagonal;
    }

    public void setAllowDiagonal(boolean pAllowDiagonal) {
        this.mAllowDiagonal = pAllowDiagonal;
    }

    protected void onUpdateControlKnob(float pRelativeX, float pRelativeY) {
        if (pRelativeX == 0.0f && pRelativeY == 0.0f) {
            super.onUpdateControlKnob(0.0f, 0.0f);
        } else if (this.mAllowDiagonal) {
            float angle = MathUtils.radToDeg(MathUtils.atan2(pRelativeY, pRelativeX)) + BitmapDescriptorFactory.HUE_CYAN;
            if (testDiagonalAngle(0.0f, angle) || testDiagonalAngle(360.0f, angle)) {
                super.onUpdateControlKnob(-0.5f, 0.0f);
            } else if (testDiagonalAngle(45.0f, angle)) {
                super.onUpdateControlKnob(-0.354f, -0.354f);
            } else if (testDiagonalAngle(90.0f, angle)) {
                super.onUpdateControlKnob(0.0f, -0.5f);
            } else if (testDiagonalAngle(135.0f, angle)) {
                super.onUpdateControlKnob(EXTENT_DIAGONAL, -0.354f);
            } else if (testDiagonalAngle(BitmapDescriptorFactory.HUE_CYAN, angle)) {
                super.onUpdateControlKnob(EXTENT_SIDE, 0.0f);
            } else if (testDiagonalAngle(225.0f, angle)) {
                super.onUpdateControlKnob(EXTENT_DIAGONAL, EXTENT_DIAGONAL);
            } else if (testDiagonalAngle(BitmapDescriptorFactory.HUE_VIOLET, angle)) {
                super.onUpdateControlKnob(0.0f, EXTENT_SIDE);
            } else if (testDiagonalAngle(315.0f, angle)) {
                super.onUpdateControlKnob(-0.354f, EXTENT_DIAGONAL);
            } else {
                super.onUpdateControlKnob(0.0f, 0.0f);
            }
        } else if (Math.abs(pRelativeX) > Math.abs(pRelativeY)) {
            if (pRelativeX > 0.0f) {
                super.onUpdateControlKnob(EXTENT_SIDE, 0.0f);
            } else if (pRelativeX < 0.0f) {
                super.onUpdateControlKnob(-0.5f, 0.0f);
            } else if (pRelativeX == 0.0f) {
                super.onUpdateControlKnob(0.0f, 0.0f);
            }
        } else if (pRelativeY > 0.0f) {
            super.onUpdateControlKnob(0.0f, EXTENT_SIDE);
        } else if (pRelativeY < 0.0f) {
            super.onUpdateControlKnob(0.0f, -0.5f);
        } else if (pRelativeY == 0.0f) {
            super.onUpdateControlKnob(0.0f, 0.0f);
        }
    }

    private boolean testDiagonalAngle(float pTestAngle, float pActualAngle) {
        return pActualAngle > pTestAngle - ANGLE_DELTA && pActualAngle < pTestAngle + ANGLE_DELTA;
    }
}
