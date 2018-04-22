package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager zzblm;
    private final Context mContext;
    private final DataLayer zzbhN;
    private final zzs zzbkh;
    private final zza zzblj;
    private final zzct zzblk;
    private final ConcurrentMap<zzo, Boolean> zzbll;

    class C05063 implements ComponentCallbacks2 {
        final /* synthetic */ TagManager zzbln;

        C05063(TagManager tagManager) {
            this.zzbln = tagManager;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.zzbln.dispatch();
            }
        }
    }

    public interface zza {
        zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs);
    }

    class C08531 implements zzb {
        final /* synthetic */ TagManager zzbln;

        C08531(TagManager tagManager) {
            this.zzbln = tagManager;
        }

        public void zzQ(Map<String, Object> map) {
            Object obj = map.get("event");
            if (obj != null) {
                this.zzbln.zzgp(obj.toString());
            }
        }
    }

    static class C08542 implements zza {
        C08542() {
        }

        public zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs) {
            return new zzp(context, tagManager, looper, str, i, com_google_android_gms_tagmanager_zzs);
        }
    }

    TagManager(Context context, zza containerHolderLoaderProvider, DataLayer dataLayer, zzct serviceManager) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzblk = serviceManager;
        this.zzblj = containerHolderLoaderProvider;
        this.zzbll = new ConcurrentHashMap();
        this.zzbhN = dataLayer;
        this.zzbhN.zza(new C08531(this));
        this.zzbhN.zza(new zzd(this.mContext));
        this.zzbkh = new zzs();
        zzHt();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzblm == null) {
                if (context == null) {
                    zzbg.m11e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                zzblm = new TagManager(context, new C08542(), new DataLayer(new zzw(context)), zzcu.zzHo());
            }
            tagManager = zzblm;
        }
        return tagManager;
    }

    @TargetApi(14)
    private void zzHt() {
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new C05063(this));
        }
    }

    private void zzgp(String str) {
        for (zzo zzfR : this.zzbll.keySet()) {
            zzfR.zzfR(str);
        }
    }

    public void dispatch() {
        this.zzblk.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.zzbhN;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, @RawRes int defaultContainerResourceId) {
        PendingResult zza = this.zzblj.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzbkh);
        zza.zzGg();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, @RawRes int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzblj.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzbkh);
        zza.zzGg();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, @RawRes int defaultContainerResourceId) {
        PendingResult zza = this.zzblj.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzbkh);
        zza.zzGi();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, @RawRes int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzblj.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzbkh);
        zza.zzGi();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, @RawRes int defaultContainerResourceId) {
        PendingResult zza = this.zzblj.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzbkh);
        zza.zzGh();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, @RawRes int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzblj.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzbkh);
        zza.zzGh();
        return zza;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        zzbg.setLogLevel(enableVerboseLogging ? 2 : 5);
    }

    public void zza(zzo com_google_android_gms_tagmanager_zzo) {
        this.zzbll.put(com_google_android_gms_tagmanager_zzo, Boolean.valueOf(true));
    }

    public boolean zzb(zzo com_google_android_gms_tagmanager_zzo) {
        return this.zzbll.remove(com_google_android_gms_tagmanager_zzo) != null;
    }

    synchronized boolean zzp(Uri uri) {
        boolean z;
        zzcb zzGU = zzcb.zzGU();
        if (zzGU.zzp(uri)) {
            String containerId = zzGU.getContainerId();
            switch (zzGU.zzGV()) {
                case NONE:
                    for (zzo com_google_android_gms_tagmanager_zzo : this.zzbll.keySet()) {
                        if (com_google_android_gms_tagmanager_zzo.getContainerId().equals(containerId)) {
                            com_google_android_gms_tagmanager_zzo.zzfT(null);
                            com_google_android_gms_tagmanager_zzo.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (zzo com_google_android_gms_tagmanager_zzo2 : this.zzbll.keySet()) {
                        if (com_google_android_gms_tagmanager_zzo2.getContainerId().equals(containerId)) {
                            com_google_android_gms_tagmanager_zzo2.zzfT(zzGU.zzGW());
                            com_google_android_gms_tagmanager_zzo2.refresh();
                        } else if (com_google_android_gms_tagmanager_zzo2.zzGd() != null) {
                            com_google_android_gms_tagmanager_zzo2.zzfT(null);
                            com_google_android_gms_tagmanager_zzo2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
