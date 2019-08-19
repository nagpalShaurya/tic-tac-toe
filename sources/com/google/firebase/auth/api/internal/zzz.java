package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

final class zzz implements zzez<Void> {
    private final /* synthetic */ zzez zzjg;
    private final /* synthetic */ zzy zzjm;

    zzz(zzy zzy, zzez zzez) {
        this.zzjm = zzy;
        this.zzjg = zzez;
    }

    public final void zzbp(@Nullable String str) {
        this.zzjg.zzbp(str);
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzjm.zzir.zzde();
    }
}
