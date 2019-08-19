package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgc extends zzza<zzgc> {
    private static volatile zzgc[] zzawk;
    public String value;
    public String zzoj;

    public static zzgc[] zzmn() {
        if (zzawk == null) {
            synchronized (zzze.zzcfl) {
                if (zzawk == null) {
                    zzawk = new zzgc[0];
                }
            }
        }
        return zzawk;
    }

    public zzgc() {
        this.zzoj = null;
        this.value = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgc)) {
            return false;
        }
        zzgc zzgc = (zzgc) obj;
        String str = this.zzoj;
        if (str == null) {
            if (zzgc.zzoj != null) {
                return false;
            }
        } else if (!str.equals(zzgc.zzoj)) {
            return false;
        }
        String str2 = this.value;
        if (str2 == null) {
            if (zzgc.value != null) {
                return false;
            }
        } else if (!str2.equals(zzgc.value)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzgc.zzcfc);
        }
        if (zzgc.zzcfc == null || zzgc.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.zzoj;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode3 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        String str = this.zzoj;
        if (str != null) {
            zzyy.zzb(1, str);
        }
        String str2 = this.value;
        if (str2 != null) {
            zzyy.zzb(2, str2);
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        String str = this.zzoj;
        if (str != null) {
            zzf += zzyy.zzc(1, str);
        }
        String str2 = this.value;
        if (str2 != null) {
            return zzf + zzyy.zzc(2, str2);
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
                this.zzoj = zzyx.readString();
            } else if (zzug == 18) {
                this.value = zzyx.readString();
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
