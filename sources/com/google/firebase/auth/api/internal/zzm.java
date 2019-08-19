package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdv;
import com.google.firebase.auth.internal.zzq;

final class zzm implements zzez<zzdv> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;

    zzm(zza zza, zzdp zzdp) {
        this.zzis = zza;
        this.zzir = zzdp;
    }

    public final void zzbp(@Nullable String str) {
        this.zzir.onFailure(zzq.zzct(str));
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzdv zzdv = (zzdv) obj;
        this.zzis.zza(new zzcz(zzdv.zzr(), zzdv.getIdToken(), Long.valueOf(zzdv.zzs()), "Bearer"), null, null, Boolean.valueOf(zzdv.isNewUser()), null, this.zzir, this);
    }
}
