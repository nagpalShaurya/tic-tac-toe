package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfz extends zzza<zzfz> {
    public Integer zzavw;
    public String zzavx;
    public Boolean zzavy;
    public String[] zzavz;

    public zzfz() {
        this.zzavw = null;
        this.zzavx = null;
        this.zzavy = null;
        this.zzavz = zzzj.zzcfv;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfz)) {
            return false;
        }
        zzfz zzfz = (zzfz) obj;
        Integer num = this.zzavw;
        if (num == null) {
            if (zzfz.zzavw != null) {
                return false;
            }
        } else if (!num.equals(zzfz.zzavw)) {
            return false;
        }
        String str = this.zzavx;
        if (str == null) {
            if (zzfz.zzavx != null) {
                return false;
            }
        } else if (!str.equals(zzfz.zzavx)) {
            return false;
        }
        Boolean bool = this.zzavy;
        if (bool == null) {
            if (zzfz.zzavy != null) {
                return false;
            }
        } else if (!bool.equals(zzfz.zzavy)) {
            return false;
        }
        if (!zzze.equals((Object[]) this.zzavz, (Object[]) zzfz.zzavz)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzfz.zzcfc);
        }
        if (zzfz.zzcfc == null || zzfz.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzavw;
        int i = 0;
        int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
        String str = this.zzavx;
        int hashCode2 = (intValue + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.zzavy;
        int hashCode3 = (((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + zzze.hashCode((Object[]) this.zzavz)) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode3 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Integer num = this.zzavw;
        if (num != null) {
            zzyy.zzd(1, num.intValue());
        }
        String str = this.zzavx;
        if (str != null) {
            zzyy.zzb(2, str);
        }
        Boolean bool = this.zzavy;
        if (bool != null) {
            zzyy.zzb(3, bool.booleanValue());
        }
        String[] strArr = this.zzavz;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.zzavz;
                if (i >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i];
                if (str2 != null) {
                    zzyy.zzb(4, str2);
                }
                i++;
            }
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzavw;
        if (num != null) {
            zzf += zzyy.zzh(1, num.intValue());
        }
        String str = this.zzavx;
        if (str != null) {
            zzf += zzyy.zzc(2, str);
        }
        Boolean bool = this.zzavy;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzyy.zzbb(3) + 1;
        }
        String[] strArr = this.zzavz;
        if (strArr == null || strArr.length <= 0) {
            return zzf;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.zzavz;
            if (i >= strArr2.length) {
                return zzf + i2 + (i3 * 1);
            }
            String str2 = strArr2[i];
            if (str2 != null) {
                i3++;
                i2 += zzyy.zzfx(str2);
            }
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzfz zza(zzyx zzyx) throws IOException {
        int zzuy;
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 8) {
                try {
                    zzuy = zzyx.zzuy();
                    if (zzuy < 0 || zzuy > 6) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append(zzuy);
                        sb.append(" is not a valid enum MatchType");
                    } else {
                        this.zzavw = Integer.valueOf(zzuy);
                    }
                } catch (IllegalArgumentException e) {
                    zzyx.zzby(zzyx.getPosition());
                    zza(zzyx, zzug);
                }
            } else if (zzug == 18) {
                this.zzavx = zzyx.readString();
            } else if (zzug == 24) {
                this.zzavy = Boolean.valueOf(zzyx.zzum());
            } else if (zzug == 34) {
                int zzb = zzzj.zzb(zzyx, 34);
                String[] strArr = this.zzavz;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzavz, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = zzyx.readString();
                    zzyx.zzug();
                    length++;
                }
                strArr2[length] = zzyx.readString();
                this.zzavz = strArr2;
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append(zzuy);
        sb2.append(" is not a valid enum MatchType");
        throw new IllegalArgumentException(sb2.toString());
    }
}
