package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

public final class PersonBuffer extends AbstractDataBuffer<Person> {
    private final zzd<PersonEntity> zzbgt;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.zzpZ() == null || !dataHolder.zzpZ().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.zzbgt = null;
        } else {
            this.zzbgt = new zzd(dataHolder, PersonEntity.CREATOR);
        }
    }

    public Person get(int position) {
        return this.zzbgt != null ? (Person) this.zzbgt.zzbG(position) : new zzk(this.zzahi, position);
    }
}
