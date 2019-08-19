package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.firebase.auth.zzd;

@Class(creator = "OnFailedIdpSignInAidlResponseCreator")
public final class zzcg extends AbstractSafeParcelable {
    public static final Creator<zzcg> CREATOR = new zzch();
    @Field(getter = "getEmail", mo7664id = 3)
    private final String zzgh;
    @Field(getter = "getStatus", mo7664id = 1)
    private final Status zzim;
    @Field(getter = "getDefaultOAuthCredential", mo7664id = 2)
    private final zzd zzin;

    @Constructor
    public zzcg(@Param(mo7667id = 1) @NonNull Status status, @Param(mo7667id = 2) @NonNull zzd zzd, @Param(mo7667id = 3) @NonNull String str) {
        this.zzim = status;
        this.zzin = zzd;
        this.zzgh = str;
    }

    public final Status getStatus() {
        return this.zzim;
    }

    public final zzd zzcv() {
        return this.zzin;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzim, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzin, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
