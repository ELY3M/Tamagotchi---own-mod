package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.TransferProgressEvent;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzk;
import com.google.android.gms.drive.events.zzm;
import java.util.ArrayList;
import java.util.List;

public class zzae extends com.google.android.gms.drive.internal.zzao.zza {
    private final int zzanf;
    private final zzf zzarC;
    private final zza zzarD;
    private final List<Integer> zzarE = new ArrayList();

    private static class zza extends Handler {
        private final Context mContext;

        private zza(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        private static void zza(zzm com_google_android_gms_drive_events_zzm, QueryResultEventParcelable queryResultEventParcelable) {
            DataHolder zzsX = queryResultEventParcelable.zzsX();
            if (zzsX != null) {
                final MetadataBuffer metadataBuffer = new MetadataBuffer(zzsX);
                com_google_android_gms_drive_events_zzm.zza(new zzk() {
                });
            }
            if (queryResultEventParcelable.zzsY()) {
                com_google_android_gms_drive_events_zzm.zzcJ(queryResultEventParcelable.zzsZ());
            }
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    zzf com_google_android_gms_drive_events_zzf = (zzf) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            ((ChangeListener) com_google_android_gms_drive_events_zzf).onChange((ChangeEvent) driveEvent);
                            return;
                        case 2:
                            ((CompletionListener) com_google_android_gms_drive_events_zzf).onCompletion((CompletionEvent) driveEvent);
                            return;
                        case 3:
                            zza((zzm) com_google_android_gms_drive_events_zzf, (QueryResultEventParcelable) driveEvent);
                            return;
                        case 4:
                            ((zzc) com_google_android_gms_drive_events_zzf).zza((ChangesAvailableEvent) driveEvent);
                            return;
                        case 8:
                            ((zzi) com_google_android_gms_drive_events_zzf).zza(new com.google.android.gms.drive.events.internal.zza(((TransferProgressEvent) driveEvent).zzta()));
                            return;
                        default:
                            zzz.zzz("EventCallback", "Unexpected event: " + driveEvent);
                            return;
                    }
                default:
                    zzz.zze(this.mContext, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }

        public void zza(zzf com_google_android_gms_drive_events_zzf, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(com_google_android_gms_drive_events_zzf, driveEvent)));
        }
    }

    public zzae(Looper looper, Context context, int i, zzf com_google_android_gms_drive_events_zzf) {
        this.zzanf = i;
        this.zzarC = com_google_android_gms_drive_events_zzf;
        this.zzarD = new zza(looper, context);
    }

    public void zzc(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent zzts = onEventResponse.zzts();
        zzx.zzab(this.zzanf == zzts.getType());
        zzx.zzab(this.zzarE.contains(Integer.valueOf(zzts.getType())));
        this.zzarD.zza(this.zzarC, zzts);
    }

    public void zzdg(int i) {
        this.zzarE.add(Integer.valueOf(i));
    }

    public boolean zzdh(int i) {
        return this.zzarE.contains(Integer.valueOf(i));
    }
}
