package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzbe {
    private final long zzabv;
    private final /* synthetic */ zzba zzany;
    @VisibleForTesting
    private final String zzaoa;
    private final String zzaob;
    private final String zzaoc;

    private zzbe(zzba zzba, String str, long j) {
        this.zzany = zzba;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.zzaoa = String.valueOf(str).concat(":start");
        this.zzaob = String.valueOf(str).concat(":count");
        this.zzaoc = String.valueOf(str).concat(":value");
        this.zzabv = j;
    }

    @WorkerThread
    private final void zzfl() {
        this.zzany.zzaf();
        long currentTimeMillis = this.zzany.zzbx().currentTimeMillis();
        Editor edit = this.zzany.zzjr().edit();
        edit.remove(this.zzaob);
        edit.remove(this.zzaoc);
        edit.putLong(this.zzaoa, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    public final void zzc(String str, long j) {
        this.zzany.zzaf();
        if (zzfn() == 0) {
            zzfl();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zzany.zzjr().getLong(this.zzaob, 0);
        if (j2 <= 0) {
            Editor edit = this.zzany.zzjr().edit();
            edit.putString(this.zzaoc, str);
            edit.putLong(this.zzaob, 1);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.zzany.zzgm().zzmd().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
        Editor edit2 = this.zzany.zzjr().edit();
        if (z) {
            edit2.putString(this.zzaoc, str);
        }
        edit2.putLong(this.zzaob, j3);
        edit2.apply();
    }

    @WorkerThread
    public final Pair<String, Long> zzfm() {
        long j;
        this.zzany.zzaf();
        this.zzany.zzaf();
        long zzfn = zzfn();
        if (zzfn == 0) {
            zzfl();
            j = 0;
        } else {
            j = Math.abs(zzfn - this.zzany.zzbx().currentTimeMillis());
        }
        long j2 = this.zzabv;
        if (j < j2) {
            return null;
        }
        if (j > (j2 << 1)) {
            zzfl();
            return null;
        }
        String string = this.zzany.zzjr().getString(this.zzaoc, null);
        long j3 = this.zzany.zzjr().getLong(this.zzaob, 0);
        zzfl();
        if (string == null || j3 <= 0) {
            return zzba.zzanc;
        }
        return new Pair<>(string, Long.valueOf(j3));
    }

    @WorkerThread
    private final long zzfn() {
        return this.zzany.zzjr().getLong(this.zzaoa, 0);
    }
}
