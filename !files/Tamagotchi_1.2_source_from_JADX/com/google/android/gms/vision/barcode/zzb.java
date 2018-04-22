package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.vision.barcode.Barcode.CalendarEvent;
import com.google.android.gms.vision.barcode.Barcode.ContactInfo;
import com.google.android.gms.vision.barcode.Barcode.DriverLicense;
import com.google.android.gms.vision.barcode.Barcode.Email;
import com.google.android.gms.vision.barcode.Barcode.GeoPoint;
import com.google.android.gms.vision.barcode.Barcode.Phone;
import com.google.android.gms.vision.barcode.Barcode.Sms;
import com.google.android.gms.vision.barcode.Barcode.UrlBookmark;
import com.google.android.gms.vision.barcode.Barcode.WiFi;

public class zzb implements Creator<Barcode> {
    static void zza(Barcode barcode, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, barcode.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, barcode.format);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, barcode.rawValue, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, barcode.displayValue, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, barcode.valueFormat);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, barcode.cornerPoints, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, barcode.email, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, barcode.phone, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, barcode.sms, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, barcode.wifi, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, barcode.url, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, barcode.geoPoint, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, barcode.calendarEvent, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, barcode.contactInfo, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, barcode.driverLicense, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzku(i);
    }

    public Barcode zzgX(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        int i3 = 0;
        Point[] pointArr = null;
        Email email = null;
        Phone phone = null;
        Sms sms = null;
        WiFi wiFi = null;
        UrlBookmark urlBookmark = null;
        GeoPoint geoPoint = null;
        CalendarEvent calendarEvent = null;
        ContactInfo contactInfo = null;
        DriverLicense driverLicense = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    pointArr = (Point[]) zza.zzb(parcel, zzat, Point.CREATOR);
                    break;
                case 7:
                    email = (Email) zza.zza(parcel, zzat, Email.CREATOR);
                    break;
                case 8:
                    phone = (Phone) zza.zza(parcel, zzat, Phone.CREATOR);
                    break;
                case 9:
                    sms = (Sms) zza.zza(parcel, zzat, Sms.CREATOR);
                    break;
                case 10:
                    wiFi = (WiFi) zza.zza(parcel, zzat, WiFi.CREATOR);
                    break;
                case 11:
                    urlBookmark = (UrlBookmark) zza.zza(parcel, zzat, UrlBookmark.CREATOR);
                    break;
                case 12:
                    geoPoint = (GeoPoint) zza.zza(parcel, zzat, GeoPoint.CREATOR);
                    break;
                case 13:
                    calendarEvent = (CalendarEvent) zza.zza(parcel, zzat, CalendarEvent.CREATOR);
                    break;
                case 14:
                    contactInfo = (ContactInfo) zza.zza(parcel, zzat, (Creator) ContactInfo.CREATOR);
                    break;
                case 15:
                    driverLicense = (DriverLicense) zza.zza(parcel, zzat, (Creator) DriverLicense.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Barcode(i, i2, str, str2, i3, pointArr, email, phone, sms, wiFi, urlBookmark, geoPoint, calendarEvent, contactInfo, driverLicense);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Barcode[] zzku(int i) {
        return new Barcode[i];
    }
}
