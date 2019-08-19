package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzz {
    final String name;
    final long zzaie;
    final long zzaif;
    final long zzaig;
    final long zzaih;
    final Long zzaii;
    final Long zzaij;
    final Long zzaik;
    final Boolean zzail;
    final String zztt;

    zzz(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        long j5 = j;
        long j6 = j2;
        long j7 = j4;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z = true;
        Preconditions.checkArgument(j5 >= 0);
        Preconditions.checkArgument(j6 >= 0);
        if (j7 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zztt = str;
        this.name = str2;
        this.zzaie = j5;
        this.zzaif = j6;
        this.zzaig = j3;
        this.zzaih = j7;
        this.zzaii = l;
        this.zzaij = l2;
        this.zzaik = l3;
        this.zzail = bool;
    }

    /* access modifiers changed from: 0000 */
    public final zzz zziu() {
        zzz zzz = new zzz(this.zztt, this.name, this.zzaie + 1, 1 + this.zzaif, this.zzaig, this.zzaih, this.zzaii, this.zzaij, this.zzaik, this.zzail);
        return zzz;
    }

    /* access modifiers changed from: 0000 */
    public final zzz zzai(long j) {
        zzz zzz = new zzz(this.zztt, this.name, this.zzaie, this.zzaif, j, this.zzaih, this.zzaii, this.zzaij, this.zzaik, this.zzail);
        return zzz;
    }

    /* access modifiers changed from: 0000 */
    public final zzz zza(long j, long j2) {
        zzz zzz = new zzz(this.zztt, this.name, this.zzaie, this.zzaif, this.zzaig, j, Long.valueOf(j2), this.zzaij, this.zzaik, this.zzail);
        return zzz;
    }

    /* access modifiers changed from: 0000 */
    public final zzz zza(Long l, Long l2, Boolean bool) {
        Boolean bool2;
        if (bool == null || bool.booleanValue()) {
            bool2 = bool;
        } else {
            bool2 = null;
        }
        zzz zzz = new zzz(this.zztt, this.name, this.zzaie, this.zzaif, this.zzaig, this.zzaih, this.zzaii, l, l2, bool2);
        return zzz;
    }
}
