package org.anddev.andengine.sensor.accelerometer;

import java.util.Arrays;
import org.anddev.andengine.sensor.BaseSensorData;

public class AccelerometerData extends BaseSensorData {
    private static final IAxisSwap[] AXISSWAPS = new IAxisSwap[4];

    private interface IAxisSwap {
        void swapAxis(float[] fArr);
    }

    class C09251 implements IAxisSwap {
        C09251() {
        }

        public void swapAxis(float[] pValues) {
            float x = -pValues[0];
            float y = pValues[1];
            pValues[0] = x;
            pValues[1] = y;
        }
    }

    class C09262 implements IAxisSwap {
        C09262() {
        }

        public void swapAxis(float[] pValues) {
            float x = pValues[1];
            float y = pValues[0];
            pValues[0] = x;
            pValues[1] = y;
        }
    }

    class C09273 implements IAxisSwap {
        C09273() {
        }

        public void swapAxis(float[] pValues) {
            float y = -pValues[1];
            pValues[0] = pValues[0];
            pValues[1] = y;
        }
    }

    class C09284 implements IAxisSwap {
        C09284() {
        }

        public void swapAxis(float[] pValues) {
            float y = -pValues[0];
            pValues[0] = -pValues[1];
            pValues[1] = y;
        }
    }

    static {
        AXISSWAPS[0] = new C09251();
        AXISSWAPS[1] = new C09262();
        AXISSWAPS[2] = new C09273();
        AXISSWAPS[3] = new C09284();
    }

    public AccelerometerData(int pDisplayOrientation) {
        super(3, pDisplayOrientation);
    }

    public float getX() {
        return this.mValues[0];
    }

    public float getY() {
        return this.mValues[1];
    }

    public float getZ() {
        return this.mValues[2];
    }

    public void setX(float pX) {
        this.mValues[0] = pX;
    }

    public void setY(float pY) {
        this.mValues[1] = pY;
    }

    public void setZ(float pZ) {
        this.mValues[2] = pZ;
    }

    public void setValues(float[] pValues) {
        super.setValues(pValues);
        AXISSWAPS[this.mDisplayRotation].swapAxis(this.mValues);
    }

    public String toString() {
        return "Accelerometer: " + Arrays.toString(this.mValues);
    }
}
