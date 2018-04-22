package org.anddev.andengine.ui.activity;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Callable;
import org.anddev.andengine.util.ActivityUtils;
import org.anddev.andengine.util.AsyncCallable;
import org.anddev.andengine.util.Callback;
import org.anddev.andengine.util.progress.ProgressCallable;

public abstract class BaseActivity extends Activity {

    public static class CancelledException extends Exception {
        private static final long serialVersionUID = -78123211381435596L;
    }

    protected <T> void doAsync(int pTitleResID, int pMessageResID, Callable<T> pCallable, Callback<T> pCallback) {
        doAsync(pTitleResID, pMessageResID, (Callable) pCallable, (Callback) pCallback, null);
    }

    protected <T> void doAsync(int pTitleResID, int pMessageResID, Callable<T> pCallable, Callback<T> pCallback, Callback<Exception> pExceptionCallback) {
        ActivityUtils.doAsync((Context) this, pTitleResID, pMessageResID, (Callable) pCallable, (Callback) pCallback, (Callback) pExceptionCallback);
    }

    protected <T> void doProgressAsync(int pTitleResID, ProgressCallable<T> pCallable, Callback<T> pCallback) {
        doProgressAsync(pTitleResID, pCallable, pCallback, null);
    }

    protected <T> void doProgressAsync(int pTitleResID, ProgressCallable<T> pCallable, Callback<T> pCallback, Callback<Exception> pExceptionCallback) {
        ActivityUtils.doProgressAsync(this, pTitleResID, pCallable, pCallback, pExceptionCallback);
    }

    protected <T> void doAsync(int pTitleResID, int pMessageResID, AsyncCallable<T> pAsyncCallable, Callback<T> pCallback, Callback<Exception> pExceptionCallback) {
        ActivityUtils.doAsync((Context) this, pTitleResID, pMessageResID, (AsyncCallable) pAsyncCallable, (Callback) pCallback, (Callback) pExceptionCallback);
    }
}
