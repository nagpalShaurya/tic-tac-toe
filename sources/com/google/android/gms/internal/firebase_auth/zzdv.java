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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj.zzs;
import com.google.firebase.auth.api.internal.zzdw;

@Class(creator = "VerifyCustomTokenResponseCreator")
@Reserved({1})
public final class zzdv extends AbstractSafeParcelable implements zzdw<zzdv, zzs> {
    public static final Creator<zzdv> CREATOR = new zzdw();
    @Field(getter = "getIdToken", mo7664id = 2)
    private String zzgc;
    @Field(getter = "getRefreshToken", mo7664id = 3)
    private String zzid;
    @Field(getter = "isNewUser", mo7664id = 5)
    private boolean zzor;
    @Field(getter = "getExpiresIn", mo7664id = 4)
    private long zzos;

    public zzdv() {
    }

    @Constructor
    zzdv(@Param(mo7667id = 2) String str, @Param(mo7667id = 3) String str2, @Param(mo7667id = 4) long j, @Param(mo7667id = 5) boolean z) {
        this.zzgc = str;
        this.zzid = str2;
        this.zzos = j;
        this.zzor = z;
    }

    public final String getIdToken() {
        return this.zzgc;
    }

    @NonNull
    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzgc, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzid, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzos);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzor);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzhl<zzs> zzdj() {
        return zzs.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhb zzhb) {
        if (zzhb instanceof zzs) {
            zzs zzs = (zzs) zzhb;
            this.zzgc = Strings.emptyToNull(zzs.getIdToken());
            this.zzid = Strings.emptyToNull(zzs.zzr());
            this.zzos = zzs.zzs();
            this.zzor = zzs.zzt();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of VerifyCustomTokenResponse.");
    }
}
