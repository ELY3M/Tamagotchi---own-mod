package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<Response> {
    static void zza(Response response, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, response.mVersionCode);
        zzb.zza(parcel, 1, response.zzTY, i, false);
        zzb.zzc(parcel, 2, response.zzTZ, false);
        zzb.zza(parcel, 3, response.zzUa, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzan(i);
    }

    public Response[] zzan(int i) {
        return new Response[i];
    }

    public Response zzw(Parcel parcel) {
        String[] strArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        Status status = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            Status status2;
            String[] strArr2;
            List list2;
            int zzat = zza.zzat(parcel);
            String[] strArr3;
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = i;
                    List list3 = list;
                    status2 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    strArr2 = strArr;
                    list2 = list3;
                    break;
                case 2:
                    status2 = status;
                    i2 = i;
                    strArr3 = strArr;
                    Object zzc = zza.zzc(parcel, zzat, UsageInfo.CREATOR);
                    strArr2 = strArr3;
                    break;
                case 3:
                    strArr2 = zza.zzB(parcel, zzat);
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    strArr3 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzat);
                    strArr2 = strArr3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    strArr2 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            list = list2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == zzau) {
            return new Response(i, status, list, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
