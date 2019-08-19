package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;

public final class zzeg {
    private String zzmo;

    public zzeg(@NonNull String str) {
        this.zzmo = Preconditions.checkNotEmpty(str);
    }

    public final zzef zzdk() {
        return new zzef(this.zzmo, null);
    }
}
