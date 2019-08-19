package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzep;

public final class AppMeasurementService extends Service implements zzep {
    private zzel<AppMeasurementService> zzadr;

    private final zzel<AppMeasurementService> zzfu() {
        if (this.zzadr == null) {
            this.zzadr = new zzel<>(this);
        }
        return this.zzadr;
    }

    @MainThread
    public final void onCreate() {
        super.onCreate();
        zzfu().onCreate();
    }

    @MainThread
    public final void onDestroy() {
        zzfu().onDestroy();
        super.onDestroy();
    }

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        return zzfu().onStartCommand(intent, i, i2);
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        return zzfu().onBind(intent);
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return zzfu().onUnbind(intent);
    }

    @MainThread
    public final void onRebind(Intent intent) {
        zzfu().onRebind(intent);
    }

    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zzb(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
    }
}
