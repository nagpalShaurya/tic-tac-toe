package com.google.android.gms.measurement.internal;

final class zzet implements Runnable {
    private final /* synthetic */ long zzafv;
    private final /* synthetic */ zzeq zzasz;

    zzet(zzeq zzeq, long j) {
        this.zzasz = zzeq;
        this.zzafv = j;
    }

    public final void run() {
        this.zzasz.zzal(this.zzafv);
    }
}
