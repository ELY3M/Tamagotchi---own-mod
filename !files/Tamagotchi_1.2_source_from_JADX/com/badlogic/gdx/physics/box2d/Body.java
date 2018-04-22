package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import java.util.ArrayList;

public class Body {
    protected final long addr;
    private ArrayList<Fixture> fixtures = new ArrayList(2);
    protected ArrayList<JointEdge> joints = new ArrayList(2);
    public final Vector2 linVelLoc = new Vector2();
    public final Vector2 linVelWorld = new Vector2();
    private final Vector2 linearVelocity = new Vector2();
    private final Vector2 localCenter = new Vector2();
    private final Vector2 localPoint = new Vector2();
    public final Vector2 localPoint2 = new Vector2();
    public final Vector2 localVector = new Vector2();
    private final MassData massData = new MassData();
    private final Vector2 position = new Vector2();
    private final float[] tmp = new float[4];
    private final Transform transform = new Transform();
    private Object userData;
    private final World world;
    private final Vector2 worldCenter = new Vector2();
    private final Vector2 worldVector = new Vector2();

    private native void jniApplyAngularImpulse(long j, float f);

    private native void jniApplyForce(long j, float f, float f2, float f3, float f4);

    private native void jniApplyLinearImpulse(long j, float f, float f2, float f3, float f4);

    private native void jniApplyTorque(long j, float f);

    private native long jniCreateFixture(long j, long j2, float f);

    private native long jniCreateFixture(long j, long j2, float f, float f2, float f3, boolean z, short s, short s2, short s3);

    private native void jniDestroyFixture(long j, long j2);

    private native float jniGetAngle(long j);

    private native float jniGetAngularDamping(long j);

    private native float jniGetAngularVelocity(long j);

    private native float jniGetInertia(long j);

    private native float jniGetLinearDamping(long j);

    private native void jniGetLinearVelocity(long j, float[] fArr);

    private native void jniGetLinearVelocityFromLocalPoint(long j, float f, float f2, float[] fArr);

    private native void jniGetLinearVelocityFromWorldPoint(long j, float f, float f2, float[] fArr);

    private native void jniGetLocalCenter(long j, float[] fArr);

    private native void jniGetLocalPoint(long j, float f, float f2, float[] fArr);

    private native void jniGetLocalVector(long j, float f, float f2, float[] fArr);

    private native float jniGetMass(long j);

    private native void jniGetMassData(long j, float[] fArr);

    private native void jniGetPosition(long j, float[] fArr);

    private native void jniGetTransform(long j, float[] fArr);

    private native int jniGetType(long j);

    private native void jniGetWorldCenter(long j, float[] fArr);

    private native void jniGetWorldPoint(long j, float f, float f2, float[] fArr);

    private native void jniGetWorldVector(long j, float f, float f2, float[] fArr);

    private native boolean jniIsActive(long j);

    private native boolean jniIsAwake(long j);

    private native boolean jniIsBullet(long j);

    private native boolean jniIsFixedRotation(long j);

    private native boolean jniIsSleepingAllowed(long j);

    private native void jniResetMassData(long j);

    private native void jniSetActive(long j, boolean z);

    private native void jniSetAngularDamping(long j, float f);

    private native void jniSetAngularVelocity(long j, float f);

    private native void jniSetAwake(long j, boolean z);

    private native void jniSetBullet(long j, boolean z);

    private native void jniSetFixedRotation(long j, boolean z);

    private native void jniSetLinearDamping(long j, float f);

    private native void jniSetLinearVelocity(long j, float f, float f2);

    private native void jniSetMassData(long j, float f, float f2, float f3, float f4);

    private native void jniSetSleepingAllowed(long j, boolean z);

    private native void jniSetTransform(long j, float f, float f2, float f3);

    private native void jniSetType(long j, int i);

    protected Body(World world, long addr) {
        this.world = world;
        this.addr = addr;
    }

    public Fixture createFixture(FixtureDef def) {
        Fixture fixture = new Fixture(this, jniCreateFixture(this.addr, def.shape.addr, def.friction, def.restitution, def.density, def.isSensor, def.filter.categoryBits, def.filter.maskBits, def.filter.groupIndex));
        this.world.fixtures.put(fixture.addr, fixture);
        this.fixtures.add(fixture);
        return fixture;
    }

    public Fixture createFixture(Shape shape, float density) {
        Fixture fixture = new Fixture(this, jniCreateFixture(this.addr, shape.addr, density));
        this.world.fixtures.put(fixture.addr, fixture);
        this.fixtures.add(fixture);
        return fixture;
    }

    public void destroyFixture(Fixture fixture) {
        jniDestroyFixture(this.addr, fixture.addr);
        this.world.fixtures.remove(fixture.addr);
        this.fixtures.remove(fixture);
    }

    public void setTransform(Vector2 position, float angle) {
        jniSetTransform(this.addr, position.f3x, position.f4y, angle);
    }

    public void setTransform(float x, float y, float angle) {
        jniSetTransform(this.addr, x, y, angle);
    }

    public Transform getTransform() {
        jniGetTransform(this.addr, this.transform.vals);
        return this.transform;
    }

    public Vector2 getPosition() {
        jniGetPosition(this.addr, this.tmp);
        this.position.f3x = this.tmp[0];
        this.position.f4y = this.tmp[1];
        return this.position;
    }

    public float getAngle() {
        return jniGetAngle(this.addr);
    }

    public Vector2 getWorldCenter() {
        jniGetWorldCenter(this.addr, this.tmp);
        this.worldCenter.f3x = this.tmp[0];
        this.worldCenter.f4y = this.tmp[1];
        return this.worldCenter;
    }

    public Vector2 getLocalCenter() {
        jniGetLocalCenter(this.addr, this.tmp);
        this.localCenter.f3x = this.tmp[0];
        this.localCenter.f4y = this.tmp[1];
        return this.localCenter;
    }

    public void setLinearVelocity(Vector2 v) {
        jniSetLinearVelocity(this.addr, v.f3x, v.f4y);
    }

    public void setLinearVelocity(float vX, float vY) {
        jniSetLinearVelocity(this.addr, vX, vY);
    }

    public Vector2 getLinearVelocity() {
        jniGetLinearVelocity(this.addr, this.tmp);
        this.linearVelocity.f3x = this.tmp[0];
        this.linearVelocity.f4y = this.tmp[1];
        return this.linearVelocity;
    }

    public void setAngularVelocity(float omega) {
        jniSetAngularVelocity(this.addr, omega);
    }

    public float getAngularVelocity() {
        return jniGetAngularVelocity(this.addr);
    }

    public void applyForce(Vector2 force, Vector2 point) {
        jniApplyForce(this.addr, force.f3x, force.f4y, point.f3x, point.f4y);
    }

    public void applyForce(float forceX, float forceY, float pointX, float pointY) {
        jniApplyForce(this.addr, forceX, forceY, pointX, pointY);
    }

    public void applyTorque(float torque) {
        jniApplyTorque(this.addr, torque);
    }

    public void applyLinearImpulse(Vector2 impulse, Vector2 point) {
        jniApplyLinearImpulse(this.addr, impulse.f3x, impulse.f4y, point.f3x, point.f4y);
    }

    public void applyLinearImpulse(float impulseX, float impulseY, float pointX, float pointY) {
        jniApplyLinearImpulse(this.addr, impulseX, impulseY, pointX, pointY);
    }

    public void applyAngularImpulse(float impulse) {
        jniApplyAngularImpulse(this.addr, impulse);
    }

    public float getMass() {
        return jniGetMass(this.addr);
    }

    public float getInertia() {
        return jniGetInertia(this.addr);
    }

    public MassData getMassData() {
        jniGetMassData(this.addr, this.tmp);
        this.massData.mass = this.tmp[0];
        this.massData.center.f3x = this.tmp[1];
        this.massData.center.f4y = this.tmp[2];
        this.massData.f5I = this.tmp[3];
        return this.massData;
    }

    public void setMassData(MassData data) {
        jniSetMassData(this.addr, data.mass, data.center.f3x, data.center.f4y, data.f5I);
    }

    public void resetMassData() {
        jniResetMassData(this.addr);
    }

    public Vector2 getWorldPoint(Vector2 localPoint) {
        jniGetWorldPoint(this.addr, localPoint.f3x, localPoint.f4y, this.tmp);
        this.localPoint.f3x = this.tmp[0];
        this.localPoint.f4y = this.tmp[1];
        return this.localPoint;
    }

    public Vector2 getWorldVector(Vector2 localVector) {
        jniGetWorldVector(this.addr, localVector.f3x, localVector.f4y, this.tmp);
        this.worldVector.f3x = this.tmp[0];
        this.worldVector.f4y = this.tmp[1];
        return this.worldVector;
    }

    public Vector2 getLocalPoint(Vector2 worldPoint) {
        jniGetLocalPoint(this.addr, worldPoint.f3x, worldPoint.f4y, this.tmp);
        this.localPoint2.f3x = this.tmp[0];
        this.localPoint2.f4y = this.tmp[1];
        return this.localPoint2;
    }

    public Vector2 getLocalVector(Vector2 worldVector) {
        jniGetLocalVector(this.addr, worldVector.f3x, worldVector.f4y, this.tmp);
        this.localVector.f3x = this.tmp[0];
        this.localVector.f4y = this.tmp[1];
        return this.localVector;
    }

    public Vector2 getLinearVelocityFromWorldPoint(Vector2 worldPoint) {
        jniGetLinearVelocityFromWorldPoint(this.addr, worldPoint.f3x, worldPoint.f4y, this.tmp);
        this.linVelWorld.f3x = this.tmp[0];
        this.linVelWorld.f4y = this.tmp[1];
        return this.linVelWorld;
    }

    public Vector2 getLinearVelocityFromLocalPoint(Vector2 localPoint) {
        jniGetLinearVelocityFromLocalPoint(this.addr, localPoint.f3x, localPoint.f4y, this.tmp);
        this.linVelLoc.f3x = this.tmp[0];
        this.linVelLoc.f4y = this.tmp[1];
        return this.linVelLoc;
    }

    public float getLinearDamping() {
        return jniGetLinearDamping(this.addr);
    }

    public void setLinearDamping(float linearDamping) {
        jniSetLinearDamping(this.addr, linearDamping);
    }

    public float getAngularDamping() {
        return jniGetAngularDamping(this.addr);
    }

    public void setAngularDamping(float angularDamping) {
        jniSetAngularDamping(this.addr, angularDamping);
    }

    public void setType(BodyType type) {
        jniSetType(this.addr, type.getValue());
    }

    public BodyType getType() {
        int type = jniGetType(this.addr);
        if (type == 0) {
            return BodyType.StaticBody;
        }
        if (type == 1) {
            return BodyType.KinematicBody;
        }
        if (type == 2) {
            return BodyType.DynamicBody;
        }
        return BodyType.StaticBody;
    }

    public void setBullet(boolean flag) {
        jniSetBullet(this.addr, flag);
    }

    public boolean isBullet() {
        return jniIsBullet(this.addr);
    }

    public void setSleepingAllowed(boolean flag) {
        jniSetSleepingAllowed(this.addr, flag);
    }

    public boolean isSleepingAllowed() {
        return jniIsSleepingAllowed(this.addr);
    }

    public void setAwake(boolean flag) {
        jniSetAwake(this.addr, flag);
    }

    public boolean isAwake() {
        return jniIsAwake(this.addr);
    }

    public void setActive(boolean flag) {
        jniSetActive(this.addr, flag);
    }

    public boolean isActive() {
        return jniIsActive(this.addr);
    }

    public void setFixedRotation(boolean flag) {
        jniSetFixedRotation(this.addr, flag);
    }

    public boolean isFixedRotation() {
        return jniIsFixedRotation(this.addr);
    }

    public ArrayList<Fixture> getFixtureList() {
        return this.fixtures;
    }

    public ArrayList<JointEdge> getJointList() {
        return this.joints;
    }

    public World getWorld() {
        return this.world;
    }

    public Object getUserData() {
        return this.userData;
    }

    public void setUserData(Object userData) {
        this.userData = userData;
    }
}
