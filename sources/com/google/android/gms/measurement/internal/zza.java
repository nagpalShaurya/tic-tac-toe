package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Map;

public final class zza extends zze {
    private final Map<String, Long> zzafq = new ArrayMap();
    private final Map<String, Integer> zzafr = new ArrayMap();
    private long zzafs;

    public zza(zzbt zzbt) {
        super(zzbt);
    }

    public final void beginAdUnitExposure(String str, long j) {
        if (str == null || str.length() == 0) {
            zzgo().zzjd().zzbx("Ad unit id must be a non-empty string");
        } else {
            zzgn().zzc((Runnable) new zzb(this, str, j));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(String str, long j) {
        zzgb();
        zzaf();
        Preconditions.checkNotEmpty(str);
        if (this.zzafr.isEmpty()) {
            this.zzafs = j;
        }
        Integer num = (Integer) this.zzafr.get(str);
        if (num != null) {
            this.zzafr.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.zzafr.size() >= 100) {
            zzgo().zzjg().zzbx("Too many ads visible");
        } else {
            this.zzafr.put(str, Integer.valueOf(1));
            this.zzafq.put(str, Long.valueOf(j));
        }
    }

    public final void endAdUnitExposure(String str, long j) {
        if (str == null || str.length() == 0) {
            zzgo().zzjd().zzbx("Ad unit id must be a non-empty string");
        } else {
            zzgn().zzc((Runnable) new zzc(this, str, j));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(String str, long j) {
        zzgb();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Integer num = (Integer) this.zzafr.get(str);
        if (num != null) {
            zzdn zzla = zzgh().zzla();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zzafr.remove(str);
                Long l = (Long) this.zzafq.get(str);
                if (l == null) {
                    zzgo().zzjd().zzbx("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.zzafq.remove(str);
                    zza(str, longValue, zzla);
                }
                if (this.zzafr.isEmpty()) {
                    long j2 = this.zzafs;
                    if (j2 == 0) {
                        zzgo().zzjd().zzbx("First ad exposure time was never set");
                        return;
                    } else {
                        zza(j - j2, zzla);
                        this.zzafs = 0;
                    }
                }
                return;
            }
            this.zzafr.put(str, Integer.valueOf(intValue));
            return;
        }
        zzgo().zzjd().zzg("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    @WorkerThread
    private final void zza(long j, zzdn zzdn) {
        if (zzdn == null) {
            zzgo().zzjl().zzbx("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            zzgo().zzjl().zzg("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzdo.zza(zzdn, bundle, true);
            zzge().logEvent("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private final void zza(String str, long j, zzdn zzdn) {
        if (zzdn == null) {
            zzgo().zzjl().zzbx("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            zzgo().zzjl().zzg("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzdo.zza(zzdn, bundle, true);
            zzge().logEvent("am", "_xu", bundle);
        }
    }

    @WorkerThread
    public final void zzq(long j) {
        zzdn zzla = zzgh().zzla();
        for (String str : this.zzafq.keySet()) {
            zza(str, j - ((Long) this.zzafq.get(str)).longValue(), zzla);
        }
        if (!this.zzafq.isEmpty()) {
            zza(j - this.zzafs, zzla);
        }
        zzr(j);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzr(long j) {
        for (String put : this.zzafq.keySet()) {
            this.zzafq.put(put, Long.valueOf(j));
        }
        if (!this.zzafq.isEmpty()) {
            this.zzafs = j;
        }
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
