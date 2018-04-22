package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<SharedContent> {
    static void zza(SharedContent sharedContent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, sharedContent.getVersionCode());
        zzb.zza(parcel, 3, sharedContent.getUri(), false);
        zzb.zza(parcel, 8, sharedContent.zzEL(), i, false);
        zzb.zza(parcel, 9, sharedContent.zzEM(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjy(i);
    }

    public SharedContent zzgs(Parcel parcel) {
        LocalContent[] localContentArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        ViewableItem[] viewableItemArr = null;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            ViewableItem[] viewableItemArr2;
            String str2;
            int zzg;
            LocalContent[] localContentArr2;
            int zzat = zza.zzat(parcel);
            LocalContent[] localContentArr3;
            switch (zza.zzca(zzat)) {
                case 1:
                    localContentArr3 = localContentArr;
                    viewableItemArr2 = viewableItemArr;
                    str2 = str;
                    zzg = zza.zzg(parcel, zzat);
                    localContentArr2 = localContentArr3;
                    break;
                case 3:
                    zzg = i;
                    ViewableItem[] viewableItemArr3 = viewableItemArr;
                    str2 = zza.zzp(parcel, zzat);
                    localContentArr2 = localContentArr;
                    viewableItemArr2 = viewableItemArr3;
                    break;
                case 8:
                    str2 = str;
                    zzg = i;
                    localContentArr3 = localContentArr;
                    viewableItemArr2 = (ViewableItem[]) zza.zzb(parcel, zzat, ViewableItem.CREATOR);
                    localContentArr2 = localContentArr3;
                    break;
                case 9:
                    localContentArr2 = (LocalContent[]) zza.zzb(parcel, zzat, LocalContent.CREATOR);
                    viewableItemArr2 = viewableItemArr;
                    str2 = str;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    localContentArr2 = localContentArr;
                    viewableItemArr2 = viewableItemArr;
                    str2 = str;
                    zzg = i;
                    break;
            }
            i = zzg;
            str = str2;
            viewableItemArr = viewableItemArr2;
            localContentArr = localContentArr2;
        }
        if (parcel.dataPosition() == zzau) {
            return new SharedContent(i, str, viewableItemArr, localContentArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SharedContent[] zzjy(int i) {
        return new SharedContent[i];
    }
}
