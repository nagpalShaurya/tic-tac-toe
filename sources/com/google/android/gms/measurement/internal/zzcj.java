package com.google.android.gms.measurement.internal;

final class zzcj implements Runnable {
    private final /* synthetic */ zzh zzaqn;
    private final /* synthetic */ zzbv zzaqo;
    private final /* synthetic */ zzfh zzaqs;

    zzcj(zzbv zzbv, zzfh zzfh, zzh zzh) {
        this.zzaqo = zzbv;
        this.zzaqs = zzfh;
        this.zzaqn = zzh;
    }

    public final void run() {
        this.zzaqo.zzamz.zzly();
        this.zzaqo.zzamz.zzc(this.zzaqs, this.zzaqn);
    }
}
