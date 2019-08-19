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

@Class(creator = "LinkEmailAuthCredentialAidlRequestCreator")
public final class zzay extends AbstractSafeParcelable {
    public static final Creator<zzay> CREATOR = new zzaz();
    @Field(getter = "getEmail", mo7664id = 1)
    private final String zzgh;
    @Field(getter = "getPassword", mo7664id = 2)
    private final String zzgi;
    @Field(getter = "getCachedState", mo7664id = 3)
    private final String zzgk;

    @Constructor
    public zzay(@Param(mo7667id = 1) @NonNull String str, @Param(mo7667id = 2) @NonNull String str2, @Param(mo7667id = 3) @NonNull String str3) {
        this.zzgh = str;
        this.zzgi = str2;
        this.zzgk = str3;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
