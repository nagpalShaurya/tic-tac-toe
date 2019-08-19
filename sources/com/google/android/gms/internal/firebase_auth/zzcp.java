package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzjl.zza;
import com.google.firebase.auth.api.internal.zzff;

public final class zzcp implements zzff<zza> {
    private String zzow;
    private String zzox;
    @Nullable
    private final String zzoy;

    public zzcp(String str) {
        this(str, null);
    }

    private zzcp(String str, @Nullable String str2) {
        this.zzow = zzco.REFRESH_TOKEN.toString();
        this.zzox = Preconditions.checkNotEmpty(str);
        this.zzoy = null;
    }

    public final /* synthetic */ zzhb zzds() {
        return (zza) ((zzfs) zza.zzjy().zzdf(this.zzow).zzdg(this.zzox).zzhm());
    }
}
