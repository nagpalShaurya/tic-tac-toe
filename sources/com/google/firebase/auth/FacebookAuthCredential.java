package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.firebase_auth.zzdr;

@Class(creator = "FacebookAuthCredentialCreator")
public class FacebookAuthCredential extends AuthCredential {
    public static final Creator<FacebookAuthCredential> CREATOR = new zzg();
    @Field(getter = "getAccessToken", mo7664id = 1)
    private final String zzgd;

    @Constructor
    FacebookAuthCredential(@Param(mo7667id = 1) @NonNull String str) {
        this.zzgd = Preconditions.checkNotEmpty(str);
    }

    public String getProvider() {
        return "facebook.com";
    }

    public String getSignInMethod() {
        return "facebook.com";
    }

    public static zzdr zza(@NonNull FacebookAuthCredential facebookAuthCredential, @Nullable String str) {
        Preconditions.checkNotNull(facebookAuthCredential);
        zzdr zzdr = new zzdr(null, facebookAuthCredential.zzgd, facebookAuthCredential.getProvider(), null, null, null, str, null);
        return zzdr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
