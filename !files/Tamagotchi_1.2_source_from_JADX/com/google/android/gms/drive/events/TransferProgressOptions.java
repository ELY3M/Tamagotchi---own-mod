package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public final class TransferProgressOptions implements SafeParcelable {
    public static final Creator<TransferProgressOptions> CREATOR = new zzo();
    final int mVersionCode;
    final int zzapT;

    TransferProgressOptions(int versionCode, int transferType) {
        this.mVersionCode = versionCode;
        this.zzapT = transferType;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        return zzw.equal(Integer.valueOf(this.zzapT), Integer.valueOf(((TransferProgressOptions) o).zzapT));
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzapT));
    }

    public String toString() {
        return String.format(Locale.US, "TransferProgressOptions[type=%d]", new Object[]{Integer.valueOf(this.zzapT)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}
