package org.anddev.andengine.util;

public interface AsyncCallable<T> {
    void call(Callback<T> callback, Callback<Exception> callback2);
}
