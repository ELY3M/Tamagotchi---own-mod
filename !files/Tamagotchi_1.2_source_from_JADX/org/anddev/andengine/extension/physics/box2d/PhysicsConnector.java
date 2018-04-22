package org.anddev.andengine.extension.physics.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.shape.IShape;
import org.anddev.andengine.extension.physics.box2d.util.constants.PhysicsConstants;
import org.anddev.andengine.util.MathUtils;

public class PhysicsConnector implements IUpdateHandler, PhysicsConstants {
    protected final Body mBody;
    protected final float mPixelToMeterRatio;
    protected final IShape mShape;
    protected final float mShapeHalfBaseHeight;
    protected final float mShapeHalfBaseWidth;
    protected boolean mUpdatePosition;
    protected boolean mUpdateRotation;

    public PhysicsConnector(IShape pShape, Body pBody) {
        this(pShape, pBody, true, true);
    }

    public PhysicsConnector(IShape pShape, Body pBody, float pPixelToMeterRatio) {
        this(pShape, pBody, true, true, pPixelToMeterRatio);
    }

    public PhysicsConnector(IShape pShape, Body pBody, boolean pUdatePosition, boolean pUpdateRotation) {
        this(pShape, pBody, pUdatePosition, pUpdateRotation, PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
    }

    public PhysicsConnector(IShape pShape, Body pBody, boolean pUdatePosition, boolean pUpdateRotation, float pPixelToMeterRatio) {
        this.mShape = pShape;
        this.mBody = pBody;
        this.mUpdatePosition = pUdatePosition;
        this.mUpdateRotation = pUpdateRotation;
        this.mPixelToMeterRatio = pPixelToMeterRatio;
        this.mShapeHalfBaseWidth = pShape.getBaseWidth() * 0.5f;
        this.mShapeHalfBaseHeight = pShape.getBaseHeight() * 0.5f;
    }

    public IShape getShape() {
        return this.mShape;
    }

    public Body getBody() {
        return this.mBody;
    }

    public boolean isUpdatePosition() {
        return this.mUpdatePosition;
    }

    public boolean isUpdateRotation() {
        return this.mUpdateRotation;
    }

    public void setUpdatePosition(boolean pUpdatePosition) {
        this.mUpdatePosition = pUpdatePosition;
    }

    public void setUpdateRotation(boolean pUpdateRotation) {
        this.mUpdateRotation = pUpdateRotation;
    }

    public void onUpdate(float pSecondsElapsed) {
        IShape shape = this.mShape;
        Body body = this.mBody;
        if (this.mUpdatePosition) {
            Vector2 position = body.getPosition();
            float pixelToMeterRatio = this.mPixelToMeterRatio;
            shape.setPosition((position.f3x * pixelToMeterRatio) - this.mShapeHalfBaseWidth, (position.f4y * pixelToMeterRatio) - this.mShapeHalfBaseHeight);
        }
        if (this.mUpdateRotation) {
            shape.setRotation(MathUtils.radToDeg(body.getAngle()));
        }
    }

    public void reset() {
    }
}
