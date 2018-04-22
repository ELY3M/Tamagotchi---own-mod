package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.plus.PlusShare;
import java.util.List;
import java.util.zip.CRC32;

public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final DocumentId zzUs;
    final long zzUt;
    int zzUu;
    final DocumentContents zzUv;
    final boolean zzUw;
    int zzUx;
    int zzUy;
    public final String zzvp;

    public static final class zza {
        private String zzOJ;
        private DocumentId zzUs;
        private long zzUt = -1;
        private int zzUu = -1;
        private DocumentContents zzUv;
        private boolean zzUw = false;
        private int zzUx = -1;
        private int zzUy = 0;

        public zza zzO(boolean z) {
            this.zzUw = z;
            return this;
        }

        public zza zza(DocumentContents documentContents) {
            this.zzUv = documentContents;
            return this;
        }

        public zza zza(DocumentId documentId) {
            this.zzUs = documentId;
            return this;
        }

        public zza zzar(int i) {
            this.zzUu = i;
            return this;
        }

        public zza zzas(int i) {
            this.zzUy = i;
            return this;
        }

        public UsageInfo zzmi() {
            return new UsageInfo(this.zzUs, this.zzUt, this.zzUu, this.zzOJ, this.zzUv, this.zzUw, this.zzUx, this.zzUy);
        }

        public zza zzw(long j) {
            this.zzUt = j;
            return this;
        }
    }

    UsageInfo(int versionCode, DocumentId documentId, long timestamp, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this.mVersionCode = versionCode;
        this.zzUs = documentId;
        this.zzUt = timestamp;
        this.zzUu = usageType;
        this.zzvp = query;
        this.zzUv = document;
        this.zzUw = isDeviceOnly;
        this.zzUx = taskPosition;
        this.zzUy = eventStatus;
    }

    private UsageInfo(DocumentId documentId, long timestampMs, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this(1, documentId, timestampMs, usageType, query, document, isDeviceOnly, taskPosition, eventStatus);
    }

    public UsageInfo(String packageName, Intent viewIntent, String title, Uri webUrl, String schemaOrgType, List<AppIndexingLink> outLinks, int eventStatus) {
        this(1, zza(packageName, viewIntent), System.currentTimeMillis(), 0, null, zza(viewIntent, title, webUrl, schemaOrgType, outLinks).zzme(), false, -1, eventStatus);
    }

    public static com.google.android.gms.appdatasearch.DocumentContents.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        com.google.android.gms.appdatasearch.DocumentContents.zza com_google_android_gms_appdatasearch_DocumentContents_zza = new com.google.android.gms.appdatasearch.DocumentContents.zza();
        com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzbD(str));
        if (uri != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzi(uri));
        }
        if (list != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzs(list));
        }
        String action = intent.getAction();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzo("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzo("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzo("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzo("intent_extra_data", action));
            }
        }
        return com_google_android_gms_appdatasearch_DocumentContents_zza.zzbz(str2).zzL(true);
    }

    public static DocumentId zza(String str, Intent intent) {
        return zzn(str, zzg(intent));
    }

    private static DocumentSection zzbD(String str) {
        return new DocumentSection(str, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).zzap(1).zzN(true).zzbC("name").zzmh(), "text1");
    }

    private static String zzg(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection zzi(Uri uri) {
        return new DocumentSection(uri.toString(), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("web_url").zzap(4).zzM(true).zzbC(PlusShare.KEY_CALL_TO_ACTION_URL).zzmh());
    }

    private static DocumentId zzn(String str, String str2) {
        return new DocumentId(str, "", str2);
    }

    private static DocumentSection zzo(String str, String str2) {
        return new DocumentSection(str2, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(str).zzM(true).zzmh(), str);
    }

    private static DocumentSection zzs(List<AppIndexingLink> list) {
        zzsu com_google_android_gms_internal_zzpm_zza = new com.google.android.gms.internal.zzpm.zza();
        com.google.android.gms.internal.zzpm.zza.zza[] com_google_android_gms_internal_zzpm_zza_zzaArr = new com.google.android.gms.internal.zzpm.zza.zza[list.size()];
        for (int i = 0; i < com_google_android_gms_internal_zzpm_zza_zzaArr.length; i++) {
            com_google_android_gms_internal_zzpm_zza_zzaArr[i] = new com.google.android.gms.internal.zzpm.zza.zza();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            com_google_android_gms_internal_zzpm_zza_zzaArr[i].zzaMq = appIndexingLink.appIndexingUrl.toString();
            com_google_android_gms_internal_zzpm_zza_zzaArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                com_google_android_gms_internal_zzpm_zza_zzaArr[i].zzaMr = appIndexingLink.webUrl.toString();
            }
        }
        com_google_android_gms_internal_zzpm_zza.zzaMo = com_google_android_gms_internal_zzpm_zza_zzaArr;
        return new DocumentSection(zzsu.toByteArray(com_google_android_gms_internal_zzpm_zza), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("outlinks").zzM(true).zzbC(".private:outLinks").zzbB("blob").zzmh());
    }

    public int describeContents() {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.zzUs, Long.valueOf(this.zzUt), Integer.valueOf(this.zzUu), Integer.valueOf(this.zzUy)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        zzj.zza(this, dest, flags);
    }
}
