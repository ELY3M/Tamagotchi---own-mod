package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzk {
    private final Map<zzd, zzlf> zzXD;

    public zzk(Activity activity, List<zzd> list, Map<zzd, List<String>> map) {
        zzx.zzz(activity);
        zzx.zzz(list);
        zzx.zzz(map);
        Map hashMap = new HashMap();
        for (zzd com_google_android_gms_auth_api_signin_zzd : list) {
            List list2 = (List) map.get(com_google_android_gms_auth_api_signin_zzd);
            if (list2 == null) {
                list2 = Collections.emptyList();
            }
            zzlf zza = zza(com_google_android_gms_auth_api_signin_zzd, activity, list2);
            if (zza != null) {
                hashMap.put(com_google_android_gms_auth_api_signin_zzd, zza);
            }
        }
        this.zzXD = Collections.unmodifiableMap(hashMap);
    }

    private zzlf zza(zzd com_google_android_gms_auth_api_signin_zzd, Activity activity, List<String> list) {
        return zzd.FACEBOOK.equals(com_google_android_gms_auth_api_signin_zzd) ? new zzlh(activity, list) : null;
    }

    public zzlf zza(zzd com_google_android_gms_auth_api_signin_zzd) {
        zzx.zzz(com_google_android_gms_auth_api_signin_zzd);
        return (zzlf) this.zzXD.get(com_google_android_gms_auth_api_signin_zzd);
    }

    public Collection<zzlf> zznh() {
        return this.zzXD.values();
    }
}
