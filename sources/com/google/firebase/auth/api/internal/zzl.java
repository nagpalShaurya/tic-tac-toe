package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.auth.internal.zzq;

final class zzl implements zzez<Object> {
    private final /* synthetic */ zzdp zzir;

    zzl(zza zza, zzdp zzdp) {
        this.zzir = zzdp;
    }

    public final void zzbp(@Nullable String str) {
        this.zzir.onFailure(zzq.zzct(str));
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzir.zzdf();
    }
}
