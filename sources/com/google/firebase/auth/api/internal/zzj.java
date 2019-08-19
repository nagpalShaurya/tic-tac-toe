package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.firebase.auth.internal.zzq;

final class zzj implements zzez<zzcj> {
    private final /* synthetic */ zzdp zzir;

    zzj(zza zza, zzdp zzdp) {
        this.zzir = zzdp;
    }

    public final void zzbp(@Nullable String str) {
        this.zzir.onFailure(zzq.zzct(str));
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzir.zza((zzcj) obj);
    }
}
