package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Iterator;

@Class(creator = "EventParamsCreator")
@Reserved({1})
public final class zzaa extends AbstractSafeParcelable implements Iterable<String> {
    public static final Creator<zzaa> CREATOR = new zzac();
    /* access modifiers changed from: private */
    @Field(getter = "z", mo7664id = 2)
    public final Bundle zzaim;

    @Constructor
    zzaa(@Param(mo7667id = 2) Bundle bundle) {
        this.zzaim = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zziv(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: 0000 */
    public final Object get(String str) {
        return this.zzaim.get(str);
    }

    /* access modifiers changed from: 0000 */
    public final Long getLong(String str) {
        return Long.valueOf(this.zzaim.getLong(str));
    }

    /* access modifiers changed from: 0000 */
    public final Double zzbq(String str) {
        return Double.valueOf(this.zzaim.getDouble(str));
    }

    /* access modifiers changed from: 0000 */
    public final String getString(String str) {
        return this.zzaim.getString(str);
    }

    public final int size() {
        return this.zzaim.size();
    }

    public final String toString() {
        return this.zzaim.toString();
    }

    public final Bundle zziv() {
        return new Bundle(this.zzaim);
    }

    public final Iterator<String> iterator() {
        return new zzab(this);
    }
}
