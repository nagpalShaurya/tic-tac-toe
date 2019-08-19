package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzdr extends zzf {
    /* access modifiers changed from: private */
    public final zzef zzarz;
    /* access modifiers changed from: private */
    public zzag zzasa;
    private volatile Boolean zzasb;
    private final zzv zzasc;
    private final zzev zzasd;
    private final List<Runnable> zzase = new ArrayList();
    private final zzv zzasf;

    protected zzdr(zzbt zzbt) {
        super(zzbt);
        this.zzasd = new zzev(zzbt.zzbx());
        this.zzarz = new zzef(this);
        this.zzasc = new zzds(this, zzbt);
        this.zzasf = new zzdx(this, zzbt);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return false;
    }

    @WorkerThread
    public final boolean isConnected() {
        zzaf();
        zzcl();
        return this.zzasa != null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzlc() {
        zzaf();
        zzcl();
        zzf(new zzdy(this, zzm(true)));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    @android.support.annotation.WorkerThread
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzag r12, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r13, com.google.android.gms.measurement.internal.zzh r14) {
        /*
            r11 = this;
            r11.zzaf()
            r11.zzgb()
            r11.zzcl()
            boolean r0 = r11.zzld()
            r1 = 0
            r2 = 100
            r3 = 0
            r4 = 100
        L_0x0014:
            r5 = 1001(0x3e9, float:1.403E-42)
            if (r3 >= r5) goto L_0x00ac
            if (r4 != r2) goto L_0x00ac
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            if (r0 == 0) goto L_0x0035
            com.google.android.gms.measurement.internal.zzal r5 = r11.zzgi()
            java.util.List r5 = r5.zzr(r2)
            if (r5 == 0) goto L_0x0035
            r4.addAll(r5)
            int r5 = r5.size()
            goto L_0x0036
        L_0x0035:
            r5 = 0
        L_0x0036:
            if (r13 == 0) goto L_0x003d
            if (r5 >= r2) goto L_0x003d
            r4.add(r13)
        L_0x003d:
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            int r6 = r4.size()
            r7 = 0
        L_0x0044:
            if (r7 >= r6) goto L_0x00a7
            java.lang.Object r8 = r4.get(r7)
            int r7 = r7 + 1
            com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r8 = (com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable) r8
            boolean r9 = r8 instanceof com.google.android.gms.measurement.internal.zzad
            if (r9 == 0) goto L_0x0067
            com.google.android.gms.measurement.internal.zzad r8 = (com.google.android.gms.measurement.internal.zzad) r8     // Catch:{ RemoteException -> 0x0058 }
            r12.zza(r8, r14)     // Catch:{ RemoteException -> 0x0058 }
            goto L_0x0044
        L_0x0058:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzap r9 = r11.zzgo()
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjd()
            java.lang.String r10 = "Failed to send event to the service"
            r9.zzg(r10, r8)
            goto L_0x0044
        L_0x0067:
            boolean r9 = r8 instanceof com.google.android.gms.measurement.internal.zzfh
            if (r9 == 0) goto L_0x0080
            com.google.android.gms.measurement.internal.zzfh r8 = (com.google.android.gms.measurement.internal.zzfh) r8     // Catch:{ RemoteException -> 0x0071 }
            r12.zza(r8, r14)     // Catch:{ RemoteException -> 0x0071 }
            goto L_0x0044
        L_0x0071:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzap r9 = r11.zzgo()
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjd()
            java.lang.String r10 = "Failed to send attribute to the service"
            r9.zzg(r10, r8)
            goto L_0x0044
        L_0x0080:
            boolean r9 = r8 instanceof com.google.android.gms.measurement.internal.zzl
            if (r9 == 0) goto L_0x0099
            com.google.android.gms.measurement.internal.zzl r8 = (com.google.android.gms.measurement.internal.zzl) r8     // Catch:{ RemoteException -> 0x008a }
            r12.zza(r8, r14)     // Catch:{ RemoteException -> 0x008a }
            goto L_0x0044
        L_0x008a:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzap r9 = r11.zzgo()
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjd()
            java.lang.String r10 = "Failed to send conditional property to the service"
            r9.zzg(r10, r8)
            goto L_0x0044
        L_0x0099:
            com.google.android.gms.measurement.internal.zzap r8 = r11.zzgo()
            com.google.android.gms.measurement.internal.zzar r8 = r8.zzjd()
            java.lang.String r9 = "Discarding data. Unrecognized parcel type."
            r8.zzbx(r9)
            goto L_0x0044
        L_0x00a7:
            int r3 = r3 + 1
            r4 = r5
            goto L_0x0014
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdr.zza(com.google.android.gms.measurement.internal.zzag, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzh):void");
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzad zzad, String str) {
        Preconditions.checkNotNull(zzad);
        zzaf();
        zzcl();
        boolean zzld = zzld();
        zzdz zzdz = new zzdz(this, zzld, zzld && zzgi().zza(zzad), zzad, zzm(true), str);
        zzf(zzdz);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzd(zzl zzl) {
        Preconditions.checkNotNull(zzl);
        zzaf();
        zzcl();
        zzgr();
        zzea zzea = new zzea(this, true, zzgi().zzc(zzl), new zzl(zzl), zzm(true), zzl);
        zzf(zzea);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzl>> atomicReference, String str, String str2, String str3) {
        zzaf();
        zzcl();
        zzeb zzeb = new zzeb(this, atomicReference, str, str2, str3, zzm(false));
        zzf(zzeb);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzfh>> atomicReference, String str, String str2, String str3, boolean z) {
        zzaf();
        zzcl();
        zzec zzec = new zzec(this, atomicReference, str, str2, str3, z, zzm(false));
        zzf(zzec);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzfh zzfh) {
        zzaf();
        zzcl();
        zzf(new zzed(this, zzld() && zzgi().zza(zzfh), zzfh, zzm(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzfh>> atomicReference, boolean z) {
        zzaf();
        zzcl();
        zzf(new zzee(this, atomicReference, zzm(false), z));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void resetAnalyticsData() {
        zzaf();
        zzgb();
        zzcl();
        zzh zzm = zzm(false);
        if (zzld()) {
            zzgi().resetAnalyticsData();
        }
        zzf(new zzdt(this, zzm));
    }

    private final boolean zzld() {
        zzgr();
        return true;
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzaf();
        zzcl();
        zzf(new zzdu(this, atomicReference, zzm(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzkz() {
        zzaf();
        zzcl();
        zzf(new zzdv(this, zzm(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzdn zzdn) {
        zzaf();
        zzcl();
        zzf(new zzdw(this, zzdn));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzcy() {
        zzaf();
        this.zzasd.start();
        this.zzasc.zzh(((Long) zzaf.zzakj.get()).longValue());
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzdj() {
        boolean z;
        boolean z2;
        zzaf();
        zzcl();
        if (!isConnected()) {
            boolean z3 = false;
            if (this.zzasb == null) {
                zzaf();
                zzcl();
                Boolean zzju = zzgp().zzju();
                if (zzju == null || !zzju.booleanValue()) {
                    zzgr();
                    if (zzgf().zzjb() == 1) {
                        z = true;
                        z2 = true;
                    } else {
                        zzgo().zzjl().zzbx("Checking service availability");
                        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzgm().getContext(), 12451000);
                        if (isGooglePlayServicesAvailable == 0) {
                            zzgo().zzjl().zzbx("Service available");
                            z = true;
                            z2 = true;
                        } else if (isGooglePlayServicesAvailable == 1) {
                            zzgo().zzjl().zzbx("Service missing");
                            z = false;
                            z2 = true;
                        } else if (isGooglePlayServicesAvailable == 2) {
                            zzgo().zzjk().zzbx("Service container out of date");
                            if (zzgm().zzme() < 13000) {
                                z = false;
                                z2 = true;
                            } else {
                                Boolean zzju2 = zzgp().zzju();
                                z = zzju2 == null || zzju2.booleanValue();
                                z2 = false;
                            }
                        } else if (isGooglePlayServicesAvailable == 3) {
                            zzgo().zzjg().zzbx("Service disabled");
                            z = false;
                            z2 = false;
                        } else if (isGooglePlayServicesAvailable == 9) {
                            zzgo().zzjg().zzbx("Service invalid");
                            z = false;
                            z2 = false;
                        } else if (isGooglePlayServicesAvailable != 18) {
                            zzgo().zzjg().zzg("Unexpected service status", Integer.valueOf(isGooglePlayServicesAvailable));
                            z = false;
                            z2 = false;
                        } else {
                            zzgo().zzjg().zzbx("Service updating");
                            z = true;
                            z2 = true;
                        }
                    }
                    if (!z && zzgq().zzib()) {
                        zzgo().zzjd().zzbx("No way to upload. Consider using the full version of Analytics");
                        z2 = false;
                    }
                    if (z2) {
                        zzgp().zzg(z);
                    }
                } else {
                    z = true;
                }
                this.zzasb = Boolean.valueOf(z);
            }
            if (this.zzasb.booleanValue()) {
                this.zzarz.zzlh();
                return;
            }
            if (!zzgq().zzib()) {
                zzgr();
                String str = "com.google.android.gms.measurement.AppMeasurementService";
                List queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), str), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    z3 = true;
                }
                if (z3) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context context = getContext();
                    zzgr();
                    intent.setComponent(new ComponentName(context, str));
                    this.zzarz.zzc(intent);
                    return;
                }
                zzgo().zzjd().zzbx("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final Boolean zzle() {
        return this.zzasb;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzag zzag) {
        zzaf();
        Preconditions.checkNotNull(zzag);
        this.zzasa = zzag;
        zzcy();
        zzlf();
    }

    @WorkerThread
    public final void disconnect() {
        zzaf();
        zzcl();
        if (zzn.zzia()) {
            this.zzarz.zzlg();
        }
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.zzarz);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        this.zzasa = null;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzaf();
        if (this.zzasa != null) {
            this.zzasa = null;
            zzgo().zzjl().zzg("Disconnected from device MeasurementService", componentName);
            zzaf();
            zzdj();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzcz() {
        zzaf();
        if (isConnected()) {
            zzgo().zzjl().zzbx("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    @WorkerThread
    private final void zzf(Runnable runnable) throws IllegalStateException {
        zzaf();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzase.size()) >= 1000) {
            zzgo().zzjd().zzbx("Discarding data. Max runnable queue size reached");
        } else {
            this.zzase.add(runnable);
            this.zzasf.zzh(60000);
            zzdj();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzlf() {
        zzaf();
        zzgo().zzjl().zzg("Processing queued up service tasks", Integer.valueOf(this.zzase.size()));
        for (Runnable run : this.zzase) {
            try {
                run.run();
            } catch (Exception e) {
                zzgo().zzjd().zzg("Task exception while flushing queue", e);
            }
        }
        this.zzase.clear();
        this.zzasf.cancel();
    }

    @Nullable
    @WorkerThread
    private final zzh zzm(boolean z) {
        zzgr();
        return zzgf().zzbr(z ? zzgo().zzjn() : null);
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
