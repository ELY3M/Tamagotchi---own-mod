package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.zzc.zza;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import org.anddev.andengine.extension.svg.util.constants.ISVGConstants;

public class zzbp extends zzj<zzax> {
    private final ExecutorService zzbkn = Executors.newCachedThreadPool();
    private final zzay<zza> zzbte = new zzay();
    private final zzay<com.google.android.gms.wearable.zza.zza> zzbtf = new zzay();
    private final zzay<ChannelListener> zzbtg = new zzay();
    private final zzay<DataListener> zzbth = new zzay();
    private final zzay<MessageListener> zzbti = new zzay();
    private final zzay<NodeListener> zzbtj = new zzay();
    private final zzay<NodeApi.zza> zzbtk = new zzay();
    private final zzay<CapabilityListener> zzbtl = new zzay();

    public zzbp(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 14, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    private FutureTask<Boolean> zza(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask(new Callable<Boolean>(this) {
            final /* synthetic */ zzbp zzbtn;

            public /* synthetic */ Object call() throws Exception {
                return zzvt();
            }

            public java.lang.Boolean zzvt() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00bf in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r1 = 3;
                r0 = "WearableClient";
                r0 = android.util.Log.isLoggable(r0, r1);
                if (r0 == 0) goto L_0x0023;
            L_0x0009:
                r0 = "WearableClient";
                r1 = new java.lang.StringBuilder;
                r1.<init>();
                r2 = "processAssets: writing data to FD : ";
                r1 = r1.append(r2);
                r2 = r3;
                r1 = r1.append(r2);
                r1 = r1.toString();
                android.util.Log.d(r0, r1);
            L_0x0023:
                r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream;
                r0 = r3;
                r1.<init>(r0);
                r0 = r4;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r1.write(r0);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r1.flush();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = 3;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                if (r0 == 0) goto L_0x0055;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            L_0x003b:
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2.<init>();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = "processAssets: wrote data: ";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = r3;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.toString();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                android.util.Log.d(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
            L_0x0055:
                r0 = 1;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f4 }
                r3 = 3;	 Catch:{ IOException -> 0x00f4 }
                r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00f4 }
                if (r2 == 0) goto L_0x007d;	 Catch:{ IOException -> 0x00f4 }
            L_0x0063:
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f4 }
                r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f4 }
                r3.<init>();	 Catch:{ IOException -> 0x00f4 }
                r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00f4 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f4 }
                r4 = r3;	 Catch:{ IOException -> 0x00f4 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f4 }
                r3 = r3.toString();	 Catch:{ IOException -> 0x00f4 }
                android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00f4 }
            L_0x007d:
                r1.close();	 Catch:{ IOException -> 0x00f4 }
            L_0x0080:
                return r0;
            L_0x0081:
                r0 = move-exception;
                r0 = "WearableClient";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2.<init>();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = "processAssets: writing data failed: ";	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r3 = r3;	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.append(r3);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r2 = r2.toString();	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                android.util.Log.w(r0, r2);	 Catch:{ IOException -> 0x0081, all -> 0x00c8 }
                r0 = "WearableClient";
                r2 = 3;
                r0 = android.util.Log.isLoggable(r0, r2);
                if (r0 == 0) goto L_0x00bf;
            L_0x00a5:
                r0 = "WearableClient";
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r3 = "processAssets: closing: ";
                r2 = r2.append(r3);
                r3 = r3;
                r2 = r2.append(r3);
                r2 = r2.toString();
                android.util.Log.d(r0, r2);
            L_0x00bf:
                r1.close();
            L_0x00c2:
                r0 = 0;
                r0 = java.lang.Boolean.valueOf(r0);
                goto L_0x0080;
            L_0x00c8:
                r0 = move-exception;
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f0 }
                r3 = 3;	 Catch:{ IOException -> 0x00f0 }
                r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00f0 }
                if (r2 == 0) goto L_0x00ec;	 Catch:{ IOException -> 0x00f0 }
            L_0x00d2:
                r2 = "WearableClient";	 Catch:{ IOException -> 0x00f0 }
                r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00f0 }
                r3.<init>();	 Catch:{ IOException -> 0x00f0 }
                r4 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00f0 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f0 }
                r4 = r3;	 Catch:{ IOException -> 0x00f0 }
                r3 = r3.append(r4);	 Catch:{ IOException -> 0x00f0 }
                r3 = r3.toString();	 Catch:{ IOException -> 0x00f0 }
                android.util.Log.d(r2, r3);	 Catch:{ IOException -> 0x00f0 }
            L_0x00ec:
                r1.close();	 Catch:{ IOException -> 0x00f0 }
            L_0x00ef:
                throw r0;
            L_0x00f0:
                r1 = move-exception;
                goto L_0x00ef;
            L_0x00f2:
                r0 = move-exception;
                goto L_0x00c2;
            L_0x00f4:
                r1 = move-exception;
                goto L_0x0080;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzbp.1.zzvt():java.lang.Boolean");
            }
        });
    }

    private Runnable zzb(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str, Uri uri, long j, long j2) {
        zzx.zzz(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        zzx.zzz(str);
        zzx.zzz(uri);
        zzx.zzb(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        zzx.zzb(j2 >= -1, "invalid length: %s", Long.valueOf(j2));
        final Uri uri2 = uri;
        final zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status2 = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
        final String str2 = str;
        final long j3 = j;
        final long j4 = j2;
        return new Runnable(this) {
            final /* synthetic */ zzbp zzbtn;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r8 = this;
                r0 = "WearableClient";
                r1 = 2;
                r0 = android.util.Log.isLoggable(r0, r1);
                if (r0 == 0) goto L_0x0010;
            L_0x0009:
                r0 = "WearableClient";
                r1 = "Executing sendFileToChannelTask";
                android.util.Log.v(r0, r1);
            L_0x0010:
                r0 = "file";
                r1 = r3;
                r1 = r1.getScheme();
                r0 = r0.equals(r1);
                if (r0 != 0) goto L_0x0034;
            L_0x001e:
                r0 = "WearableClient";
                r1 = "Channel.sendFile used with non-file URI";
                android.util.Log.w(r0, r1);
                r0 = r4;
                r1 = new com.google.android.gms.common.api.Status;
                r2 = 10;
                r3 = "Channel.sendFile used with non-file URI";
                r1.<init>(r2, r3);
                r0.zzw(r1);
            L_0x0033:
                return;
            L_0x0034:
                r0 = new java.io.File;
                r1 = r3;
                r1 = r1.getPath();
                r0.<init>(r1);
                r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
                r3 = android.os.ParcelFileDescriptor.open(r0, r1);	 Catch:{ FileNotFoundException -> 0x006a }
                r0 = r8.zzbtn;	 Catch:{ RemoteException -> 0x0090 }
                r0 = r0.zzqJ();	 Catch:{ RemoteException -> 0x0090 }
                r0 = (com.google.android.gms.wearable.internal.zzax) r0;	 Catch:{ RemoteException -> 0x0090 }
                r1 = new com.google.android.gms.wearable.internal.zzbo$zzr;	 Catch:{ RemoteException -> 0x0090 }
                r2 = r4;	 Catch:{ RemoteException -> 0x0090 }
                r1.<init>(r2);	 Catch:{ RemoteException -> 0x0090 }
                r2 = r5;	 Catch:{ RemoteException -> 0x0090 }
                r4 = r6;	 Catch:{ RemoteException -> 0x0090 }
                r6 = r8;	 Catch:{ RemoteException -> 0x0090 }
                r0.zza(r1, r2, r3, r4, r6);	 Catch:{ RemoteException -> 0x0090 }
                r3.close();	 Catch:{ IOException -> 0x0061 }
                goto L_0x0033;
            L_0x0061:
                r0 = move-exception;
                r1 = "WearableClient";
                r2 = "Failed to close sourceFd";
                android.util.Log.w(r1, r2, r0);
                goto L_0x0033;
            L_0x006a:
                r1 = move-exception;
                r1 = "WearableClient";
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r3 = "File couldn't be opened for Channel.sendFile: ";
                r2 = r2.append(r3);
                r0 = r2.append(r0);
                r0 = r0.toString();
                android.util.Log.w(r1, r0);
                r0 = r4;
                r1 = new com.google.android.gms.common.api.Status;
                r2 = 13;
                r1.<init>(r2);
                r0.zzw(r1);
                goto L_0x0033;
            L_0x0090:
                r0 = move-exception;
                r1 = "WearableClient";
                r2 = "Channel.sendFile failed.";
                android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x00b1 }
                r0 = r4;	 Catch:{ all -> 0x00b1 }
                r1 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x00b1 }
                r2 = 8;
                r1.<init>(r2);	 Catch:{ all -> 0x00b1 }
                r0.zzw(r1);	 Catch:{ all -> 0x00b1 }
                r3.close();	 Catch:{ IOException -> 0x00a8 }
                goto L_0x0033;
            L_0x00a8:
                r0 = move-exception;
                r1 = "WearableClient";
                r2 = "Failed to close sourceFd";
                android.util.Log.w(r1, r2, r0);
                goto L_0x0033;
            L_0x00b1:
                r0 = move-exception;
                r3.close();	 Catch:{ IOException -> 0x00b6 }
            L_0x00b5:
                throw r0;
            L_0x00b6:
                r1 = move-exception;
                r2 = "WearableClient";
                r3 = "Failed to close sourceFd";
                android.util.Log.w(r2, r3, r1);
                goto L_0x00b5;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzbp.3.run():void");
            }
        };
    }

    private Runnable zzb(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str, Uri uri, boolean z) {
        zzx.zzz(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        zzx.zzz(str);
        zzx.zzz(uri);
        final Uri uri2 = uri;
        final zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status2 = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status;
        final boolean z2 = z;
        final String str2 = str;
        return new Runnable(this) {
            final /* synthetic */ zzbp zzbtn;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r4 = this;
                r0 = "WearableClient";
                r1 = 2;
                r0 = android.util.Log.isLoggable(r0, r1);
                if (r0 == 0) goto L_0x0010;
            L_0x0009:
                r0 = "WearableClient";
                r1 = "Executing receiveFileFromChannelTask";
                android.util.Log.v(r0, r1);
            L_0x0010:
                r0 = "file";
                r1 = r2;
                r1 = r1.getScheme();
                r0 = r0.equals(r1);
                if (r0 != 0) goto L_0x0034;
            L_0x001e:
                r0 = "WearableClient";
                r1 = "Channel.receiveFile used with non-file URI";
                android.util.Log.w(r0, r1);
                r0 = r3;
                r1 = new com.google.android.gms.common.api.Status;
                r2 = 10;
                r3 = "Channel.receiveFile used with non-file URI";
                r1.<init>(r2, r3);
                r0.zzw(r1);
            L_0x0033:
                return;
            L_0x0034:
                r1 = new java.io.File;
                r0 = r2;
                r0 = r0.getPath();
                r1.<init>(r0);
                r2 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
                r0 = r4;
                if (r0 == 0) goto L_0x006d;
            L_0x0045:
                r0 = 33554432; // 0x2000000 float:9.403955E-38 double:1.6578092E-316;
            L_0x0047:
                r0 = r0 | r2;
                r1 = android.os.ParcelFileDescriptor.open(r1, r0);	 Catch:{ FileNotFoundException -> 0x006f }
                r0 = r4.zzbtn;	 Catch:{ RemoteException -> 0x0095 }
                r0 = r0.zzqJ();	 Catch:{ RemoteException -> 0x0095 }
                r0 = (com.google.android.gms.wearable.internal.zzax) r0;	 Catch:{ RemoteException -> 0x0095 }
                r2 = new com.google.android.gms.wearable.internal.zzbo$zzu;	 Catch:{ RemoteException -> 0x0095 }
                r3 = r3;	 Catch:{ RemoteException -> 0x0095 }
                r2.<init>(r3);	 Catch:{ RemoteException -> 0x0095 }
                r3 = r5;	 Catch:{ RemoteException -> 0x0095 }
                r0.zza(r2, r3, r1);	 Catch:{ RemoteException -> 0x0095 }
                r1.close();	 Catch:{ IOException -> 0x0064 }
                goto L_0x0033;
            L_0x0064:
                r0 = move-exception;
                r1 = "WearableClient";
                r2 = "Failed to close targetFd";
                android.util.Log.w(r1, r2, r0);
                goto L_0x0033;
            L_0x006d:
                r0 = 0;
                goto L_0x0047;
            L_0x006f:
                r0 = move-exception;
                r0 = "WearableClient";
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r3 = "File couldn't be opened for Channel.receiveFile: ";
                r2 = r2.append(r3);
                r1 = r2.append(r1);
                r1 = r1.toString();
                android.util.Log.w(r0, r1);
                r0 = r3;
                r1 = new com.google.android.gms.common.api.Status;
                r2 = 13;
                r1.<init>(r2);
                r0.zzw(r1);
                goto L_0x0033;
            L_0x0095:
                r0 = move-exception;
                r2 = "WearableClient";
                r3 = "Channel.receiveFile failed.";
                android.util.Log.w(r2, r3, r0);	 Catch:{ all -> 0x00b7 }
                r0 = r3;	 Catch:{ all -> 0x00b7 }
                r2 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x00b7 }
                r3 = 8;
                r2.<init>(r3);	 Catch:{ all -> 0x00b7 }
                r0.zzw(r2);	 Catch:{ all -> 0x00b7 }
                r1.close();	 Catch:{ IOException -> 0x00ad }
                goto L_0x0033;
            L_0x00ad:
                r0 = move-exception;
                r1 = "WearableClient";
                r2 = "Failed to close targetFd";
                android.util.Log.w(r1, r2, r0);
                goto L_0x0033;
            L_0x00b7:
                r0 = move-exception;
                r1.close();	 Catch:{ IOException -> 0x00bc }
            L_0x00bb:
                throw r0;
            L_0x00bc:
                r1 = move-exception;
                r2 = "WearableClient";
                r3 = "Failed to close targetFd";
                android.util.Log.w(r2, r3, r1);
                goto L_0x00bb;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzbp.2.run():void");
            }
        };
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzew(iBinder);
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.zzbte.zzev(iBinder);
            this.zzbtf.zzev(iBinder);
            this.zzbtg.zzev(iBinder);
            this.zzbth.zzev(iBinder);
            this.zzbti.zzev(iBinder);
            this.zzbtj.zzev(iBinder);
            this.zzbtk.zzev(iBinder);
            this.zzbtl.zzev(iBinder);
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(zzb<DataItemResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, Uri uri) throws RemoteException {
        ((zzax) zzqJ()).zza(new zzk(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult), uri);
    }

    public void zza(zzb<DataItemBuffer> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataItemBuffer, Uri uri, int i) throws RemoteException {
        ((zzax) zzqJ()).zza(new zzl(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataItemBuffer), uri, i);
    }

    public void zza(zzb<GetFdForAssetResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult, Asset asset) throws RemoteException {
        ((zzax) zzqJ()).zza(new zzm(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult), asset);
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, CapabilityListener capabilityListener) throws RemoteException {
        this.zzbtl.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, capabilityListener);
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, CapabilityListener capabilityListener, zzq<CapabilityListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_CapabilityApi_CapabilityListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbtl.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, capabilityListener, zzbq.zze(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_CapabilityApi_CapabilityListener, intentFilterArr));
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, ChannelListener channelListener, zzq<ChannelListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener, String str, IntentFilter[] intentFilterArr) throws RemoteException {
        if (str == null) {
            this.zzbtg.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, channelListener, zzbq.zzd(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener, intentFilterArr));
            return;
        }
        this.zzbtg.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, new zzbj(str, channelListener), zzbq.zza(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_ChannelApi_ChannelListener, str, intentFilterArr));
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, ChannelListener channelListener, String str) throws RemoteException {
        if (str == null) {
            this.zzbtg.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, channelListener);
            return;
        }
        this.zzbtg.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, new zzbj(str, channelListener));
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, DataListener dataListener) throws RemoteException {
        this.zzbth.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, dataListener);
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, DataListener dataListener, zzq<DataListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_DataApi_DataListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbth.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, dataListener, zzbq.zza(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_DataApi_DataListener, intentFilterArr));
    }

    public void zza(zzb<GetFdForAssetResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult, DataItemAsset dataItemAsset) throws RemoteException {
        zza((zzb) com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, MessageListener messageListener) throws RemoteException {
        this.zzbti.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, messageListener);
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, MessageListener messageListener, zzq<MessageListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_MessageApi_MessageListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbti.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, messageListener, zzbq.zzb(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_MessageApi_MessageListener, intentFilterArr));
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, NodeListener nodeListener) throws RemoteException {
        this.zzbtj.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, nodeListener);
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, NodeListener nodeListener, zzq<NodeListener> com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_NodeApi_NodeListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbtj.zza(this, com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, nodeListener, zzbq.zzc(com_google_android_gms_common_api_internal_zzq_com_google_android_gms_wearable_NodeApi_NodeListener, intentFilterArr));
    }

    public void zza(zzb<DataItemResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, PutDataRequest putDataRequest) throws RemoteException {
        for (Entry value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest zzr = PutDataRequest.zzr(putDataRequest.getUri());
        zzr.setData(putDataRequest.getData());
        if (putDataRequest.isUrgent()) {
            zzr.setUrgent();
        }
        List arrayList = new ArrayList();
        for (Entry value2 : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) value2.getValue();
            if (asset2.getData() != null) {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    zzr.putAsset((String) value2.getKey(), Asset.createFromFd(createPipe[0]));
                    Runnable zza = zza(createPipe[1], asset2.getData());
                    arrayList.add(zza);
                    this.zzbkn.submit(zza);
                } catch (Throwable e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            } else if (asset2.getUri() != null) {
                try {
                    zzr.putAsset((String) value2.getKey(), Asset.createFromFd(getContext().getContentResolver().openFileDescriptor(asset2.getUri(), ISVGConstants.ATTRIBUTE_RADIUS)));
                } catch (FileNotFoundException e2) {
                    new zzq(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, arrayList).zza(new PutDataResponse(4005, null));
                    Log.w("WearableClient", "Couldn't resolve asset URI: " + asset2.getUri());
                    return;
                }
            } else {
                zzr.putAsset((String) value2.getKey(), asset2);
            }
        }
        ((zzax) zzqJ()).zza(new zzq(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, arrayList), zzr);
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str, Uri uri, long j, long j2) {
        try {
            this.zzbkn.execute(zzb(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, str, uri, j, j2));
        } catch (RuntimeException e) {
            com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status.zzw(new Status(8));
            throw e;
        }
    }

    public void zza(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str, Uri uri, boolean z) {
        try {
            this.zzbkn.execute(zzb(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, str, uri, z));
        } catch (RuntimeException e) {
            com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status.zzw(new Status(8));
            throw e;
        }
    }

    public void zza(zzb<SendMessageResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult, String str, String str2, byte[] bArr) throws RemoteException {
        ((zzax) zzqJ()).zza(new zzt(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult), str, str2, bArr);
    }

    public void zzb(zzb<GetAllCapabilitiesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetAllCapabilitiesResult, int i) throws RemoteException {
        ((zzax) zzqJ()).zza(new zzf(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetAllCapabilitiesResult), i);
    }

    public void zzb(zzb<DeleteDataItemsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult, Uri uri, int i) throws RemoteException {
        ((zzax) zzqJ()).zzb(new zze(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult), uri, i);
    }

    public void zze(zzb<OpenChannelResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_ChannelApi_OpenChannelResult, String str, String str2) throws RemoteException {
        ((zzax) zzqJ()).zza(new zzp(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_ChannelApi_OpenChannelResult), str, str2);
    }

    protected zzax zzew(IBinder iBinder) {
        return zzax.zza.zzeu(iBinder);
    }

    public void zzg(zzb<GetCapabilityResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetCapabilityResult, String str, int i) throws RemoteException {
        ((zzax) zzqJ()).zza(new zzg(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetCapabilityResult), str, i);
    }

    protected String zzgu() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected String zzgv() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    public void zzh(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str, int i) throws RemoteException {
        ((zzax) zzqJ()).zzb(new zzd(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), str, i);
    }

    public void zzr(zzb<DataItemBuffer> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataItemBuffer) throws RemoteException {
        ((zzax) zzqJ()).zzb(new zzl(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataItemBuffer));
    }

    public void zzr(zzb<AddLocalCapabilityResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_AddLocalCapabilityResult, String str) throws RemoteException {
        ((zzax) zzqJ()).zzd(new zza(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_AddLocalCapabilityResult), str);
    }

    public void zzs(zzb<GetLocalNodeResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult) throws RemoteException {
        ((zzax) zzqJ()).zzc(new zzn(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult));
    }

    public void zzs(zzb<RemoveLocalCapabilityResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_RemoveLocalCapabilityResult, String str) throws RemoteException {
        ((zzax) zzqJ()).zze(new zzs(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_RemoveLocalCapabilityResult), str);
    }

    public void zzt(zzb<GetConnectedNodesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult) throws RemoteException {
        ((zzax) zzqJ()).zzd(new zzj(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult));
    }

    public void zzt(zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((zzax) zzqJ()).zzf(new zzc(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status), str);
    }

    public void zzu(zzb<GetInputStreamResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_Channel_GetInputStreamResult, String str) throws RemoteException {
        zzau com_google_android_gms_wearable_internal_zzt = new zzt();
        ((zzax) zzqJ()).zza(new zzh(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_Channel_GetInputStreamResult, com_google_android_gms_wearable_internal_zzt), com_google_android_gms_wearable_internal_zzt, str);
    }

    public void zzv(zzb<GetOutputStreamResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_Channel_GetOutputStreamResult, String str) throws RemoteException {
        zzau com_google_android_gms_wearable_internal_zzt = new zzt();
        ((zzax) zzqJ()).zzb(new zzi(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_Channel_GetOutputStreamResult, com_google_android_gms_wearable_internal_zzt), com_google_android_gms_wearable_internal_zzt, str);
    }
}
