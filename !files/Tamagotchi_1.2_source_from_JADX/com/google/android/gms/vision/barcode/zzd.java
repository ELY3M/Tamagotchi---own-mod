package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode.CalendarDateTime;
import com.google.android.gms.vision.barcode.Barcode.CalendarEvent;

public class zzd implements Creator<CalendarEvent> {
    static void zza(CalendarEvent calendarEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, calendarEvent.versionCode);
        zzb.zza(parcel, 2, calendarEvent.summary, false);
        zzb.zza(parcel, 3, calendarEvent.description, false);
        zzb.zza(parcel, 4, calendarEvent.location, false);
        zzb.zza(parcel, 5, calendarEvent.organizer, false);
        zzb.zza(parcel, 6, calendarEvent.status, false);
        zzb.zza(parcel, 7, calendarEvent.start, i, false);
        zzb.zza(parcel, 8, calendarEvent.end, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkw(i);
    }

    public CalendarEvent zzgZ(Parcel parcel) {
        CalendarDateTime calendarDateTime = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        CalendarDateTime calendarDateTime2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    calendarDateTime2 = (CalendarDateTime) zza.zza(parcel, zzat, CalendarDateTime.CREATOR);
                    break;
                case 8:
                    calendarDateTime = (CalendarDateTime) zza.zza(parcel, zzat, CalendarDateTime.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CalendarEvent(i, str5, str4, str3, str2, str, calendarDateTime2, calendarDateTime);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CalendarEvent[] zzkw(int i) {
        return new CalendarEvent[i];
    }
}
