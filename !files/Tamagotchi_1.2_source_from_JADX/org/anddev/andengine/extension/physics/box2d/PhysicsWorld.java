package org.anddev.andengine.extension.physics.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactFilter;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.DestructionListener;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.physics.box2d.World;
import java.util.Iterator;
import java.util.List;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.runnable.RunnableHandler;

public class PhysicsWorld implements IUpdateHandler {
    public static final int POSITION_ITERATIONS_DEFAULT = 8;
    public static final int VELOCITY_ITERATIONS_DEFAULT = 8;
    protected final PhysicsConnectorManager mPhysicsConnectorManager;
    protected int mPositionIterations;
    protected final RunnableHandler mRunnableHandler;
    protected int mVelocityIterations;
    protected final World mWorld;

    static {
        System.loadLibrary("andenginephysicsbox2dextension");
    }

    public PhysicsWorld(Vector2 pGravity, boolean pAllowSleep) {
        this(pGravity, pAllowSleep, 8, 8);
    }

    public PhysicsWorld(Vector2 pGravity, boolean pAllowSleep, int pVelocityIterations, int pPositionIterations) {
        this.mPhysicsConnectorManager = new PhysicsConnectorManager();
        this.mRunnableHandler = new RunnableHandler();
        this.mVelocityIterations = 8;
        this.mPositionIterations = 8;
        this.mWorld = new World(pGravity, pAllowSleep);
        this.mVelocityIterations = pVelocityIterations;
        this.mPositionIterations = pPositionIterations;
    }

    public int getPositionIterations() {
        return this.mPositionIterations;
    }

    public void setPositionIterations(int pPositionIterations) {
        this.mPositionIterations = pPositionIterations;
    }

    public int getVelocityIterations() {
        return this.mVelocityIterations;
    }

    public void setVelocityIterations(int pVelocityIterations) {
        this.mVelocityIterations = pVelocityIterations;
    }

    public PhysicsConnectorManager getPhysicsConnectorManager() {
        return this.mPhysicsConnectorManager;
    }

    public void clearPhysicsConnectors() {
        this.mPhysicsConnectorManager.clear();
    }

    public void registerPhysicsConnector(PhysicsConnector pPhysicsConnector) {
        this.mPhysicsConnectorManager.add(pPhysicsConnector);
    }

    public void unregisterPhysicsConnector(PhysicsConnector pPhysicsConnector) {
        this.mPhysicsConnectorManager.remove(pPhysicsConnector);
    }

    public void onUpdate(float pSecondsElapsed) {
        this.mRunnableHandler.onUpdate(pSecondsElapsed);
        this.mWorld.step(pSecondsElapsed, this.mVelocityIterations, this.mPositionIterations);
        this.mPhysicsConnectorManager.onUpdate(pSecondsElapsed);
    }

    public void reset() {
        this.mPhysicsConnectorManager.reset();
        this.mRunnableHandler.reset();
    }

    public void postRunnable(Runnable pRunnable) {
        this.mRunnableHandler.postRunnable(pRunnable);
    }

    public void clearForces() {
        this.mWorld.clearForces();
    }

    public Body createBody(BodyDef pDef) {
        return this.mWorld.createBody(pDef);
    }

    public Joint createJoint(JointDef pDef) {
        return this.mWorld.createJoint(pDef);
    }

    public void destroyBody(Body pBody) {
        this.mWorld.destroyBody(pBody);
    }

    public void destroyJoint(Joint pJoint) {
        this.mWorld.destroyJoint(pJoint);
    }

    public void dispose() {
        this.mWorld.dispose();
    }

    public boolean getAutoClearForces() {
        return this.mWorld.getAutoClearForces();
    }

    public Iterator<Body> getBodies() {
        return this.mWorld.getBodies();
    }

    public int getBodyCount() {
        return this.mWorld.getBodyCount();
    }

    public int getContactCount() {
        return this.mWorld.getContactCount();
    }

    public List<Contact> getContactList() {
        return this.mWorld.getContactList();
    }

    public Vector2 getGravity() {
        return this.mWorld.getGravity();
    }

    public Iterator<Joint> getJoints() {
        return this.mWorld.getJoints();
    }

    public int getJointCount() {
        return this.mWorld.getJointCount();
    }

    public int getProxyCount() {
        return this.mWorld.getProxyCount();
    }

    public boolean isLocked() {
        return this.mWorld.isLocked();
    }

    public void QueryAABB(QueryCallback pCallback, float pLowerX, float pLowerY, float pUpperX, float pUpperY) {
        this.mWorld.QueryAABB(pCallback, pLowerX, pLowerY, pUpperX, pUpperY);
    }

    public void setAutoClearForces(boolean pFlag) {
        this.mWorld.setAutoClearForces(pFlag);
    }

    public void setContactFilter(ContactFilter pFilter) {
        this.mWorld.setContactFilter(pFilter);
    }

    public void setContactListener(ContactListener pListener) {
        this.mWorld.setContactListener(pListener);
    }

    public void setContinuousPhysics(boolean pFlag) {
        this.mWorld.setContinuousPhysics(pFlag);
    }

    public void setDestructionListener(DestructionListener pListener) {
        this.mWorld.setDestructionListener(pListener);
    }

    public void setGravity(Vector2 pGravity) {
        this.mWorld.setGravity(pGravity);
    }

    public void setWarmStarting(boolean pFlag) {
        this.mWorld.setWarmStarting(pFlag);
    }

    public void rayCast(RayCastCallback pRayCastCallback, Vector2 pPoint1, Vector2 pPoint2) {
        this.mWorld.rayCast(pRayCastCallback, pPoint1, pPoint2);
    }
}
