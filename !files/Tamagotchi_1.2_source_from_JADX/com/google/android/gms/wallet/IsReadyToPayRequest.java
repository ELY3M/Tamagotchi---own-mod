package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IsReadyToPayRequest implements SafeParcelable {
    public static final Creator<IsReadyToPayRequest> CREATOR = new zzi();
    final int mVersionCode;

    public final class zza {
        final /* synthetic */ IsReadyToPayRequest zzboK;

        private zza(IsReadyToPayRequest isReadyToPayRequest) {
            this.zzboK = isReadyToPayRequest;
        }

        public IsReadyToPayRequest zzIk() {
            return this.zzboK;
        }
    }

    IsReadyToPayRequest() {
        this.mVersionCode = 1;
    }

    IsReadyToPayRequest(int versionCode) {
        this.mVersionCode = versionCode;
    }

    public static zza zzIj() {
        IsReadyToPayRequest isReadyToPayRequest = new IsReadyToPayRequest();
        isReadyToPayRequest.getClass();
        return new zza();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi.zza(this, out, flags);
    }
}
