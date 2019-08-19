package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcz implements Runnable {
    private final /* synthetic */ zzcs zzarc;
    private final /* synthetic */ long zzari;

    zzcz(zzcs zzcs, long j) {
        this.zzarc = zzcs;
        this.zzari = j;
    }

    public final void run() {
        zzcs zzcs = this.zzarc;
        long j = this.zzari;
        zzcs.zzaf();
        zzcs.zzgb();
        zzcs.zzcl();
        zzcs.zzgo().zzjk().zzbx("Resetting analytics data (FE)");
        zzcs.zzgj().zzlj();
        if (zzcs.zzgq().zzbe(zzcs.zzgf().zzal())) {
            zzcs.zzgp().zzanj.set(j);
        }
        boolean isEnabled = zzcs.zzadj.isEnabled();
        if (!zzcs.zzgq().zzhu()) {
            zzcs.zzgp().zzi(!isEnabled);
        }
        zzcs.zzgg().resetAnalyticsData();
        zzcs.zzara = !isEnabled;
        if (this.zzarc.zzgq().zza(zzaf.zzalk)) {
            this.zzarc.zzgg().zza(new AtomicReference<>());
        }
    }
}
