package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import java.util.concurrent.atomic.AtomicReference;

public final class zzan extends zzcp {
    private static final AtomicReference<String[]> zzalt = new AtomicReference<>();
    private static final AtomicReference<String[]> zzalu = new AtomicReference<>();
    private static final AtomicReference<String[]> zzalv = new AtomicReference<>();

    zzan(zzbt zzbt) {
        super(zzbt);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return false;
    }

    private final boolean zzjc() {
        zzgr();
        return this.zzadj.zzkj() && this.zzadj.zzgo().isLoggable(3);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzbs(String str) {
        if (str == null) {
            return null;
        }
        if (!zzjc()) {
            return str;
        }
        return zza(str, Event.zzadl, Event.zzadk, zzalt);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzbt(String str) {
        if (str == null) {
            return null;
        }
        if (!zzjc()) {
            return str;
        }
        return zza(str, Param.zzadn, Param.zzadm, zzalu);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzbu(String str) {
        if (str == null) {
            return null;
        }
        if (!zzjc()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, UserProperty.zzadp, UserProperty.zzado, zzalv);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("experiment_id");
        sb.append("(");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    @Nullable
    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzfk.zzu(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strArr2[i]);
                        sb.append("(");
                        sb.append(strArr[i]);
                        sb.append(")");
                        strArr3[i] = sb.toString();
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzb(zzad zzad) {
        if (zzad == null) {
            return null;
        }
        if (!zzjc()) {
            return zzad.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzad.origin);
        sb.append(",name=");
        sb.append(zzbs(zzad.name));
        sb.append(",params=");
        sb.append(zzb(zzad.zzaid));
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(zzy zzy) {
        if (zzy == null) {
            return null;
        }
        if (!zzjc()) {
            return zzy.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Event{appId='");
        sb.append(zzy.zztt);
        sb.append("', name='");
        sb.append(zzbs(zzy.name));
        sb.append("', params=");
        sb.append(zzb(zzy.zzaid));
        sb.append("}");
        return sb.toString();
    }

    @Nullable
    private final String zzb(zzaa zzaa) {
        if (zzaa == null) {
            return null;
        }
        if (!zzjc()) {
            return zzaa.toString();
        }
        return zzd(zzaa.zziv());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzd(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzjc()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(zzbt(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
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
