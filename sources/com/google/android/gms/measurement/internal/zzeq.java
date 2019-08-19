package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzdx;

public final class zzeq extends zzf {
    private Handler handler;
    @VisibleForTesting
    private long zzasw = zzbx().elapsedRealtime();
    private final zzv zzasx = new zzer(this, this.zzadj);
    private final zzv zzasy = new zzes(this, this.zzadj);

    zzeq(zzbt zzbt) {
        super(zzbt);
    }

    private final void zzli() {
        synchronized (this) {
            if (this.handler == null) {
                this.handler = new zzdx(Looper.getMainLooper());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzlj() {
        this.zzasx.cancel();
        this.zzasy.cancel();
        this.zzasw = 0;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzal(long j) {
        zzaf();
        zzli();
        zzgo().zzjl().zzg("Activity resumed, time", Long.valueOf(j));
        this.zzasw = j;
        if (zzgq().zzbj(zzgf().zzal())) {
            zzam(zzbx().currentTimeMillis());
            return;
        }
        this.zzasx.cancel();
        this.zzasy.cancel();
        if (zzbx().currentTimeMillis() - zzgp().zzanq.get() > zzgp().zzant.get()) {
            zzgp().zzanr.set(true);
            zzgp().zzanu.set(0);
        }
        if (zzgp().zzanr.get()) {
            this.zzasx.zzh(Math.max(0, zzgp().zzanp.get() - zzgp().zzanu.get()));
        } else {
            this.zzasy.zzh(Math.max(0, 3600000 - zzgp().zzanu.get()));
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzam(long j) {
        zzaf();
        zzli();
        this.zzasx.cancel();
        this.zzasy.cancel();
        if (j - zzgp().zzanq.get() > zzgp().zzant.get()) {
            zzgp().zzanr.set(true);
            zzgp().zzanu.set(0);
        }
        if (zzgp().zzanr.get()) {
            zzao(j);
        } else {
            this.zzasy.zzh(Math.max(0, 3600000 - zzgp().zzanu.get()));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzan(long j) {
        zzaf();
        zzli();
        this.zzasx.cancel();
        this.zzasy.cancel();
        zzgo().zzjl().zzg("Activity paused, time", Long.valueOf(j));
        if (this.zzasw != 0) {
            zzgp().zzanu.set(zzgp().zzanu.get() + (j - this.zzasw));
        }
    }

    @WorkerThread
    private final void zzao(long j) {
        zzaf();
        String str = "Session started, time";
        zzgo().zzjl().zzg(str, Long.valueOf(zzbx().elapsedRealtime()));
        if (zzgq().zzbi(zzgf().zzal())) {
            long j2 = j / 1000;
            zzcs zzge = zzge();
            Long valueOf = Long.valueOf(j2);
            zzge.zza("auto", "_sid", (Object) valueOf, j);
        } else {
            zzge().zza("auto", "_sid", (Object) null, j);
        }
        zzgp().zzanr.set(false);
        Bundle bundle = new Bundle();
        if (zzgq().zzbi(zzgf().zzal())) {
            bundle.putLong("_sid", j / 1000);
        }
        zzge().zza("auto", "_s", j, bundle);
        zzgp().zzant.set(j);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zzlk() {
        zzaf();
        zzao(zzbx().currentTimeMillis());
    }

    @WorkerThread
    public final boolean zzn(boolean z) {
        zzaf();
        zzcl();
        long elapsedRealtime = zzbx().elapsedRealtime();
        zzgp().zzant.set(zzbx().currentTimeMillis());
        long j = elapsedRealtime - this.zzasw;
        if (z || j >= 1000) {
            zzgp().zzanu.set(j);
            zzgo().zzjl().zzg("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzdo.zza(zzgh().zzla(), bundle, true);
            zzge().logEvent("auto", "_e", bundle);
            this.zzasw = elapsedRealtime;
            this.zzasy.cancel();
            this.zzasy.zzh(Math.max(0, 3600000 - zzgp().zzanu.get()));
            return true;
        }
        zzgo().zzjl().zzg("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzll() {
        zzaf();
        zzn(false);
        zzgd().zzq(zzbx().elapsedRealtime());
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzga() {
        super.zzga();
    }

    public final /* bridge */ /* synthetic */ void zzgb() {
        super.zzgb();
    }

    public final /* bridge */ /* synthetic */ void zzgc() {
        super.zzgc();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zza zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzcs zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzaj zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzdr zzgg() {
        return super.zzgg();
    }

    public final /* bridge */ /* synthetic */ zzdo zzgh() {
        return super.zzgh();
    }

    public final /* bridge */ /* synthetic */ zzal zzgi() {
        return super.zzgi();
    }

    public final /* bridge */ /* synthetic */ zzeq zzgj() {
        return super.zzgj();
    }

    public final /* bridge */ /* synthetic */ zzx zzgk() {
        return super.zzgk();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzan zzgl() {
        return super.zzgl();
    }

    public final /* bridge */ /* synthetic */ zzfk zzgm() {
        return super.zzgm();
    }

    public final /* bridge */ /* synthetic */ zzbo zzgn() {
        return super.zzgn();
    }

    public final /* bridge */ /* synthetic */ zzap zzgo() {
        return super.zzgo();
    }

    public final /* bridge */ /* synthetic */ zzba zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ zzn zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzk zzgr() {
        return super.zzgr();
    }
}
