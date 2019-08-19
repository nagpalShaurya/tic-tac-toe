package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzza;
import java.io.IOException;

public abstract class zzza<M extends zzza<M>> extends zzzg {
    protected zzzc zzcfc;

    /* access modifiers changed from: protected */
    public int zzf() {
        if (this.zzcfc == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzcfc.size(); i2++) {
            i += this.zzcfc.zzcc(i2).zzf();
        }
        return i;
    }

    public void zza(zzyy zzyy) throws IOException {
        if (this.zzcfc != null) {
            for (int i = 0; i < this.zzcfc.size(); i++) {
                this.zzcfc.zzcc(i).zza(zzyy);
            }
        }
    }

    public final <T> T zza(zzzb<M, T> zzzb) {
        zzzc zzzc = this.zzcfc;
        if (zzzc == null) {
            return null;
        }
        zzzd zzcb = zzzc.zzcb(zzzb.tag >>> 3);
        if (zzcb == null) {
            return null;
        }
        return zzcb.zzb(zzzb);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzyx zzyx, int i) throws IOException {
        int position = zzyx.getPosition();
        if (!zzyx.zzao(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzzi zzzi = new zzzi(i, zzyx.zzs(position, zzyx.getPosition() - position));
        zzzd zzzd = null;
        zzzc zzzc = this.zzcfc;
        if (zzzc == null) {
            this.zzcfc = new zzzc();
        } else {
            zzzd = zzzc.zzcb(i2);
        }
        if (zzzd == null) {
            zzzd = new zzzd();
            this.zzcfc.zza(i2, zzzd);
        }
        zzzd.zza(zzzi);
        return true;
    }

    public final /* synthetic */ zzzg zzyu() throws CloneNotSupportedException {
        return (zzza) clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzza zzza = (zzza) super.clone();
        zzze.zza(this, zzza);
        return zzza;
    }
}
