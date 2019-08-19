package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj.C0529zzj;
import com.google.firebase.auth.api.internal.zzdw;

@Class(creator = "ResetPasswordResponseCreator")
@Reserved({1})
public final class zzdg extends AbstractSafeParcelable implements zzdw<zzdg, C0529zzj> {
    public static final Creator<zzdg> CREATOR = new zzdi();
    @Field(getter = "getEmail", mo7664id = 2)
    private String zzgh;
    @Field(getter = "getRequestType", mo7664id = 4)
    private String zzpf;
    @Field(getter = "getNewEmail", mo7664id = 3)
    private String zzpn;

    public zzdg() {
    }

    @Constructor
    zzdg(@Param(mo7667id = 2) String str, @Param(mo7667id = 3) String str2, @Param(mo7667id = 4) String str3) {
        this.zzgh = str;
        this.zzpn = str2;
        this.zzpf = str3;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String zzad() {
        return this.zzpn;
    }

    public final String zzea() {
        return this.zzpf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzpn, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzpf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzhl<C0529zzj> zzdj() {
        return C0529zzj.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhb zzhb) {
        String str;
        if (zzhb instanceof C0529zzj) {
            C0529zzj zzj = (C0529zzj) zzhb;
            this.zzgh = Strings.emptyToNull(zzj.getEmail());
            this.zzpn = Strings.emptyToNull(zzj.zzad());
            int i = zzdh.zzpg[zzj.zzae().ordinal()];
            if (i == 1) {
                str = "VERIFY_EMAIL";
            } else if (i != 2) {
                str = null;
            } else {
                str = "PASSWORD_RESET";
            }
            this.zzpf = str;
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of ResetPasswordResponse.");
    }
}
