package org.anddev.andengine.extension.physics.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class FixedStepPhysicsWorld extends PhysicsWorld {
    public static final int STEPSPERSECOND_DEFAULT = 60;
    private final int mMaximumStepsPerUpdate;
    private float mSecondsElapsedAccumulator;
    private final float mTimeStep;

    public FixedStepPhysicsWorld(int pStepsPerSecond, Vector2 pGravity, boolean pAllowSleep) {
        this(pStepsPerSecond, Integer.MAX_VALUE, pGravity, pAllowSleep);
    }

    public FixedStepPhysicsWorld(int pStepsPerSecond, int pMaximumStepsPerUpdate, Vector2 pGravity, boolean pAllowSleep) {
        super(pGravity, pAllowSleep);
        this.mTimeStep = 1.0f / ((float) pStepsPerSecond);
        this.mMaximumStepsPerUpdate = pMaximumStepsPerUpdate;
    }

    public FixedStepPhysicsWorld(int pStepsPerSecond, Vector2 pGravity, boolean pAllowSleep, int pVelocityIterations, int pPositionIterations) {
        this(pStepsPerSecond, Integer.MAX_VALUE, pGravity, pAllowSleep, pVelocityIterations, pPositionIterations);
    }

    public FixedStepPhysicsWorld(int pStepsPerSecond, int pMaximumStepsPerUpdate, Vector2 pGravity, boolean pAllowSleep, int pVelocityIterations, int pPositionIterations) {
        super(pGravity, pAllowSleep, pVelocityIterations, pPositionIterations);
        this.mTimeStep = 1.0f / ((float) pStepsPerSecond);
        this.mMaximumStepsPerUpdate = pMaximumStepsPerUpdate;
    }

    public void onUpdate(float pSecondsElapsed) {
        this.mRunnableHandler.onUpdate(pSecondsElapsed);
        this.mSecondsElapsedAccumulator += pSecondsElapsed;
        int velocityIterations = this.mVelocityIterations;
        int positionIterations = this.mPositionIterations;
        World world = this.mWorld;
        float stepLength = this.mTimeStep;
        int stepsAllowed = this.mMaximumStepsPerUpdate;
        while (this.mSecondsElapsedAccumulator >= stepLength && stepsAllowed > 0) {
            world.step(stepLength, velocityIterations, positionIterations);
            this.mSecondsElapsedAccumulator -= stepLength;
            stepsAllowed--;
        }
        this.mPhysicsConnectorManager.onUpdate(pSecondsElapsed);
    }
}
