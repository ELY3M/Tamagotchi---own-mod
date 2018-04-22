package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzi {
    public static void zza(SignInConfiguration signInConfiguration, List<zzd> list, Map<zzd, List<String>> map) {
        zzx.zzz(signInConfiguration);
        zzx.zzz(list);
        zzx.zzz(map);
        GoogleSignInOptions zznm = signInConfiguration.zznm();
        if (zznm != null) {
            list.add(zzd.GOOGLE);
            List linkedList = new LinkedList();
            Iterator it = zznm.zzmN().iterator();
            while (it.hasNext()) {
                linkedList.add(((Scope) it.next()).zzpb());
            }
            map.put(zzd.GOOGLE, linkedList);
        }
    }
}
