package org.anddev.andengine.util.sort;

import java.util.Comparator;
import java.util.List;

public class InsertionSorter<T> extends Sorter<T> {
    public void sort(T[] pArray, int pStart, int pEnd, Comparator<T> pComparator) {
        for (int i = pStart + 1; i < pEnd; i++) {
            T current = pArray[i];
            T prev = pArray[i - 1];
            if (pComparator.compare(current, prev) < 0) {
                int j;
                int j2 = i;
                while (true) {
                    j = j2 - 1;
                    pArray[j2] = prev;
                    if (j <= pStart) {
                        break;
                    }
                    prev = pArray[j - 1];
                    if (pComparator.compare(current, prev) >= 0) {
                        break;
                    }
                    j2 = j;
                }
                pArray[j] = current;
            }
        }
    }

    public void sort(List<T> pList, int pStart, int pEnd, Comparator<T> pComparator) {
        for (int i = pStart + 1; i < pEnd; i++) {
            T current = pList.get(i);
            T prev = pList.get(i - 1);
            if (pComparator.compare(current, prev) < 0) {
                int j;
                int j2 = i;
                while (true) {
                    j = j2 - 1;
                    pList.set(j2, prev);
                    if (j <= pStart) {
                        break;
                    }
                    prev = pList.get(j - 1);
                    if (pComparator.compare(current, prev) >= 0) {
                        break;
                    }
                    j2 = j;
                }
                pList.set(j, current);
            }
        }
    }
}
