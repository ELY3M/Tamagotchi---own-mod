package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new zza();
    private final int mVersionCode;
    String zzJU;

    CountrySpecification(int versionCode, String countryCode) {
        this.mVersionCode = versionCode;
        this.zzJU = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.mVersionCode = 1;
        this.zzJU = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.zzJU;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
