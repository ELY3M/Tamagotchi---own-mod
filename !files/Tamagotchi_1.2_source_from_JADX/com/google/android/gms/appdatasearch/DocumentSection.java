package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class DocumentSection implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public static final int zzTM = Integer.parseInt("-1");
    private static final RegisterSectionInfo zzTN = new zza("SsbContext").zzM(true).zzbB("blob").zzmh();
    final int mVersionCode;
    public final String zzTO;
    final RegisterSectionInfo zzTP;
    public final int zzTQ;
    public final byte[] zzTR;

    DocumentSection(int versionCode, String content, RegisterSectionInfo sectionInfo, int globalSearchSectionType, byte[] blobContent) {
        boolean z = globalSearchSectionType == zzTM || zzh.zzao(globalSearchSectionType) != null;
        zzx.zzb(z, "Invalid section type " + globalSearchSectionType);
        this.mVersionCode = versionCode;
        this.zzTO = content;
        this.zzTP = sectionInfo;
        this.zzTQ = globalSearchSectionType;
        this.zzTR = blobContent;
        String zzmf = zzmf();
        if (zzmf != null) {
            throw new IllegalArgumentException(zzmf);
        }
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo) {
        this(1, content, sectionInfo, zzTM, null);
    }

    public DocumentSection(String content, RegisterSectionInfo sectionInfo, String globalSearchSectionType) {
        this(1, content, sectionInfo, zzh.zzbA(globalSearchSectionType), null);
    }

    public DocumentSection(byte[] blobContent, RegisterSectionInfo sectionInfo) {
        this(1, null, sectionInfo, zzTM, blobContent);
    }

    public static DocumentSection zzh(byte[] bArr) {
        return new DocumentSection(bArr, zzTN);
    }

    public int describeContents() {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        zzd.zza(this, dest, flags);
    }

    public String zzmf() {
        return (this.zzTQ == zzTM || zzh.zzao(this.zzTQ) != null) ? (this.zzTO == null || this.zzTR == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.zzTQ;
    }
}
