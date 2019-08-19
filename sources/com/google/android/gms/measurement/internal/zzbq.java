package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread.UncaughtExceptionHandler;

final class zzbq implements UncaughtExceptionHandler {
    private final String zzapf;
    private final /* synthetic */ zzbo zzapg;

    public zzbq(zzbo zzbo, String str) {
        this.zzapg = zzbo;
        Preconditions.checkNotNull(str);
        this.zzapf = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzapg.zzgo().zzjd().zzg(this.zzapf, th);
    }
}
