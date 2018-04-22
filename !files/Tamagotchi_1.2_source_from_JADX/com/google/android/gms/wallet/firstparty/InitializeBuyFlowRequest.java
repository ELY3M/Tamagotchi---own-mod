package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class InitializeBuyFlowRequest implements SafeParcelable {
    public static final Creator<InitializeBuyFlowRequest> CREATOR = new zzf();
    private final int mVersionCode;
    byte[][] zzbpV;

    InitializeBuyFlowRequest(int versionCode, byte[][] purchaseContextProtos) {
        this.mVersionCode = versionCode;
        this.zzbpV = purchaseContextProtos;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }
}
