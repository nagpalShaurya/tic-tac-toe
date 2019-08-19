package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzfe implements Callable<String> {
    private final /* synthetic */ zzh zzaqn;
    private final /* synthetic */ zzfa zzaty;

    zzfe(zzfa zzfa, zzh zzh) {
        this.zzaty = zzfa;
        this.zzaqn = zzh;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzg zzg;
        if (this.zzaty.zzgq().zzbd(this.zzaqn.packageName)) {
            zzg = this.zzaty.zzg(this.zzaqn);
        } else {
            zzg = this.zzaty.zzjq().zzbl(this.zzaqn.packageName);
        }
        if (zzg != null) {
            return zzg.getAppInstanceId();
        }
        this.zzaty.zzgo().zzjg().zzbx("App info was null when attempting to get app instance id");
        return null;
    }
}
