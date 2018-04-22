package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;

public class Thing {
    final Bundle zzUG;

    public static class Builder {
        final Bundle zzUH = new Bundle();

        public Thing build() {
            return new Thing(this.zzUH);
        }

        public Builder put(String key, Thing value) {
            zzx.zzz(key);
            if (value != null) {
                this.zzUH.putParcelable(key, value.zzUG);
            }
            return this;
        }

        public Builder put(String key, String value) {
            zzx.zzz(key);
            if (value != null) {
                this.zzUH.putString(key, value);
            }
            return this;
        }

        public Builder put(String key, boolean value) {
            zzx.zzz(key);
            this.zzUH.putBoolean(key, value);
            return this;
        }

        public Builder put(String key, Thing[] values) {
            zzx.zzz(key);
            if (values != null) {
                ArrayList arrayList = new ArrayList();
                for (Thing thing : values) {
                    if (thing != null) {
                        arrayList.add(thing.zzUG);
                    }
                }
                this.zzUH.putParcelableArray(key, (Parcelable[]) arrayList.toArray(new Bundle[arrayList.size()]));
            }
            return this;
        }

        public Builder put(String key, String[] values) {
            zzx.zzz(key);
            if (values != null) {
                this.zzUH.putStringArray(key, values);
            }
            return this;
        }

        public Builder setDescription(String description) {
            put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, description);
            return this;
        }

        public Builder setId(String id) {
            if (id != null) {
                put("id", id);
            }
            return this;
        }

        public Builder setName(String name) {
            zzx.zzz(name);
            put("name", name);
            return this;
        }

        public Builder setType(String type) {
            put(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE, type);
            return this;
        }

        public Builder setUrl(Uri url) {
            zzx.zzz(url);
            put(PlusShare.KEY_CALL_TO_ACTION_URL, url.toString());
            return this;
        }
    }

    Thing(Bundle propertyBundle) {
        this.zzUG = propertyBundle;
    }

    public Bundle zzmk() {
        return this.zzUG;
    }
}
