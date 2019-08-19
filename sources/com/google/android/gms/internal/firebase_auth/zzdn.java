package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzn;
import com.google.android.gms.internal.firebase_auth.zzj.zzn.zza;
import com.google.firebase.auth.api.internal.zzff;

public final class zzdn implements zzff<zzn> {
    private String zzgh;
    private String zzgi;
    @Nullable
    private String zzgw;
    @Nullable
    private String zzhw;

    public zzdn(@Nullable String str) {
        this.zzgw = str;
    }

    public zzdn(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4) {
        this.zzgh = Preconditions.checkNotEmpty(str);
        this.zzgi = Preconditions.checkNotEmpty(str2);
        this.zzhw = null;
        this.zzgw = str4;
    }

    public final /* synthetic */ zzhb zzds() {
        zza zzap = zzn.zzap();
        String str = this.zzgh;
        if (str != null) {
            zzap.zzau(str);
        }
        String str2 = this.zzgi;
        if (str2 != null) {
            zzap.zzav(str2);
        }
        String str3 = this.zzgw;
        if (str3 != null) {
            zzap.zzaw(str3);
        }
        return (zzn) ((zzfs) zzap.zzhm());
    }
}
