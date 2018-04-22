package org.anddev.andengine.util.modifier.ease;

public interface IEaseFunction {
    public static final IEaseFunction DEFAULT = EaseLinear.getInstance();

    float getPercentage(float f, float f2);
}
