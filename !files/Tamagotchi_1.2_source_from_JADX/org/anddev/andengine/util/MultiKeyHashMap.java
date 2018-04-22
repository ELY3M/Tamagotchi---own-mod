package org.anddev.andengine.util;

import java.util.HashMap;
import java.util.Map.Entry;

public class MultiKeyHashMap<K, V> extends HashMap<MultiKey<K>, V> {
    private static final long serialVersionUID = -6262447639526561122L;

    public V get(K... pKeys) {
        int hashCode = MultiKey.hash(pKeys);
        for (Entry<MultiKey<K>, V> entry : entrySet()) {
            MultiKey<K> entryKey = (MultiKey) entry.getKey();
            if (entryKey.hashCode() == hashCode && isEqualKey(entryKey.getKeys(), pKeys)) {
                return entry.getValue();
            }
        }
        return null;
    }

    private boolean isEqualKey(K[] pKeysA, K[] pKeysB) {
        if (pKeysA.length != pKeysB.length) {
            return false;
        }
        for (int i = 0; i < pKeysA.length; i++) {
            K keyA = pKeysA[i];
            K keyB = pKeysB[i];
            if (keyA == null) {
                if (keyB != null) {
                    return false;
                }
            } else if (!keyA.equals(keyB)) {
                return false;
            }
        }
        return true;
    }
}
