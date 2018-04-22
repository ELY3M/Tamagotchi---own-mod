package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzw.zza;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.internal.zzz;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama {
    private final IStreetViewPanoramaDelegate zzaSr;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public interface OnStreetViewPanoramaLongClickListener {
        void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    protected StreetViewPanorama(IStreetViewPanoramaDelegate sv) {
        this.zzaSr = (IStreetViewPanoramaDelegate) zzx.zzz(sv);
    }

    public void animateTo(StreetViewPanoramaCamera camera, long duration) {
        try {
            this.zzaSr.animateTo(camera, duration);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.zzaSr.getStreetViewPanoramaLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.zzaSr.getPanoramaCamera();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.zzaSr.isPanningGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.zzaSr.isStreetNamesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.zzaSr.isUserNavigationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.zzaSr.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation orientation) {
        try {
            zzd orientationToPoint = this.zzaSr.orientationToPoint(orientation);
            return orientationToPoint == null ? null : (Point) zze.zzp(orientationToPoint);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.zzaSr.pointToOrientation(zze.zzC(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(final OnStreetViewPanoramaCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaSr.setOnStreetViewPanoramaCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaSr.setOnStreetViewPanoramaCameraChangeListener(new zza(this) {
            final /* synthetic */ StreetViewPanorama zzaSt;

            public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera camera) {
                listener.onStreetViewPanoramaCameraChange(camera);
            }
        });
    }

    public final void setOnStreetViewPanoramaChangeListener(final OnStreetViewPanoramaChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaSr.setOnStreetViewPanoramaChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaSr.setOnStreetViewPanoramaChangeListener(new com.google.android.gms.maps.internal.zzx.zza(this) {
            final /* synthetic */ StreetViewPanorama zzaSt;

            public void onStreetViewPanoramaChange(StreetViewPanoramaLocation location) {
                listener.onStreetViewPanoramaChange(location);
            }
        });
    }

    public final void setOnStreetViewPanoramaClickListener(final OnStreetViewPanoramaClickListener listener) {
        if (listener == null) {
            try {
                this.zzaSr.setOnStreetViewPanoramaClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaSr.setOnStreetViewPanoramaClickListener(new zzy.zza(this) {
            final /* synthetic */ StreetViewPanorama zzaSt;

            public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation orientation) {
                listener.onStreetViewPanoramaClick(orientation);
            }
        });
    }

    public final void setOnStreetViewPanoramaLongClickListener(final OnStreetViewPanoramaLongClickListener listener) {
        if (listener == null) {
            try {
                this.zzaSr.setOnStreetViewPanoramaLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaSr.setOnStreetViewPanoramaLongClickListener(new zzz.zza(this) {
            final /* synthetic */ StreetViewPanorama zzaSt;

            public void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation orientation) {
                listener.onStreetViewPanoramaLongClick(orientation);
            }
        });
    }

    public void setPanningGesturesEnabled(boolean enablePanning) {
        try {
            this.zzaSr.enablePanning(enablePanning);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position) {
        try {
            this.zzaSr.setPosition(position);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position, int radius) {
        try {
            this.zzaSr.setPositionWithRadius(position, radius);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(String panoId) {
        try {
            this.zzaSr.setPositionWithID(panoId);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStreetNamesEnabled(boolean enableStreetNames) {
        try {
            this.zzaSr.enableStreetNames(enableStreetNames);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setUserNavigationEnabled(boolean enableUserNavigation) {
        try {
            this.zzaSr.enableUserNavigation(enableUserNavigation);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean enableZoom) {
        try {
            this.zzaSr.enableZoom(enableZoom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IStreetViewPanoramaDelegate zzzY() {
        return this.zzaSr;
    }
}
