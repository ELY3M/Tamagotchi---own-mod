package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzay<T> {
    private final Map<T, zzbq<T>> zzaxd = new HashMap();

    private static class zza<T> extends zzb<Status> {
        private WeakReference<Map<T, zzbq<T>>> zzbsM;
        private WeakReference<T> zzbsN;

        zza(Map<T, zzbq<T>> map, T t, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzbsM = new WeakReference(map);
            this.zzbsN = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzbsM.get();
            Object obj = this.zzbsN.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    zzbq com_google_android_gms_wearable_internal_zzbq = (zzbq) map.remove(obj);
                    if (com_google_android_gms_wearable_internal_zzbq != null) {
                        com_google_android_gms_wearable_internal_zzbq.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    private static class zzb<T> extends zzb<Status> {
        private WeakReference<Map<T, zzbq<T>>> zzbsM;
        private WeakReference<T> zzbsN;

        zzb(Map<T, zzbq<T>> map, T t, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
            this.zzbsM = new WeakReference(map);
            this.zzbsN = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzbsM.get();
            Object obj = this.zzbsN.get();
            if (!(status.getStatus().getStatusCode() != 4002 || map == null || obj == null)) {
                synchronized (map) {
                    zzbq com_google_android_gms_wearable_internal_zzbq = (zzbq) map.remove(obj);
                    if (com_google_android_gms_wearable_internal_zzbq != null) {
                        com_google_android_gms_wearable_internal_zzbq.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    zzay() {
    }

    public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, T t) throws RemoteException {
        synchronized (this.zzaxd) {
            zzbq com_google_android_gms_wearable_internal_zzbq = (zzbq) this.zzaxd.remove(t);
            if (com_google_android_gms_wearable_internal_zzbq == null) {
                com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status.zzs(new Status(4002));
                return;
            }
            com_google_android_gms_wearable_internal_zzbq.clear();
            ((zzax) com_google_android_gms_wearable_internal_zzbp.zzqJ()).zza(new zzb(this.zzaxd, t, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), new RemoveListenerRequest(com_google_android_gms_wearable_internal_zzbq));
        }
    }

    public void zza(zzbp com_google_android_gms_wearable_internal_zzbp, com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, T t, zzbq<T> com_google_android_gms_wearable_internal_zzbq_T) throws RemoteException {
        synchronized (this.zzaxd) {
            if (this.zzaxd.get(t) != null) {
                com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status.zzs(new Status(4001));
                return;
            }
            this.zzaxd.put(t, com_google_android_gms_wearable_internal_zzbq_T);
            try {
                ((zzax) com_google_android_gms_wearable_internal_zzbp.zzqJ()).zza(new zza(this.zzaxd, t, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), new AddListenerRequest(com_google_android_gms_wearable_internal_zzbq_T));
            } catch (RemoteException e) {
                this.zzaxd.remove(t);
                throw e;
            }
        }
    }

    public void zzev(IBinder iBinder) {
        synchronized (this.zzaxd) {
            zzax zzeu = com.google.android.gms.wearable.internal.zzax.zza.zzeu(iBinder);
            zzav com_google_android_gms_wearable_internal_zzbo_zzo = new zzo();
            for (Entry entry : this.zzaxd.entrySet()) {
                zzbq com_google_android_gms_wearable_internal_zzbq = (zzbq) entry.getValue();
                try {
                    zzeu.zza(com_google_android_gms_wearable_internal_zzbo_zzo, new AddListenerRequest(com_google_android_gms_wearable_internal_zzbq));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzbq);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzbq);
                }
            }
        }
    }
}
