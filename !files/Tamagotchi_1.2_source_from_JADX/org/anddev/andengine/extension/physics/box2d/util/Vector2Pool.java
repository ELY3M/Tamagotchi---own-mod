package org.anddev.andengine.extension.physics.box2d.util;

import com.badlogic.gdx.math.Vector2;
import org.anddev.andengine.util.pool.GenericPool;

public class Vector2Pool {
    private static final GenericPool<Vector2> POOL = new C09211();

    class C09211 extends GenericPool<Vector2> {
        C09211() {
        }

        protected Vector2 onAllocatePoolItem() {
            return new Vector2();
        }
    }

    public static Vector2 obtain() {
        return (Vector2) POOL.obtainPoolItem();
    }

    public static Vector2 obtain(Vector2 pCopyFrom) {
        return ((Vector2) POOL.obtainPoolItem()).set(pCopyFrom);
    }

    public static Vector2 obtain(float pX, float pY) {
        return ((Vector2) POOL.obtainPoolItem()).set(pX, pY);
    }

    public static void recycle(Vector2 pVector2) {
        POOL.recyclePoolItem(pVector2);
    }
}
