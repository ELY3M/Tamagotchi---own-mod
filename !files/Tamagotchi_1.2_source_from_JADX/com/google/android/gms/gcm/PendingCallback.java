package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PendingCallback implements Parcelable {
    public static final Creator<PendingCallback> CREATOR = new C03351();
    final IBinder zzakD;

    static class C03351 implements Creator<PendingCallback> {
        C03351() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzeJ(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzhg(i);
        }

        public PendingCallback zzeJ(Parcel parcel) {
            return new PendingCallback(parcel);
        }

        public PendingCallback[] zzhg(int i) {
            return new PendingCallback[i];
        }
    }

    public PendingCallback(Parcel in) {
        this.zzakD = in.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getIBinder() {
        return this.zzakD;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzakD);
    }
}
