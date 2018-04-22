package org.anddev.andengine.util.sort;

import java.util.Comparator;
import java.util.List;

public abstract class Sorter<T> {
    public abstract void sort(List<T> list, int i, int i2, Comparator<T> comparator);

    public abstract void sort(T[] tArr, int i, int i2, Comparator<T> comparator);

    public final void sort(T[] pArray, Comparator<T> pComparator) {
        sort((Object[]) pArray, 0, pArray.length, (Comparator) pComparator);
    }

    public final void sort(List<T> pList, Comparator<T> pComparator) {
        sort((List) pList, 0, pList.size(), (Comparator) pComparator);
    }
}
