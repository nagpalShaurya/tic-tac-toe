package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzcn;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.auth.internal.zzq;

final class zzf implements zzez<zzcn> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;

    zzf(zza zza, zzdp zzdp) {
        this.zzis = zza;
        this.zzir = zzdp;
    }

    public final void zzbp(@Nullable String str) {
        this.zzir.onFailure(zzq.zzct(str));
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzcn zzcn = (zzcn) obj;
        this.zzis.zza(new zzcz(zzcn.zzr(), zzcn.getIdToken(), Long.valueOf(zzcn.zzs()), "Bearer"), null, null, Boolean.valueOf(zzcn.isNewUser()), null, this.zzir, this);
    }
}
