package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "EventParcelCreator")
@Reserved({1})
public final class zzad extends AbstractSafeParcelable {
    public static final Creator<zzad> CREATOR = new zzae();
    @Field(mo7664id = 2)
    public final String name;
    @Field(mo7664id = 4)
    public final String origin;
    @Field(mo7664id = 3)
    public final zzaa zzaid;
    @Field(mo7664id = 5)
    public final long zzaip;

    @Constructor
    public zzad(@Param(mo7667id = 2) String str, @Param(mo7667id = 3) zzaa zzaa, @Param(mo7667id = 4) String str2, @Param(mo7667id = 5) long j) {
        this.name = str;
        this.zzaid = zzaa;
        this.origin = str2;
        this.zzaip = j;
    }

    zzad(zzad zzad, long j) {
        Preconditions.checkNotNull(zzad);
        this.name = zzad.name;
        this.zzaid = zzad.zzaid;
        this.origin = zzad.origin;
        this.zzaip = j;
    }

    public final String toString() {
        String str = this.origin;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzaid);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzaid, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.origin, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzaip);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
