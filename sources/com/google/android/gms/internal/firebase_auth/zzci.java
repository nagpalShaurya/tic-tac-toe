package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zza;
import com.google.android.gms.internal.firebase_auth.zzj.zza.C0528zza;
import com.google.firebase.auth.api.internal.zzff;

public final class zzci implements zzff<zza> {
    @Nullable
    private final String zzgw;
    private String zzoj;
    private String zzok = "http://localhost";

    public zzci(@NonNull String str, @Nullable String str2) {
        this.zzoj = Preconditions.checkNotEmpty(str);
        this.zzgw = str2;
    }

    public final /* synthetic */ zzhb zzds() {
        C0528zza zze = zza.zzc().zzd(this.zzoj).zze(this.zzok);
        String str = this.zzgw;
        if (str != null) {
            zze.zzf(str);
        }
        return (zza) ((zzfs) zze.zzhm());
    }
}
