package com.google.android.gms.games.video;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class VideoRef extends zzc implements Video {
    VideoRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzyg();
    }

    public int getDuration() {
        return getInteger("duration");
    }

    public long getFileSize() {
        return getLong("filesize");
    }

    public String getPackageName() {
        return getString("package");
    }

    public long getStartTime() {
        return getLong("start_time");
    }

    public String toString() {
        return VideoEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((VideoEntity) zzyg()).writeToParcel(dest, flags);
    }

    public String zzxX() {
        return getString("filepath");
    }

    public Video zzyg() {
        return new VideoEntity(this);
    }
}
