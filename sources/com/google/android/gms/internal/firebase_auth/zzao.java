package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ConfirmPasswordResetAidlRequestCreator")
public final class zzao extends AbstractSafeParcelable {
    public static final Creator<zzao> CREATOR = new zzap();
    @Nullable
    @Field(getter = "getTenantId", mo7664id = 3)
    private final String zzgw;
    @Field(getter = "getCode", mo7664id = 1)
    private final String zzib;
    @Field(getter = "getNewPassword", mo7664id = 2)
    private final String zzic;

    @Constructor
    public zzao(@Param(mo7667id = 1) @NonNull String str, @Param(mo7667id = 2) @NonNull String str2, @Nullable @Param(mo7667id = 3) String str3) {
        this.zzib = str;
        this.zzic = str2;
        this.zzgw = str3;
    }

    public final String zzcm() {
        return this.zzib;
    }

    public final String zzcn() {
        return this.zzic;
    }

    @Nullable
    public final String zzcf() {
        return this.zzgw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzib, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzic, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
