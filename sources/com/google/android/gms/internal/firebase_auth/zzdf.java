package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzi;
import com.google.android.gms.internal.firebase_auth.zzj.zzi.zza;
import com.google.firebase.auth.api.internal.zzff;

public final class zzdf implements zzff<zzi> {
    @Nullable
    private final String zzgw;
    private final String zzib;
    @Nullable
    private final String zzic;

    public zzdf(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        this.zzib = Preconditions.checkNotEmpty(str);
        this.zzic = str2;
        this.zzgw = str3;
    }

    public final /* synthetic */ zzhb zzds() {
        zza zzaf = zzi.zzab().zzaf(this.zzib);
        String str = this.zzic;
        if (str != null) {
            zzaf.zzag(str);
        }
        String str2 = this.zzgw;
        if (str2 != null) {
            zzaf.zzah(str2);
        }
        return (zzi) ((zzfs) zzaf.zzhm());
    }
}
