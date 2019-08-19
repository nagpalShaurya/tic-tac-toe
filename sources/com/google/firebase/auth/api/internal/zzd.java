package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdy;
import com.google.firebase.auth.internal.zzq;

final class zzd implements zzez<zzdy> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;

    zzd(zza zza, zzdp zzdp) {
        this.zzis = zza;
        this.zzir = zzdp;
    }

    public final void zzbp(@Nullable String str) {
        this.zzir.onFailure(zzq.zzct(str));
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzdy zzdy = (zzdy) obj;
        this.zzis.zza(new zzcz(zzdy.zzr(), zzdy.getIdToken(), Long.valueOf(zzdy.zzs()), "Bearer"), null, null, Boolean.valueOf(false), null, this.zzir, this);
    }
}
