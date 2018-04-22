package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.internal.zzpm.zzb;
import com.google.android.gms.internal.zzpm.zzc;
import com.google.android.gms.internal.zzpm.zzd;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.List;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;

public class zzkj {
    private static DocumentSection zza(String str, zzc com_google_android_gms_internal_zzpm_zzc) {
        return new DocumentSection(zzsu.toByteArray(com_google_android_gms_internal_zzpm_zzc), new zza(str).zzM(true).zzbC(str).zzbB("blob").zzmh());
    }

    public static UsageInfo zza(Action action, long j, String str, int i) {
        int i2;
        boolean z = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzmk());
        Bundle bundle2 = bundle.getBundle(TMXConstants.TAG_OBJECT);
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE);
        Intent zza = zzkk.zza(str, Uri.parse(bundle2.getString(PlusShare.KEY_CALL_TO_ACTION_URL)));
        DocumentContents.zza zza2 = UsageInfo.zza(zza, string, parse, string2, null);
        if (bundle.containsKey(".private:ssbContext")) {
            zza2.zza(DocumentSection.zzh(bundle.getByteArray(".private:ssbContext")));
            bundle.remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            zza2.zzb(new Account(bundle.getString(".private:accountName"), "com.google"));
            bundle.remove(".private:accountName");
        }
        if (bundle.containsKey(".private:isContextOnly") && bundle.getBoolean(".private:isContextOnly")) {
            i2 = 4;
            bundle.remove(".private:isContextOnly");
        } else {
            i2 = 0;
        }
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
        }
        zza2.zza(zza(".private:action", zzg(bundle)));
        return new UsageInfo.zza().zza(UsageInfo.zza(str, zza)).zzw(j).zzar(i2).zza(zza2.zzme()).zzO(z).zzas(i).zzmi();
    }

    private static zzb zzb(String str, Bundle bundle) {
        zzb com_google_android_gms_internal_zzpm_zzb = new zzb();
        com_google_android_gms_internal_zzpm_zzb.name = str;
        com_google_android_gms_internal_zzpm_zzb.zzaMt = new zzd();
        com_google_android_gms_internal_zzpm_zzb.zzaMt.zzaMy = zzg(bundle);
        return com_google_android_gms_internal_zzpm_zzb;
    }

    static zzc zzg(Bundle bundle) {
        List arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                arrayList.add(zzp(str, (String) obj));
            } else if (obj instanceof Bundle) {
                arrayList.add(zzb(str, (Bundle) obj));
            } else if (obj instanceof String[]) {
                for (String str2 : (String[]) obj) {
                    if (str2 != null) {
                        arrayList.add(zzp(str, str2));
                    }
                }
            } else if (obj instanceof Bundle[]) {
                for (Bundle bundle2 : (Bundle[]) obj) {
                    if (bundle2 != null) {
                        arrayList.add(zzb(str, bundle2));
                    }
                }
            } else if (obj instanceof Boolean) {
                arrayList.add(zzi(str, ((Boolean) obj).booleanValue()));
            } else {
                Log.e("SearchIndex", "Unsupported value: " + obj);
            }
        }
        zzc com_google_android_gms_internal_zzpm_zzc = new zzc();
        if (bundle.containsKey(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE)) {
            com_google_android_gms_internal_zzpm_zzc.type = bundle.getString(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE);
        }
        com_google_android_gms_internal_zzpm_zzc.zzaMu = (zzb[]) arrayList.toArray(new zzb[arrayList.size()]);
        return com_google_android_gms_internal_zzpm_zzc;
    }

    private static zzb zzi(String str, boolean z) {
        zzb com_google_android_gms_internal_zzpm_zzb = new zzb();
        com_google_android_gms_internal_zzpm_zzb.name = str;
        com_google_android_gms_internal_zzpm_zzb.zzaMt = new zzd();
        com_google_android_gms_internal_zzpm_zzb.zzaMt.zzaMv = z;
        return com_google_android_gms_internal_zzpm_zzb;
    }

    private static zzb zzp(String str, String str2) {
        zzb com_google_android_gms_internal_zzpm_zzb = new zzb();
        com_google_android_gms_internal_zzpm_zzb.name = str;
        com_google_android_gms_internal_zzpm_zzb.zzaMt = new zzd();
        com_google_android_gms_internal_zzpm_zzb.zzaMt.zzamJ = str2;
        return com_google_android_gms_internal_zzpm_zzb;
    }
}
