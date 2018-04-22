package org.anddev.andengine.entity;

import java.util.Comparator;
import java.util.List;
import org.anddev.andengine.util.sort.InsertionSorter;

public class ZIndexSorter extends InsertionSorter<IEntity> {
    private static ZIndexSorter INSTANCE;
    private final Comparator<IEntity> mZIndexComparator = new C05931();

    class C05931 implements Comparator<IEntity> {
        C05931() {
        }

        public int compare(IEntity pEntityA, IEntity pEntityB) {
            return pEntityA.getZIndex() - pEntityB.getZIndex();
        }
    }

    private ZIndexSorter() {
    }

    public static ZIndexSorter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ZIndexSorter();
        }
        return INSTANCE;
    }

    public void sort(IEntity[] pEntities) {
        sort((Object[]) pEntities, this.mZIndexComparator);
    }

    public void sort(IEntity[] pEntities, int pStart, int pEnd) {
        sort((Object[]) pEntities, pStart, pEnd, this.mZIndexComparator);
    }

    public void sort(List<IEntity> pEntities) {
        sort((List) pEntities, this.mZIndexComparator);
    }

    public void sort(List<IEntity> pEntities, int pStart, int pEnd) {
        sort((List) pEntities, pStart, pEnd, this.mZIndexComparator);
    }
}
