package com.google.android.gms.games.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.internal.zzne;
import java.lang.ref.WeakReference;

public class PopupManager {
    protected GamesClientImpl zzaFJ;
    protected PopupLocationInfo zzaFK;

    public static final class PopupLocationInfo {
        public int bottom;
        public int gravity;
        public int left;
        public int right;
        public int top;
        public IBinder zzaFL;
        public int zzaFM;

        private PopupLocationInfo(int gravity, IBinder windowToken) {
            this.zzaFM = -1;
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.gravity = gravity;
            this.zzaFL = windowToken;
        }

        public Bundle zzxg() {
            Bundle bundle = new Bundle();
            bundle.putInt("popupLocationInfo.gravity", this.gravity);
            bundle.putInt("popupLocationInfo.displayId", this.zzaFM);
            bundle.putInt("popupLocationInfo.left", this.left);
            bundle.putInt("popupLocationInfo.top", this.top);
            bundle.putInt("popupLocationInfo.right", this.right);
            bundle.putInt("popupLocationInfo.bottom", this.bottom);
            return bundle;
        }
    }

    @TargetApi(12)
    private static final class PopupManagerHCMR1 extends PopupManager implements OnAttachStateChangeListener, OnGlobalLayoutListener {
        private boolean zzaEe = false;
        private WeakReference<View> zzaFN;

        protected PopupManagerHCMR1(GamesClientImpl gamesClientImpl, int gravity) {
            super(gamesClientImpl, gravity);
        }

        @TargetApi(17)
        private void zzq(View view) {
            int i = -1;
            if (zzne.zzsi()) {
                Display display = view.getDisplay();
                if (display != null) {
                    i = display.getDisplayId();
                }
            }
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            this.zzaFK.zzaFM = i;
            this.zzaFK.zzaFL = windowToken;
            this.zzaFK.left = iArr[0];
            this.zzaFK.top = iArr[1];
            this.zzaFK.right = iArr[0] + width;
            this.zzaFK.bottom = iArr[1] + height;
            if (this.zzaEe) {
                zzxh();
                this.zzaEe = false;
            }
        }

        public void onGlobalLayout() {
            if (this.zzaFN != null) {
                View view = (View) this.zzaFN.get();
                if (view != null) {
                    zzq(view);
                }
            }
        }

        public void onViewAttachedToWindow(View v) {
            zzq(v);
        }

        public void onViewDetachedFromWindow(View v) {
            this.zzaFJ.zzwR();
            v.removeOnAttachStateChangeListener(this);
        }

        protected void zzgv(int i) {
            this.zzaFK = new PopupLocationInfo(i, null);
        }

        @TargetApi(16)
        public void zzp(View view) {
            View view2;
            Context context;
            this.zzaFJ.zzwR();
            if (this.zzaFN != null) {
                view2 = (View) this.zzaFN.get();
                context = this.zzaFJ.getContext();
                if (view2 == null && (context instanceof Activity)) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                if (view2 != null) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (zzne.zzsh()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            }
            this.zzaFN = null;
            context = this.zzaFJ.getContext();
            if (view == null && (context instanceof Activity)) {
                view2 = ((Activity) context).findViewById(16908290);
                if (view2 == null) {
                    view2 = ((Activity) context).getWindow().getDecorView();
                }
                GamesLog.zzz("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
                view = view2;
            }
            if (view != null) {
                zzq(view);
                this.zzaFN = new WeakReference(view);
                view.addOnAttachStateChangeListener(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
                return;
            }
            GamesLog.zzA("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
        }

        public void zzxh() {
            if (this.zzaFK.zzaFL != null) {
                super.zzxh();
            } else {
                this.zzaEe = this.zzaFN != null;
            }
        }
    }

    private PopupManager(GamesClientImpl gamesClientImpl, int gravity) {
        this.zzaFJ = gamesClientImpl;
        zzgv(gravity);
    }

    public static PopupManager zza(GamesClientImpl gamesClientImpl, int i) {
        return zzne.zzse() ? new PopupManagerHCMR1(gamesClientImpl, i) : new PopupManager(gamesClientImpl, i);
    }

    public void setGravity(int gravity) {
        this.zzaFK.gravity = gravity;
    }

    protected void zzgv(int i) {
        this.zzaFK = new PopupLocationInfo(i, new Binder());
    }

    public void zzp(View view) {
    }

    public void zzxh() {
        this.zzaFJ.zza(this.zzaFK.zzaFL, this.zzaFK.zzxg());
    }

    public Bundle zzxi() {
        return this.zzaFK.zzxg();
    }

    public IBinder zzxj() {
        return this.zzaFK.zzaFL;
    }

    public PopupLocationInfo zzxk() {
        return this.zzaFK;
    }
}
