package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzvm.zze;

final class zzxh implements zzwr {
    private final int flags;
    private final String info;
    private final Object[] zzcba;
    private final zzwt zzcbd;

    zzxh(zzwt zzwt, String str, Object[] objArr) {
        this.zzcbd = zzwt;
        this.info = str;
        this.zzcba = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.flags = c | (charAt2 << i);
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zzxp() {
        return this.info;
    }

    /* access modifiers changed from: 0000 */
    public final Object[] zzxq() {
        return this.zzcba;
    }

    public final zzwt zzxi() {
        return this.zzcbd;
    }

    public final int zzxg() {
        return (this.flags & 1) == 1 ? zze.zzbzb : zze.zzbzc;
    }

    public final boolean zzxh() {
        return (this.flags & 2) == 2;
    }
}
