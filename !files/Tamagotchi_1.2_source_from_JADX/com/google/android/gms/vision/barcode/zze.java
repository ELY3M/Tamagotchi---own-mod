package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode.Address;
import com.google.android.gms.vision.barcode.Barcode.ContactInfo;
import com.google.android.gms.vision.barcode.Barcode.Email;
import com.google.android.gms.vision.barcode.Barcode.PersonName;
import com.google.android.gms.vision.barcode.Barcode.Phone;

public class zze implements Creator<ContactInfo> {
    static void zza(ContactInfo contactInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, contactInfo.versionCode);
        zzb.zza(parcel, 2, contactInfo.name, i, false);
        zzb.zza(parcel, 3, contactInfo.organization, false);
        zzb.zza(parcel, 4, contactInfo.title, false);
        zzb.zza(parcel, 5, contactInfo.phones, i, false);
        zzb.zza(parcel, 6, contactInfo.emails, i, false);
        zzb.zza(parcel, 7, contactInfo.urls, false);
        zzb.zza(parcel, 8, contactInfo.addresses, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzha(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkx(i);
    }

    public ContactInfo zzha(Parcel parcel) {
        Address[] addressArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String[] strArr = null;
        Email[] emailArr = null;
        Phone[] phoneArr = null;
        String str = null;
        String str2 = null;
        PersonName personName = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    personName = (PersonName) zza.zza(parcel, zzat, PersonName.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    phoneArr = (Phone[]) zza.zzb(parcel, zzat, Phone.CREATOR);
                    break;
                case 6:
                    emailArr = (Email[]) zza.zzb(parcel, zzat, Email.CREATOR);
                    break;
                case 7:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                case 8:
                    addressArr = (Address[]) zza.zzb(parcel, zzat, Address.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ContactInfo(i, personName, str2, str, phoneArr, emailArr, strArr, addressArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ContactInfo[] zzkx(int i) {
        return new ContactInfo[i];
    }
}
