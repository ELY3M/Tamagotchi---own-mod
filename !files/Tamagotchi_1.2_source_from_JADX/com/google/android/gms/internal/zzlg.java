package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zzlg implements zzlf {
    protected final Activity mActivity;
    private String zzWP;
    private String zzXT;
    protected final Set<String> zzXf;
    private zza zzYe;

    protected zzlg(Activity activity, List<String> list, List<String> list2) {
        this.mActivity = (Activity) zzx.zzz(activity);
        Set hashSet = new HashSet((Collection) zzx.zzz(list));
        hashSet.addAll((Collection) zzx.zzz(list2));
        this.zzXf = Collections.unmodifiableSet(hashSet);
    }

    protected Intent zza(IdpTokenType idpTokenType, String str, String str2) {
        zzx.zzz(idpTokenType);
        zzx.zzcM(str);
        Intent intent = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent.putExtra("idpTokenType", idpTokenType);
        intent.putExtra("idpToken", str);
        intent.putExtra("pendingToken", str2);
        zzd zzmU = zzmU();
        if (zzmU != null) {
            intent.putExtra("idProvider", zzmU.zzmT());
        }
        return intent;
    }

    protected void zzb(zza com_google_android_gms_internal_zzlf_zza) {
        this.zzYe = (zza) zzx.zzz(com_google_android_gms_internal_zzlf_zza);
    }

    protected void zzb(String str, String str2, zza com_google_android_gms_internal_zzlf_zza) {
        zzbW(str);
        zzbX(str2);
        zzb(com_google_android_gms_internal_zzlf_zza);
    }

    protected void zzbW(String str) {
        this.zzWP = str;
    }

    protected void zzbX(String str) {
        this.zzXT = str;
    }

    protected Set<String> zzns() {
        return this.zzXf;
    }

    protected zza zznt() {
        return this.zzYe;
    }

    protected String zznu() {
        return this.zzXT;
    }
}
