package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Creator<InstrumentInfo> CREATOR = new zzh();
    private final int mVersionCode;
    private String zzboI;
    private String zzboJ;

    InstrumentInfo(int versionCode, String instrumentType, String instrumentDetails) {
        this.mVersionCode = versionCode;
        this.zzboI = instrumentType;
        this.zzboJ = instrumentDetails;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.zzboJ;
    }

    public String getInstrumentType() {
        return this.zzboI;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }
}
