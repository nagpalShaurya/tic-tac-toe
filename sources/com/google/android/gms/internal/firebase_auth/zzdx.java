package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzt;
import com.google.android.gms.internal.firebase_auth.zzj.zzt.zza;
import com.google.firebase.auth.api.internal.zzff;

public final class zzdx implements zzff<zzt> {
    private String zzgh;
    private String zzgi;
    @Nullable
    private final String zzgw;
    private boolean zzpt = true;

    public zzdx(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        this.zzgh = Preconditions.checkNotEmpty(str);
        this.zzgi = Preconditions.checkNotEmpty(str2);
        this.zzgw = str3;
    }

    public final /* synthetic */ zzhb zzds() {
        zza zzm = zzt.zzbd().zzbj(this.zzgh).zzbk(this.zzgi).zzm(this.zzpt);
        String str = this.zzgw;
        if (str != null) {
            zzm.zzbl(str);
        }
        return (zzt) ((zzfs) zzm.zzhm());
    }
}
