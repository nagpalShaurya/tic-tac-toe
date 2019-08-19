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

@Class(creator = "LinkFederatedCredentialAidlRequestCreator")
public final class zzba extends AbstractSafeParcelable {
    public static final Creator<zzba> CREATOR = new zzbb();
    @Field(getter = "getCachedState", mo7664id = 1)
    private final String zzgk;
    @Field(getter = "getVerifyAssertionRequest", mo7664id = 2)
    private final zzdr zzie;

    @Constructor
    public zzba(@Param(mo7667id = 1) @NonNull String str, @Param(mo7667id = 2) @NonNull zzdr zzdr) {
        this.zzgk = str;
        this.zzie = zzdr;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final zzdr zzco() {
        return this.zzie;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgk, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzie, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
