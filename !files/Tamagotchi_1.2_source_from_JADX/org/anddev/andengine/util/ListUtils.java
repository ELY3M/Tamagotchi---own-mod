package org.anddev.andengine.util;

import java.util.ArrayList;

public class ListUtils {
    public static <T> ArrayList<? extends T> toList(T pItem) {
        ArrayList<T> out = new ArrayList();
        out.add(pItem);
        return out;
    }

    public static <T> ArrayList<? extends T> toList(T... pItems) {
        ArrayList<T> out = new ArrayList();
        for (Object add : pItems) {
            out.add(add);
        }
        return out;
    }
}
