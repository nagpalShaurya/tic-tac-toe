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
import com.google.firebase.auth.ActionCodeSettings;

@Class(creator = "SendGetOobConfirmationCodeEmailAidlRequestCreator")
public final class zzbi extends AbstractSafeParcelable {
    public static final Creator<zzbi> CREATOR = new zzbj();
    @Field(getter = "getEmail", mo7664id = 1)
    private final String zzgh;
    @Nullable
    @Field(getter = "getTenantId", mo7664id = 3)
    private final String zzgw;
    @Field(getter = "getActionCodeSettings", mo7664id = 2)
    private final ActionCodeSettings zzig;

    @Constructor
    public zzbi(@Param(mo7667id = 1) @NonNull String str, @Param(mo7667id = 2) @NonNull ActionCodeSettings actionCodeSettings, @Nullable @Param(mo7667id = 3) String str2) {
        this.zzgh = str;
        this.zzig = actionCodeSettings;
        this.zzgw = str2;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }

    public final String zzcf() {
        return this.zzgw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzig, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
