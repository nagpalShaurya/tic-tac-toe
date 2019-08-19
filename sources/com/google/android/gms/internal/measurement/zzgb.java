package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgb extends zzza<zzgb> {
    public String zzafx;
    public Long zzawe;
    private Integer zzawf;
    public zzgc[] zzawg;
    public zzga[] zzawh;
    public zzfu[] zzawi;
    private String zzawj;

    public zzgb() {
        this.zzawe = null;
        this.zzafx = null;
        this.zzawf = null;
        this.zzawg = zzgc.zzmn();
        this.zzawh = zzga.zzmm();
        this.zzawi = zzfu.zzmi();
        this.zzawj = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgb)) {
            return false;
        }
        zzgb zzgb = (zzgb) obj;
        Long l = this.zzawe;
        if (l == null) {
            if (zzgb.zzawe != null) {
                return false;
            }
        } else if (!l.equals(zzgb.zzawe)) {
            return false;
        }
        String str = this.zzafx;
        if (str == null) {
            if (zzgb.zzafx != null) {
                return false;
            }
        } else if (!str.equals(zzgb.zzafx)) {
            return false;
        }
        Integer num = this.zzawf;
        if (num == null) {
            if (zzgb.zzawf != null) {
                return false;
            }
        } else if (!num.equals(zzgb.zzawf)) {
            return false;
        }
        if (!zzze.equals((Object[]) this.zzawg, (Object[]) zzgb.zzawg) || !zzze.equals((Object[]) this.zzawh, (Object[]) zzgb.zzawh) || !zzze.equals((Object[]) this.zzawi, (Object[]) zzgb.zzawi)) {
            return false;
        }
        String str2 = this.zzawj;
        if (str2 == null) {
            if (zzgb.zzawj != null) {
                return false;
            }
        } else if (!str2.equals(zzgb.zzawj)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzgb.zzcfc);
        }
        if (zzgb.zzcfc == null || zzgb.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Long l = this.zzawe;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.zzafx;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.zzawf;
        int hashCode4 = (((((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + zzze.hashCode((Object[]) this.zzawg)) * 31) + zzze.hashCode((Object[]) this.zzawh)) * 31) + zzze.hashCode((Object[]) this.zzawi)) * 31;
        String str2 = this.zzawj;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode5 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Long l = this.zzawe;
        if (l != null) {
            zzyy.zzi(1, l.longValue());
        }
        String str = this.zzafx;
        if (str != null) {
            zzyy.zzb(2, str);
        }
        Integer num = this.zzawf;
        if (num != null) {
            zzyy.zzd(3, num.intValue());
        }
        zzgc[] zzgcArr = this.zzawg;
        int i = 0;
        if (zzgcArr != null && zzgcArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzgc[] zzgcArr2 = this.zzawg;
                if (i2 >= zzgcArr2.length) {
                    break;
                }
                zzgc zzgc = zzgcArr2[i2];
                if (zzgc != null) {
                    zzyy.zza(4, (zzzg) zzgc);
                }
                i2++;
            }
        }
        zzga[] zzgaArr = this.zzawh;
        if (zzgaArr != null && zzgaArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzga[] zzgaArr2 = this.zzawh;
                if (i3 >= zzgaArr2.length) {
                    break;
                }
                zzga zzga = zzgaArr2[i3];
                if (zzga != null) {
                    zzyy.zza(5, (zzzg) zzga);
                }
                i3++;
            }
        }
        zzfu[] zzfuArr = this.zzawi;
        if (zzfuArr != null && zzfuArr.length > 0) {
            while (true) {
                zzfu[] zzfuArr2 = this.zzawi;
                if (i >= zzfuArr2.length) {
                    break;
                }
                zzfu zzfu = zzfuArr2[i];
                if (zzfu != null) {
                    zzyy.zza(6, (zzzg) zzfu);
                }
                i++;
            }
        }
        String str2 = this.zzawj;
        if (str2 != null) {
            zzyy.zzb(7, str2);
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        Long l = this.zzawe;
        if (l != null) {
            zzf += zzyy.zzd(1, l.longValue());
        }
        String str = this.zzafx;
        if (str != null) {
            zzf += zzyy.zzc(2, str);
        }
        Integer num = this.zzawf;
        if (num != null) {
            zzf += zzyy.zzh(3, num.intValue());
        }
        zzgc[] zzgcArr = this.zzawg;
        int i = 0;
        if (zzgcArr != null && zzgcArr.length > 0) {
            int i2 = zzf;
            int i3 = 0;
            while (true) {
                zzgc[] zzgcArr2 = this.zzawg;
                if (i3 >= zzgcArr2.length) {
                    break;
                }
                zzgc zzgc = zzgcArr2[i3];
                if (zzgc != null) {
                    i2 += zzyy.zzb(4, (zzzg) zzgc);
                }
                i3++;
            }
            zzf = i2;
        }
        zzga[] zzgaArr = this.zzawh;
        if (zzgaArr != null && zzgaArr.length > 0) {
            int i4 = zzf;
            int i5 = 0;
            while (true) {
                zzga[] zzgaArr2 = this.zzawh;
                if (i5 >= zzgaArr2.length) {
                    break;
                }
                zzga zzga = zzgaArr2[i5];
                if (zzga != null) {
                    i4 += zzyy.zzb(5, (zzzg) zzga);
                }
                i5++;
            }
            zzf = i4;
        }
        zzfu[] zzfuArr = this.zzawi;
        if (zzfuArr != null && zzfuArr.length > 0) {
            while (true) {
                zzfu[] zzfuArr2 = this.zzawi;
                if (i >= zzfuArr2.length) {
                    break;
                }
                zzfu zzfu = zzfuArr2[i];
                if (zzfu != null) {
                    zzf += zzyy.zzb(6, (zzzg) zzfu);
                }
                i++;
            }
        }
        String str2 = this.zzawj;
        if (str2 != null) {
            return zzf + zzyy.zzc(7, str2);
        }
        return zzf;
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 8) {
                this.zzawe = Long.valueOf(zzyx.zzuz());
            } else if (zzug == 18) {
                this.zzafx = zzyx.readString();
            } else if (zzug == 24) {
                this.zzawf = Integer.valueOf(zzyx.zzuy());
            } else if (zzug == 34) {
                int zzb = zzzj.zzb(zzyx, 34);
                zzgc[] zzgcArr = this.zzawg;
                int length = zzgcArr == null ? 0 : zzgcArr.length;
                zzgc[] zzgcArr2 = new zzgc[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzawg, 0, zzgcArr2, 0, length);
                }
                while (length < zzgcArr2.length - 1) {
                    zzgcArr2[length] = new zzgc();
                    zzyx.zza((zzzg) zzgcArr2[length]);
                    zzyx.zzug();
                    length++;
                }
                zzgcArr2[length] = new zzgc();
                zzyx.zza((zzzg) zzgcArr2[length]);
                this.zzawg = zzgcArr2;
            } else if (zzug == 42) {
                int zzb2 = zzzj.zzb(zzyx, 42);
                zzga[] zzgaArr = this.zzawh;
                int length2 = zzgaArr == null ? 0 : zzgaArr.length;
                zzga[] zzgaArr2 = new zzga[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzawh, 0, zzgaArr2, 0, length2);
                }
                while (length2 < zzgaArr2.length - 1) {
                    zzgaArr2[length2] = new zzga();
                    zzyx.zza((zzzg) zzgaArr2[length2]);
                    zzyx.zzug();
                    length2++;
                }
                zzgaArr2[length2] = new zzga();
                zzyx.zza((zzzg) zzgaArr2[length2]);
                this.zzawh = zzgaArr2;
            } else if (zzug == 50) {
                int zzb3 = zzzj.zzb(zzyx, 50);
                zzfu[] zzfuArr = this.zzawi;
                int length3 = zzfuArr == null ? 0 : zzfuArr.length;
                zzfu[] zzfuArr2 = new zzfu[(zzb3 + length3)];
                if (length3 != 0) {
                    System.arraycopy(this.zzawi, 0, zzfuArr2, 0, length3);
                }
                while (length3 < zzfuArr2.length - 1) {
                    zzfuArr2[length3] = new zzfu();
                    zzyx.zza((zzzg) zzfuArr2[length3]);
                    zzyx.zzug();
                    length3++;
                }
                zzfuArr2[length3] = new zzfu();
                zzyx.zza((zzzg) zzfuArr2[length3]);
                this.zzawi = zzfuArr2;
            } else if (zzug == 58) {
                this.zzawj = zzyx.readString();
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
