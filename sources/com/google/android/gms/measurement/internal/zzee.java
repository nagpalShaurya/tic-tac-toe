package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzee implements Runnable {
    private final /* synthetic */ boolean zzaev;
    private final /* synthetic */ zzh zzaqn;
    private final /* synthetic */ zzdr zzasg;
    private final /* synthetic */ AtomicReference zzash;

    zzee(zzdr zzdr, AtomicReference atomicReference, zzh zzh, boolean z) {
        this.zzasg = zzdr;
        this.zzash = atomicReference;
        this.zzaqn = zzh;
        this.zzaev = z;
    }

    public final void run() {
        synchronized (this.zzash) {
            try {
                zzag zzd = this.zzasg.zzasa;
                if (zzd == null) {
                    this.zzasg.zzgo().zzjd().zzbx("Failed to get user properties");
                    this.zzash.notify();
                    return;
                }
                this.zzash.set(zzd.zza(this.zzaqn, this.zzaev));
                this.zzasg.zzcy();
                this.zzash.notify();
            } catch (RemoteException e) {
                try {
                    this.zzasg.zzgo().zzjd().zzg("Failed to get user properties", e);
                    this.zzash.notify();
                } catch (Throwable th) {
                    this.zzash.notify();
                    throw th;
                }
            }
        }
    }
}
