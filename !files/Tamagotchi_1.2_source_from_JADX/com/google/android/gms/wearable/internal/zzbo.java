package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

final class zzbo {

    static abstract class zzb<T> extends zza {
        private com.google.android.gms.common.api.internal.zza.zzb<T> zzUz;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<T> com_google_android_gms_common_api_internal_zza_zzb_T) {
            this.zzUz = com_google_android_gms_common_api_internal_zza_zzb_T;
        }

        public void zzX(T t) {
            com.google.android.gms.common.api.internal.zza.zzb com_google_android_gms_common_api_internal_zza_zzb = this.zzUz;
            if (com_google_android_gms_common_api_internal_zza_zzb != null) {
                com_google_android_gms_common_api_internal_zza_zzb.zzs(t);
                this.zzUz = null;
            }
        }
    }

    static final class zzo extends zza {
        zzo() {
        }

        public void zza(Status status) {
        }
    }

    static final class zza extends zzb<AddLocalCapabilityResult> {
        public zza(com.google.android.gms.common.api.internal.zza.zzb<AddLocalCapabilityResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_AddLocalCapabilityResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_AddLocalCapabilityResult);
        }

        public void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zza(zzbk.zzgc(addLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzc extends zzb<Status> {
        public zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(CloseChannelResponse closeChannelResponse) {
            zzX(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zzd extends zzb<Status> {
        public zzd(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzb(CloseChannelResponse closeChannelResponse) {
            zzX(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zze extends zzb<DeleteDataItemsResult> {
        public zze(com.google.android.gms.common.api.internal.zza.zzb<DeleteDataItemsResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult);
        }

        public void zza(DeleteDataItemsResponse deleteDataItemsResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzx.zzb(zzbk.zzgc(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.zzbsz));
        }
    }

    static final class zzf extends zzb<GetAllCapabilitiesResult> {
        public zzf(com.google.android.gms.common.api.internal.zza.zzb<GetAllCapabilitiesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetAllCapabilitiesResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetAllCapabilitiesResult);
        }

        public void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zzd(zzbk.zzgc(getAllCapabilitiesResponse.statusCode), zzbo.zzG(getAllCapabilitiesResponse.zzbsA)));
        }
    }

    static final class zzg extends zzb<GetCapabilityResult> {
        public zzg(com.google.android.gms.common.api.internal.zza.zzb<GetCapabilityResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetCapabilityResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_GetCapabilityResult);
        }

        public void zza(GetCapabilityResponse getCapabilityResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zze(zzbk.zzgc(getCapabilityResponse.statusCode), new com.google.android.gms.wearable.internal.zzj.zzc(getCapabilityResponse.zzbsB)));
        }
    }

    static final class zzh extends zzb<GetInputStreamResult> {
        private final zzt zzbtd;

        public zzh(com.google.android.gms.common.api.internal.zza.zzb<GetInputStreamResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_Channel_GetInputStreamResult, zzt com_google_android_gms_wearable_internal_zzt) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_Channel_GetInputStreamResult);
            this.zzbtd = (zzt) zzx.zzz(com_google_android_gms_wearable_internal_zzt);
        }

        public void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) {
            InputStream inputStream = null;
            if (getChannelInputStreamResponse.zzbsC != null) {
                inputStream = new zzp(new AutoCloseInputStream(getChannelInputStreamResponse.zzbsC));
                this.zzbtd.zza(inputStream.zzIJ());
            }
            zzX(new zza(new Status(getChannelInputStreamResponse.statusCode), inputStream));
        }
    }

    static final class zzi extends zzb<GetOutputStreamResult> {
        private final zzt zzbtd;

        public zzi(com.google.android.gms.common.api.internal.zza.zzb<GetOutputStreamResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_Channel_GetOutputStreamResult, zzt com_google_android_gms_wearable_internal_zzt) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_Channel_GetOutputStreamResult);
            this.zzbtd = (zzt) zzx.zzz(com_google_android_gms_wearable_internal_zzt);
        }

        public void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) {
            OutputStream outputStream = null;
            if (getChannelOutputStreamResponse.zzbsC != null) {
                outputStream = new zzq(new AutoCloseOutputStream(getChannelOutputStreamResponse.zzbsC));
                this.zzbtd.zza(outputStream.zzIJ());
            }
            zzX(new zzb(new Status(getChannelOutputStreamResponse.statusCode), outputStream));
        }
    }

    static final class zzj extends zzb<GetConnectedNodesResult> {
        public zzj(com.google.android.gms.common.api.internal.zza.zzb<GetConnectedNodesResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult);
        }

        public void zza(GetConnectedNodesResponse getConnectedNodesResponse) {
            List arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.zzbsI);
            zzX(new com.google.android.gms.wearable.internal.zzbb.zza(zzbk.zzgc(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    static final class zzk extends zzb<DataItemResult> {
        public zzk(com.google.android.gms.common.api.internal.zza.zzb<DataItemResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
        }

        public void zza(GetDataItemResponse getDataItemResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzx.zza(zzbk.zzgc(getDataItemResponse.statusCode), getDataItemResponse.zzbsJ));
        }
    }

    static final class zzl extends zzb<DataItemBuffer> {
        public zzl(com.google.android.gms.common.api.internal.zza.zzb<DataItemBuffer> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataItemBuffer) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataItemBuffer);
        }

        public void zzah(DataHolder dataHolder) {
            zzX(new DataItemBuffer(dataHolder));
        }
    }

    static final class zzm extends zzb<GetFdForAssetResult> {
        public zzm(com.google.android.gms.common.api.internal.zza.zzb<GetFdForAssetResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult);
        }

        public void zza(GetFdForAssetResponse getFdForAssetResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzx.zzc(zzbk.zzgc(getFdForAssetResponse.statusCode), getFdForAssetResponse.zzbsK));
        }
    }

    static final class zzn extends zzb<GetLocalNodeResult> {
        public zzn(com.google.android.gms.common.api.internal.zza.zzb<GetLocalNodeResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult);
        }

        public void zza(GetLocalNodeResponse getLocalNodeResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzbb.zzb(zzbk.zzgc(getLocalNodeResponse.statusCode), getLocalNodeResponse.zzbsL));
        }
    }

    static final class zzp extends zzb<OpenChannelResult> {
        public zzp(com.google.android.gms.common.api.internal.zza.zzb<OpenChannelResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_ChannelApi_OpenChannelResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_ChannelApi_OpenChannelResult);
        }

        public void zza(OpenChannelResponse openChannelResponse) {
            zzX(new zza(zzbk.zzgc(openChannelResponse.statusCode), openChannelResponse.zzbsc));
        }
    }

    static final class zzq extends zzb<DataItemResult> {
        private final List<FutureTask<Boolean>> zzzM;

        zzq(com.google.android.gms.common.api.internal.zza.zzb<DataItemResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, List<FutureTask<Boolean>> list) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
            this.zzzM = list;
        }

        public void zza(PutDataResponse putDataResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzx.zza(zzbk.zzgc(putDataResponse.statusCode), putDataResponse.zzbsJ));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask cancel : this.zzzM) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class zzr extends zzb<Status> {
        public zzr(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(ChannelSendFileResponse channelSendFileResponse) {
            zzX(new Status(channelSendFileResponse.statusCode));
        }
    }

    static final class zzs extends zzb<RemoveLocalCapabilityResult> {
        public zzs(com.google.android.gms.common.api.internal.zza.zzb<RemoveLocalCapabilityResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_RemoveLocalCapabilityResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_CapabilityApi_RemoveLocalCapabilityResult);
        }

        public void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zza(zzbk.zzgc(removeLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzt extends zzb<SendMessageResult> {
        public zzt(com.google.android.gms.common.api.internal.zza.zzb<SendMessageResult> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult);
        }

        public void zza(SendMessageResponse sendMessageResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzaz.zzb(zzbk.zzgc(sendMessageResponse.statusCode), sendMessageResponse.zzaNj));
        }
    }

    static final class zzu extends zzb<Status> {
        public zzu(com.google.android.gms.common.api.internal.zza.zzb<Status> com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_internal_zza_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(ChannelReceiveFileResponse channelReceiveFileResponse) {
            zzX(new Status(channelReceiveFileResponse.statusCode));
        }
    }

    private static Map<String, CapabilityInfo> zzG(List<CapabilityInfoParcelable> list) {
        Map hashMap = new HashMap(list.size() * 2);
        for (CapabilityInfoParcelable capabilityInfoParcelable : list) {
            hashMap.put(capabilityInfoParcelable.getName(), new com.google.android.gms.wearable.internal.zzj.zzc(capabilityInfoParcelable));
        }
        return hashMap;
    }
}
