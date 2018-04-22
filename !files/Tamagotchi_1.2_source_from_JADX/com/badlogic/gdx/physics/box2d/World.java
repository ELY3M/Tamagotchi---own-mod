package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.JointDef.JointType;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.FrictionJoint;
import com.badlogic.gdx.physics.box2d.joints.FrictionJointDef;
import com.badlogic.gdx.physics.box2d.joints.GearJoint;
import com.badlogic.gdx.physics.box2d.joints.GearJointDef;
import com.badlogic.gdx.physics.box2d.joints.LineJoint;
import com.badlogic.gdx.physics.box2d.joints.LineJointDef;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.physics.box2d.joints.MouseJointDef;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJoint;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;
import com.badlogic.gdx.physics.box2d.joints.PulleyJoint;
import com.badlogic.gdx.physics.box2d.joints.PulleyJointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.physics.box2d.joints.WeldJoint;
import com.badlogic.gdx.physics.box2d.joints.WeldJointDef;
import com.badlogic.gdx.utils.LongMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {
    private final long addr;
    protected final LongMap<Body> bodies = new LongMap(100);
    private final Contact contact = new Contact(this, 0);
    private long[] contactAddrs = new long[200];
    protected ContactFilter contactFilter = null;
    protected ContactListener contactListener = null;
    private final ArrayList<Contact> contacts = new ArrayList();
    protected final LongMap<Fixture> fixtures = new LongMap(100);
    private final ArrayList<Contact> freeContacts = new ArrayList();
    final Vector2 gravity = new Vector2();
    private final ContactImpulse impulse = new ContactImpulse(this, 0);
    protected final LongMap<Joint> joints = new LongMap(100);
    private final Manifold manifold = new Manifold(this, 0);
    private QueryCallback queryCallback = null;
    private RayCastCallback rayCastCallback = null;
    private Vector2 rayNormal = new Vector2();
    private Vector2 rayPoint = new Vector2();
    final float[] tmpGravity = new float[2];

    private native void jniClearForces(long j);

    private native long jniCreateBody(long j, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f9);

    private native long jniCreateDistanceJoint(long j, long j2, long j3, boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7);

    private native long jniCreateFrictionJoint(long j, long j2, long j3, boolean z, float f, float f2, float f3, float f4, float f5, float f6);

    private native long jniCreateGearJoint(long j, long j2, long j3, boolean z, long j4, long j5, float f);

    private native long jniCreateLineJoint(long j, long j2, long j3, boolean z, float f, float f2, float f3, float f4, float f5, float f6, boolean z2, float f7, float f8, boolean z3, float f9, float f10);

    private native long jniCreateMouseJoint(long j, long j2, long j3, boolean z, float f, float f2, float f3, float f4, float f5);

    private native long jniCreatePrismaticJoint(long j, long j2, long j3, boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z2, float f8, float f9, boolean z3, float f10, float f11);

    private native long jniCreatePulleyJoint(long j, long j2, long j3, boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13);

    private native long jniCreateRevoluteJoint(long j, long j2, long j3, boolean z, float f, float f2, float f3, float f4, float f5, boolean z2, float f6, float f7, boolean z3, float f8, float f9);

    private native long jniCreateWeldJoint(long j, long j2, long j3, boolean z, float f, float f2, float f3, float f4, float f5);

    private native void jniDestroyBody(long j, long j2);

    private native void jniDestroyJoint(long j, long j2);

    private native void jniDispose(long j);

    private native boolean jniGetAutoClearForces(long j);

    private native int jniGetBodyCount(long j);

    private native int jniGetContactCount(long j);

    private native void jniGetContactList(long j, long[] jArr);

    private native void jniGetGravity(long j, float[] fArr);

    private native int jniGetJointcount(long j);

    private native int jniGetProxyCount(long j);

    private native boolean jniIsLocked(long j);

    private native void jniQueryAABB(long j, float f, float f2, float f3, float f4);

    private native void jniRayCast(long j, float f, float f2, float f3, float f4);

    private native void jniSetAutoClearForces(long j, boolean z);

    private native void jniSetContiousPhysics(long j, boolean z);

    private native void jniSetGravity(long j, float f, float f2);

    private native void jniSetWarmStarting(long j, boolean z);

    private native void jniStep(long j, float f, int i, int i2);

    private native long newWorld(float f, float f2, boolean z);

    public void rayCast(RayCastCallback callback, Vector2 point1, Vector2 point2) {
        this.rayCastCallback = callback;
        jniRayCast(this.addr, point1.f3x, point1.f4y, point2.f3x, point2.f4y);
    }

    private float reportRayFixture(long addr, float pX, float pY, float nX, float nY, float fraction) {
        if (this.rayCastCallback != null) {
            return this.rayCastCallback.reportRayFixture((Fixture) this.fixtures.get(addr), this.rayPoint.set(pX, pY), this.rayNormal.set(nX, nY), fraction);
        }
        return 0.0f;
    }

    public World(Vector2 gravity, boolean doSleep) {
        this.addr = newWorld(gravity.f3x, gravity.f4y, doSleep);
        for (int i = 0; i < 200; i++) {
            this.freeContacts.add(new Contact(this, 0));
        }
    }

    public void setDestructionListener(DestructionListener listener) {
    }

    public void setContactFilter(ContactFilter filter) {
        this.contactFilter = filter;
    }

    public void setContactListener(ContactListener listener) {
        this.contactListener = listener;
    }

    public Body createBody(BodyDef def) {
        Body body = new Body(this, jniCreateBody(this.addr, def.type.getValue(), def.position.f3x, def.position.f4y, def.angle, def.linearVelocity.f3x, def.linearVelocity.f4y, def.angularVelocity, def.linearDamping, def.angularDamping, def.allowSleep, def.awake, def.fixedRotation, def.bullet, def.active, def.inertiaScale));
        this.bodies.put(body.addr, body);
        return body;
    }

    public void destroyBody(Body body) {
        int i;
        this.bodies.remove(body.addr);
        for (i = 0; i < body.getFixtureList().size(); i++) {
            this.fixtures.remove(((Fixture) body.getFixtureList().get(i)).addr);
        }
        for (i = 0; i < body.getJointList().size(); i++) {
            this.joints.remove(((JointEdge) body.getJointList().get(i)).joint.addr);
        }
        jniDestroyBody(this.addr, body.addr);
    }

    public Joint createJoint(JointDef def) {
        long jointAddr = createProperJoint(def);
        Joint joint = null;
        if (def.type == JointType.DistanceJoint) {
            joint = new DistanceJoint(this, jointAddr);
        }
        if (def.type == JointType.FrictionJoint) {
            joint = new FrictionJoint(this, jointAddr);
        }
        if (def.type == JointType.GearJoint) {
            joint = new GearJoint(this, jointAddr);
        }
        if (def.type == JointType.LineJoint) {
            joint = new LineJoint(this, jointAddr);
        }
        if (def.type == JointType.MouseJoint) {
            joint = new MouseJoint(this, jointAddr);
        }
        if (def.type == JointType.PrismaticJoint) {
            joint = new PrismaticJoint(this, jointAddr);
        }
        if (def.type == JointType.PulleyJoint) {
            joint = new PulleyJoint(this, jointAddr);
        }
        if (def.type == JointType.RevoluteJoint) {
            joint = new RevoluteJoint(this, jointAddr);
        }
        if (def.type == JointType.WeldJoint) {
            joint = new WeldJoint(this, jointAddr);
        }
        if (joint != null) {
            this.joints.put(joint.addr, joint);
        }
        JointEdge jointEdgeA = new JointEdge(def.bodyB, joint);
        JointEdge jointEdgeB = new JointEdge(def.bodyA, joint);
        joint.jointEdgeA = jointEdgeA;
        joint.jointEdgeB = jointEdgeB;
        def.bodyA.joints.add(jointEdgeA);
        def.bodyB.joints.add(jointEdgeB);
        return joint;
    }

    private long createProperJoint(JointDef def) {
        if (def.type == JointType.DistanceJoint) {
            DistanceJointDef d = (DistanceJointDef) def;
            return jniCreateDistanceJoint(this.addr, d.bodyA.addr, d.bodyB.addr, d.collideConnected, d.localAnchorA.f3x, d.localAnchorA.f4y, d.localAnchorB.f3x, d.localAnchorB.f4y, d.length, d.frequencyHz, d.dampingRatio);
        } else if (def.type == JointType.FrictionJoint) {
            FrictionJointDef d2 = (FrictionJointDef) def;
            return jniCreateFrictionJoint(this.addr, d2.bodyA.addr, d2.bodyB.addr, d2.collideConnected, d2.localAnchorA.f3x, d2.localAnchorA.f4y, d2.localAnchorB.f3x, d2.localAnchorB.f4y, d2.maxForce, d2.maxTorque);
        } else if (def.type == JointType.GearJoint) {
            GearJointDef d3 = (GearJointDef) def;
            return jniCreateGearJoint(this.addr, d3.bodyA.addr, d3.bodyB.addr, d3.collideConnected, d3.joint1.addr, d3.joint2.addr, d3.ratio);
        } else if (def.type == JointType.LineJoint) {
            LineJointDef d4 = (LineJointDef) def;
            return jniCreateLineJoint(this.addr, d4.bodyA.addr, d4.bodyB.addr, d4.collideConnected, d4.localAnchorA.f3x, d4.localAnchorA.f4y, d4.localAnchorB.f3x, d4.localAnchorB.f4y, d4.localAxisA.f3x, d4.localAxisA.f4y, d4.enableLimit, d4.lowerTranslation, d4.upperTranslation, d4.enableMotor, d4.maxMotorForce, d4.motorSpeed);
        } else if (def.type == JointType.MouseJoint) {
            MouseJointDef d5 = (MouseJointDef) def;
            return jniCreateMouseJoint(this.addr, d5.bodyA.addr, d5.bodyB.addr, d5.collideConnected, d5.target.f3x, d5.target.f4y, d5.maxForce, d5.frequencyHz, d5.dampingRatio);
        } else if (def.type == JointType.PrismaticJoint) {
            PrismaticJointDef d6 = (PrismaticJointDef) def;
            return jniCreatePrismaticJoint(this.addr, d6.bodyA.addr, d6.bodyB.addr, d6.collideConnected, d6.localAnchorA.f3x, d6.localAnchorA.f4y, d6.localAnchorB.f3x, d6.localAnchorB.f4y, d6.localAxis1.f3x, d6.localAxis1.f4y, d6.referenceAngle, d6.enableLimit, d6.lowerTranslation, d6.upperTranslation, d6.enableMotor, d6.maxMotorForce, d6.motorSpeed);
        } else if (def.type == JointType.PulleyJoint) {
            PulleyJointDef d7 = (PulleyJointDef) def;
            return jniCreatePulleyJoint(this.addr, d7.bodyA.addr, d7.bodyB.addr, d7.collideConnected, d7.groundAnchorA.f3x, d7.groundAnchorA.f4y, d7.groundAnchorB.f3x, d7.groundAnchorB.f4y, d7.localAnchorA.f3x, d7.localAnchorA.f4y, d7.localAnchorB.f3x, d7.localAnchorB.f4y, d7.lengthA, d7.maxLengthA, d7.lengthB, d7.maxLengthB, d7.ratio);
        } else if (def.type == JointType.RevoluteJoint) {
            RevoluteJointDef d8 = (RevoluteJointDef) def;
            return jniCreateRevoluteJoint(this.addr, d8.bodyA.addr, d8.bodyB.addr, d8.collideConnected, d8.localAnchorA.f3x, d8.localAnchorA.f4y, d8.localAnchorB.f3x, d8.localAnchorB.f4y, d8.referenceAngle, d8.enableLimit, d8.lowerAngle, d8.upperAngle, d8.enableMotor, d8.motorSpeed, d8.maxMotorTorque);
        } else if (def.type != JointType.WeldJoint) {
            return 0;
        } else {
            WeldJointDef d9 = (WeldJointDef) def;
            return jniCreateWeldJoint(this.addr, d9.bodyA.addr, d9.bodyB.addr, d9.collideConnected, d9.localAnchorA.f3x, d9.localAnchorA.f4y, d9.localAnchorB.f3x, d9.localAnchorB.f4y, d9.referenceAngle);
        }
    }

    public void destroyJoint(Joint joint) {
        this.joints.remove(joint.addr);
        joint.jointEdgeA.other.joints.remove(joint.jointEdgeB);
        joint.jointEdgeB.other.joints.remove(joint.jointEdgeA);
        jniDestroyJoint(this.addr, joint.addr);
    }

    public void step(float timeStep, int velocityIterations, int positionIterations) {
        jniStep(this.addr, timeStep, velocityIterations, positionIterations);
    }

    public void clearForces() {
        jniClearForces(this.addr);
    }

    public void setWarmStarting(boolean flag) {
        jniSetWarmStarting(this.addr, flag);
    }

    public void setContinuousPhysics(boolean flag) {
        jniSetContiousPhysics(this.addr, flag);
    }

    public int getProxyCount() {
        return jniGetProxyCount(this.addr);
    }

    public int getBodyCount() {
        return jniGetBodyCount(this.addr);
    }

    public int getJointCount() {
        return jniGetJointcount(this.addr);
    }

    public int getContactCount() {
        return jniGetContactCount(this.addr);
    }

    public void setGravity(Vector2 gravity) {
        jniSetGravity(this.addr, gravity.f3x, gravity.f4y);
    }

    public Vector2 getGravity() {
        jniGetGravity(this.addr, this.tmpGravity);
        this.gravity.f3x = this.tmpGravity[0];
        this.gravity.f4y = this.tmpGravity[1];
        return this.gravity;
    }

    public boolean isLocked() {
        return jniIsLocked(this.addr);
    }

    public void setAutoClearForces(boolean flag) {
        jniSetAutoClearForces(this.addr, flag);
    }

    public boolean getAutoClearForces() {
        return jniGetAutoClearForces(this.addr);
    }

    public void QueryAABB(QueryCallback callback, float lowerX, float lowerY, float upperX, float upperY) {
        this.queryCallback = callback;
        jniQueryAABB(this.addr, lowerX, lowerY, upperX, upperY);
    }

    public List<Contact> getContactList() {
        int i;
        int numContacts = getContactCount();
        if (numContacts > this.contactAddrs.length) {
            this.contactAddrs = new long[numContacts];
        }
        if (numContacts > this.freeContacts.size()) {
            int freeConts = this.freeContacts.size();
            for (i = 0; i < numContacts - freeConts; i++) {
                this.freeContacts.add(new Contact(this, 0));
            }
        }
        jniGetContactList(this.addr, this.contactAddrs);
        this.contacts.clear();
        for (i = 0; i < numContacts; i++) {
            Contact contact = (Contact) this.freeContacts.get(i);
            contact.addr = this.contactAddrs[i];
            this.contacts.add(contact);
        }
        return this.contacts;
    }

    public Iterator<Body> getBodies() {
        return this.bodies.values();
    }

    public Iterator<Joint> getJoints() {
        return this.joints.values();
    }

    public void dispose() {
        jniDispose(this.addr);
    }

    private boolean contactFilter(long fixtureA, long fixtureB) {
        boolean z = true;
        if (this.contactFilter != null) {
            return this.contactFilter.shouldCollide((Fixture) this.fixtures.get(fixtureA), (Fixture) this.fixtures.get(fixtureB));
        }
        Filter filterA = ((Fixture) this.fixtures.get(fixtureA)).getFilterData();
        Filter filterB = ((Fixture) this.fixtures.get(fixtureB)).getFilterData();
        if (filterA.groupIndex != filterB.groupIndex || filterA.groupIndex == (short) 0) {
            if ((filterA.maskBits & filterB.categoryBits) == 0 || (filterA.categoryBits & filterB.maskBits) == 0) {
                z = false;
            }
            return z;
        } else if (filterA.groupIndex <= (short) 0) {
            return false;
        } else {
            return true;
        }
    }

    private void beginContact(long contactAddr) {
        this.contact.addr = contactAddr;
        if (this.contactListener != null) {
            this.contactListener.beginContact(this.contact);
        }
    }

    private void endContact(long contactAddr) {
        this.contact.addr = contactAddr;
        if (this.contactListener != null) {
            this.contactListener.endContact(this.contact);
        }
    }

    private void preSolve(long contactAddr, long manifoldAddr) {
        this.contact.addr = contactAddr;
        this.manifold.addr = manifoldAddr;
        if (this.contactListener != null) {
            this.contactListener.preSolve(this.contact, this.manifold);
        }
    }

    private void postSolve(long contactAddr, long impulseAddr) {
        this.contact.addr = contactAddr;
        this.impulse.addr = impulseAddr;
        if (this.contactListener != null) {
            this.contactListener.postSolve(this.contact, this.impulse);
        }
    }

    private boolean reportFixture(long addr) {
        if (this.queryCallback != null) {
            return this.queryCallback.reportFixture((Fixture) this.fixtures.get(addr));
        }
        return false;
    }
}
