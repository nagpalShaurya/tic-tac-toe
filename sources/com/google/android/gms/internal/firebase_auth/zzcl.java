package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzc;
import com.google.firebase.auth.api.internal.zzff;

public final class zzcl implements zzff<zzc> {
    private String zzgc;

    public zzcl(@NonNull String str) {
        this.zzgc = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzhb zzds() {
        return (zzc) ((zzfs) zzc.zzn().zzh(this.zzgc).zzhm());
    }
}
