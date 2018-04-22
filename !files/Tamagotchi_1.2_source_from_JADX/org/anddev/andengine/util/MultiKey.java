package org.anddev.andengine.util;

import java.util.Arrays;

public class MultiKey<K> {
    private final int mCachedHashCode;
    private final K[] mKeys;

    public MultiKey(K... pKeys) {
        this.mKeys = pKeys;
        this.mCachedHashCode = hash(pKeys);
    }

    public K[] getKeys() {
        return this.mKeys;
    }

    public boolean equals(Object pOther) {
        if (pOther == this) {
            return true;
        }
        if (!(pOther instanceof MultiKey)) {
            return false;
        }
        return Arrays.equals(this.mKeys, ((MultiKey) pOther).mKeys);
    }

    public static int hash(Object... pKeys) {
        int hashCode = 0;
        for (Object key : pKeys) {
            if (key != null) {
                hashCode ^= key.hashCode();
            }
        }
        return hashCode;
    }

    public int hashCode() {
        return this.mCachedHashCode;
    }

    public String toString() {
        return "MultiKey" + Arrays.asList(this.mKeys).toString();
    }

    public K getKey(int pIndex) {
        return this.mKeys[pIndex];
    }

    public int size() {
        return this.mKeys.length;
    }
}
