package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.zze;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    private final zzf<T> zzavA = new C07251(this);
    private T zzavx;
    private Bundle zzavy;
    private LinkedList<zza> zzavz;

    private interface zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    class C07251 implements zzf<T> {
        final /* synthetic */ zza zzavB;

        C07251(zza com_google_android_gms_dynamic_zza) {
            this.zzavB = com_google_android_gms_dynamic_zza;
        }

        public void zza(T t) {
            this.zzavB.zzavx = t;
            Iterator it = this.zzavB.zzavz.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzb(this.zzavB.zzavx);
            }
            this.zzavB.zzavz.clear();
            this.zzavB.zzavy = null;
        }
    }

    class C07296 implements zza {
        final /* synthetic */ zza zzavB;

        C07296(zza com_google_android_gms_dynamic_zza) {
            this.zzavB = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 4;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzavB.zzavx.onStart();
        }
    }

    class C07307 implements zza {
        final /* synthetic */ zza zzavB;

        C07307(zza com_google_android_gms_dynamic_zza) {
            this.zzavB = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 5;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzavB.zzavx.onResume();
        }
    }

    private void zza(Bundle bundle, zza com_google_android_gms_dynamic_zza_zza) {
        if (this.zzavx != null) {
            com_google_android_gms_dynamic_zza_zza.zzb(this.zzavx);
            return;
        }
        if (this.zzavz == null) {
            this.zzavz = new LinkedList();
        }
        this.zzavz.add(com_google_android_gms_dynamic_zza_zza);
        if (bundle != null) {
            if (this.zzavy == null) {
                this.zzavy = (Bundle) bundle.clone();
            } else {
                this.zzavy.putAll(bundle);
            }
        }
        zza(this.zzavA);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence zzc = zzg.zzc(context, isGooglePlayServicesAvailable, zze.zzao(context));
        CharSequence zzh = zzg.zzh(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zzc);
        linearLayout.addView(textView);
        if (zzh != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzh);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.zzbv(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzeJ(int i) {
        while (!this.zzavz.isEmpty() && ((zza) this.zzavz.getLast()).getState() >= i) {
            this.zzavz.removeLast();
        }
    }

    public void onCreate(final Bundle savedInstanceState) {
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzavB;

            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.zzavB.zzavx.onCreate(savedInstanceState);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzavB;

            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.zzavB.zzavx.onCreateView(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.zzavx == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.zzavx != null) {
            this.zzavx.onDestroy();
        } else {
            zzeJ(1);
        }
    }

    public void onDestroyView() {
        if (this.zzavx != null) {
            this.zzavx.onDestroyView();
        } else {
            zzeJ(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        zza(savedInstanceState, new zza(this) {
            final /* synthetic */ zza zzavB;

            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.zzavB.zzavx.onInflate(activity, attrs, savedInstanceState);
            }
        });
    }

    public void onLowMemory() {
        if (this.zzavx != null) {
            this.zzavx.onLowMemory();
        }
    }

    public void onPause() {
        if (this.zzavx != null) {
            this.zzavx.onPause();
        } else {
            zzeJ(5);
        }
    }

    public void onResume() {
        zza(null, new C07307(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.zzavx != null) {
            this.zzavx.onSaveInstanceState(outState);
        } else if (this.zzavy != null) {
            outState.putAll(this.zzavy);
        }
    }

    public void onStart() {
        zza(null, new C07296(this));
    }

    public void onStop() {
        if (this.zzavx != null) {
            this.zzavx.onStop();
        } else {
            zzeJ(4);
        }
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zzf<T> com_google_android_gms_dynamic_zzf_T);

    public T zztU() {
        return this.zzavx;
    }
}
