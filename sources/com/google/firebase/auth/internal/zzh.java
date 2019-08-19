package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaf;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

@Class(creator = "DefaultAuthUserInfoCreator")
public final class zzh extends AbstractSafeParcelable implements UserInfo {
    public static final Creator<zzh> CREATOR = new zzi();
    @Field(getter = "getProviderId", mo7664id = 2)
    @NonNull
    private String zzgb;
    @Nullable
    @Field(getter = "getEmail", mo7664id = 5)
    private String zzgh;
    @Nullable
    @Field(getter = "getPhoneNumber", mo7664id = 6)
    private String zzhq;
    @Nullable
    @Field(getter = "getDisplayName", mo7664id = 3)
    private String zzhw;
    @Nullable
    @Field(getter = "getPhotoUrlString", mo7664id = 4)
    private String zzhx;
    @Nullable
    private Uri zzia;
    @Field(getter = "isEmailVerified", mo7664id = 7)
    private boolean zzpa;
    @Nullable
    @Field(getter = "getRawUserInfo", mo7664id = 8)
    private String zzpl;
    @Field(getter = "getUid", mo7664id = 1)
    @NonNull
    private String zzqq;

    @Constructor
    @VisibleForTesting
    public zzh(@Param(mo7667id = 1) @NonNull String str, @Param(mo7667id = 2) @NonNull String str2, @Nullable @Param(mo7667id = 5) String str3, @Nullable @Param(mo7667id = 4) String str4, @Nullable @Param(mo7667id = 3) String str5, @Nullable @Param(mo7667id = 6) String str6, @Param(mo7667id = 7) boolean z, @Nullable @Param(mo7667id = 8) String str7) {
        this.zzqq = str;
        this.zzgb = str2;
        this.zzgh = str3;
        this.zzhq = str4;
        this.zzhw = str5;
        this.zzhx = str6;
        if (!TextUtils.isEmpty(this.zzhx)) {
            this.zzia = Uri.parse(this.zzhx);
        }
        this.zzpa = z;
        this.zzpl = str7;
    }

    public zzh(@NonNull zzct zzct, @NonNull String str) {
        Preconditions.checkNotNull(zzct);
        Preconditions.checkNotEmpty(str);
        this.zzqq = Preconditions.checkNotEmpty(zzct.getLocalId());
        this.zzgb = str;
        this.zzgh = zzct.getEmail();
        this.zzhw = zzct.getDisplayName();
        Uri photoUri = zzct.getPhotoUri();
        if (photoUri != null) {
            this.zzhx = photoUri.toString();
            this.zzia = photoUri;
        }
        this.zzpa = zzct.isEmailVerified();
        this.zzpl = null;
        this.zzhq = zzct.getPhoneNumber();
    }

    public zzh(@NonNull zzdb zzdb) {
        Preconditions.checkNotNull(zzdb);
        this.zzqq = zzdb.zzbg();
        this.zzgb = Preconditions.checkNotEmpty(zzdb.getProviderId());
        this.zzhw = zzdb.getDisplayName();
        Uri photoUri = zzdb.getPhotoUri();
        if (photoUri != null) {
            this.zzhx = photoUri.toString();
            this.zzia = photoUri;
        }
        this.zzgh = zzdb.getEmail();
        this.zzhq = zzdb.getPhoneNumber();
        this.zzpa = false;
        this.zzpl = zzdb.getRawUserInfo();
    }

    @NonNull
    public final String getUid() {
        return this.zzqq;
    }

    @NonNull
    public final String getProviderId() {
        return this.zzgb;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzhw;
    }

    @Nullable
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzhx) && this.zzia == null) {
            this.zzia = Uri.parse(this.zzhx);
        }
        return this.zzia;
    }

    @Nullable
    public final String getEmail() {
        return this.zzgh;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.zzhq;
    }

    public final boolean isEmailVerified() {
        return this.zzpa;
    }

    @Nullable
    public final String getRawUserInfo() {
        return this.zzpl;
    }

    @Nullable
    public final String zzdz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zzqq);
            jSONObject.putOpt("providerId", this.zzgb);
            jSONObject.putOpt("displayName", this.zzhw);
            jSONObject.putOpt("photoUrl", this.zzhx);
            jSONObject.putOpt("email", this.zzgh);
            jSONObject.putOpt("phoneNumber", this.zzhq);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzpa));
            jSONObject.putOpt("rawUserInfo", this.zzpl);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzaf((Throwable) e);
        }
    }

    @Nullable
    public static zzh zzcr(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzh zzh = new zzh(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
            return zzh;
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzaf((Throwable) e);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhx, false);
        SafeParcelWriter.writeString(parcel, 5, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 6, getPhoneNumber(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmailVerified());
        SafeParcelWriter.writeString(parcel, 8, this.zzpl, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
