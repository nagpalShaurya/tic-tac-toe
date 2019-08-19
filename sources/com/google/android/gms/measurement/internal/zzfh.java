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

@Class(creator = "UserAttributeParcelCreator")
public final class zzfh extends AbstractSafeParcelable {
    public static final Creator<zzfh> CREATOR = new zzfi();
    @Field(mo7664id = 2)
    public final String name;
    @Field(mo7664id = 7)
    public final String origin;
    @Field(mo7664id = 1)
    private final int versionCode;
    @Field(mo7664id = 6)
    private final String zzamp;
    @Field(mo7664id = 3)
    public final long zzaue;
    @Field(mo7664id = 4)
    private final Long zzauf;
    @Field(mo7664id = 5)
    private final Float zzaug;
    @Field(mo7664id = 8)
    private final Double zzauh;

    zzfh(zzfj zzfj) {
        this(zzfj.name, zzfj.zzaue, zzfj.value, zzfj.origin);
    }

    zzfh(String str, long j, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.versionCode = 2;
        this.name = str;
        this.zzaue = j;
        this.origin = str2;
        if (obj == null) {
            this.zzauf = null;
            this.zzaug = null;
            this.zzauh = null;
            this.zzamp = null;
        } else if (obj instanceof Long) {
            this.zzauf = (Long) obj;
            this.zzaug = null;
            this.zzauh = null;
            this.zzamp = null;
        } else if (obj instanceof String) {
            this.zzauf = null;
            this.zzaug = null;
            this.zzauh = null;
            this.zzamp = (String) obj;
        } else if (obj instanceof Double) {
            this.zzauf = null;
            this.zzaug = null;
            this.zzauh = (Double) obj;
            this.zzamp = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    @Constructor
    zzfh(@Param(mo7667id = 1) int i, @Param(mo7667id = 2) String str, @Param(mo7667id = 3) long j, @Param(mo7667id = 4) Long l, @Param(mo7667id = 5) Float f, @Param(mo7667id = 6) String str2, @Param(mo7667id = 7) String str3, @Param(mo7667id = 8) Double d) {
        this.versionCode = i;
        this.name = str;
        this.zzaue = j;
        this.zzauf = l;
        Double d2 = null;
        this.zzaug = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.zzauh = d2;
        } else {
            this.zzauh = d;
        }
        this.zzamp = str2;
        this.origin = str3;
    }

    public final Object getValue() {
        Long l = this.zzauf;
        if (l != null) {
            return l;
        }
        Double d = this.zzauh;
        if (d != null) {
            return d;
        }
        String str = this.zzamp;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzaue);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzauf, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzamp, false);
        SafeParcelWriter.writeString(parcel, 7, this.origin, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzauh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
