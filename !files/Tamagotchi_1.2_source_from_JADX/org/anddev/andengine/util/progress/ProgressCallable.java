package org.anddev.andengine.util.progress;

public interface ProgressCallable<T> {
    T call(IProgressListener iProgressListener) throws Exception;
}
