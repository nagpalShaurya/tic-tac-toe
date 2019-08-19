package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzep;

public final class zzel<T extends Context & zzep> {
    private final T zzaby;

    public zzel(T t) {
        Preconditions.checkNotNull(t);
        this.zzaby = t;
    }

    @MainThread
    public final void onCreate() {
        zzbt zza = zzbt.zza((Context) this.zzaby, (zzak) null);
        zzap zzgo = zza.zzgo();
        zza.zzgr();
        zzgo.zzjl().zzbx("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void onDestroy() {
        zzbt zza = zzbt.zza((Context) this.zzaby, (zzak) null);
        zzap zzgo = zza.zzgo();
        zza.zzgr();
        zzgo.zzjl().zzbx("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        zzbt zza = zzbt.zza((Context) this.zzaby, (zzak) null);
        zzap zzgo = zza.zzgo();
        if (intent == null) {
            zzgo.zzjg().zzbx("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zza.zzgr();
        zzgo.zzjl().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzb(new zzem(this, i2, zzgo, intent));
        }
        return 2;
    }

    private final void zzb(Runnable runnable) {
        zzfa zzm = zzfa.zzm(this.zzaby);
        zzm.zzgn().zzc((Runnable) new zzeo(this, zzm, runnable));
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            zzgo().zzjd().zzbx("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzbv(zzfa.zzm(this.zzaby));
        }
        zzgo().zzjg().zzg("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzgo().zzjd().zzbx("onUnbind called with null intent");
            return true;
        }
        zzgo().zzjl().zzg("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    @TargetApi(24)
    @MainThread
    public final boolean onStartJob(JobParameters jobParameters) {
        zzbt zza = zzbt.zza((Context) this.zzaby, (zzak) null);
        zzap zzgo = zza.zzgo();
        String string = jobParameters.getExtras().getString("action");
        zza.zzgr();
        zzgo.zzjl().zzg("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            zzb(new zzen(this, zzgo, jobParameters));
        }
        return true;
    }

    @MainThread
    public final void onRebind(Intent intent) {
        if (intent == null) {
            zzgo().zzjd().zzbx("onRebind called with null intent");
            return;
        }
        zzgo().zzjl().zzg("onRebind called. action", intent.getAction());
    }

    private final zzap zzgo() {
        return zzbt.zza((Context) this.zzaby, (zzak) null).zzgo();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(zzap zzap, JobParameters jobParameters) {
        zzap.zzjl().zzbx("AppMeasurementJobService processed last upload request.");
        ((zzep) this.zzaby).zza(jobParameters, false);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(int i, zzap zzap, Intent intent) {
        if (((zzep) this.zzaby).callServiceStopSelfResult(i)) {
            zzap.zzjl().zzg("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzgo().zzjl().zzbx("Completed wakeful intent.");
            ((zzep) this.zzaby).zzb(intent);
        }
    }
}
