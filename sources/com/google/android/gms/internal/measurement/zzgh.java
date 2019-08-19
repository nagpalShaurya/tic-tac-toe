package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgh extends zzza<zzgh> {
    public zzgi[] zzawy;

    public zzgh() {
        this.zzawy = zzgi.zzms();
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgh)) {
            return false;
        }
        zzgh zzgh = (zzgh) obj;
        if (!zzze.equals((Object[]) this.zzawy, (Object[]) zzgh.zzawy)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzgh.zzcfc);
        }
        if (zzgh.zzcfc == null || zzgh.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzze.hashCode((Object[]) this.zzawy)) * 31;
        if (this.zzcfc == null || this.zzcfc.isEmpty()) {
            i = 0;
        } else {
            i = this.zzcfc.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        zzgi[] zzgiArr = this.zzawy;
        if (zzgiArr != null && zzgiArr.length > 0) {
            int i = 0;
            while (true) {
                zzgi[] zzgiArr2 = this.zzawy;
                if (i >= zzgiArr2.length) {
                    break;
                }
                zzgi zzgi = zzgiArr2[i];
                if (zzgi != null) {
                    zzyy.zza(1, (zzzg) zzgi);
                }
                i++;
            }
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        zzgi[] zzgiArr = this.zzawy;
        if (zzgiArr != null && zzgiArr.length > 0) {
            int i = 0;
            while (true) {
                zzgi[] zzgiArr2 = this.zzawy;
                if (i >= zzgiArr2.length) {
                    break;
                }
                zzgi zzgi = zzgiArr2[i];
                if (zzgi != null) {
                    zzf += zzyy.zzb(1, (zzzg) zzgi);
                }
                i++;
            }
        }
        return zzf;
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 10) {
                int zzb = zzzj.zzb(zzyx, 10);
                zzgi[] zzgiArr = this.zzawy;
                int length = zzgiArr == null ? 0 : zzgiArr.length;
                zzgi[] zzgiArr2 = new zzgi[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzawy, 0, zzgiArr2, 0, length);
                }
                while (length < zzgiArr2.length - 1) {
                    zzgiArr2[length] = new zzgi();
                    zzyx.zza((zzzg) zzgiArr2[length]);
                    zzyx.zzug();
                    length++;
                }
                zzgiArr2[length] = new zzgi();
                zzyx.zza((zzzg) zzgiArr2[length]);
                this.zzawy = zzgiArr2;
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
