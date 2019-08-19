package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzdp implements Runnable {
    private final /* synthetic */ boolean zzaru;
    private final /* synthetic */ zzdn zzarv;
    private final /* synthetic */ zzdn zzarw;
    private final /* synthetic */ zzdo zzarx;

    zzdp(zzdo zzdo, boolean z, zzdn zzdn, zzdn zzdn2) {
        this.zzarx = zzdo;
        this.zzaru = z;
        this.zzarv = zzdn;
        this.zzarw = zzdn2;
    }

    public final void run() {
        if (this.zzaru && this.zzarx.zzaro != null) {
            zzdo zzdo = this.zzarx;
            zzdo.zza(zzdo.zzaro);
        }
        zzdn zzdn = this.zzarv;
        if (zzdn == null || zzdn.zzarm != this.zzarw.zzarm || !zzfk.zzu(this.zzarv.zzarl, this.zzarw.zzarl) || !zzfk.zzu(this.zzarv.zzuw, this.zzarw.zzuw)) {
            Bundle bundle = new Bundle();
            zzdo.zza(this.zzarw, bundle, true);
            zzdn zzdn2 = this.zzarv;
            if (zzdn2 != null) {
                if (zzdn2.zzuw != null) {
                    bundle.putString("_pn", this.zzarv.zzuw);
                }
                bundle.putString("_pc", this.zzarv.zzarl);
                bundle.putLong("_pi", this.zzarv.zzarm);
            }
            this.zzarx.zzge().zza("auto", "_vs", bundle);
        }
        zzdo zzdo2 = this.zzarx;
        zzdo2.zzaro = this.zzarw;
        zzdo2.zzgg().zzb(this.zzarw);
    }
}
