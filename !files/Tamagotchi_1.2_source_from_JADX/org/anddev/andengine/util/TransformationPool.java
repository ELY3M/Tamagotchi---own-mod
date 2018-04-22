package org.anddev.andengine.util;

import org.anddev.andengine.util.pool.GenericPool;

public class TransformationPool {
    private static final GenericPool<Transformation> POOL = new C09321();

    class C09321 extends GenericPool<Transformation> {
        C09321() {
        }

        protected Transformation onAllocatePoolItem() {
            return new Transformation();
        }
    }

    public static Transformation obtain() {
        return (Transformation) POOL.obtainPoolItem();
    }

    public static void recycle(Transformation pTransformation) {
        pTransformation.setToIdentity();
        POOL.recyclePoolItem(pTransformation);
    }
}
