package com.badlogic.gdx.math;

public final class Vector2 {
    private static final Vector2 tmp = new Vector2();
    public float f3x;
    public float f4y;

    public Vector2(float x, float y) {
        this.f3x = x;
        this.f4y = y;
    }

    public Vector2(Vector2 v) {
        set(v);
    }

    public Vector2 cpy() {
        return new Vector2(this);
    }

    public float len() {
        return (float) Math.sqrt((double) ((this.f3x * this.f3x) + (this.f4y * this.f4y)));
    }

    public float len2() {
        return (this.f3x * this.f3x) + (this.f4y * this.f4y);
    }

    public Vector2 set(Vector2 v) {
        this.f3x = v.f3x;
        this.f4y = v.f4y;
        return this;
    }

    public Vector2 set(float x, float y) {
        this.f3x = x;
        this.f4y = y;
        return this;
    }

    public Vector2 sub(Vector2 v) {
        this.f3x -= v.f3x;
        this.f4y -= v.f4y;
        return this;
    }

    public Vector2 nor() {
        float len = len();
        if (len != 0.0f) {
            this.f3x /= len;
            this.f4y /= len;
        }
        return this;
    }

    public Vector2 add(Vector2 v) {
        this.f3x += v.f3x;
        this.f4y += v.f4y;
        return this;
    }

    public Vector2 add(float x, float y) {
        this.f3x += x;
        this.f4y += y;
        return this;
    }

    public float dot(Vector2 v) {
        return (this.f3x * v.f3x) + (this.f4y * v.f4y);
    }

    public Vector2 mul(float scalar) {
        this.f3x *= scalar;
        this.f4y *= scalar;
        return this;
    }

    public float dst(Vector2 v) {
        float x_d = v.f3x - this.f3x;
        float y_d = v.f4y - this.f4y;
        return (float) Math.sqrt((double) ((x_d * x_d) + (y_d * y_d)));
    }

    public float dst(float x, float y) {
        float x_d = x - this.f3x;
        float y_d = y - this.f4y;
        return (float) Math.sqrt((double) ((x_d * x_d) + (y_d * y_d)));
    }

    public float dst2(Vector2 v) {
        float x_d = v.f3x - this.f3x;
        float y_d = v.f4y - this.f4y;
        return (x_d * x_d) + (y_d * y_d);
    }

    public String toString() {
        return "[" + this.f3x + ":" + this.f4y + "]";
    }

    public Vector2 sub(float x, float y) {
        this.f3x -= x;
        this.f4y -= y;
        return this;
    }

    public Vector2 tmp() {
        return tmp.set(this);
    }

    public float cross(Vector2 v) {
        return (this.f3x * v.f4y) - (v.f3x * this.f4y);
    }

    public float lenManhattan() {
        return Math.abs(this.f3x) + Math.abs(this.f4y);
    }
}
