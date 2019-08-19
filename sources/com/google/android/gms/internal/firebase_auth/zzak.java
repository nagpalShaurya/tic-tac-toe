package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "ChangePasswordAidlRequestCreator")
public final class zzak extends AbstractSafeParcelable {
    public static final Creator<zzak> CREATOR = new zzal();
    @Field(getter = "getPassword", mo7664id = 2)
    private final String zzgi;
    @Field(getter = "getCachedState", mo7664id = 1)
    private final String zzgk;

    @Constructor
    public zzak(@Param(mo7667id = 1) @NonNull String str, @Param(mo7667id = 2) @NonNull String str2) {
        this.zzgk = str;
        this.zzgi = str2;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgk, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
