package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzpa implements BleApi {

    private static class zza extends com.google.android.gms.internal.zzpj.zza {
        private final zzb<BleDevicesResult> zzamC;

        private zza(zzb<BleDevicesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_BleDevicesResult) {
            this.zzamC = com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_fitness_result_BleDevicesResult;
        }

        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzamC.zzs(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final BleDevice bleDevice) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpa zzazN;

            protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
                ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new ClaimBleDeviceRequest(bleDevice.getAddress(), bleDevice, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpa zzazN;

            protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
                ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new ClaimBleDeviceRequest(deviceAddress, null, new zzph(this)));
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.zza(new zza<BleDevicesResult>(this, client) {
            final /* synthetic */ zzpa zzazN;

            protected BleDevicesResult zzI(Status status) {
                return BleDevicesResult.zzQ(status);
            }

            protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
                ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new ListClaimedBleDevicesRequest(new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzI(status);
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, final StartBleScanRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzpa zzazN;

            protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
                ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new StartBleScanRequest(request, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, final BleScanCallback requestCallback) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzpa zzazN;

            protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
                ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new StopBleScanRequest(requestCallback, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpa zzazN;

            protected void zza(zznz com_google_android_gms_internal_zznz) throws RemoteException {
                ((zzok) com_google_android_gms_internal_zznz.zzqJ()).zza(new UnclaimBleDeviceRequest(deviceAddress, new zzph(this)));
            }
        });
    }
}
