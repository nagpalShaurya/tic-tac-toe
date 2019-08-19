package com.google.firebase.auth.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.google.firebase.auth.FirebaseAuth;

public final class zzz {
    private static final zzz zzrq = new zzz();
    private final zzac zzro;
    private final zzx zzrp;

    private zzz() {
        this(zzac.zzen(), zzx.zzek());
    }

    @VisibleForTesting
    private zzz(@NonNull zzac zzac, @NonNull zzx zzx) {
        this.zzro = zzac;
        this.zzrp = zzx;
    }

    public static zzz zzem() {
        return zzrq;
    }

    public final void zzg(@NonNull FirebaseAuth firebaseAuth) {
        this.zzro.zzh(firebaseAuth);
    }

    public final void zza(@NonNull Context context) {
        this.zzro.zza(context);
    }
}
