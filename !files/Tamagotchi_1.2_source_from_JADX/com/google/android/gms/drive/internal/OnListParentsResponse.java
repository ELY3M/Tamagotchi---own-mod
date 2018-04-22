package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListParentsResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Creator<OnListParentsResponse> CREATOR = new zzbd();
    final int mVersionCode;
    final DataHolder zzast;

    OnListParentsResponse(int versionCode, DataHolder parents) {
        this.mVersionCode = versionCode;
        this.zzast = parents;
    }

    public int describeContents() {
        return 0;
    }

    protected void zzJ(Parcel parcel, int i) {
        zzbd.zza(this, parcel, i);
    }

    public DataHolder zztv() {
        return this.zzast;
    }
}
