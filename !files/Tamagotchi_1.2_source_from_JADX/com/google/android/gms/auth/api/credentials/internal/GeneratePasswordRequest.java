package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GeneratePasswordRequest implements SafeParcelable {
    public static final Creator<GeneratePasswordRequest> CREATOR = new zzh();
    final int mVersionCode;
    private final PasswordSpecification zzVM;

    GeneratePasswordRequest(int version, PasswordSpecification passwordSpecification) {
        this.mVersionCode = version;
        this.zzVM = passwordSpecification;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }

    public PasswordSpecification zzmr() {
        return this.zzVM;
    }
}
