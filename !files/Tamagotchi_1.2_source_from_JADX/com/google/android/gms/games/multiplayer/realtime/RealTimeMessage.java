package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new C03271();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzaJR;
    private final byte[] zzaJS;
    private final int zzaJT;

    static class C03271 implements Creator<RealTimeMessage> {
        C03271() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzeu(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzgK(i);
        }

        public RealTimeMessage zzeu(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        public RealTimeMessage[] zzgK(int i) {
            return new RealTimeMessage[i];
        }
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.zzaJR = (String) zzx.zzz(senderParticipantId);
        this.zzaJS = (byte[]) ((byte[]) zzx.zzz(messageData)).clone();
        this.zzaJT = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.zzaJS;
    }

    public String getSenderParticipantId() {
        return this.zzaJR;
    }

    public boolean isReliable() {
        return this.zzaJT == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.zzaJR);
        parcel.writeByteArray(this.zzaJS);
        parcel.writeInt(this.zzaJT);
    }
}
