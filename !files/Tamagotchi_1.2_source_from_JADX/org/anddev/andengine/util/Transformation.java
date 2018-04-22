package org.anddev.andengine.util;

import android.util.FloatMath;

public class Transformation {
    private float f10a = 1.0f;
    private float f11b = 0.0f;
    private float f12c = 0.0f;
    private float f13d = 1.0f;
    private float tx = 0.0f;
    private float ty = 0.0f;

    public String toString() {
        return "Transformation{[" + this.f10a + ", " + this.f12c + ", " + this.tx + "][" + this.f11b + ", " + this.f13d + ", " + this.ty + "][0.0, 0.0, 1.0]}";
    }

    public void reset() {
        setToIdentity();
    }

    public void setToIdentity() {
        this.f10a = 1.0f;
        this.f13d = 1.0f;
        this.f11b = 0.0f;
        this.f12c = 0.0f;
        this.tx = 0.0f;
        this.ty = 0.0f;
    }

    public void setTo(Transformation pTransformation) {
        this.f10a = pTransformation.f10a;
        this.f13d = pTransformation.f13d;
        this.f11b = pTransformation.f11b;
        this.f12c = pTransformation.f12c;
        this.tx = pTransformation.tx;
        this.ty = pTransformation.ty;
    }

    public void preTranslate(float pX, float pY) {
        this.tx += (this.f10a * pX) + (this.f12c * pY);
        this.ty += (this.f11b * pX) + (this.f13d * pY);
    }

    public void postTranslate(float pX, float pY) {
        this.tx += pX;
        this.ty += pY;
    }

    public Transformation setToTranslate(float pX, float pY) {
        this.f10a = 1.0f;
        this.f11b = 0.0f;
        this.f12c = 0.0f;
        this.f13d = 1.0f;
        this.tx = pX;
        this.ty = pY;
        return this;
    }

    public void preScale(float pScaleX, float pScaleY) {
        this.f10a *= pScaleX;
        this.f11b *= pScaleX;
        this.f12c *= pScaleY;
        this.f13d *= pScaleY;
    }

    public void postScale(float pScaleX, float pScaleY) {
        this.f10a *= pScaleX;
        this.f11b *= pScaleY;
        this.f12c *= pScaleX;
        this.f13d *= pScaleY;
        this.tx *= pScaleX;
        this.ty *= pScaleY;
    }

    public Transformation setToScale(float pScaleX, float pScaleY) {
        this.f10a = pScaleX;
        this.f11b = 0.0f;
        this.f12c = 0.0f;
        this.f13d = pScaleY;
        this.tx = 0.0f;
        this.ty = 0.0f;
        return this;
    }

    public void preRotate(float pAngle) {
        float angleRad = MathUtils.degToRad(pAngle);
        float sin = FloatMath.sin(angleRad);
        float cos = FloatMath.cos(angleRad);
        float a = this.f10a;
        float b = this.f11b;
        float c = this.f12c;
        float d = this.f13d;
        this.f10a = (cos * a) + (sin * c);
        this.f11b = (cos * b) + (sin * d);
        this.f12c = (cos * c) - (sin * a);
        this.f13d = (cos * d) - (sin * b);
    }

    public void postRotate(float pAngle) {
        float angleRad = MathUtils.degToRad(pAngle);
        float sin = FloatMath.sin(angleRad);
        float cos = FloatMath.cos(angleRad);
        float a = this.f10a;
        float b = this.f11b;
        float c = this.f12c;
        float d = this.f13d;
        float tx = this.tx;
        float ty = this.ty;
        this.f10a = (a * cos) - (b * sin);
        this.f11b = (a * sin) + (b * cos);
        this.f12c = (c * cos) - (d * sin);
        this.f13d = (c * sin) + (d * cos);
        this.tx = (tx * cos) - (ty * sin);
        this.ty = (tx * sin) + (ty * cos);
    }

    public Transformation setToRotate(float pAngle) {
        float angleRad = MathUtils.degToRad(pAngle);
        float sin = FloatMath.sin(angleRad);
        float cos = FloatMath.cos(angleRad);
        this.f10a = cos;
        this.f11b = sin;
        this.f12c = -sin;
        this.f13d = cos;
        this.tx = 0.0f;
        this.ty = 0.0f;
        return this;
    }

    public void postConcat(Transformation pTransformation) {
        postConcat(pTransformation.f10a, pTransformation.f11b, pTransformation.f12c, pTransformation.f13d, pTransformation.tx, pTransformation.ty);
    }

    private void postConcat(float pA, float pB, float pC, float pD, float pTX, float pTY) {
        float a = this.f10a;
        float b = this.f11b;
        float c = this.f12c;
        float d = this.f13d;
        float tx = this.tx;
        float ty = this.ty;
        this.f10a = (a * pA) + (b * pC);
        this.f11b = (a * pB) + (b * pD);
        this.f12c = (c * pA) + (d * pC);
        this.f13d = (c * pB) + (d * pD);
        this.tx = ((tx * pA) + (ty * pC)) + pTX;
        this.ty = ((tx * pB) + (ty * pD)) + pTY;
    }

    public void preConcat(Transformation pTransformation) {
        preConcat(pTransformation.f10a, pTransformation.f11b, pTransformation.f12c, pTransformation.f13d, pTransformation.tx, pTransformation.ty);
    }

    private void preConcat(float pA, float pB, float pC, float pD, float pTX, float pTY) {
        float a = this.f10a;
        float b = this.f11b;
        float c = this.f12c;
        float d = this.f13d;
        float tx = this.tx;
        float ty = this.ty;
        this.f10a = (pA * a) + (pB * c);
        this.f11b = (pA * b) + (pB * d);
        this.f12c = (pC * a) + (pD * c);
        this.f13d = (pC * b) + (pD * d);
        this.tx = ((pTX * a) + (pTY * c)) + tx;
        this.ty = ((pTX * b) + (pTY * d)) + ty;
    }

    public void transform(float[] pVertices) {
        int count = pVertices.length >> 1;
        int j = 0;
        int i = 0;
        while (true) {
            count--;
            if (count >= 0) {
                int i2 = i + 1;
                float x = pVertices[i];
                i = i2 + 1;
                float y = pVertices[i2];
                int i3 = j + 1;
                pVertices[j] = ((this.f10a * x) + (this.f12c * y)) + this.tx;
                j = i3 + 1;
                pVertices[i3] = ((this.f11b * x) + (this.f13d * y)) + this.ty;
            } else {
                return;
            }
        }
    }
}
