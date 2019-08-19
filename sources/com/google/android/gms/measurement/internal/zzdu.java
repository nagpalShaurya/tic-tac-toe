package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzdu implements Runnable {
    private final /* synthetic */ zzh zzaqn;
    private final /* synthetic */ zzdr zzasg;
    private final /* synthetic */ AtomicReference zzash;

    zzdu(zzdr zzdr, AtomicReference atomicReference, zzh zzh) {
        this.zzasg = zzdr;
        this.zzash = atomicReference;
        this.zzaqn = zzh;
    }

    public final void run() {
        synchronized (this.zzash) {
            try {
                zzag zzd = this.zzasg.zzasa;
                if (zzd == null) {
                    this.zzasg.zzgo().zzjd().zzbx("Failed to get app instance id");
                    this.zzash.notify();
                    return;
                }
                this.zzash.set(zzd.zzc(this.zzaqn));
                String str = (String) this.zzash.get();
                if (str != null) {
                    this.zzasg.zzge().zzcm(str);
                    this.zzasg.zzgp().zzanl.zzcc(str);
                }
                this.zzasg.zzcy();
                this.zzash.notify();
            } catch (RemoteException e) {
                try {
                    this.zzasg.zzgo().zzjd().zzg("Failed to get app instance id", e);
                    this.zzash.notify();
                } catch (Throwable th) {
                    this.zzash.notify();
                    throw th;
                }
            }
        }
    }
}
