package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape.Type;

public class Fixture {
    protected final long addr;
    private final Body body;
    private final Filter filter = new Filter();
    protected Shape shape;
    private final short[] tmp = new short[3];
    protected Object userData;

    private native float jniGetDensity(long j);

    private native void jniGetFilterData(long j, short[] sArr);

    private native float jniGetFriction(long j);

    private native float jniGetRestitution(long j);

    private native long jniGetShape(long j);

    private native int jniGetType(long j);

    private native boolean jniIsSensor(long j);

    private native void jniSetDensity(long j, float f);

    private native void jniSetFilterData(long j, short s, short s2, short s3);

    private native void jniSetFriction(long j, float f);

    private native void jniSetRestitution(long j, float f);

    private native void jniSetSensor(long j, boolean z);

    private native boolean jniTestPoint(long j, float f, float f2);

    protected Fixture(Body body, long addr) {
        this.body = body;
        this.addr = addr;
    }

    public Type getType() {
        if (jniGetType(this.addr) == 0) {
            return Type.Circle;
        }
        return Type.Polygon;
    }

    public Shape getShape() {
        if (this.shape == null) {
            long shapeAddr = jniGetShape(this.addr);
            if (Shape.jniGetType(shapeAddr) == 0) {
                this.shape = new CircleShape(shapeAddr);
            } else {
                this.shape = new PolygonShape(shapeAddr);
            }
        }
        return this.shape;
    }

    public void setSensor(boolean sensor) {
        jniSetSensor(this.addr, sensor);
    }

    public boolean isSensor() {
        return jniIsSensor(this.addr);
    }

    public void setFilterData(Filter filter) {
        jniSetFilterData(this.addr, filter.categoryBits, filter.maskBits, filter.groupIndex);
    }

    public Filter getFilterData() {
        jniGetFilterData(this.addr, this.tmp);
        this.filter.maskBits = this.tmp[0];
        this.filter.categoryBits = this.tmp[1];
        this.filter.groupIndex = this.tmp[2];
        return this.filter;
    }

    public Body getBody() {
        return this.body;
    }

    public boolean testPoint(Vector2 p) {
        return jniTestPoint(this.addr, p.f3x, p.f4y);
    }

    public boolean testPoint(float x, float y) {
        return jniTestPoint(this.addr, x, y);
    }

    public void setDensity(float density) {
        jniSetDensity(this.addr, density);
    }

    public float getDensity() {
        return jniGetDensity(this.addr);
    }

    public float getFriction() {
        return jniGetFriction(this.addr);
    }

    public void setFriction(float friction) {
        jniSetFriction(this.addr, friction);
    }

    public float getRestitution() {
        return jniGetRestitution(this.addr);
    }

    public void setRestitution(float restitution) {
        jniSetRestitution(this.addr, restitution);
    }

    public void setUserData(Object userData) {
        this.userData = userData;
    }

    public Object getUserData() {
        return this.userData;
    }
}
