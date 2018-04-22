package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<ParcelableEvent> {
    static void zza(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableEvent.mVersionCode);
        zzb.zza(parcel, 2, parcelableEvent.zzLq, false);
        zzb.zza(parcel, 3, parcelableEvent.zzrG, false);
        zzb.zzb(parcel, 4, parcelableEvent.zzauR, false);
        zzb.zza(parcel, 5, parcelableEvent.zzauS);
        zzb.zza(parcel, 6, parcelableEvent.zzauL, false);
        zzb.zza(parcel, 7, parcelableEvent.zzauV, false);
        zzb.zza(parcel, 8, parcelableEvent.zzauW, i, false);
        zzb.zza(parcel, 9, parcelableEvent.zzauX, i, false);
        zzb.zza(parcel, 10, parcelableEvent.zzauY, i, false);
        zzb.zza(parcel, 11, parcelableEvent.zzauZ, i, false);
        zzb.zza(parcel, 12, parcelableEvent.zzava, i, false);
        zzb.zza(parcel, 13, parcelableEvent.zzavb, i, false);
        zzb.zza(parcel, 14, parcelableEvent.zzavc, i, false);
        zzb.zza(parcel, 15, parcelableEvent.zzavd, i, false);
        zzb.zza(parcel, 17, parcelableEvent.zzauU);
        zzb.zza(parcel, 16, parcelableEvent.zzauT);
        zzb.zza(parcel, 18, parcelableEvent.zzave, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeA(i);
    }

    public ParcelableEvent zzcE(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        FieldChangedDetails fieldChangedDetails = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    list = zza.zzD(parcel, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    textInsertedDetails = (TextInsertedDetails) zza.zza(parcel, zzat, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    textDeletedDetails = (TextDeletedDetails) zza.zza(parcel, zzat, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    valuesAddedDetails = (ValuesAddedDetails) zza.zza(parcel, zzat, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    valuesRemovedDetails = (ValuesRemovedDetails) zza.zza(parcel, zzat, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    valuesSetDetails = (ValuesSetDetails) zza.zza(parcel, zzat, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    valueChangedDetails = (ValueChangedDetails) zza.zza(parcel, zzat, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    referenceShiftedDetails = (ReferenceShiftedDetails) zza.zza(parcel, zzat, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    objectChangedDetails = (ObjectChangedDetails) zza.zza(parcel, zzat, ObjectChangedDetails.CREATOR);
                    break;
                case 16:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 17:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 18:
                    fieldChangedDetails = (FieldChangedDetails) zza.zza(parcel, zzat, FieldChangedDetails.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableEvent(i, str, str2, list, z, z2, z3, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails, fieldChangedDetails);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ParcelableEvent[] zzeA(int i) {
        return new ParcelableEvent[i];
    }
}
