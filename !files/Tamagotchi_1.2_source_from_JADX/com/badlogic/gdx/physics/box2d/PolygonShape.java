package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Shape.Type;

public class PolygonShape extends Shape {
    private static float[] verts = new float[2];

    private native void jniGetVertex(long j, int i, float[] fArr);

    private native int jniGetVertexCount(long j);

    private native void jniSet(long j, float[] fArr);

    private native void jniSetAsBox(long j, float f, float f2);

    private native void jniSetAsBox(long j, float f, float f2, float f3, float f4, float f5);

    private native void jniSetAsEdge(long j, float f, float f2, float f3, float f4);

    private native long newPolygonShape();

    public PolygonShape() {
        this.addr = newPolygonShape();
    }

    protected PolygonShape(long addr) {
        this.addr = addr;
    }

    public Type getType() {
        return Type.Polygon;
    }

    public void set(Vector2[] vertices) {
        float[] verts = new float[(vertices.length * 2)];
        int i = 0;
        int j = 0;
        while (i < vertices.length * 2) {
            verts[i] = vertices[j].f3x;
            verts[i + 1] = vertices[j].f4y;
            i += 2;
            j++;
        }
        jniSet(this.addr, verts);
    }

    public void setAsBox(float hx, float hy) {
        jniSetAsBox(this.addr, hx, hy);
    }

    public void setAsBox(float hx, float hy, Vector2 center, float angle) {
        jniSetAsBox(this.addr, hx, hy, center.f3x, center.f4y, angle);
    }

    public void setAsEdge(Vector2 v1, Vector2 v2) {
        jniSetAsEdge(this.addr, v1.f3x, v1.f4y, v2.f3x, v2.f4y);
    }

    public int getVertexCount() {
        return jniGetVertexCount(this.addr);
    }

    public void getVertex(int index, Vector2 vertex) {
        jniGetVertex(this.addr, index, verts);
        vertex.f3x = verts[0];
        vertex.f4y = verts[1];
    }
}
