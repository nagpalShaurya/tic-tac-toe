package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.firebase_auth.zzj.zzp;
import com.google.android.gms.internal.firebase_auth.zzj.zzp.zza;
import com.google.firebase.auth.api.internal.zzff;

@Class(creator = "VerifyAssertionRequestCreator")
@Reserved({1})
public final class zzdr extends AbstractSafeParcelable implements zzff<zzp> {
    public static final Creator<zzdr> CREATOR = new zzds();
    @Field(getter = "getProviderId", mo7664id = 6)
    private String zzgb;
    @Field(getter = "getIdToken", mo7664id = 4)
    private String zzgc;
    @Field(getter = "getAccessToken", mo7664id = 5)
    private String zzgd;
    @Nullable
    @Field(getter = "getPendingToken", mo7664id = 17)
    private String zzgf;
    @Nullable
    @Field(getter = "getEmail", mo7664id = 7)
    private String zzgh;
    @Field(getter = "getTenantId", mo7664id = 15)
    private String zzgw;
    @Field(getter = "getAutoCreate", mo7664id = 11)
    private boolean zzhr;
    @Field(getter = "getReturnSecureToken", mo7664id = 10)
    private boolean zzpt;
    @Field(getter = "getRequestUri", mo7664id = 2)
    private String zzpx;
    @Field(getter = "getCurrentIdToken", mo7664id = 3)
    private String zzpy;
    @Field(getter = "getPostBody", mo7664id = 8)
    private String zzpz;
    @Field(getter = "getOauthTokenSecret", mo7664id = 9)
    private String zzqa;
    @Field(getter = "getAuthCode", mo7664id = 12)
    private String zzqb;
    @Field(getter = "getSessionId", mo7664id = 13)
    private String zzqc;
    @Field(getter = "getIdpResponseUrl", mo7664id = 14)
    private String zzqd;
    @Field(getter = "getReturnIdpCredential", mo7664id = 16)
    private boolean zzqe;

    public zzdr() {
        this.zzpt = true;
        this.zzhr = true;
    }

    @Constructor
    zzdr(@Param(mo7667id = 2) String str, @Param(mo7667id = 3) String str2, @Param(mo7667id = 4) String str3, @Param(mo7667id = 5) String str4, @Param(mo7667id = 6) String str5, @Param(mo7667id = 7) String str6, @Param(mo7667id = 8) String str7, @Param(mo7667id = 9) String str8, @Param(mo7667id = 10) boolean z, @Param(mo7667id = 11) boolean z2, @Param(mo7667id = 12) String str9, @Param(mo7667id = 13) String str10, @Param(mo7667id = 14) String str11, @Param(mo7667id = 15) String str12, @Param(mo7667id = 16) boolean z3, @Param(mo7667id = 17) String str13) {
        this.zzpx = str;
        this.zzpy = str2;
        this.zzgc = str3;
        this.zzgd = str4;
        this.zzgb = str5;
        this.zzgh = str6;
        this.zzpz = str7;
        this.zzqa = str8;
        this.zzpt = z;
        this.zzhr = z2;
        this.zzqb = str9;
        this.zzqc = str10;
        this.zzqd = str11;
        this.zzgw = str12;
        this.zzqe = z3;
        this.zzgf = str13;
    }

    public zzdr(@Nullable String str, @Nullable String str2, @NonNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        this.zzpx = "http://localhost";
        this.zzgc = str;
        this.zzgd = str2;
        this.zzqa = str5;
        this.zzqb = str6;
        this.zzgw = str7;
        this.zzgf = str8;
        this.zzpt = true;
        if (!TextUtils.isEmpty(this.zzgc) || !TextUtils.isEmpty(this.zzgd) || !TextUtils.isEmpty(this.zzqb)) {
            this.zzgb = Preconditions.checkNotEmpty(str3);
            this.zzgh = null;
            StringBuilder sb = new StringBuilder();
            String str9 = "&";
            if (!TextUtils.isEmpty(this.zzgc)) {
                sb.append("id_token=");
                sb.append(this.zzgc);
                sb.append(str9);
            }
            if (!TextUtils.isEmpty(this.zzgd)) {
                sb.append("access_token=");
                sb.append(this.zzgd);
                sb.append(str9);
            }
            if (!TextUtils.isEmpty(this.zzgh)) {
                sb.append("identifier=");
                sb.append(this.zzgh);
                sb.append(str9);
            }
            if (!TextUtils.isEmpty(this.zzqa)) {
                sb.append("oauth_token_secret=");
                sb.append(this.zzqa);
                sb.append(str9);
            }
            if (!TextUtils.isEmpty(this.zzqb)) {
                sb.append("code=");
                sb.append(this.zzqb);
                sb.append(str9);
            }
            sb.append("providerId=");
            sb.append(this.zzgb);
            this.zzpz = sb.toString();
            this.zzhr = true;
            return;
        }
        throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
    }

    public final zzdr zzcq(@NonNull String str) {
        this.zzpy = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzdr zzp(boolean z) {
        this.zzhr = false;
        return this;
    }

    public final zzdr zzq(boolean z) {
        this.zzqe = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzpx, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzpy, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzgc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzgd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzgb, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzpz, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzqa, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzpt);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzhr);
        SafeParcelWriter.writeString(parcel, 12, this.zzqb, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzqc, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzqd, false);
        SafeParcelWriter.writeString(parcel, 15, this.zzgw, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzqe);
        SafeParcelWriter.writeString(parcel, 17, this.zzgf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzhb zzds() {
        zza zzk = zzp.zzas().zzi(this.zzpt).zzk(this.zzhr);
        String str = this.zzpy;
        if (str != null) {
            zzk.zzbe(str);
        }
        String str2 = this.zzpx;
        if (str2 != null) {
            zzk.zzbb(str2);
        }
        String str3 = this.zzpz;
        if (str3 != null) {
            zzk.zzbc(str3);
        }
        String str4 = this.zzgw;
        if (str4 != null) {
            zzk.zzbf(str4);
        }
        String str5 = this.zzgf;
        if (str5 != null) {
            zzk.zzbg(str5);
        }
        if (!TextUtils.isEmpty(this.zzqc)) {
            zzk.zzbd(this.zzqc);
        }
        if (!TextUtils.isEmpty(this.zzqd)) {
            zzk.zzbb(this.zzqd);
        }
        zzk.zzj(this.zzqe);
        return (zzp) ((zzfs) zzk.zzhm());
    }
}
