package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.google.android.gms.tagmanager.zzm.zza;

@TargetApi(12)
class zzba<K, V> implements zzl<K, V> {
    private LruCache<K, V> zzbjq;

    zzba(int i, final zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        this.zzbjq = new LruCache<K, V>(this, i) {
            final /* synthetic */ zzba zzbjs;

            protected int sizeOf(K key, V value) {
                return com_google_android_gms_tagmanager_zzm_zza_K__V.sizeOf(key, value);
            }
        };
    }

    public V get(K key) {
        return this.zzbjq.get(key);
    }

    public void zzh(K k, V v) {
        this.zzbjq.put(k, v);
    }
}
