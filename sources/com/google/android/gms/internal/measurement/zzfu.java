package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfu extends zzza<zzfu> {
    private static volatile zzfu[] zzaux;
    public Integer zzauy;
    public zzfy[] zzauz;
    public zzfv[] zzava;
    private Boolean zzavb;
    private Boolean zzavc;

    public static zzfu[] zzmi() {
        if (zzaux == null) {
            synchronized (zzze.zzcfl) {
                if (zzaux == null) {
                    zzaux = new zzfu[0];
                }
            }
        }
        return zzaux;
    }

    public zzfu() {
        this.zzauy = null;
        this.zzauz = zzfy.zzml();
        this.zzava = zzfv.zzmj();
        this.zzavb = null;
        this.zzavc = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfu)) {
            return false;
        }
        zzfu zzfu = (zzfu) obj;
        Integer num = this.zzauy;
        if (num == null) {
            if (zzfu.zzauy != null) {
                return false;
            }
        } else if (!num.equals(zzfu.zzauy)) {
            return false;
        }
        if (!zzze.equals((Object[]) this.zzauz, (Object[]) zzfu.zzauz) || !zzze.equals((Object[]) this.zzava, (Object[]) zzfu.zzava)) {
            return false;
        }
        Boolean bool = this.zzavb;
        if (bool == null) {
            if (zzfu.zzavb != null) {
                return false;
            }
        } else if (!bool.equals(zzfu.zzavb)) {
            return false;
        }
        Boolean bool2 = this.zzavc;
        if (bool2 == null) {
            if (zzfu.zzavc != null) {
                return false;
            }
        } else if (!bool2.equals(zzfu.zzavc)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzfu.zzcfc);
        }
        if (zzfu.zzcfc == null || zzfu.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzauy;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzze.hashCode((Object[]) this.zzauz)) * 31) + zzze.hashCode((Object[]) this.zzava)) * 31;
        Boolean bool = this.zzavb;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzavc;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode4 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Integer num = this.zzauy;
        if (num != null) {
            zzyy.zzd(1, num.intValue());
        }
        zzfy[] zzfyArr = this.zzauz;
        int i = 0;
        if (zzfyArr != null && zzfyArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzfy[] zzfyArr2 = this.zzauz;
                if (i2 >= zzfyArr2.length) {
                    break;
                }
                zzfy zzfy = zzfyArr2[i2];
                if (zzfy != null) {
                    zzyy.zza(2, (zzzg) zzfy);
                }
                i2++;
            }
        }
        zzfv[] zzfvArr = this.zzava;
        if (zzfvArr != null && zzfvArr.length > 0) {
            while (true) {
                zzfv[] zzfvArr2 = this.zzava;
                if (i >= zzfvArr2.length) {
                    break;
                }
                zzfv zzfv = zzfvArr2[i];
                if (zzfv != null) {
                    zzyy.zza(3, (zzzg) zzfv);
                }
                i++;
            }
        }
        Boolean bool = this.zzavb;
        if (bool != null) {
            zzyy.zzb(4, bool.booleanValue());
        }
        Boolean bool2 = this.zzavc;
        if (bool2 != null) {
            zzyy.zzb(5, bool2.booleanValue());
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzauy;
        if (num != null) {
            zzf += zzyy.zzh(1, num.intValue());
        }
        zzfy[] zzfyArr = this.zzauz;
        int i = 0;
        if (zzfyArr != null && zzfyArr.length > 0) {
            int i2 = zzf;
            int i3 = 0;
            while (true) {
                zzfy[] zzfyArr2 = this.zzauz;
                if (i3 >= zzfyArr2.length) {
                    break;
                }
                zzfy zzfy = zzfyArr2[i3];
                if (zzfy != null) {
                    i2 += zzyy.zzb(2, (zzzg) zzfy);
                }
                i3++;
            }
            zzf = i2;
        }
        zzfv[] zzfvArr = this.zzava;
        if (zzfvArr != null && zzfvArr.length > 0) {
            while (true) {
                zzfv[] zzfvArr2 = this.zzava;
                if (i >= zzfvArr2.length) {
                    break;
                }
                zzfv zzfv = zzfvArr2[i];
                if (zzfv != null) {
                    zzf += zzyy.zzb(3, (zzzg) zzfv);
                }
                i++;
            }
        }
        Boolean bool = this.zzavb;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzyy.zzbb(4) + 1;
        }
        Boolean bool2 = this.zzavc;
        if (bool2 == null) {
            return zzf;
        }
        bool2.booleanValue();
        return zzf + zzyy.zzbb(5) + 1;
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 8) {
                this.zzauy = Integer.valueOf(zzyx.zzuy());
            } else if (zzug == 18) {
                int zzb = zzzj.zzb(zzyx, 18);
                zzfy[] zzfyArr = this.zzauz;
                int length = zzfyArr == null ? 0 : zzfyArr.length;
                zzfy[] zzfyArr2 = new zzfy[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzauz, 0, zzfyArr2, 0, length);
                }
                while (length < zzfyArr2.length - 1) {
                    zzfyArr2[length] = new zzfy();
                    zzyx.zza((zzzg) zzfyArr2[length]);
                    zzyx.zzug();
                    length++;
                }
                zzfyArr2[length] = new zzfy();
                zzyx.zza((zzzg) zzfyArr2[length]);
                this.zzauz = zzfyArr2;
            } else if (zzug == 26) {
                int zzb2 = zzzj.zzb(zzyx, 26);
                zzfv[] zzfvArr = this.zzava;
                int length2 = zzfvArr == null ? 0 : zzfvArr.length;
                zzfv[] zzfvArr2 = new zzfv[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzava, 0, zzfvArr2, 0, length2);
                }
                while (length2 < zzfvArr2.length - 1) {
                    zzfvArr2[length2] = new zzfv();
                    zzyx.zza((zzzg) zzfvArr2[length2]);
                    zzyx.zzug();
                    length2++;
                }
                zzfvArr2[length2] = new zzfv();
                zzyx.zza((zzzg) zzfvArr2[length2]);
                this.zzava = zzfvArr2;
            } else if (zzug == 32) {
                this.zzavb = Boolean.valueOf(zzyx.zzum());
            } else if (zzug == 40) {
                this.zzavc = Boolean.valueOf(zzyx.zzum());
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
    }
}
