package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;

final class zzda implements Runnable {
    private final /* synthetic */ zzcs zzarc;
    private final /* synthetic */ ConditionalUserProperty zzarj;

    zzda(zzcs zzcs, ConditionalUserProperty conditionalUserProperty) {
        this.zzarc = zzcs;
        this.zzarj = conditionalUserProperty;
    }

    public final void run() {
        this.zzarc.zzb(this.zzarj);
    }
}
