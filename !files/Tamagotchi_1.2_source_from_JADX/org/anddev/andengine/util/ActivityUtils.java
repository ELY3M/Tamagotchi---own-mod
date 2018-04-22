package org.anddev.andengine.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.util.concurrent.Callable;
import org.anddev.andengine.ui.activity.BaseActivity.CancelledException;
import org.anddev.andengine.util.progress.IProgressListener;
import org.anddev.andengine.util.progress.ProgressCallable;

public class ActivityUtils {

    class C05991 extends AsyncTask<Void, Void, T> {
        private Exception mException = null;
        private ProgressDialog mPD;
        private final /* synthetic */ Callable val$pCallable;
        private final /* synthetic */ Callback val$pCallback;
        private final /* synthetic */ boolean val$pCancelable;
        private final /* synthetic */ Context val$pContext;
        private final /* synthetic */ Callback val$pExceptionCallback;
        private final /* synthetic */ CharSequence val$pMessage;
        private final /* synthetic */ CharSequence val$pTitle;

        C05991(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, Callable callable, Callback callback, Callback callback2) {
            this.val$pContext = context;
            this.val$pTitle = charSequence;
            this.val$pMessage = charSequence2;
            this.val$pCancelable = z;
            this.val$pCallable = callable;
            this.val$pCallback = callback;
            this.val$pExceptionCallback = callback2;
        }

        public void onPreExecute() {
            this.mPD = ProgressDialog.show(this.val$pContext, this.val$pTitle, this.val$pMessage, true, this.val$pCancelable);
            if (this.val$pCancelable) {
                ProgressDialog progressDialog = this.mPD;
                final Callback callback = this.val$pExceptionCallback;
                progressDialog.setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface pDialogInterface) {
                        callback.onCallback(new CancelledException());
                        pDialogInterface.dismiss();
                    }
                });
            }
            super.onPreExecute();
        }

        public T doInBackground(Void... params) {
            try {
                return this.val$pCallable.call();
            } catch (Exception e) {
                this.mException = e;
                return null;
            }
        }

        public void onPostExecute(T result) {
            try {
                this.mPD.dismiss();
            } catch (Exception e) {
                Debug.m62e("Error", e);
            }
            if (isCancelled()) {
                this.mException = new CancelledException();
            }
            if (this.mException == null) {
                this.val$pCallback.onCallback(result);
            } else if (this.val$pExceptionCallback == null) {
                Debug.m62e("Error", this.mException);
            } else {
                this.val$pExceptionCallback.onCallback(this.mException);
            }
            super.onPostExecute(result);
        }
    }

    class C06002 extends AsyncTask<Void, Integer, T> {
        private Exception mException = null;
        private ProgressDialog mPD;
        private final /* synthetic */ ProgressCallable val$pCallable;
        private final /* synthetic */ Callback val$pCallback;
        private final /* synthetic */ Context val$pContext;
        private final /* synthetic */ Callback val$pExceptionCallback;
        private final /* synthetic */ int val$pTitleResID;

        class C09301 implements IProgressListener {
            C09301() {
            }

            public void onProgressChanged(int pProgress) {
                C06002.this.onProgressUpdate(Integer.valueOf(pProgress));
            }
        }

        C06002(Context context, int i, ProgressCallable progressCallable, Callback callback, Callback callback2) {
            this.val$pContext = context;
            this.val$pTitleResID = i;
            this.val$pCallable = progressCallable;
            this.val$pCallback = callback;
            this.val$pExceptionCallback = callback2;
        }

        public void onPreExecute() {
            this.mPD = new ProgressDialog(this.val$pContext);
            this.mPD.setTitle(this.val$pTitleResID);
            this.mPD.setIcon(17301582);
            this.mPD.setIndeterminate(false);
            this.mPD.setProgressStyle(1);
            this.mPD.show();
            super.onPreExecute();
        }

        public T doInBackground(Void... params) {
            try {
                return this.val$pCallable.call(new C09301());
            } catch (Exception e) {
                this.mException = e;
                return null;
            }
        }

        public void onProgressUpdate(Integer... values) {
            this.mPD.setProgress(values[0].intValue());
        }

        public void onPostExecute(T result) {
            try {
                this.mPD.dismiss();
            } catch (Exception e) {
                Debug.m62e("Error", e);
            }
            if (isCancelled()) {
                this.mException = new CancelledException();
            }
            if (this.mException == null) {
                this.val$pCallback.onCallback(result);
            } else if (this.val$pExceptionCallback == null) {
                Debug.m62e("Error", this.mException);
            } else {
                this.val$pExceptionCallback.onCallback(this.mException);
            }
            super.onPostExecute(result);
        }
    }

    class C09313 implements Callback<T> {
        private final /* synthetic */ Callback val$pCallback;
        private final /* synthetic */ ProgressDialog val$pd;

        C09313(ProgressDialog progressDialog, Callback callback) {
            this.val$pd = progressDialog;
            this.val$pCallback = callback;
        }

        public void onCallback(T result) {
            try {
                this.val$pd.dismiss();
            } catch (Exception e) {
                Debug.m62e("Error", e);
            }
            this.val$pCallback.onCallback(result);
        }
    }

    public static void requestFullscreen(Activity pActivity) {
        Window window = pActivity.getWindow();
        window.addFlags(1024);
        window.clearFlags(2048);
        window.requestFeature(1);
    }

    public static void setScreenBrightness(Activity pActivity, float pScreenBrightness) {
        Window window = pActivity.getWindow();
        LayoutParams windowLayoutParams = window.getAttributes();
        windowLayoutParams.screenBrightness = pScreenBrightness;
        window.setAttributes(windowLayoutParams);
    }

    public static void keepScreenOn(Activity pActivity) {
        pActivity.getWindow().addFlags(128);
    }

    public static <T> void doAsync(Context pContext, int pTitleResID, int pMessageResID, Callable<T> pCallable, Callback<T> pCallback) {
        doAsync(pContext, pTitleResID, pMessageResID, (Callable) pCallable, (Callback) pCallback, null, false);
    }

    public static <T> void doAsync(Context pContext, CharSequence pTitle, CharSequence pMessage, Callable<T> pCallable, Callback<T> pCallback) {
        doAsync(pContext, pTitle, pMessage, (Callable) pCallable, (Callback) pCallback, null, false);
    }

    public static <T> void doAsync(Context pContext, int pTitleResID, int pMessageResID, Callable<T> pCallable, Callback<T> pCallback, boolean pCancelable) {
        doAsync(pContext, pTitleResID, pMessageResID, (Callable) pCallable, (Callback) pCallback, null, pCancelable);
    }

    public static <T> void doAsync(Context pContext, CharSequence pTitle, CharSequence pMessage, Callable<T> pCallable, Callback<T> pCallback, boolean pCancelable) {
        doAsync(pContext, pTitle, pMessage, (Callable) pCallable, (Callback) pCallback, null, pCancelable);
    }

    public static <T> void doAsync(Context pContext, int pTitleResID, int pMessageResID, Callable<T> pCallable, Callback<T> pCallback, Callback<Exception> pExceptionCallback) {
        doAsync(pContext, pTitleResID, pMessageResID, (Callable) pCallable, (Callback) pCallback, (Callback) pExceptionCallback, false);
    }

    public static <T> void doAsync(Context pContext, CharSequence pTitle, CharSequence pMessage, Callable<T> pCallable, Callback<T> pCallback, Callback<Exception> pExceptionCallback) {
        doAsync(pContext, pTitle, pMessage, (Callable) pCallable, (Callback) pCallback, (Callback) pExceptionCallback, false);
    }

    public static <T> void doAsync(Context pContext, int pTitleResID, int pMessageResID, Callable<T> pCallable, Callback<T> pCallback, Callback<Exception> pExceptionCallback, boolean pCancelable) {
        doAsync(pContext, pContext.getString(pTitleResID), pContext.getString(pMessageResID), (Callable) pCallable, (Callback) pCallback, (Callback) pExceptionCallback, pCancelable);
    }

    public static <T> void doAsync(Context pContext, CharSequence pTitle, CharSequence pMessage, Callable<T> pCallable, Callback<T> pCallback, Callback<Exception> pExceptionCallback, boolean pCancelable) {
        new C05991(pContext, pTitle, pMessage, pCancelable, pCallable, pCallback, pExceptionCallback).execute(null);
    }

    public static <T> void doProgressAsync(Context pContext, int pTitleResID, ProgressCallable<T> pCallable, Callback<T> pCallback) {
        doProgressAsync(pContext, pTitleResID, pCallable, pCallback, null);
    }

    public static <T> void doProgressAsync(Context pContext, int pTitleResID, ProgressCallable<T> pCallable, Callback<T> pCallback, Callback<Exception> pExceptionCallback) {
        new C06002(pContext, pTitleResID, pCallable, pCallback, pExceptionCallback).execute(null);
    }

    public static <T> void doAsync(Context pContext, int pTitleResID, int pMessageResID, AsyncCallable<T> pAsyncCallable, Callback<T> pCallback, Callback<Exception> pExceptionCallback) {
        pAsyncCallable.call(new C09313(ProgressDialog.show(pContext, pContext.getString(pTitleResID), pContext.getString(pMessageResID)), pCallback), pExceptionCallback);
    }
}
