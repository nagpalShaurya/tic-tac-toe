package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgf extends zzza<zzgf> {
    private static volatile zzgf[] zzaws;
    public Integer count;
    public String name;
    public zzgg[] zzawt;
    public Long zzawu;
    public Long zzawv;

    public static zzgf[] zzmq() {
        if (zzaws == null) {
            synchronized (zzze.zzcfl) {
                if (zzaws == null) {
                    zzaws = new zzgf[0];
                }
            }
        }
        return zzaws;
    }

    public zzgf() {
        this.zzawt = zzgg.zzmr();
        this.name = null;
        this.zzawu = null;
        this.zzawv = null;
        this.count = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgf)) {
            return false;
        }
        zzgf zzgf = (zzgf) obj;
        if (!zzze.equals((Object[]) this.zzawt, (Object[]) zzgf.zzawt)) {
            return false;
        }
        String str = this.name;
        if (str == null) {
            if (zzgf.name != null) {
                return false;
            }
        } else if (!str.equals(zzgf.name)) {
            return false;
        }
        Long l = this.zzawu;
        if (l == null) {
            if (zzgf.zzawu != null) {
                return false;
            }
        } else if (!l.equals(zzgf.zzawu)) {
            return false;
        }
        Long l2 = this.zzawv;
        if (l2 == null) {
            if (zzgf.zzawv != null) {
                return false;
            }
        } else if (!l2.equals(zzgf.zzawv)) {
            return false;
        }
        Integer num = this.count;
        if (num == null) {
            if (zzgf.count != null) {
                return false;
            }
        } else if (!num.equals(zzgf.count)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzgf.zzcfc);
        }
        if (zzgf.zzcfc == null || zzgf.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzze.hashCode((Object[]) this.zzawt)) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.zzawu;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.zzawv;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.count;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode5 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        zzgg[] zzggArr = this.zzawt;
        if (zzggArr != null && zzggArr.length > 0) {
            int i = 0;
            while (true) {
                zzgg[] zzggArr2 = this.zzawt;
                if (i >= zzggArr2.length) {
                    break;
                }
                zzgg zzgg = zzggArr2[i];
                if (zzgg != null) {
                    zzyy.zza(1, (zzzg) zzgg);
                }
                i++;
            }
        }
        String str = this.name;
        if (str != null) {
            zzyy.zzb(2, str);
        }
        Long l = this.zzawu;
        if (l != null) {
            zzyy.zzi(3, l.longValue());
        }
        Long l2 = this.zzawv;
        if (l2 != null) {
            zzyy.zzi(4, l2.longValue());
        }
        Integer num = this.count;
        if (num != null) {
            zzyy.zzd(5, num.intValue());
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        zzgg[] zzggArr = this.zzawt;
        if (zzggArr != null && zzggArr.length > 0) {
            int i = 0;
            while (true) {
                zzgg[] zzggArr2 = this.zzawt;
                if (i >= zzggArr2.length) {
                    break;
                }
                zzgg zzgg = zzggArr2[i];
                if (zzgg != null) {
                    zzf += zzyy.zzb(1, (zzzg) zzgg);
                }
                i++;
            }
        }
        String str = this.name;
        if (str != null) {
            zzf += zzyy.zzc(2, str);
        }
        Long l = this.zzawu;
        if (l != null) {
            zzf += zzyy.zzd(3, l.longValue());
        }
        Long l2 = this.zzawv;
        if (l2 != null) {
            zzf += zzyy.zzd(4, l2.longValue());
        }
        Integer num = this.count;
        if (num != null) {
            return zzf + zzyy.zzh(5, num.intValue());
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
                zzgg[] zzggArr = this.zzawt;
                int length = zzggArr == null ? 0 : zzggArr.length;
                zzgg[] zzggArr2 = new zzgg[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzawt, 0, zzggArr2, 0, length);
                }
                while (length < zzggArr2.length - 1) {
                    zzggArr2[length] = new zzgg();
                    zzyx.zza((zzzg) zzggArr2[length]);
                    zzyx.zzug();
                    length++;
                }
                zzggArr2[length] = new zzgg();
                zzyx.zza((zzzg) zzggArr2[length]);
                this.zzawt = zzggArr2;
            } else if (zzug == 18) {
                this.name = zzyx.readString();
            } else if (zzug == 24) {
                this.zzawu = Long.valueOf(zzyx.zzuz());
            } else if (zzug == 32) {
                this.zzawv = Long.valueOf(zzyx.zzuz());
            } else if (zzug == 40) {
                this.count = Integer.valueOf(zzyx.zzuy());
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
