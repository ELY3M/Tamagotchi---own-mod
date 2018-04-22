package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.drive.internal.zzz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {
    private final Context mContext;
    private final LayoutInflater mInflater;
    private final int zzavs;
    private int zzavt;
    private final int zzavu;
    private final List<DataBuffer<T>> zzavv;
    private boolean zzavw;

    public DataBufferAdapter(Context context, int resource) {
        this(context, resource, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId) {
        this(context, resource, textViewResourceId, new ArrayList());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, List<DataBuffer<T>> objects) {
        this.zzavw = true;
        this.mContext = context;
        this.zzavt = resource;
        this.zzavs = resource;
        this.zzavu = textViewResourceId;
        this.zzavv = objects;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, DataBuffer<T>... buffers) {
        this(context, resource, textViewResourceId, Arrays.asList(buffers));
    }

    public DataBufferAdapter(Context context, int resource, List<DataBuffer<T>> objects) {
        this(context, resource, 0, (List) objects);
    }

    public DataBufferAdapter(Context context, int resource, DataBuffer<T>... buffers) {
        this(context, resource, 0, Arrays.asList(buffers));
    }

    private View zza(int i, View view, ViewGroup viewGroup, int i2) {
        View inflate = view == null ? this.mInflater.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.zzavu == 0 ? (TextView) inflate : (TextView) inflate.findViewById(this.zzavu);
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return inflate;
        } catch (Throwable e) {
            zzz.zza("DataBufferAdapter", e, "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> buffer) {
        this.zzavv.add(buffer);
        if (this.zzavw) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer release : this.zzavv) {
            release.release();
        }
        this.zzavv.clear();
        if (this.zzavw) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        int i = 0;
        for (DataBuffer count : this.zzavv) {
            i = count.getCount() + i;
        }
        return i;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return zza(position, convertView, parent, this.zzavt);
    }

    public T getItem(int position) throws CursorIndexOutOfBoundsException {
        int i = position;
        for (DataBuffer dataBuffer : this.zzavv) {
            int count = dataBuffer.getCount();
            if (count <= i) {
                i -= count;
            } else {
                try {
                    return dataBuffer.get(i);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(position, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(position, getCount());
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return zza(position, convertView, parent, this.zzavs);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.zzavw = true;
    }

    public void setDropDownViewResource(int resource) {
        this.zzavt = resource;
    }

    public void setNotifyOnChange(boolean notifyOnChange) {
        this.zzavw = notifyOnChange;
    }
}
