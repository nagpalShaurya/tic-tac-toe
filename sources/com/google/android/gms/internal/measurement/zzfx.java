package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfx extends zzza<zzfx> {
    public Integer zzavo;
    public Boolean zzavp;
    public String zzavq;
    public String zzavr;
    public String zzavs;

    public zzfx() {
        this.zzavo = null;
        this.zzavp = null;
        this.zzavq = null;
        this.zzavr = null;
        this.zzavs = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfx)) {
            return false;
        }
        zzfx zzfx = (zzfx) obj;
        Integer num = this.zzavo;
        if (num == null) {
            if (zzfx.zzavo != null) {
                return false;
            }
        } else if (!num.equals(zzfx.zzavo)) {
            return false;
        }
        Boolean bool = this.zzavp;
        if (bool == null) {
            if (zzfx.zzavp != null) {
                return false;
            }
        } else if (!bool.equals(zzfx.zzavp)) {
            return false;
        }
        String str = this.zzavq;
        if (str == null) {
            if (zzfx.zzavq != null) {
                return false;
            }
        } else if (!str.equals(zzfx.zzavq)) {
            return false;
        }
        String str2 = this.zzavr;
        if (str2 == null) {
            if (zzfx.zzavr != null) {
                return false;
            }
        } else if (!str2.equals(zzfx.zzavr)) {
            return false;
        }
        String str3 = this.zzavs;
        if (str3 == null) {
            if (zzfx.zzavs != null) {
                return false;
            }
        } else if (!str3.equals(zzfx.zzavs)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzfx.zzcfc);
        }
        if (zzfx.zzcfc == null || zzfx.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzavo;
        int i = 0;
        int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
        Boolean bool = this.zzavp;
        int hashCode2 = (intValue + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.zzavq;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzavr;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzavs;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode5 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Integer num = this.zzavo;
        if (num != null) {
            zzyy.zzd(1, num.intValue());
        }
        Boolean bool = this.zzavp;
        if (bool != null) {
            zzyy.zzb(2, bool.booleanValue());
        }
        String str = this.zzavq;
        if (str != null) {
            zzyy.zzb(3, str);
        }
        String str2 = this.zzavr;
        if (str2 != null) {
            zzyy.zzb(4, str2);
        }
        String str3 = this.zzavs;
        if (str3 != null) {
            zzyy.zzb(5, str3);
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzavo;
        if (num != null) {
            zzf += zzyy.zzh(1, num.intValue());
        }
        Boolean bool = this.zzavp;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzyy.zzbb(2) + 1;
        }
        String str = this.zzavq;
        if (str != null) {
            zzf += zzyy.zzc(3, str);
        }
        String str2 = this.zzavr;
        if (str2 != null) {
            zzf += zzyy.zzc(4, str2);
        }
        String str3 = this.zzavs;
        if (str3 != null) {
            return zzf + zzyy.zzc(5, str3);
        }
        return zzf;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final zzfx zza(zzyx zzyx) throws IOException {
        int zzuy;
        while (true) {
            int zzug = zzyx.zzug();
            if (zzug == 0) {
                return this;
            }
            if (zzug == 8) {
                try {
                    zzuy = zzyx.zzuy();
                    if (zzuy < 0 || zzuy > 4) {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append(zzuy);
                        sb.append(" is not a valid enum ComparisonType");
                    } else {
                        this.zzavo = Integer.valueOf(zzuy);
                    }
                } catch (IllegalArgumentException e) {
                    zzyx.zzby(zzyx.getPosition());
                    zza(zzyx, zzug);
                }
            } else if (zzug == 16) {
                this.zzavp = Boolean.valueOf(zzyx.zzum());
            } else if (zzug == 26) {
                this.zzavq = zzyx.readString();
            } else if (zzug == 34) {
                this.zzavr = zzyx.readString();
            } else if (zzug == 42) {
                this.zzavs = zzyx.readString();
            } else if (!super.zza(zzyx, zzug)) {
                return this;
            }
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append(zzuy);
        sb2.append(" is not a valid enum ComparisonType");
        throw new IllegalArgumentException(sb2.toString());
    }
}
