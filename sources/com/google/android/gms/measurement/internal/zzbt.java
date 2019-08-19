package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzsl;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.atomic.AtomicReference;

public class zzbt implements zzcq {
    private static volatile zzbt zzapl;
    private final boolean zzadv;
    private final String zzadx;
    private final long zzagx;
    private final zzk zzaiq;
    private final String zzapm;
    private final String zzapn;
    private final zzn zzapo;
    private final zzba zzapp;
    private final zzap zzapq;
    private final zzbo zzapr;
    private final zzeq zzaps;
    private final AppMeasurement zzapt;
    private final zzfk zzapu;
    private final zzan zzapv;
    private final zzdo zzapw;
    private final zzcs zzapx;
    private final zza zzapy;
    private zzal zzapz;
    private zzdr zzaqa;
    private zzx zzaqb;
    private zzaj zzaqc;
    private zzbg zzaqd;
    private Boolean zzaqe;
    private long zzaqf;
    private volatile Boolean zzaqg;
    private int zzaqh;
    private int zzaqi;
    private final Context zzri;
    private final Clock zzrz;
    private boolean zzvz = false;

    private zzbt(zzcr zzcr) {
        Preconditions.checkNotNull(zzcr);
        this.zzaiq = new zzk(zzcr.zzri);
        zzaf.zza(this.zzaiq);
        this.zzri = zzcr.zzri;
        this.zzadx = zzcr.zzadx;
        this.zzapm = zzcr.zzapm;
        this.zzapn = zzcr.zzapn;
        this.zzadv = zzcr.zzadv;
        this.zzaqg = zzcr.zzaqg;
        zzsl.init(this.zzri);
        this.zzrz = DefaultClock.getInstance();
        this.zzagx = this.zzrz.currentTimeMillis();
        this.zzapo = new zzn(this);
        zzba zzba = new zzba(this);
        zzba.zzq();
        this.zzapp = zzba;
        zzap zzap = new zzap(this);
        zzap.zzq();
        this.zzapq = zzap;
        zzfk zzfk = new zzfk(this);
        zzfk.zzq();
        this.zzapu = zzfk;
        zzan zzan = new zzan(this);
        zzan.zzq();
        this.zzapv = zzan;
        this.zzapy = new zza(this);
        zzdo zzdo = new zzdo(this);
        zzdo.zzq();
        this.zzapw = zzdo;
        zzcs zzcs = new zzcs(this);
        zzcs.zzq();
        this.zzapx = zzcs;
        this.zzapt = new AppMeasurement(this);
        zzeq zzeq = new zzeq(this);
        zzeq.zzq();
        this.zzaps = zzeq;
        zzbo zzbo = new zzbo(this);
        zzbo.zzq();
        this.zzapr = zzbo;
        zzk zzk = this.zzaiq;
        if (this.zzri.getApplicationContext() instanceof Application) {
            zzcs zzge = zzge();
            if (zzge.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) zzge.getContext().getApplicationContext();
                if (zzge.zzaqv == null) {
                    zzge.zzaqv = new zzdm(zzge, null);
                }
                application.unregisterActivityLifecycleCallbacks(zzge.zzaqv);
                application.registerActivityLifecycleCallbacks(zzge.zzaqv);
                zzge.zzgo().zzjl().zzbx("Registered activity lifecycle callback");
            }
        } else {
            zzgo().zzjg().zzbx("Application context is not an Application");
        }
        this.zzapr.zzc((Runnable) new zzbu(this, zzcr));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzcr zzcr) {
        String str;
        zzar zzar;
        zzgn().zzaf();
        zzn.zzht();
        zzx zzx = new zzx(this);
        zzx.zzq();
        this.zzaqb = zzx;
        zzaj zzaj = new zzaj(this);
        zzaj.zzq();
        this.zzaqc = zzaj;
        zzal zzal = new zzal(this);
        zzal.zzq();
        this.zzapz = zzal;
        zzdr zzdr = new zzdr(this);
        zzdr.zzq();
        this.zzaqa = zzdr;
        this.zzapu.zzgs();
        this.zzapp.zzgs();
        this.zzaqd = new zzbg(this);
        this.zzaqc.zzgs();
        zzgo().zzjj().zzg("App measurement is starting up, version", Long.valueOf(this.zzapo.zzhc()));
        zzk zzk = this.zzaiq;
        zzgo().zzjj().zzbx("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzk zzk2 = this.zzaiq;
        String zzal2 = zzaj.zzal();
        if (TextUtils.isEmpty(this.zzadx)) {
            if (zzgm().zzcw(zzal2)) {
                zzar = zzgo().zzjj();
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzar = zzgo().zzjj();
                String str2 = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
                String valueOf = String.valueOf(zzal2);
                str = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            }
            zzar.zzbx(str);
        }
        zzgo().zzjk().zzbx("Debug-level message logging enabled");
        if (this.zzaqh != this.zzaqi) {
            zzgo().zzjd().zze("Not all components initialized", Integer.valueOf(this.zzaqh), Integer.valueOf(this.zzaqi));
        }
        this.zzvz = true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void start() {
        zzgn().zzaf();
        if (zzgp().zzane.get() == 0) {
            zzgp().zzane.set(this.zzrz.currentTimeMillis());
        }
        if (Long.valueOf(zzgp().zzanj.get()).longValue() == 0) {
            zzgo().zzjl().zzg("Persisting first open", Long.valueOf(this.zzagx));
            zzgp().zzanj.set(this.zzagx);
        }
        if (zzkr()) {
            zzk zzk = this.zzaiq;
            if (!TextUtils.isEmpty(zzgf().getGmpAppId()) || !TextUtils.isEmpty(zzgf().zzgw())) {
                zzgm();
                if (zzfk.zza(zzgf().getGmpAppId(), zzgp().zzjs(), zzgf().zzgw(), zzgp().zzjt())) {
                    zzgo().zzjj().zzbx("Rechecking which service to use due to a GMP App Id change");
                    zzgp().zzjv();
                    if (this.zzapo.zza(zzaf.zzalc)) {
                        zzgi().resetAnalyticsData();
                    }
                    this.zzaqa.disconnect();
                    this.zzaqa.zzdj();
                    zzgp().zzanj.set(this.zzagx);
                    zzgp().zzanl.zzcc(null);
                }
                zzgp().zzca(zzgf().getGmpAppId());
                zzgp().zzcb(zzgf().zzgw());
                if (this.zzapo.zzbj(zzgf().zzal())) {
                    this.zzaps.zzam(this.zzagx);
                }
            }
            zzge().zzcm(zzgp().zzanl.zzjz());
            zzk zzk2 = this.zzaiq;
            if (!TextUtils.isEmpty(zzgf().getGmpAppId()) || !TextUtils.isEmpty(zzgf().zzgw())) {
                boolean isEnabled = isEnabled();
                if (!zzgp().zzjy() && !this.zzapo.zzhu()) {
                    zzgp().zzi(!isEnabled);
                }
                if (this.zzapo.zze(zzgf().zzal(), zzaf.zzalj)) {
                    zzj(false);
                }
                if (!this.zzapo.zzbd(zzgf().zzal()) || isEnabled) {
                    zzge().zzkz();
                }
                zzgg().zza(new AtomicReference<>());
            }
        } else if (isEnabled()) {
            if (!zzgm().zzx("android.permission.INTERNET")) {
                zzgo().zzjd().zzbx("App is missing INTERNET permission");
            }
            if (!zzgm().zzx("android.permission.ACCESS_NETWORK_STATE")) {
                zzgo().zzjd().zzbx("App is missing ACCESS_NETWORK_STATE permission");
            }
            zzk zzk3 = this.zzaiq;
            if (!Wrappers.packageManager(this.zzri).isCallerInstantApp() && !this.zzapo.zzib()) {
                if (!zzbj.zza(this.zzri)) {
                    zzgo().zzjd().zzbx("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzfk.zza(this.zzri, false)) {
                    zzgo().zzjd().zzbx("AppMeasurementService not registered/enabled");
                }
            }
            zzgo().zzjd().zzbx("Uploading is not possible. App measurement disabled");
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(boolean r13) {
        /*
            r12 = this;
            com.google.android.gms.measurement.internal.zzbo r0 = r12.zzgn()
            r0.zzaf()
            com.google.android.gms.measurement.internal.zzba r0 = r12.zzgp()
            com.google.android.gms.measurement.internal.zzbf r0 = r0.zzans
            java.lang.String r4 = r0.zzjz()
            if (r13 != 0) goto L_0x0045
            if (r4 == 0) goto L_0x0045
            java.lang.String r13 = "unset"
            boolean r13 = r13.equals(r4)
            if (r13 == 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzcs r5 = r12.zzge()
            r8 = 0
            com.google.android.gms.common.util.Clock r13 = r12.zzrz
            long r9 = r13.currentTimeMillis()
            java.lang.String r6 = "app"
            java.lang.String r7 = "_ap"
            r5.zza(r6, r7, r8, r9)
            goto L_0x0045
        L_0x0032:
            com.google.android.gms.measurement.internal.zzcs r1 = r12.zzge()
            com.google.android.gms.common.util.Clock r13 = r12.zzrz
            long r5 = r13.currentTimeMillis()
            java.lang.String r2 = "app"
            java.lang.String r3 = "_ap"
            r1.zza(r2, r3, r4, r5)
            r13 = 0
            goto L_0x0046
        L_0x0045:
            r13 = 1
        L_0x0046:
            if (r13 == 0) goto L_0x0087
            com.google.android.gms.measurement.internal.zzn r13 = r12.zzapo
            java.lang.String r0 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r13 = r13.zzau(r0)
            if (r13 == 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zzcs r0 = r12.zzge()
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x0061
            r1 = 1
            goto L_0x0063
        L_0x0061:
            r1 = 0
        L_0x0063:
            java.lang.Long r3 = java.lang.Long.valueOf(r1)
            com.google.android.gms.common.util.Clock r13 = r12.zzrz
            long r4 = r13.currentTimeMillis()
            java.lang.String r1 = "auto"
            java.lang.String r2 = "_ap"
            r0.zza(r1, r2, r3, r4)
            return
        L_0x0075:
            com.google.android.gms.measurement.internal.zzcs r6 = r12.zzge()
            r9 = 0
            com.google.android.gms.common.util.Clock r13 = r12.zzrz
            long r10 = r13.currentTimeMillis()
            java.lang.String r7 = "auto"
            java.lang.String r8 = "_ap"
            r6.zza(r7, r8, r9, r10)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzbt.zzj(boolean):void");
    }

    public final zzk zzgr() {
        return this.zzaiq;
    }

    public final zzn zzgq() {
        return this.zzapo;
    }

    public final zzba zzgp() {
        zza((zzco) this.zzapp);
        return this.zzapp;
    }

    public final zzap zzgo() {
        zza((zzcp) this.zzapq);
        return this.zzapq;
    }

    public final zzap zzkf() {
        zzap zzap = this.zzapq;
        if (zzap == null || !zzap.isInitialized()) {
            return null;
        }
        return this.zzapq;
    }

    public final zzbo zzgn() {
        zza((zzcp) this.zzapr);
        return this.zzapr;
    }

    public final zzeq zzgj() {
        zza((zzf) this.zzaps);
        return this.zzaps;
    }

    public final zzbg zzkg() {
        return this.zzaqd;
    }

    /* access modifiers changed from: 0000 */
    public final zzbo zzkh() {
        return this.zzapr;
    }

    public final zzcs zzge() {
        zza((zzf) this.zzapx);
        return this.zzapx;
    }

    public final AppMeasurement zzki() {
        return this.zzapt;
    }

    public final zzfk zzgm() {
        zza((zzco) this.zzapu);
        return this.zzapu;
    }

    public final zzan zzgl() {
        zza((zzco) this.zzapv);
        return this.zzapv;
    }

    public final zzal zzgi() {
        zza((zzf) this.zzapz);
        return this.zzapz;
    }

    public final Context getContext() {
        return this.zzri;
    }

    public final boolean zzkj() {
        return TextUtils.isEmpty(this.zzadx);
    }

    public final String zzkk() {
        return this.zzadx;
    }

    public final String zzkl() {
        return this.zzapm;
    }

    public final String zzkm() {
        return this.zzapn;
    }

    public final boolean zzkn() {
        return this.zzadv;
    }

    public final Clock zzbx() {
        return this.zzrz;
    }

    public final zzdo zzgh() {
        zza((zzf) this.zzapw);
        return this.zzapw;
    }

    public final zzdr zzgg() {
        zza((zzf) this.zzaqa);
        return this.zzaqa;
    }

    public final zzx zzgk() {
        zza((zzcp) this.zzaqb);
        return this.zzaqb;
    }

    public final zzaj zzgf() {
        zza((zzf) this.zzaqc);
        return this.zzaqc;
    }

    public final zza zzgd() {
        zza zza = this.zzapy;
        if (zza != null) {
            return zza;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzbt zza(Context context, zzak zzak) {
        if (zzak != null && (zzak.origin == null || zzak.zzadx == null)) {
            zzak zzak2 = new zzak(zzak.zzadt, zzak.zzadu, zzak.zzadv, zzak.zzadw, null, null, zzak.zzady);
            zzak = zzak2;
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzapl == null) {
            synchronized (zzbt.class) {
                if (zzapl == null) {
                    zzapl = new zzbt(new zzcr(context, zzak));
                }
            }
        } else if (!(zzak == null || zzak.zzady == null || !zzak.zzady.containsKey("dataCollectionDefaultEnabled"))) {
            zzapl.zzd(zzak.zzady.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zzapl;
    }

    private final void zzcl() {
        if (!this.zzvz) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private static void zza(zzcp zzcp) {
        if (zzcp == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzcp.isInitialized()) {
            String valueOf = String.valueOf(zzcp.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zza(zzf zzf) {
        if (zzf == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzf.isInitialized()) {
            String valueOf = String.valueOf(zzf.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zza(zzco zzco) {
        if (zzco == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzd(boolean z) {
        this.zzaqg = Boolean.valueOf(z);
    }

    @WorkerThread
    public final boolean zzko() {
        return this.zzaqg != null && this.zzaqg.booleanValue();
    }

    @WorkerThread
    public final boolean isEnabled() {
        boolean z;
        zzgn().zzaf();
        zzcl();
        if (this.zzapo.zzhu()) {
            return false;
        }
        Boolean zzhv = this.zzapo.zzhv();
        if (zzhv != null) {
            z = zzhv.booleanValue();
        } else {
            z = !GoogleServices.isMeasurementExplicitlyDisabled();
            if (z && this.zzaqg != null && ((Boolean) zzaf.zzalh.get()).booleanValue()) {
                z = this.zzaqg.booleanValue();
            }
        }
        return zzgp().zzh(z);
    }

    /* access modifiers changed from: 0000 */
    public final long zzkp() {
        Long valueOf = Long.valueOf(zzgp().zzanj.get());
        if (valueOf.longValue() == 0) {
            return this.zzagx;
        }
        return Math.min(this.zzagx, valueOf.longValue());
    }

    /* access modifiers changed from: 0000 */
    public final void zzgb() {
        zzk zzk = this.zzaiq;
    }

    /* access modifiers changed from: 0000 */
    public final void zzga() {
        zzk zzk = this.zzaiq;
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(zzcp zzcp) {
        this.zzaqh++;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(zzf zzf) {
        this.zzaqh++;
    }

    /* access modifiers changed from: 0000 */
    public final void zzkq() {
        this.zzaqi++;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zzkr() {
        zzcl();
        zzgn().zzaf();
        Boolean bool = this.zzaqe;
        if (bool == null || this.zzaqf == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzrz.elapsedRealtime() - this.zzaqf) > 1000)) {
            this.zzaqf = this.zzrz.elapsedRealtime();
            zzk zzk = this.zzaiq;
            boolean z = true;
            this.zzaqe = Boolean.valueOf(zzgm().zzx("android.permission.INTERNET") && zzgm().zzx("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzri).isCallerInstantApp() || this.zzapo.zzib() || (zzbj.zza(this.zzri) && zzfk.zza(this.zzri, false))));
            if (this.zzaqe.booleanValue()) {
                if (!zzgm().zzt(zzgf().getGmpAppId(), zzgf().zzgw()) && TextUtils.isEmpty(zzgf().zzgw())) {
                    z = false;
                }
                this.zzaqe = Boolean.valueOf(z);
            }
        }
        return this.zzaqe.booleanValue();
    }
}
