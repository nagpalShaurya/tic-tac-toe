package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdx;

abstract class zzv {
    private static volatile Handler handler;
    private final zzcq zzahw;
    private final Runnable zzyo;
    /* access modifiers changed from: private */
    public volatile long zzyp;

    zzv(zzcq zzcq) {
        Preconditions.checkNotNull(zzcq);
        this.zzahw = zzcq;
        this.zzyo = new zzw(this, zzcq);
    }

    public abstract void run();

    public final void zzh(long j) {
        cancel();
        if (j >= 0) {
            this.zzyp = this.zzahw.zzbx().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzyo, j)) {
                this.zzahw.zzgo().zzjd().zzg("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean zzej() {
        return this.zzyp != 0;
    }

    /* access modifiers changed from: 0000 */
    public final void cancel() {
        this.zzyp = 0;
        getHandler().removeCallbacks(this.zzyo);
    }

    private final Handler getHandler() {
        Handler handler2;
        if (handler != null) {
            return handler;
        }
        synchronized (zzv.class) {
            if (handler == null) {
                handler = new zzdx(this.zzahw.getContext().getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }
}
