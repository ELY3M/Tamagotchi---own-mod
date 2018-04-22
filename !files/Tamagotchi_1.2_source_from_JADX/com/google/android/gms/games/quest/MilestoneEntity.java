package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final Creator<MilestoneEntity> CREATOR = new MilestoneEntityCreator();
    private final int mState;
    private final int mVersionCode;
    private final String zzaDU;
    private final String zzaFd;
    private final long zzaKt;
    private final long zzaKu;
    private final byte[] zzaKv;

    MilestoneEntity(int versionCode, String milestoneId, long currentProgress, long targetProgress, byte[] completionBlob, int state, String eventId) {
        this.mVersionCode = versionCode;
        this.zzaFd = milestoneId;
        this.zzaKt = currentProgress;
        this.zzaKu = targetProgress;
        this.zzaKv = completionBlob;
        this.mState = state;
        this.zzaDU = eventId;
    }

    public MilestoneEntity(Milestone milestone) {
        this.mVersionCode = 4;
        this.zzaFd = milestone.getMilestoneId();
        this.zzaKt = milestone.getCurrentProgress();
        this.zzaKu = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.zzaDU = milestone.getEventId();
        Object completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.zzaKv = null;
            return;
        }
        this.zzaKv = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.zzaKv, 0, completionRewardData.length);
    }

    static int zza(Milestone milestone) {
        return zzw.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean zza(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return zzw.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && zzw.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && zzw.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && zzw.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && zzw.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String zzb(Milestone milestone) {
        return zzw.zzy(milestone).zzg("MilestoneId", milestone.getMilestoneId()).zzg("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).zzg("TargetProgress", Long.valueOf(milestone.getTargetProgress())).zzg("State", Integer.valueOf(milestone.getState())).zzg("CompletionRewardData", milestone.getCompletionRewardData()).zzg("EventId", milestone.getEventId()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.zzaKv;
    }

    public long getCurrentProgress() {
        return this.zzaKt;
    }

    public String getEventId() {
        return this.zzaDU;
    }

    public String getMilestoneId() {
        return this.zzaFd;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.zzaKu;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MilestoneEntityCreator.zza(this, out, flags);
    }
}
