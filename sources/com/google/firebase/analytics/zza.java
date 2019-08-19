package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zza implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zzbse;

    zza(FirebaseAnalytics firebaseAnalytics) {
        this.zzbse = firebaseAnalytics;
    }

    public final /* synthetic */ Object call() throws Exception {
        String zza = this.zzbse.zzfx();
        if (zza != null) {
            return zza;
        }
        String zzaj = this.zzbse.zzadj.zzge().zzaj(120000);
        if (zzaj != null) {
            this.zzbse.zzcm(zzaj);
            return zzaj;
        }
        throw new TimeoutException();
    }
}
