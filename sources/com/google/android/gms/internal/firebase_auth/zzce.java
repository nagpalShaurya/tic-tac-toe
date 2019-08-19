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
import com.google.firebase.auth.UserProfileChangeRequest;

@Class(creator = "UpdateProfileAidlRequestCreator")
public final class zzce extends AbstractSafeParcelable {
    public static final Creator<zzce> CREATOR = new zzcf();
    @Field(getter = "getCachedState", mo7664id = 2)
    private final String zzgk;
    @Field(getter = "getUserProfileChangeRequest", mo7664id = 1)
    private final UserProfileChangeRequest zzil;

    @Constructor
    public zzce(@Param(mo7667id = 1) @NonNull UserProfileChangeRequest userProfileChangeRequest, @Param(mo7667id = 2) @NonNull String str) {
        this.zzil = userProfileChangeRequest;
        this.zzgk = str;
    }

    public final UserProfileChangeRequest zzcu() {
        return this.zzil;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzil, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
