package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.TransferProgressEvent;
import com.google.android.gms.drive.events.TransferStateEvent;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR = new zzba();
    final int mVersionCode;
    final int zzanf;
    final ChangeEvent zzasl;
    final CompletionEvent zzasm;
    final QueryResultEventParcelable zzasn;
    final ChangesAvailableEvent zzaso;
    final TransferStateEvent zzasp;
    final TransferProgressEvent zzasq;

    OnEventResponse(int versionCode, int eventType, ChangeEvent changeEvent, CompletionEvent completionEvent, QueryResultEventParcelable queryResultEvent, ChangesAvailableEvent changesAvailableEvent, TransferStateEvent transferStateEvent, TransferProgressEvent transferProgressEvent) {
        this.mVersionCode = versionCode;
        this.zzanf = eventType;
        this.zzasl = changeEvent;
        this.zzasm = completionEvent;
        this.zzasn = queryResultEvent;
        this.zzaso = changesAvailableEvent;
        this.zzasp = transferStateEvent;
        this.zzasq = transferProgressEvent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzba.zza(this, dest, flags);
    }

    public DriveEvent zzts() {
        switch (this.zzanf) {
            case 1:
                return this.zzasl;
            case 2:
                return this.zzasm;
            case 3:
                return this.zzasn;
            case 4:
                return this.zzaso;
            case 7:
                return this.zzasp;
            case 8:
                return this.zzasq;
            default:
                throw new IllegalStateException("Unexpected event type " + this.zzanf);
        }
    }
}
