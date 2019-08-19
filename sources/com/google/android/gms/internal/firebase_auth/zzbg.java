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

@Class(creator = "SendEmailVerificationWithSettingsAidlRequestCreator")
public final class zzbg extends AbstractSafeParcelable {
    public static final Creator<zzbg> CREATOR = new zzbh();
    @Field(getter = "getToken", mo7664id = 1)
    private final String zzhm;
    @Nullable
    @Field(getter = "getActionCodeSettings", mo7664id = 2)
    private final ActionCodeSettings zzig;

    @Constructor
    public zzbg(@Param(mo7667id = 1) @NonNull String str, @Nullable @Param(mo7667id = 2) ActionCodeSettings actionCodeSettings) {
        this.zzhm = str;
        this.zzig = actionCodeSettings;
    }

    public final String getToken() {
        return this.zzhm;
    }

    @Nullable
    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhm, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzig, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
