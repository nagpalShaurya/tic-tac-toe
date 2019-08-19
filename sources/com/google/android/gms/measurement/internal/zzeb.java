package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzeb implements Runnable {
    private final /* synthetic */ String zzaeh;
    private final /* synthetic */ String zzaeo;
    private final /* synthetic */ zzh zzaqn;
    private final /* synthetic */ String zzaqq;
    private final /* synthetic */ zzdr zzasg;
    private final /* synthetic */ AtomicReference zzash;

    zzeb(zzdr zzdr, AtomicReference atomicReference, String str, String str2, String str3, zzh zzh) {
        this.zzasg = zzdr;
        this.zzash = atomicReference;
        this.zzaqq = str;
        this.zzaeh = str2;
        this.zzaeo = str3;
        this.zzaqn = zzh;
    }

    public final void run() {
        synchronized (this.zzash) {
            try {
                zzag zzd = this.zzasg.zzasa;
                if (zzd == null) {
                    this.zzasg.zzgo().zzjd().zzd("Failed to get conditional properties", zzap.zzbv(this.zzaqq), this.zzaeh, this.zzaeo);
                    this.zzash.set(Collections.emptyList());
                    this.zzash.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zzaqq)) {
                    this.zzash.set(zzd.zza(this.zzaeh, this.zzaeo, this.zzaqn));
                } else {
                    this.zzash.set(zzd.zze(this.zzaqq, this.zzaeh, this.zzaeo));
                }
                this.zzasg.zzcy();
                this.zzash.notify();
            } catch (RemoteException e) {
                try {
                    this.zzasg.zzgo().zzjd().zzd("Failed to get conditional properties", zzap.zzbv(this.zzaqq), this.zzaeh, e);
                    this.zzash.set(Collections.emptyList());
                    this.zzash.notify();
                } catch (Throwable th) {
                    this.zzash.notify();
                    throw th;
                }
            }
        }
    }
}
