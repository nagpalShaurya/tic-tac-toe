package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzdt;

final class zzq implements zzez<zzcz> {
    final /* synthetic */ zzdp zzir;
    final /* synthetic */ zza zzis;
    private final /* synthetic */ zzdr zzjf;

    zzq(zza zza, zzdr zzdr, zzdp zzdp) {
        this.zzis = zza;
        this.zzjf = zzdr;
        this.zzir = zzdp;
    }

    public final void zzbp(@Nullable String str) {
        this.zzir.onFailure(com.google.firebase.auth.internal.zzq.zzct(str));
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzcz zzcz = (zzcz) obj;
        if (this.zzis.zziq.zzdi().booleanValue()) {
            this.zzjf.zzq(this.zzis.zziq.zzdi().booleanValue());
        }
        this.zzjf.zzcq(zzcz.zzdw());
        this.zzis.zzip.zza(this.zzjf, (zzez<zzdt>) new zzr<zzdt>(this, this));
    }
}
