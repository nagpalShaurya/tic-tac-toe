package com.google.android.gms.internal.firebase_auth;

import java.util.List;

final class zzgo extends zzgl {
    private zzgo() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> zza(Object obj, long j) {
        zzga zzd = zzd(obj, j);
        if (zzd.zzeu()) {
            return zzd;
        }
        int size = zzd.size();
        zzga zzj = zzd.zzj(size == 0 ? 10 : size << 1);
        zziv.zza(obj, j, (Object) zzj);
        return zzj;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzev();
    }

    /* access modifiers changed from: 0000 */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzga zzd = zzd(obj, j);
        zzga zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzd.zzeu()) {
                zzd = zzd.zzj(size2 + size);
            }
            zzd.addAll(zzd2);
        }
        if (size > 0) {
            zzd2 = zzd;
        }
        zziv.zza(obj, j, (Object) zzd2);
    }

    private static <E> zzga<E> zzd(Object obj, long j) {
        return (zzga) zziv.zzp(obj, j);
    }
}
