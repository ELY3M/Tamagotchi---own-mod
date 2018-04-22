package org.acra.util;

import android.support.annotation.NonNull;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class BoundedLinkedList<E> extends LinkedList<E> {
    private final int maxSize;

    public BoundedLinkedList(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean add(E object) {
        if (size() == this.maxSize) {
            removeFirst();
        }
        return super.add(object);
    }

    public void add(int location, E object) {
        if (size() == this.maxSize) {
            removeFirst();
        }
        super.add(location, object);
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        int size = collection.size();
        if (size > this.maxSize) {
            LinkedList<? extends E> list = new LinkedList(collection);
            for (int i = 0; i < size - this.maxSize; i++) {
                list.removeFirst();
            }
            collection = list;
        }
        int overhead = (size() + collection.size()) - this.maxSize;
        if (overhead > 0) {
            removeRange(0, overhead);
        }
        return super.addAll(collection);
    }

    public boolean addAll(int location, Collection<? extends E> collection) {
        if (location == size()) {
            return super.addAll(location, collection);
        }
        throw new UnsupportedOperationException();
    }

    public void addFirst(E e) {
        throw new UnsupportedOperationException();
    }

    public void addLast(E object) {
        add(object);
    }

    @NonNull
    public String toString() {
        StringBuilder result = new StringBuilder();
        Iterator i$ = iterator();
        while (i$.hasNext()) {
            result.append(i$.next().toString());
        }
        return result.toString();
    }

    public boolean offer(E o) {
        return add(o);
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        return add(e);
    }

    public void push(E e) {
        add(e);
    }
}
