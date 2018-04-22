package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.anddev.andengine.util.MathUtils;

public class LongMap<V> {
    private static final int EMPTY = 0;
    private static final int PRIME1 = -1105259343;
    private static final int PRIME2 = -1262997959;
    private static final int PRIME3 = -825114047;
    int capacity;
    private Entries entries;
    boolean hasZeroValue;
    private int hashShift;
    long[] keyTable;
    private Keys keys;
    private float loadFactor;
    private int mask;
    private int pushIterations;
    public int size;
    private int stashCapacity;
    int stashSize;
    private int threshold;
    V[] valueTable;
    private Values values;
    V zeroValue;

    public static class Entry<V> {
        public long key;
        public V value;

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    private static class MapIterator<V> {
        static final int INDEX_ILLEGAL = -2;
        static final int INDEX_ZERO = -1;
        int currentIndex;
        public boolean hasNext;
        final LongMap<V> map;
        int nextIndex;

        public MapIterator(LongMap<V> map) {
            this.map = map;
            reset();
        }

        public void reset() {
            this.currentIndex = -2;
            this.nextIndex = -1;
            if (this.map.hasZeroValue) {
                this.hasNext = true;
            } else {
                findNextIndex();
            }
        }

        void findNextIndex() {
            this.hasNext = false;
            long[] keyTable = this.map.keyTable;
            int n = this.map.capacity + this.map.stashSize;
            do {
                int i = this.nextIndex + 1;
                this.nextIndex = i;
                if (i >= n) {
                    return;
                }
            } while (keyTable[this.nextIndex] == 0);
            this.hasNext = true;
        }

        public void remove() {
            if (this.currentIndex == -1 && this.map.hasZeroValue) {
                this.map.zeroValue = null;
                this.map.hasZeroValue = false;
            } else if (this.currentIndex < 0) {
                throw new IllegalStateException("next must be called before remove.");
            } else if (this.currentIndex >= this.map.capacity) {
                this.map.removeStashIndex(this.currentIndex);
            } else {
                this.map.keyTable[this.currentIndex] = 0;
                this.map.valueTable[this.currentIndex] = null;
            }
            this.currentIndex = -2;
            LongMap longMap = this.map;
            longMap.size--;
        }
    }

    public static class Entries<V> extends MapIterator<V> implements Iterable<Entry<V>>, Iterator<Entry<V>> {
        private Entry<V> entry = new Entry();

        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public Entries(LongMap map) {
            super(map);
        }

        public Entry<V> next() {
            if (this.hasNext) {
                long[] keyTable = this.map.keyTable;
                if (this.nextIndex == -1) {
                    this.entry.key = 0;
                    this.entry.value = this.map.zeroValue;
                } else {
                    this.entry.key = keyTable[this.nextIndex];
                    this.entry.value = this.map.valueTable[this.nextIndex];
                }
                this.currentIndex = this.nextIndex;
                findNextIndex();
                return this.entry;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public Iterator<Entry<V>> iterator() {
            return this;
        }
    }

    public static class Keys extends MapIterator {
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public Keys(LongMap map) {
            super(map);
        }

        public long next() {
            long key = this.nextIndex == -1 ? 0 : this.map.keyTable[this.nextIndex];
            this.currentIndex = this.nextIndex;
            findNextIndex();
            return key;
        }
    }

    public static class Values<V> extends MapIterator<V> implements Iterable<V>, Iterator<V> {
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public Values(LongMap<V> map) {
            super(map);
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public V next() {
            V value;
            if (this.nextIndex == -1) {
                value = this.map.zeroValue;
            } else {
                value = this.map.valueTable[this.nextIndex];
            }
            this.currentIndex = this.nextIndex;
            findNextIndex();
            return value;
        }

        public Iterator<V> iterator() {
            return this;
        }
    }

    public LongMap() {
        this(32, 0.8f);
    }

    public LongMap(int initialCapacity) {
        this(initialCapacity, 0.8f);
    }

    public LongMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity must be >= 0: " + initialCapacity);
        } else if (this.capacity > 1073741824) {
            throw new IllegalArgumentException("initialCapacity is too large: " + initialCapacity);
        } else {
            this.capacity = MathUtils.nextPowerOfTwo(initialCapacity);
            if (loadFactor <= 0.0f) {
                throw new IllegalArgumentException("loadFactor must be > 0: " + loadFactor);
            }
            this.loadFactor = loadFactor;
            this.threshold = (int) (((float) this.capacity) * loadFactor);
            this.mask = this.capacity - 1;
            this.hashShift = 31 - Integer.numberOfTrailingZeros(this.capacity);
            this.stashCapacity = Math.max(3, ((int) Math.ceil(Math.log((double) this.capacity))) + 1);
            this.pushIterations = Math.max(Math.min(this.capacity, 32), ((int) Math.sqrt((double) this.capacity)) / 4);
            this.keyTable = new long[(this.capacity + this.stashCapacity)];
            this.valueTable = new Object[this.keyTable.length];
        }
    }

    public V put(long key, V value) {
        if (key == 0) {
            V oldValue = this.zeroValue;
            this.zeroValue = value;
            this.hasZeroValue = true;
            this.size++;
            return oldValue;
        }
        int index1 = (int) (((long) this.mask) & key);
        long key1 = this.keyTable[index1];
        if (key1 == key) {
            oldValue = this.valueTable[index1];
            this.valueTable[index1] = value;
            return oldValue;
        }
        int index2 = hash2(key);
        long key2 = this.keyTable[index2];
        if (key2 == key) {
            oldValue = this.valueTable[index2];
            this.valueTable[index2] = value;
            return oldValue;
        }
        int index3 = hash3(key);
        long key3 = this.keyTable[index3];
        if (key3 == key) {
            oldValue = this.valueTable[index3];
            this.valueTable[index3] = value;
            return oldValue;
        } else if (key1 == 0) {
            this.keyTable[index1] = key;
            this.valueTable[index1] = value;
            r3 = this.size;
            this.size = r3 + 1;
            if (r3 >= this.threshold) {
                resize(this.capacity << 1);
            }
            return null;
        } else if (key2 == 0) {
            this.keyTable[index2] = key;
            this.valueTable[index2] = value;
            r3 = this.size;
            this.size = r3 + 1;
            if (r3 >= this.threshold) {
                resize(this.capacity << 1);
            }
            return null;
        } else if (key3 == 0) {
            this.keyTable[index3] = key;
            this.valueTable[index3] = value;
            r3 = this.size;
            this.size = r3 + 1;
            if (r3 >= this.threshold) {
                resize(this.capacity << 1);
            }
            return null;
        } else {
            push(key, value, index1, key1, index2, key2, index3, key3);
            return null;
        }
    }

    public void putAll(LongMap<V> map) {
        Iterator it = map.entries().iterator();
        while (it.hasNext()) {
            Entry<V> entry = (Entry) it.next();
            put(entry.key, entry.value);
        }
    }

    private void putResize(long key, V value) {
        if (key == 0) {
            this.zeroValue = value;
            this.hasZeroValue = true;
            return;
        }
        int index1 = (int) (((long) this.mask) & key);
        long key1 = this.keyTable[index1];
        int i;
        if (key1 == 0) {
            this.keyTable[index1] = key;
            this.valueTable[index1] = value;
            i = this.size;
            this.size = i + 1;
            if (i >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        int index2 = hash2(key);
        long key2 = this.keyTable[index2];
        if (key2 == 0) {
            this.keyTable[index2] = key;
            this.valueTable[index2] = value;
            i = this.size;
            this.size = i + 1;
            if (i >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        int index3 = hash3(key);
        long key3 = this.keyTable[index3];
        if (key3 == 0) {
            this.keyTable[index3] = key;
            this.valueTable[index3] = value;
            i = this.size;
            this.size = i + 1;
            if (i >= this.threshold) {
                resize(this.capacity << 1);
                return;
            }
            return;
        }
        push(key, value, index1, key1, index2, key2, index3, key3);
    }

    private void push(long insertKey, V insertValue, int index1, long key1, int index2, long key2, int index3, long key3) {
        long[] keyTable = this.keyTable;
        Object[] valueTable = this.valueTable;
        int mask = this.mask;
        int i = 0;
        int pushIterations = this.pushIterations;
        while (true) {
            long evictedKey;
            V evictedValue;
            switch (MathUtils.random(0, 2)) {
                case 0:
                    evictedKey = key1;
                    evictedValue = valueTable[index1];
                    keyTable[index1] = insertKey;
                    valueTable[index1] = insertValue;
                    break;
                case 1:
                    evictedKey = key2;
                    evictedValue = valueTable[index2];
                    keyTable[index2] = insertKey;
                    valueTable[index2] = insertValue;
                    break;
                default:
                    evictedKey = key3;
                    evictedValue = valueTable[index3];
                    keyTable[index3] = insertKey;
                    valueTable[index3] = insertValue;
                    break;
            }
            index1 = (int) (((long) mask) & evictedKey);
            key1 = keyTable[index1];
            int i2;
            if (key1 == 0) {
                keyTable[index1] = evictedKey;
                valueTable[index1] = evictedValue;
                i2 = this.size;
                this.size = i2 + 1;
                if (i2 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            index2 = hash2(evictedKey);
            key2 = keyTable[index2];
            if (key2 == 0) {
                keyTable[index2] = evictedKey;
                valueTable[index2] = evictedValue;
                i2 = this.size;
                this.size = i2 + 1;
                if (i2 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            index3 = hash3(evictedKey);
            key3 = keyTable[index3];
            if (key3 == 0) {
                keyTable[index3] = evictedKey;
                valueTable[index3] = evictedValue;
                i2 = this.size;
                this.size = i2 + 1;
                if (i2 >= this.threshold) {
                    resize(this.capacity << 1);
                    return;
                }
                return;
            }
            i++;
            if (i == pushIterations) {
                putStash(evictedKey, evictedValue);
                return;
            } else {
                insertKey = evictedKey;
                insertValue = evictedValue;
            }
        }
    }

    private void putStash(long key, V value) {
        if (this.stashSize == this.stashCapacity) {
            resize(this.capacity << 1);
            put(key, value);
            return;
        }
        long[] keyTable = this.keyTable;
        int i = this.capacity;
        int n = i + this.stashSize;
        while (i < n) {
            if (keyTable[i] == key) {
                this.valueTable[i] = value;
                return;
            }
            i++;
        }
        int index = this.capacity + this.stashSize;
        keyTable[index] = key;
        this.valueTable[index] = value;
        this.stashSize++;
    }

    public V get(long key) {
        if (key == 0) {
            return this.zeroValue;
        }
        int index = (int) (((long) this.mask) & key);
        if (this.keyTable[index] != key) {
            index = hash2(key);
            if (this.keyTable[index] != key) {
                index = hash3(key);
                if (this.keyTable[index] != key) {
                    return getStash(key);
                }
            }
        }
        return this.valueTable[index];
    }

    private V getStash(long key) {
        long[] keyTable = this.keyTable;
        int i = this.capacity;
        int n = i + this.stashSize;
        while (i < n) {
            if (keyTable[i] == key) {
                return this.valueTable[i];
            }
            i++;
        }
        return null;
    }

    public V remove(long key) {
        V v;
        if (key != 0) {
            int index = (int) (((long) this.mask) & key);
            if (this.keyTable[index] == key) {
                this.keyTable[index] = 0;
                v = this.valueTable[index];
                this.valueTable[index] = null;
                this.size--;
                return v;
            }
            index = hash2(key);
            if (this.keyTable[index] == key) {
                this.keyTable[index] = 0;
                v = this.valueTable[index];
                this.valueTable[index] = null;
                this.size--;
                return v;
            }
            index = hash3(key);
            if (this.keyTable[index] != key) {
                return removeStash(key);
            }
            this.keyTable[index] = 0;
            v = this.valueTable[index];
            this.valueTable[index] = null;
            this.size--;
            return v;
        } else if (!this.hasZeroValue) {
            return null;
        } else {
            v = this.zeroValue;
            this.zeroValue = null;
            this.hasZeroValue = false;
            this.size--;
            return v;
        }
    }

    V removeStash(long key) {
        long[] keyTable = this.keyTable;
        int i = this.capacity;
        int n = i + this.stashSize;
        while (i < n) {
            if (keyTable[i] == key) {
                V oldValue = this.valueTable[i];
                removeStashIndex(i);
                this.size--;
                return oldValue;
            }
            i++;
        }
        return null;
    }

    void removeStashIndex(int index) {
        this.stashSize--;
        int lastIndex = this.capacity + this.stashSize;
        if (index < lastIndex) {
            this.keyTable[index] = this.keyTable[lastIndex];
            this.valueTable[index] = this.valueTable[lastIndex];
            this.valueTable[lastIndex] = null;
            return;
        }
        this.valueTable[index] = null;
    }

    public void clear() {
        long[] keyTable = this.keyTable;
        Object[] valueTable = this.valueTable;
        int i = this.capacity + this.stashSize;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                this.size = 0;
                this.stashSize = 0;
                this.zeroValue = null;
                this.hasZeroValue = false;
                return;
            }
            keyTable[i2] = 0;
            valueTable[i2] = null;
            i = i2;
        }
    }

    public boolean containsValue(Object value, boolean identity) {
        Object[] valueTable = this.valueTable;
        int i;
        int i2;
        if (value == null) {
            if (this.hasZeroValue && this.zeroValue == null) {
                return true;
            }
            long[] keyTable = this.keyTable;
            i = this.capacity + this.stashSize;
            while (true) {
                i2 = i - 1;
                if (i <= 0) {
                    break;
                } else if (keyTable[i2] != 0 && valueTable[i2] == null) {
                    return true;
                } else {
                    i = i2;
                }
            }
        } else if (identity) {
            if (value != this.zeroValue) {
                i = this.capacity + this.stashSize;
                while (true) {
                    i2 = i - 1;
                    if (i <= 0) {
                        break;
                    } else if (valueTable[i2] == value) {
                        return true;
                    } else {
                        i = i2;
                    }
                }
            } else {
                return true;
            }
        } else if (!this.hasZeroValue || !value.equals(this.zeroValue)) {
            i = this.capacity + this.stashSize;
            while (true) {
                i2 = i - 1;
                if (i <= 0) {
                    break;
                } else if (value.equals(valueTable[i2])) {
                    return true;
                } else {
                    i = i2;
                }
            }
        } else {
            return true;
        }
        return false;
    }

    public boolean containsKey(long key) {
        if (key == 0) {
            return this.hasZeroValue;
        }
        if (this.keyTable[(int) (((long) this.mask) & key)] != key) {
            if (this.keyTable[hash2(key)] != key) {
                if (this.keyTable[hash3(key)] != key) {
                    return containsKeyStash(key);
                }
            }
        }
        return true;
    }

    private boolean containsKeyStash(long key) {
        long[] keyTable = this.keyTable;
        int i = this.capacity;
        int n = i + this.stashSize;
        while (i < n) {
            if (keyTable[i] == key) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void ensureCapacity(int additionalCapacity) {
        int sizeNeeded = this.size + additionalCapacity;
        if (sizeNeeded >= this.threshold) {
            resize(MathUtils.nextPowerOfTwo((int) (((float) sizeNeeded) / this.loadFactor)));
        }
    }

    private void resize(int newSize) {
        int i;
        int oldEndIndex = this.capacity + this.stashSize;
        this.capacity = newSize;
        this.threshold = (int) (((float) newSize) * this.loadFactor);
        this.mask = newSize - 1;
        this.hashShift = 31 - Integer.numberOfTrailingZeros(newSize);
        this.stashCapacity = Math.max(3, (int) Math.ceil(Math.log((double) newSize)));
        this.pushIterations = Math.max(Math.min(this.capacity, 32), ((int) Math.sqrt((double) this.capacity)) / 4);
        long[] oldKeyTable = this.keyTable;
        Object[] oldValueTable = this.valueTable;
        this.keyTable = new long[(this.stashCapacity + newSize)];
        this.valueTable = new Object[(this.stashCapacity + newSize)];
        if (this.hasZeroValue) {
            i = 1;
        } else {
            i = 0;
        }
        this.size = i;
        this.stashSize = 0;
        for (int i2 = 0; i2 < oldEndIndex; i2++) {
            long key = oldKeyTable[i2];
            if (key != 0) {
                putResize(key, oldValueTable[i2]);
            }
        }
    }

    private int hash2(long h) {
        h *= -1262997959;
        return (int) (((h >>> this.hashShift) ^ h) & ((long) this.mask));
    }

    private int hash3(long h) {
        h *= -825114047;
        return (int) (((h >>> this.hashShift) ^ h) & ((long) this.mask));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
        r12 = this;
        r10 = 0;
        r8 = 61;
        r7 = r12.size;
        if (r7 != 0) goto L_0x000b;
    L_0x0008:
        r7 = "[]";
    L_0x000a:
        return r7;
    L_0x000b:
        r0 = new java.lang.StringBuilder;
        r7 = 32;
        r0.<init>(r7);
        r7 = 91;
        r0.append(r7);
        r3 = r12.keyTable;
        r6 = r12.valueTable;
        r1 = r3.length;
        r2 = r1;
    L_0x001d:
        r1 = r2 + -1;
        if (r2 > 0) goto L_0x0030;
    L_0x0021:
        r2 = r1;
    L_0x0022:
        r1 = r2 + -1;
        if (r2 > 0) goto L_0x0045;
    L_0x0026:
        r7 = 93;
        r0.append(r7);
        r7 = r0.toString();
        goto L_0x000a;
    L_0x0030:
        r4 = r3[r1];
        r7 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r7 != 0) goto L_0x0038;
    L_0x0036:
        r2 = r1;
        goto L_0x001d;
    L_0x0038:
        r0.append(r4);
        r0.append(r8);
        r7 = r6[r1];
        r0.append(r7);
        r2 = r1;
        goto L_0x0022;
    L_0x0045:
        r4 = r3[r1];
        r7 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r7 != 0) goto L_0x004d;
    L_0x004b:
        r2 = r1;
        goto L_0x0022;
    L_0x004d:
        r7 = ", ";
        r0.append(r7);
        r0.append(r4);
        r0.append(r8);
        r7 = r6[r1];
        r0.append(r7);
        r2 = r1;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.LongMap.toString():java.lang.String");
    }

    public Entries<V> entries() {
        if (this.entries == null) {
            this.entries = new Entries(this);
        } else {
            this.entries.reset();
        }
        return this.entries;
    }

    public Values<V> values() {
        if (this.values == null) {
            this.values = new Values(this);
        } else {
            this.values.reset();
        }
        return this.values;
    }

    public Keys keys() {
        if (this.keys == null) {
            this.keys = new Keys(this);
        } else {
            this.keys.reset();
        }
        return this.keys;
    }
}
