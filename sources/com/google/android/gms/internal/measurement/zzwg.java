package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzwg extends zzwd {
    private zzwg() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> zza(Object obj, long j) {
        zzvs zzd = zzd(obj, j);
        if (zzd.zztw()) {
            return zzd;
        }
        int size = zzd.size();
        zzvs zzak = zzd.zzak(size == 0 ? 10 : size << 1);
        zzyh.zza(obj, j, (Object) zzak);
        return zzak;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzsm();
    }

    /* access modifiers changed from: 0000 */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzvs zzd = zzd(obj, j);
        zzvs zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzd.zztw()) {
                zzd = zzd.zzak(size2 + size);
            }
            zzd.addAll(zzd2);
        }
        if (size > 0) {
            zzd2 = zzd;
        }
        zzyh.zza(obj, j, (Object) zzd2);
    }

    private static <E> zzvs<E> zzd(Object obj, long j) {
        return (zzvs) zzyh.zzp(obj, j);
    }
}
