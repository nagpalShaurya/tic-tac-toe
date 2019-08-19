package com.google.android.gms.measurement.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzbr<V> extends FutureTask<V> implements Comparable<zzbr> {
    private final String zzapf;
    private final /* synthetic */ zzbo zzapg;
    private final long zzaph = zzbo.zzape.getAndIncrement();
    final boolean zzapi;

    zzbr(zzbo zzbo, Callable<V> callable, boolean z, String str) {
        this.zzapg = zzbo;
        super(callable);
        Preconditions.checkNotNull(str);
        this.zzapf = str;
        this.zzapi = z;
        if (this.zzaph == Long.MAX_VALUE) {
            zzbo.zzgo().zzjd().zzbx("Tasks index overflow");
        }
    }

    zzbr(zzbo zzbo, Runnable runnable, boolean z, String str) {
        this.zzapg = zzbo;
        super(runnable, null);
        Preconditions.checkNotNull(str);
        this.zzapf = str;
        this.zzapi = false;
        if (this.zzaph == Long.MAX_VALUE) {
            zzbo.zzgo().zzjd().zzbx("Tasks index overflow");
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zzapg.zzgo().zzjd().zzg(this.zzapf, th);
        if (th instanceof zzbp) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        zzbr zzbr = (zzbr) obj;
        boolean z = this.zzapi;
        if (z != zzbr.zzapi) {
            return z ? -1 : 1;
        }
        long j = this.zzaph;
        long j2 = zzbr.zzaph;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzapg.zzgo().zzje().zzg("Two tasks share the same index. index", Long.valueOf(this.zzaph));
        return 0;
    }
}
