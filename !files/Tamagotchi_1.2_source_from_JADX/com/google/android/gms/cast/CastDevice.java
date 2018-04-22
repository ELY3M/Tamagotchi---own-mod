package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_MULTIZONE_GROUP = 32;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Creator<CastDevice> CREATOR = new zzb();
    private final int mVersionCode;
    private int zzBc;
    private String zzZT;
    String zzZU;
    private Inet4Address zzZV;
    private String zzZW;
    private String zzZX;
    private String zzZY;
    private int zzZZ;
    private List<WebImage> zzaaa;
    private int zzaab;
    private String zzaac;

    private CastDevice() {
        this(4, null, null, null, null, null, -1, new ArrayList(), 0, -1, null);
    }

    CastDevice(int versionCode, String deviceId, String hostAddress, String friendlyName, String modelName, String deviceVersion, int servicePort, List<WebImage> icons, int capabilities, int status, String serviceInstanceName) {
        this.mVersionCode = versionCode;
        this.zzZT = zzbZ(deviceId);
        this.zzZU = zzbZ(hostAddress);
        if (!TextUtils.isEmpty(this.zzZU)) {
            try {
                InetAddress byName = InetAddress.getByName(this.zzZU);
                if (byName instanceof Inet4Address) {
                    this.zzZV = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                Log.i("CastDevice", "Unable to convert host address (" + this.zzZU + ") to ipaddress: " + e.getMessage());
            }
        }
        this.zzZW = zzbZ(friendlyName);
        this.zzZX = zzbZ(modelName);
        this.zzZY = zzbZ(deviceVersion);
        this.zzZZ = servicePort;
        if (icons == null) {
            icons = new ArrayList();
        }
        this.zzaaa = icons;
        this.zzaab = capabilities;
        this.zzBc = status;
        this.zzaac = zzbZ(serviceInstanceName);
    }

    public static CastDevice getFromBundle(Bundle extras) {
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) extras.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    private static String zzbZ(String str) {
        return str == null ? "" : str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return this.zzZT == null ? castDevice.zzZT == null : zzf.zza(this.zzZT, castDevice.zzZT) && zzf.zza(this.zzZV, castDevice.zzZV) && zzf.zza(this.zzZX, castDevice.zzZX) && zzf.zza(this.zzZW, castDevice.zzZW) && zzf.zza(this.zzZY, castDevice.zzZY) && this.zzZZ == castDevice.zzZZ && zzf.zza(this.zzaaa, castDevice.zzaaa) && this.zzaab == castDevice.zzaab && this.zzBc == castDevice.zzBc && zzf.zza(this.zzaac, castDevice.zzaac);
    }

    public int getCapabilities() {
        return this.zzaab;
    }

    public String getDeviceId() {
        return this.zzZT.startsWith("__cast_nearby__") ? this.zzZT.substring("__cast_nearby__".length() + 1) : this.zzZT;
    }

    public String getDeviceVersion() {
        return this.zzZY;
    }

    public String getFriendlyName() {
        return this.zzZW;
    }

    public WebImage getIcon(int preferredWidth, int preferredHeight) {
        WebImage webImage = null;
        if (this.zzaaa.isEmpty()) {
            return null;
        }
        if (preferredWidth <= 0 || preferredHeight <= 0) {
            return (WebImage) this.zzaaa.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.zzaaa) {
            WebImage webImage32;
            int width = webImage32.getWidth();
            int height = webImage32.getHeight();
            if (width < preferredWidth || height < preferredHeight) {
                if (width < preferredWidth && height < preferredHeight && (webImage == null || (webImage.getWidth() < width && webImage.getHeight() < height))) {
                    webImage = webImage2;
                }
                webImage32 = webImage;
                webImage = webImage2;
            } else {
                if (webImage2 == null || (webImage2.getWidth() > width && webImage2.getHeight() > height)) {
                    WebImage webImage4 = webImage;
                    webImage = webImage32;
                    webImage32 = webImage4;
                }
                webImage32 = webImage;
                webImage = webImage2;
            }
            webImage2 = webImage;
            webImage = webImage32;
        }
        if (webImage2 == null) {
            webImage2 = webImage != null ? webImage : (WebImage) this.zzaaa.get(0);
        }
        return webImage2;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzaaa);
    }

    public Inet4Address getIpAddress() {
        return this.zzZV;
    }

    public String getModelName() {
        return this.zzZX;
    }

    public int getServicePort() {
        return this.zzZZ;
    }

    public int getStatus() {
        return this.zzBc;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasCapabilities(int[] capabilities) {
        if (capabilities == null) {
            return false;
        }
        for (int hasCapability : capabilities) {
            if (!hasCapability(hasCapability)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int capability) {
        return (this.zzaab & capability) == capability;
    }

    public boolean hasIcons() {
        return !this.zzaaa.isEmpty();
    }

    public int hashCode() {
        return this.zzZT == null ? 0 : this.zzZT.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.zzZT.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        if (this.zzZT == null) {
            return castDevice.zzZT == null;
        } else {
            return zzf.zza(this.zzZT, castDevice.zzZT);
        }
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.zzZW, this.zzZT});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public String zzny() {
        return this.zzZT;
    }

    public String zznz() {
        return this.zzaac;
    }
}
