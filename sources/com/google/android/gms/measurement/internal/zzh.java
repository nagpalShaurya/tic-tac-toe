package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "AppMetadataCreator")
@Reserved({1, 20})
public final class zzh extends AbstractSafeParcelable {
    public static final Creator<zzh> CREATOR = new zzi();
    @Field(mo7664id = 2)
    public final String packageName;
    @Field(mo7664id = 6)
    public final long zzadt;
    @Field(mo7664id = 3)
    public final String zzafx;
    @Field(mo7664id = 12)
    public final String zzafz;
    @Field(defaultValueUnchecked = "Integer.MIN_VALUE", mo7664id = 11)
    public final long zzagd;
    @Field(mo7664id = 5)
    public final String zzage;
    @Field(mo7664id = 7)
    public final long zzagf;
    @Field(defaultValue = "true", mo7664id = 9)
    public final boolean zzagg;
    @Field(mo7664id = 13)
    public final long zzagh;
    @Field(defaultValue = "true", mo7664id = 16)
    public final boolean zzagi;
    @Field(defaultValue = "true", mo7664id = 17)
    public final boolean zzagj;
    @Field(mo7664id = 19)
    public final String zzagk;
    @Field(mo7664id = 8)
    public final String zzagv;
    @Field(mo7664id = 10)
    public final boolean zzagw;
    @Field(mo7664id = 14)
    public final long zzagx;
    @Field(mo7664id = 15)
    public final int zzagy;
    @Field(mo7664id = 18)
    public final boolean zzagz;
    @Field(mo7664id = 4)
    public final String zzts;

    zzh(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5, String str7) {
        Preconditions.checkNotEmpty(str);
        this.packageName = str;
        this.zzafx = TextUtils.isEmpty(str2) ? null : str2;
        this.zzts = str3;
        this.zzagd = j;
        this.zzage = str4;
        this.zzadt = j2;
        this.zzagf = j3;
        this.zzagv = str5;
        this.zzagg = z;
        this.zzagw = z2;
        this.zzafz = str6;
        this.zzagh = j4;
        this.zzagx = j5;
        this.zzagy = i;
        this.zzagi = z3;
        this.zzagj = z4;
        this.zzagz = z5;
        this.zzagk = str7;
    }

    @Constructor
    zzh(@Param(mo7667id = 2) String str, @Param(mo7667id = 3) String str2, @Param(mo7667id = 4) String str3, @Param(mo7667id = 5) String str4, @Param(mo7667id = 6) long j, @Param(mo7667id = 7) long j2, @Param(mo7667id = 8) String str5, @Param(mo7667id = 9) boolean z, @Param(mo7667id = 10) boolean z2, @Param(mo7667id = 11) long j3, @Param(mo7667id = 12) String str6, @Param(mo7667id = 13) long j4, @Param(mo7667id = 14) long j5, @Param(mo7667id = 15) int i, @Param(mo7667id = 16) boolean z3, @Param(mo7667id = 17) boolean z4, @Param(mo7667id = 18) boolean z5, @Param(mo7667id = 19) String str7) {
        this.packageName = str;
        this.zzafx = str2;
        this.zzts = str3;
        this.zzagd = j3;
        this.zzage = str4;
        this.zzadt = j;
        this.zzagf = j2;
        this.zzagv = str5;
        this.zzagg = z;
        this.zzagw = z2;
        this.zzafz = str6;
        this.zzagh = j4;
        this.zzagx = j5;
        this.zzagy = i;
        this.zzagi = z3;
        this.zzagj = z4;
        this.zzagz = z5;
        this.zzagk = str7;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzafx, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzts, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzage, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzadt);
        SafeParcelWriter.writeLong(parcel, 7, this.zzagf);
        SafeParcelWriter.writeString(parcel, 8, this.zzagv, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzagg);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzagw);
        SafeParcelWriter.writeLong(parcel, 11, this.zzagd);
        SafeParcelWriter.writeString(parcel, 12, this.zzafz, false);
        SafeParcelWriter.writeLong(parcel, 13, this.zzagh);
        SafeParcelWriter.writeLong(parcel, 14, this.zzagx);
        SafeParcelWriter.writeInt(parcel, 15, this.zzagy);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzagi);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzagj);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzagz);
        SafeParcelWriter.writeString(parcel, 19, this.zzagk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
