package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzd;
import java.util.List;

@Class(creator = "DefaultAuthResultCreator")
public final class zzf implements AuthResult {
    public static final Creator<zzf> CREATOR = new zzg();
    @Field(getter = "getUser", mo7664id = 1)
    private zzl zzqn;
    @Field(getter = "getAdditionalUserInfo", mo7664id = 2)
    private zzd zzqo;
    @Field(getter = "getOAuthCredential", mo7664id = 3)
    private zzd zzqp;

    @Constructor
    zzf(@Param(mo7667id = 1) zzl zzl, @Param(mo7667id = 2) zzd zzd, @Param(mo7667id = 3) zzd zzd2) {
        this.zzqn = zzl;
        this.zzqo = zzd;
        this.zzqp = zzd2;
    }

    public zzf(@NonNull zzl zzl) {
        this.zzqn = (zzl) Preconditions.checkNotNull(zzl);
        List zzef = this.zzqn.zzef();
        this.zzqo = null;
        for (int i = 0; i < zzef.size(); i++) {
            if (!TextUtils.isEmpty(((zzh) zzef.get(i)).getRawUserInfo())) {
                this.zzqo = new zzd(((zzh) zzef.get(i)).getProviderId(), ((zzh) zzef.get(i)).getRawUserInfo(), zzl.isNewUser());
            }
        }
        if (this.zzqo == null) {
            this.zzqo = new zzd(zzl.isNewUser());
        }
        this.zzqp = zzl.zzcv();
    }

    @Nullable
    public final FirebaseUser getUser() {
        return this.zzqn;
    }

    @Nullable
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzqo;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUser(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAdditionalUserInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzqp, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int describeContents() {
        return 0;
    }
}
